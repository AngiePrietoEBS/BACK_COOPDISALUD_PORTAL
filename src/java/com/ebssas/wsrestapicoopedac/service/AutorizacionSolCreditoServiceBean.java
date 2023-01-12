/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.AutorizacionSolCreditoDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.HistoriaSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito;
import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.domain.HistoriaSolCredito;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.general.CrearEmailHTML;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.response.ResponseAutorizacionSolCredito;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.sms.ResponseSendSMSV3;
import com.ebssas.wsrestapicoopedac.sms.sendSMS;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class AutorizacionSolCreditoServiceBean implements AutorizacionSolCreditoService {

    private SolicitudCreditoServiceBean solicitudCreditoServiceBean = new SolicitudCreditoServiceBean();
    private ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private CrearEmailHTML emailHTML = new CrearEmailHTML();
    private SendEmailSMTP emailSMTP = new SendEmailSMTP();

    @Override
    public ResponseAutorizacionSolCredito findAllAutorizacionBySolCred(Long idSolCred) {

        ResponseAutorizacionSolCredito rasc = new ResponseAutorizacionSolCredito();

        List<AutorizacionSolCredito> listA = new AutorizacionSolCreditoDataAccessImp().findAllAutorizacionBySolCred(idSolCred);
        if (!listA.isEmpty()) {
            rasc.setbRta(Boolean.TRUE);
            rasc.setsMsj("Consulta exitosa");
            rasc.setListAutorizaciones(listA);
        } else {
            rasc.setbRta(Boolean.FALSE);
            rasc.setsMsj("No se encontraron registros de autorizaciones");
        }

        return rasc;

    }

    @Override
    public RespuestaGenerica saveAutorizacion(List<AutorizacionSolCredito> ascs) {

        RespuestaGenerica generica = new RespuestaGenerica();
        AutorizacionSolCreditoDataAccessImp accessImp = new AutorizacionSolCreditoDataAccessImp();
        Boolean actualizada = false;

        if (!ascs.isEmpty()) {
            String iNumRadic = ascs.get(0).getISolCredito().getINumRadic();
            SolicitudCredito credito = new SolicitudCreditoServiceBean().findSolCreditoByRadicado(iNumRadic);

            for (AutorizacionSolCredito auto : ascs) {
                AutorizacionSolCredito buscarA = accessImp.findAutorizacionByTipo(auto.getITipoAutorizacion().getICodigo());
                if (buscarA.getICodigo() != null) {
                    auto.setICodigo(buscarA.getICodigo());
                    auto.setFFechaSistema(new Date());
                    accessImp.updateAutorizacion(auto);
                    generica.setbRta(Boolean.TRUE);
                } else {
                    auto.setFFechaSistema(new Date());
                    AutorizacionSolCredito asc = accessImp.saveAutorizacion(auto);
                    if (asc.getICodigo() != null) {
                        generica.setbRta(Boolean.TRUE);
                    } else {
                        generica.setbRta(Boolean.FALSE);
                    }

                }
            }

            try {
                if (generica.getbRta()) {
                    SolicitudCredito buscarSC = this.solicitudCreditoServiceBean.findSolCreditoByRadicado(iNumRadic);
                    if (buscarSC.getICodigo() != null) {
                        credito.setICodigo(buscarSC.getICodigo());
                        credito.setIEstadoSolicitud(new TipoEstadoSolicitudCredito(Long.parseLong("2")));
                        SolicitudCredito updateSC = this.solicitudCreditoServiceBean.updateSolCreditoByRadicado(credito);

                        if (updateSC.getICodigo() != null) {

                            HistoriaSolCredito historia = new HistoriaSolCredito();
                            historia.setFFecha(new Date());
                            historia.setCObservacion("La solicitud de crédito se encontraba en estado RADICADA");
                            historia.setISolCredito(credito);

                            new HistoriaSolCredDataAccessImp().saveHistoriaSolicitudCredito(historia);

                            DatosPersonales datosPersonales = new DatosPersonalesSolCredServiceBean().findDatosPersonalesByPersona(credito.getIPersona().getICodigo());
                            if (datosPersonales.getCEmail().contains("@") && !datosPersonales.getCNumCelular().equals("")) {

                                HashMap<String, String> hashMapData = new HashMap<>();
                                Utilidad util = new Utilidad();
                                hashMapData.put("fechaSolicitud", util.dateToStringFormatFechaHora(credito.getFFechaSolicitud()));
                                hashMapData.put("sNumRadicSolCred", credito.getINumRadic() + "");
                                //hashMapData.put("sDescPeriodicidad", credito.get());
                                hashMapData.put("sMontoCredito", credito.getNMontoSolicitado().toString());
                                hashMapData.put("sLineaCredito", "COOPRIMAS");
                                hashMapData.put("sValorCuota", credito.getNValorCuota().toString());
                                hashMapData.put("sPlazo", credito.getIPlazo().toString());

                                String sEmalHTML = emailHTML.emailSolicitudCredRadicado(hashMapData);
                                String sEmailRemitente = this.parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                                boolean brtaEmail = emailSMTP.SendEmailHTML(datosPersonales.getCEmail(), sEmailRemitente, sEmalHTML, "SOLICITUD DE CRÉDITO COOPEDAC");
                                //String mensaje = "Nos permitirmos informarle que su solicitud de credito ha sido registrada con el numero " + credito.getINumRadic() + ", con la siguiente informacion:";
                                //ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", datosPersonales.getCNumCelular(), mensaje, "1");

                                if (brtaEmail) {
                                    generica.setbRta(Boolean.TRUE);
                                    generica.setiCodigo(1);
                                    generica.setsMsj("Información actualizada correctamente.");
                                } else {
                                    generica.setbRta(Boolean.TRUE);
                                    generica.setiCodigo(1);
                                    generica.setsMsj("Se ha presentado un problema al enviar el SMS.");
                                }

                                if (!actualizada) {
                                    String nombreUsuario = new PersonaServiceBean().personaWebFindByID(Long.parseLong("1")).getCNombres();
                                    //ResponseSendSMSV3 smsA = new sendSMS().envioSMS_SencilloV3("57", datosPersonales.getCNumCelular(), mensaje, "1");
                                    HashMap<String, String> hashMapDataAdmin = new HashMap<>();
                                    hashMapDataAdmin.put("nombreUsuario", nombreUsuario);
                                    String sEmalHTMLAdmin = emailHTML.emailSolicitudCreditoAdmin(hashMapDataAdmin);
                                    String emailReceptor = this.parametroServiceBean.obtenerParametroPorNombre("EMAIL_NOT_SOL_CRED");
                                    emailSMTP.SendEmailHTML(emailReceptor, sEmailRemitente, sEmalHTMLAdmin, "NUEVA SOLICITUD DE CRÉDITO COOPEDAC");
                                    generica.setbRta(Boolean.TRUE);
                                    generica.setiCodigo(1);
                                    generica.setsMsj("Información actualizada correctamente.");
                                }

                            } else {
                                generica.setbRta(Boolean.FALSE);
                                generica.setiCodigo(0);
                                generica.setsMsj("No cuenta con un correo registrado en COOPEDAC.");
                            }

                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setiCodigo(0);
                            generica.setsMsj("Se ha presentado un problema al actualizar la solicitud de crédito. Por favor intente de nuevo.");
                        }

                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("No se encontro solicitud de crÃ©dito");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                generica.setbRta(Boolean.FALSE);
                generica.setiCodigo(0);
                generica.setsMsj("Se ha presentado un problema al actualizar la solicitud de crÃ©dito. Por favor intente de nuevo, si el error persiste comuniquese con la entidad.");
            }

            //generica.setbRta(Boolean.TRUE);
            //generica.setsMsj("La informaciÃ³n fue actualizada exitosamente. Puede continuar con la solicitud.");
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("Se ha presentado un problema al actualizar la informaciÃ³n, por favor intente de nuevo.");
        }

        return generica;

    }

    @Override
    public AutorizacionSolCredito updateAutorizacion(AutorizacionSolCredito asc) {
        return new AutorizacionSolCreditoDataAccessImp().updateAutorizacion(asc);
    }

}
