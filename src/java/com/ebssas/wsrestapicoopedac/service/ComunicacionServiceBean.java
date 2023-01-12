/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.ComunicacionDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Comunicacion;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoMensaje;
import com.ebssas.wsrestapicoopedac.general.CrearEmailHTML;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.response.ResponseComunicacion;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.sms.ResponseSendSMSV3;
import com.ebssas.wsrestapicoopedac.sms.sendSMS;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ComunicacionServiceBean {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private Utilidad util = new Utilidad();

    public ResponseComunicacion saveComunicacion(Comunicacion comunicacion) {
        ResponseComunicacion generica = new ResponseComunicacion();
        if (comunicacion.getCMensaje() != "") {
            SolicitudCredito solB = new SolicitudCreditoServiceBean().findSolCreditoByRadicado(comunicacion.getISolCredito().getINumRadic());
            if (solB.getICodigo() != null) {
                String mensaje = util.decodeBase64(comunicacion.getCMensaje());

                PersonasDTO persona = new CygnusCoreServiceBean().wsConsultarPersona(solB.getIPersona().getICodigo() + "", "", "").get(0);
                if (comunicacion.getITipoComunicacion().getICodigo() == 2) {
                    generica = enviarEmail(comunicacion, persona, mensaje);

                } else if (comunicacion.getITipoComunicacion().getICodigo() == 1) {
                    generica = enviarSMS(comunicacion, persona, mensaje);
                } else if (comunicacion.getITipoComunicacion().getICodigo() == 3) {
                    ResponseComunicacion generica1 = enviarEmail(comunicacion, persona, mensaje);
                    comunicacion.setICodigo(null);
                    ResponseComunicacion generica2 = enviarSMS(comunicacion, persona, mensaje);
                    if (!generica1.getbRta() && !generica2.getbRta()) {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Ha ocurrido un error al enviar el mensaje.");
                    } else if (!generica1.getbRta()) {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Ha ocurrido un error al enviar el mensaje por Correo.");
                    } else if (!generica2.getbRta()) {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Ha ocurrido un error al enviar el mensaje por SMS.");
                    } else {
                        generica.setbRta(Boolean.TRUE);
                        generica.setsMsj("Se han enviado correctamente los comunicados.");
                        generica.setComunicacion(generica1.getComunicacion());
                    }
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("Ha ocurrido un error al enviar el mensaje.");
                }
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("No se ha podido encontrar la solicitud.");
            }

        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("No se ha podido encontrar la solicitud...");
        }

        return generica;
    }

    public ResponseComunicacion enviarEmail(Comunicacion comunicacion, PersonasDTO persona, String mensaje) {
        ResponseComunicacion generica = new ResponseComunicacion();
        String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");

        try {

            String genero = persona.getCSexo().equals("M") ? "Apreciado" : "Apreciada";

            HashMap<String, String> hashMapData = new HashMap<>();
            hashMapData.put("nomUsuario", persona.getCNombres() + " " + persona.getCApellidos());
            hashMapData.put("mensaje", mensaje);
            hashMapData.put("genero", genero);
            hashMapData.put("fecha", util.dateToStringFormatFechaHora(new Date()));
            String sEmailHTML = new CrearEmailHTML().cuerpoHTML(hashMapData);
            Boolean bRtaSendMailHTML = new SendEmailSMTP().SendEmailHTML(persona.getCEMail(), sEmailRemitente, sEmailHTML, "COMUNICADO SOLICITUD DE CRÉDITO COOPEDAC");
            if (bRtaSendMailHTML) {
                comunicacion.setCMensaje(mensaje);
                comunicacion.setCEstado("ACT");
                comunicacion.setFFechaComunicacion(new Date());
                comunicacion.setITipoMensaje(new TipoMensaje(Long.valueOf("1")));
                Comunicacion c = new ComunicacionDataAccessImp().saveComunicacion(comunicacion);
                if (c.getICodigo() != null) {
                    generica.setComunicacion(c);
                    generica.setbRta(Boolean.TRUE);
                    generica.setsMsj("Se ha enviado correctamente el mensaje");
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("No se ha podido enviar el comunicado, si el error persiste comuniquese con la entidad.");
                }

            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("No se ha podido enviar el comunicado, si el error persiste comuniquese con la entidad.");
            }
        } catch (Exception e) {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("No se ha podido enviar el comunicado, si el error persiste comuniquese con la entidad.");
        }

        return generica;
    }

    public ResponseComunicacion enviarSMS(Comunicacion comunicacion, PersonasDTO personasDTO, String mensaje) {
        ResponseComunicacion generica = new ResponseComunicacion();

        ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", personasDTO.getCTelefono(), mensaje, "1");
        if (sms.getStatus().equals("1x000")) {
            generica.setbRta(Boolean.TRUE);
            generica.setsMsj("Se ha enviado correctamente el mensaje");
            comunicacion.setCMensaje(mensaje);
            comunicacion.setCEstado("ACT");
            comunicacion.setFFechaComunicacion(new Date());
            comunicacion.setITipoMensaje(new TipoMensaje(Long.valueOf("1")));
            Comunicacion c = new ComunicacionDataAccessImp().saveComunicacion(comunicacion);
            if (c.getICodigo() != null) {
                generica.setComunicacion(c);
                generica.setbRta(Boolean.TRUE);
                generica.setsMsj("Se ha enviado correctamente el mensaje");
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("No se ha podido enviar el comunicado, si el error persiste comuniquese con la entidad.");
            }
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("No se ha podido enviar el comunicado, si el error persiste comuniquese con la entidad.");
        }

        return generica;
    }

    public List<Comunicacion> findAllComunicacionesSolCred(Long codigo) {
        return new ComunicacionDataAccessImp().findAllComunicacion(codigo);
    }

}
