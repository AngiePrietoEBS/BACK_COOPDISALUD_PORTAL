/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import java.util.HashMap;
import WSCygnusCoopedac.PersonasDTO;
import WSSimuladorCreditoCoopedac.RespuestaCrea;
import com.ebssas.wsrestapicoopedac.dataaccess.SolicitudCreditoDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.HistoriaSolCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.response.ResponseNuevaSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseValidarSolCred;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.dataaccess.HistoriaSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.general.CrearEmailHTML;
import com.ebssas.wsrestapicoopedac.request.RequestValidarLinea;
import com.ebssas.wsrestapicoopedac.response.ResponseSolicitudDiligenciada;
//import com.ebssas.wsrestapicoopedac.response.RespuestaCrea;
import com.ebssas.wsrestapicoopedac.sms.ResponseSendSMSV3;
import com.ebssas.wsrestapicoopedac.sms.sendSMS;

import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSSimuladorCredito;

/**
 *
 * @author juan_
 */
public class SolicitudCreditoServiceBean implements SolicitudCreditoService {

    public static final SolicitudCreditoDataAccessImp solicitudCreditoDataAccessImp = new SolicitudCreditoDataAccessImp();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String WS_SIMULADOR = parametroServiceBean.obtenerParametroPorNombre("WS_SIM_CREDITO");
    private final SendEmailSMTP enviarEmail = new SendEmailSMTP();
    private final CrearEmailHTML sendEmail = new CrearEmailHTML();
    private final Utilidad util = new Utilidad();

    @Override
    public ResponseSolicitudCredito buscarTodasSolCredito() {
        ResponseSolicitudCredito responseSolicitudCredito = new ResponseSolicitudCredito();
        try {
            List<SolicitudCredito> solCreditoBuscar = this.solicitudCreditoDataAccessImp.findAll();
            if (solCreditoBuscar != null && !solCreditoBuscar.isEmpty()) {
                responseSolicitudCredito.setFlag(true);
                responseSolicitudCredito.setsMsg("Se ha encontrado la información de las solicitud");
                responseSolicitudCredito.setListaSolicitud(solCreditoBuscar);
            } else {
                responseSolicitudCredito.setFlag(false);
                responseSolicitudCredito.setsMsg("No se ha encontrado una solicitud");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseSolicitudCredito.setFlag(false);
            responseSolicitudCredito.setsMsg("Ha ocurrido un error al intentar obtener la información de las solicitudes");
        }
        return responseSolicitudCredito;
    }

    @Override
    public ResponseSolCredito findSolCreditoByRadicado2(String sNumRadic) {

        ResponseSolCredito responseSolCredito = new ResponseSolCredito();

        SolicitudCredito credito = new SolicitudCreditoDataAccessImp().findSolCreditoByRadicado(sNumRadic);

        if (credito.getICodigo() != null) {
            String linea = new AdminCoreServiceBean().wsLineaCreditoByID(credito.getITipoCredito().getICodigo() + "").getListLineaCredito().getLineaCreditoDTO().get(0).getSDescripcion();
            credito.getITipoCredito().setCNombre(linea);
            responseSolCredito.setbRta(Boolean.TRUE);
            responseSolCredito.setsMsj("Consulta exitosa");
            responseSolCredito.setSolicitudCredito(credito);
        } else {
            responseSolCredito.setbRta(Boolean.FALSE);
            responseSolCredito.setsMsj("No se encontro solicitud de cr�dito con el siguiente n�mero de radicado: " + sNumRadic);
        }
        return responseSolCredito;
    }

    public ResponseSolicitudCredito buscarSolCredbyPersona(Long xCodPersona) {

        ResponseSolicitudCredito responseSolCredito = new ResponseSolicitudCredito();

        List<SolicitudCredito> credito = new SolicitudCreditoDataAccessImp().buscarSolCredbyPersona(xCodPersona);

        if (credito != null) {
            responseSolCredito.setFlag(Boolean.TRUE);
            responseSolCredito.setsMsg("Consulta exitosa");
            responseSolCredito.setListaSolicitud(credito);
        } else {
            responseSolCredito.setFlag(Boolean.FALSE);
            responseSolCredito.setsMsg("No se encontro solicitudes de cr�dito");
        }
        return responseSolCredito;
    }

    @Override
    public SolicitudCredito findSolCreditoByRadicado(String sNumRadic) {

        return new SolicitudCreditoDataAccessImp().findSolCreditoByRadicado(sNumRadic);
//        SolicitudCredito credito = new SolicitudCreditoDataAccessImp().findSolCreditoByRadicado(sNumRadic);
//
//        if (credito.getICodigo() != null) {
//            responseSolCredito.setbRta(Boolean.TRUE);
//            responseSolCredito.setsMsj("Consulta exitosa");
//            responseSolCredito.setSolicitudCredito(credito);
//        } else {
//            responseSolCredito.setbRta(Boolean.FALSE);
//            responseSolCredito.setsMsj("No se encontro solicitud de crédito con el siguiente número de radicado: " + sNumRadic);
//        }
//        return responseSolCredito;
    }

    @Override
    public SolicitudCredito updateSolCreditoByRadicado(SolicitudCredito solicitudCredito) {
        return new SolicitudCreditoDataAccessImp().updateSolicitud(solicitudCredito);
    }

    @Override
    public ResponseNuevaSolicitudCredito saveSolicitudCredito(SolicitudCredito solicitudCredito) {
        ResponseNuevaSolicitudCredito generica = new ResponseNuevaSolicitudCredito();

        if (solicitudCredito != null) {
            SolicitudCredito buscarSC = new SolicitudCreditoDataAccessImp().findSolCreditoByRadicado(solicitudCredito.getINumRadic());
            if (buscarSC.getICodigo() != null) {
                solicitudCredito.setICodigo(buscarSC.getICodigo());
                SolicitudCredito scU = new SolicitudCreditoDataAccessImp().updateSolicitud(solicitudCredito);
                if (scU.getICodigo() != null) {
                    generica.setSolicitudCredito(scU);
                    generica.setbRta(Boolean.TRUE);
                    generica.setsMsj("Se ha actualizado la informaci�n exitosamente");
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("Se prensento un problema al actualizar la solicitud");
                }
            } else {
                solicitudCredito.setFFechaSolicitud(new Date());
                solicitudCredito.setIEstadoSolicitud(new TipoEstadoSolicitudCredito(Long.parseLong("1")));
                SolicitudCredito scS = new SolicitudCreditoDataAccessImp().saveSolicitud(solicitudCredito);
                if (scS.getICodigo() != null) {

                    String sNumRadic = new Utilidad().dateToStringFormatFechaNumRadicSolCred("yyyyMMdd");
                    if (scS.getICodigo().intValue() >= 1 && scS.getICodigo().intValue() <= 9) {
                        sNumRadic += "0" + scS.getICodigo().toString();
                    } else {
                        sNumRadic += scS.getICodigo().toString();
                    }

                    scS.setINumRadic(sNumRadic);
                    new SolicitudCreditoDataAccessImp().updateSolicitud(scS);

                    generica.setSolicitudCredito(scS);
                    generica.setbRta(Boolean.TRUE);
                    generica.setsMsj("Se ha guardado la informaci�n exitosamente con el siguiente n�mero de solicitud: " + sNumRadic);
                    //generica.setsMsj("Se ha guardado la información exitosamente");
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("Se prensento un problema al guardar la solicitud");
                }
            }
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("La informaci�n debe estar completa");
        }

        return generica;
    }

    @Override
    public ResponseValidarSolCred validarSolicitudCredito(Long codPersona) {

        ResponseValidarSolCred validarSolCred = new ResponseValidarSolCred();

        try {
            SolicitudCredito solicitudCreditoV = new SolicitudCreditoDataAccessImp().validarSolCred(codPersona);
            if (solicitudCreditoV.getICodigo() != null) {
                validarSolCred.setbRta(Boolean.TRUE);
                validarSolCred.setsMsj("Tiene una solicitud en curso.");
                validarSolCred.setiCodigo(1);
                validarSolCred.setSolicitudCredito(solicitudCreditoV);
            } else {
                validarSolCred.setbRta(Boolean.TRUE);
                validarSolCred.setsMsj("Puede continuar con la solicitud");
                validarSolCred.setiCodigo(2);
            }
        } catch (Exception e) {
            validarSolCred.setbRta(Boolean.FALSE);
            validarSolCred.setsMsj("Se ha presentado un problema validando la solicitud.");
            validarSolCred.setiCodigo(0);
        }

        return validarSolCred;
    }

    public RespuestaGenerica cambiarEstado(Long codSolicitudCredito, Long xiCodEstadSolic, Long xiCodUser, String observacion, String cNumRadic, String cPagareCygnus, String cPagareDeceval) {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        try {
            String mensaje = "";
            if (codSolicitudCredito != null && xiCodEstadSolic != null && xiCodUser != null) {
                SolicitudCredito buscarSolicitud = solicitudCreditoDataAccessImp.findSolicitudCreditoById(codSolicitudCredito);
                if (buscarSolicitud.getICodigo() != null) {
                    Usuario buscarUsuario = new UsuarioServiceBean().findUsuarioByICodigo(xiCodUser);
                    if (buscarUsuario != null) {
                        TipoEstadoSolicitudCredito tipoEstado = new TipoEstadoSolCreditoServiceBean().findByID(xiCodEstadSolic);
                        if (tipoEstado != null) {
                            String mensajeCorrecto = "La solicitud de cr�dito ha cambiado su estado a: " + tipoEstado.getCDescripcion() + ". Motivo: " + observacion;
                            String mensajeError = "Se ha presentado un inconveniente al intentar cambiar el estado de la solicitud de cr�dito.";
                            respuesta = this.cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, tipoEstado, mensajeCorrecto, mensajeError, cNumRadic, cPagareCygnus, cPagareDeceval);
                            if (respuesta.getbRta()) {

                                List<PersonasDTO> buscarPersona = new CygnusCoreServiceBean().wsConsultarPersona("", buscarSolicitud.getIPersona().getITipoIdent().toString(), buscarSolicitud.getIPersona().getCIdentificacion());

                                String sMailDestino = buscarPersona.get(0).isBResultado() && buscarPersona.get(0).getCEMail() != null ? buscarPersona.get(0).getCEMail() : "";
                                //String sNumCel = buscarPersona.isBResultado() && buscarPersona.getCTelefono() != null ? buscarPersona.getCTelefono() : "";
                                String sNombresPersona = buscarPersona.get(0).isBResultado() && buscarPersona.get(0).getCNombres() != null ? buscarPersona.get(0).getCNombres() : "";
                                String sRadicado = buscarSolicitud.getINumRadic();
//                                    String sMailDestino = "juanp7529@gmail.com";
//                                    String sNumCel = "3187905455";
//                                    String sNombresPersona = buscarSolicitud.getIPersona().getCNombres() + " " + buscarSolicitud.getIPersona().getCApellidos();
                                HashMap<String, String> hashMapData = new HashMap<>();
                                hashMapData.put("sNombres", sNombresPersona);
                                //hashMapData.put("sRadicado", sRadicado);
                                hashMapData.put("sTipoSolicitud", tipoEstado.getCDescripcion());
                                String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");

                                if (tipoEstado.getICodigo() == 3) { //APROBADO
                                    // Se comentan los siguientes metodos al parecer su logica ya estan contenida en  cambiarEstadoSolicitud 
                                    // RespuestaCrea crea = guardarCreditoEnCore(buscarSolicitud, "C");
                                    hashMapData.put("sRadicado", sRadicado);
                                    buscarSolicitud.setCNumRadic(sRadicado);
                                    //  this.updateSolCreditoByRadicado(buscarSolicitud);

                                    hashMapData.put("sObservacion", "");
                                    //String crearCuerpoHtml = sendEmail.cuerpoHTMLPagare(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
                                    String crearCuerpoHtmlAprobada = sendEmail.cuerpoHTMLCambioEstado(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
                                    //boolean enviarEmailAprobado = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtml, "Instrucciones Pagare. COOPEDAC");
                                    boolean enviarEmial = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtmlAprobada, "Respuesta solicitud de cr�dito aprobada");

                                    mensaje = "Nos permitimos informarle que su solicitud de credito radicada con el numero de registro " + sRadicado + " fue: " + tipoEstado.getCDescripcion();
//                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", , mensaje, "1");
                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", buscarPersona.get(0).getCTelefono(), mensaje, "0");

                                    if (enviarEmial /*&& enviarEmailAprobado/*sms != null && sms.getStatus().equals("1x000")*/) {
                                        mensajeCorrecto = "Se ha enviado la notificaci�n al n�mero " + buscarPersona.get(0).getCTelefono() + " La solicitud de cr�dito ha sido Aprobada";
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n SMS " + buscarPersona.get(0).getCTelefono();
                                        TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(tipoEstado.getICodigo());
                                        crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
                                    } else {
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al correo " + sMailDestino;
                                        cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, new TipoEstadoSolicitudCredito(Long.parseLong("1")), mensajeError, mensajeError, cNumRadic, cPagareCygnus, cPagareDeceval);
                                        respuesta.setbRta(false);
                                        respuesta.setsMsj(mensajeError);
                                    }
                                    /*Boolean bRtaSendSMS = sendSms.envioSMS_Sencillo("57", sNumCel, "COOPEDAC le informa que su solicitud de cr�dito cambio su estado a " + tipoEstado.getCDescripcion());
                                    if (bRtaSendSMS) {
                                        mensajeCorrecto = "Se ha enviado la notificaci�n al celular " + sNumCel;
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al celular " + sNumCel;
                                        TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoDataAccessImp().findByID(tipoEstado.getICodigo());
                                        crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
                                    } else {
                                        mensajeCorrecto = "Se ha enviado la notificaci�n al celular " + sNumCel;
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al celular " + sNumCel;
                                        cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, Long.parseLong("1"), mensajeError, mensajeError);
                                        respuesta.setbRta(false);
                                        respuesta.setsMsj(mensajeError);
                                    }*/
                                    if (enviarEmial /*&& enviarEmailAprobado/*sms.getStatus().equals("1x000")*/) {
                                        respuesta.setbRta(Boolean.TRUE);
                                        respuesta.setiCodigo(1);
                                        respuesta.setsMsj("Se ha enviado un mail al correo registrado sobre las instrucciones a seguir");

                                    }
                                } else if (tipoEstado.getICodigo() == 4) { //APLAZADO

                                    hashMapData.put("sObservacion", observacion);

                                    String crearCuerpoHtml = sendEmail.cuerpoHTMLCambioEstado(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
                                    boolean enviarEmial = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtml, "Respuesta solicitud de crédito COOPEDAC");
                                    mensaje = "";
//                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", buscarPersona.get(0).getCTelefono(), "", "1");
                                    mensaje = "Nos permitimos informarle que su solicitud de credito radicada con el numero de registro " + sRadicado + " fue: " + tipoEstado.getCDescripcion();
//                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", , mensaje, "1");
                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", buscarPersona.get(0).getCTelefono(), mensaje, "0");
                                    //String mensaje = "Nos permitimos informarle que su solicitud de credito con el N� registro " + sRadicado + " fue: " + tipoEstado.getCDescripcion();
                                    if (enviarEmial/*sms.getStatus().equals("1x000")*/) {
                                        mensajeCorrecto = "Se ha enviado la notificaci�n al correo " + sMailDestino + " La solicitud de cr�dito ha sido Aplazada";
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificación al correo " + sMailDestino;
                                        TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(tipoEstado.getICodigo());
                                        crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
                                        respuesta.setbRta(Boolean.TRUE);
                                        respuesta.setiCodigo(1);
                                        respuesta.setsMsj("Se ha enviado un correo electronico al email registrado.");
                                    } else {
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al correo " + sMailDestino;
                                        cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, new TipoEstadoSolicitudCredito(Long.parseLong("1")), mensajeError, mensajeError, cNumRadic, cPagareCygnus, cPagareDeceval);
                                        respuesta.setbRta(false);
                                        respuesta.setsMsj(mensajeError);
                                    }

                                    if (enviarEmial) {
                                        mensajeCorrecto = "Se ha enviado la notificaci�n al correo " + sMailDestino + " La solicitud de crédito ha sido Aplazada";
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificación al correo " + sMailDestino;
                                        TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(tipoEstado.getICodigo());
                                        crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
                                        respuesta.setbRta(Boolean.TRUE);
                                        respuesta.setiCodigo(1);
                                        respuesta.setsMsj("Se ha enviado un correo electronico al email registrado.");
                                    } else {
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al correo " + sMailDestino;
                                        cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, new TipoEstadoSolicitudCredito(Long.parseLong("1")), mensajeError, mensajeError, cNumRadic, cPagareCygnus, cPagareDeceval);
                                        respuesta.setbRta(false);
                                        respuesta.setsMsj(mensajeError);
                                    }
                                } else if (tipoEstado.getICodigo() == 5) { //NEGADO

                                    hashMapData.put("sObservacion", observacion);
//                                    String mensaje = "Nos permitimos informarle que su solicitud de credito con el N� de registro" + sRadicado + " fue: " + tipoEstado.getCDescripcion();
//                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", buscarPersona.getCTelefono(), mensaje, "1");
//
//                                    if (sms.getStatus().equals("1x000")) {
//                                        mensajeCorrecto = "Se ha enviado la notificaci�n SMS. La solicitud de cr�dito ha sido Negada";
//                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al SMS " + sMailDestino;
//                                        TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(tipoEstado.getICodigo());
//                                        crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
//                                        respuesta.setbRta(Boolean.TRUE);
//                                        respuesta.setiCodigo(1);
//                                        respuesta.setsMsj("Se ha enviado un correo electronico al email registrado.");
//                                    } else {
//                                        mensajeError = "Se ha presentado un inconveniente al enviar SMS";
//                                        cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, new TipoEstadoSolicitudCredito(Long.parseLong("1")), mensajeError, mensajeError);
//                                        respuesta.setbRta(false);
//                                        respuesta.setsMsj(mensajeError);
//                                    }

                                    String crearCuerpoHtml = sendEmail.cuerpoHTMLCambioEstado(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
                                    boolean enviarEmial = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtml, "Respuesta solicitud de crédito COOPEDAC");
                                    mensaje = "Nos permitimos informarle que su solicitud de credito radicada con el numero de registro " + sRadicado + " fue: " + tipoEstado.getCDescripcion();
//                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", , mensaje, "1");
                                    ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", buscarPersona.get(0).getCTelefono(), mensaje, "0");
                                    if (enviarEmial) {
                                        mensajeCorrecto = "Se ha enviado la notificaci�n al correo " + sMailDestino + " La solicitud de crédito ha sido Negada";
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al correo " + sMailDestino;
                                        TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(tipoEstado.getICodigo());
                                        crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
                                        respuesta.setbRta(Boolean.TRUE);
                                        respuesta.setiCodigo(1);
                                        respuesta.setsMsj("Se ha enviado un correo electronico al email registrado.");
                                    } else {
                                        mensajeError = "Se ha presentado un inconveniente al enviar notificaci�n al correo " + sMailDestino;
                                        cambiarEstadoSolicitud(buscarSolicitud, buscarUsuario, new TipoEstadoSolicitudCredito(Long.parseLong("1")), mensajeError, mensajeError, cNumRadic, cPagareCygnus, cPagareDeceval);
                                        respuesta.setbRta(false);
                                        respuesta.setsMsj(mensajeError);
                                    }
                                } else {
                                    if (tipoEstado.getICodigo() == 7) {
                                        guardarCreditoEnCore(buscarSolicitud, "L");
                                    }

                                    TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(tipoEstado.getICodigo());
                                    crearHistoriaSolicitud(buscarSolicitud, buscarUsuario, tipoEstadoSolCred, mensajeCorrecto, mensajeError);
                                    respuesta.setbRta(Boolean.TRUE);
                                    respuesta.setiCodigo(1);
                                    respuesta.setsMsj("Se ha actualizado el estado de la solicitud de cr�dito");
                                }
                            } else {
                                respuesta.setbRta(Boolean.FALSE);
                                respuesta.setsMsj("No se ha podido cambiar el estado de la solicitud");
                            }
                        } else {
                            respuesta.setbRta(Boolean.FALSE);
                            respuesta.setsMsj("No se ha encontrado el tipo de la solicitud");
                        }
                    } else {
                        respuesta.setbRta(Boolean.FALSE);
                        respuesta.setsMsj("No se ha encontrado la informaci�n del usuario");
                    }
                } else {
                    respuesta.setbRta(Boolean.FALSE);
                    respuesta.setsMsj("No se ha encontrado la solicitud");
                }

            } else {
                respuesta.setbRta(Boolean.FALSE);
                respuesta.setsMsj("Ha ocurrido un error al obtener la informaci�n de la solicitud");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ha ocurrido un error inesperado, por favor intentelo de nuevo");
        }
        return respuesta;
    }

    public RespuestaGenerica cambiarEstadoSolicitud(SolicitudCredito solicitudCredito, Usuario usuario, TipoEstadoSolicitudCredito estado, String mensajeHistoria, String mensajeError, String cNumRadic, String cPagareCygnus, String cPagareDeceval) {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        try {
            //TipoEstadoSolicitudCredito tipoEstadoSolCred = new TipoEstadoSolCreditoServiceBean().findByID(xiCodEstadSolic);
            if (estado != null) {
                solicitudCredito.setiUsuarioModificador(usuario);
                solicitudCredito.setFFechaModificacion(new Date());
                solicitudCredito.setIEstadoSolicitud(estado);
                solicitudCredito.setCNumRadic(cNumRadic);
                solicitudCredito.setCPagareCygnus(cPagareCygnus);
                solicitudCredito.setCPagareDeceval(cPagareDeceval);
                SolicitudCredito creditoU = solicitudCreditoDataAccessImp.updateSolicitud(solicitudCredito);
                respuesta = this.crearHistoriaSolicitud(solicitudCredito, usuario, estado, mensajeHistoria, mensajeError);
            } else {
                respuesta.setbRta(false);
                respuesta.setsMsj("No se encontrado la informaci�n para el tipo de estado del cr�dito.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ocurrio un error al intentar cambiar la solicitud");
        }
        return respuesta;
    }

    public RespuestaCrea guardarCreditoEnCore(SolicitudCredito solicitudCredito, String estadoCredito) {
        RespuestaCrea rc = new SimuladorCreditoServiceBean().crearCreditoCygnus(solicitudCredito, estadoCredito);
        return rc;
    }

    public RespuestaGenerica crearHistoriaSolicitud(SolicitudCredito solCredito, Usuario usuario, TipoEstadoSolicitudCredito estadoSolicitudCreditoNue, String mensajeHistoria, String mensajeError) {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        try {

            HistoriaSolCredito historiaSolicitudCredito = new HistoriaSolCredito();
            historiaSolicitudCredito.setISolCredito(solCredito);
            //historiaSolicitudCredito.setIEstadoSolicitud(estadoSolicitudCreditoNue);
            historiaSolicitudCredito.setCObservacion(mensajeHistoria);
            historiaSolicitudCredito.setFFecha(new Date());
            //historiaSolicitudCredito.setFFechaCreacion(new Date());
            HistoriaSolCredito hsc = new HistoriaSolCredDataAccessImp().saveHistoriaSolicitudCredito(historiaSolicitudCredito);
            if (hsc != null && hsc.getICodigo() != null) {
                respuesta.setbRta(Boolean.TRUE);
            } else {
                respuesta.setbRta(Boolean.FALSE);
                respuesta.setsMsj(mensajeError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj(mensajeError);
        }
        return respuesta;
    }

    public ResponseSolicitudDiligenciada findSolCreditoDiligenciada(Long idPersona) {
        ResponseSolicitudDiligenciada diligenciada = new ResponseSolicitudDiligenciada();

        try {
            if (idPersona != null) {
                SolicitudCredito credito = solicitudCreditoDataAccessImp.findSolCreditoDiligenciada(idPersona);

                if (credito.getICodigo() != null) {

                    diligenciada.setbRta(Boolean.TRUE);
                    diligenciada.setsMsj("Ya tiene una solicitud en diligencia.");
                    diligenciada.setSolicitudCredito(credito);
                } else {
                    diligenciada.setbRta(Boolean.FALSE);
                    diligenciada.setsMsj("No se ha encontrado una solicitud de cr�dito previamente diligenciada.");
                }
            } else {
                diligenciada.setbRta(Boolean.FALSE);
                diligenciada.setsMsj("Se ha prensentado un problema al validar solicitud, por favor intente de nuevo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            diligenciada.setbRta(Boolean.FALSE);
            diligenciada.setsMsj("Se ha prensentado un problema al validar solicitud, por favor intente de nuevo más tarde.");
        }

        return diligenciada;
    }

    public RespuestaGenerica findSolCreditoByLineaByPersona(RequestValidarLinea requestValidarLinea) {

        RespuestaGenerica generica = new RespuestaGenerica();
        Utilidad util = new Utilidad();
        try {
            if (requestValidarLinea.getsCodLinea() != null && requestValidarLinea.getlCodPersona() != null) {
                boolean permite = false;

                Persona persona = new PersonaServiceBean().personaWebFindByID(requestValidarLinea.getlCodPersona());

                permite = new SimuladorCreditoServiceBean().permiteCredito(persona.getCIdentificacion(), requestValidarLinea.getsCodLinea());

                if (permite) {
                    SolicitudCredito credito = solicitudCreditoDataAccessImp.findSolCreditoByLineaByPersonaByEstado(Long.parseLong(requestValidarLinea.getsCodLinea()), requestValidarLinea.getlCodPersona(), "2");
                    if (credito.getICodigo() == null) {
                        generica.setbRta(Boolean.TRUE);
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Ya tiene un credito REGISTRADO con esta linea.");
                    }
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("Ya tiene un cr�dito APROBADO con esta l�nea.");
                }
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("Se ha prensentado un problema al validar solicitud, por favor intente de nuevo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("Se ha prensentado un problema al validar solicitud, por favor intente de nuevo m�s tarde.");
        }

        return generica;
    }

    /**
     * M�todo que permite actualizar la tabla SOLICITUD CREDITO en su campo
     * C_Base64 con el Pagar�.
     *
     * @param solicitudCredito
     * @return
     */
    public RespuestaGenerica saveDocumentoPagare(SolicitudCredito solicitudCredito) {
        RespuestaGenerica respuestaGenerica = new RespuestaGenerica();
        SolicitudCredito buscarSolicitud = solicitudCreditoDataAccessImp.findSolicitudCreditoById(solicitudCredito.getICodigo());
        buscarSolicitud.setCBase64(solicitudCredito.getCBase64());
        buscarSolicitud.setCPagareDeceval(solicitudCredito.getCPagareDeceval());
        SolicitudCredito respuestaUpdate = solicitudCreditoDataAccessImp.updateSolicitud(buscarSolicitud);
        if (respuestaUpdate != null) {
            respuestaGenerica.setiCodigo(respuestaUpdate.getICodigo().intValue());
            respuestaGenerica.setbRta(Boolean.TRUE);
            respuestaGenerica.setsMsj("Se ha registrado el Pagare para la Solicitud de Credito");
        } else {
            respuestaGenerica.setbRta(Boolean.FALSE);
            respuestaGenerica.setsMsj("Se ha registrado el Pagare para la Solicitud de Credito");
        }
        return respuestaGenerica;
    }

}
