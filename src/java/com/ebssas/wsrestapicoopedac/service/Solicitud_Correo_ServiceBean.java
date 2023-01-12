/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.SolicitudCreditoDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.CrearEmailHTML;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import static com.ebssas.wsrestapicoopedac.service.SolicitudCreditoServiceBean.solicitudCreditoDataAccessImp;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Juan Sebastian F
 */
public class Solicitud_Correo_ServiceBean {

    public static final SolicitudCreditoDataAccessImp   solicitudCreditoDataAccessImp = new SolicitudCreditoDataAccessImp();
    private final ParametroServiceBean                  parametroServiceBean          = new ParametroServiceBean();
    private final String                                WS_SIMULADOR                  = parametroServiceBean.obtenerParametroPorNombre("WS_SIM_CREDITO");
    private final SendEmailSMTP                         enviarEmail                   = new SendEmailSMTP();
    private final CrearEmailHTML                        sendEmail                     = new CrearEmailHTML();
    private final Utilidad                              util                          = new Utilidad();

    //Estra Solicitud se Genera en la Pantalla despues de Hacer o no la Simulacion para Informarle al Cliente que Esta Diligenciando un Credito
    public RespuestaGenerica Diligenciado(Long iCodigo, Long Radicado, String LCredito) {
        
        RespuestaGenerica respuesta = new RespuestaGenerica();    
        
        if(iCodigo==null || Radicado==null || LCredito==null) {
            System.out.println("Error [BSERVICE-SCS-D], algunos de los valores son NULL, iCodigo:"+
                    iCodigo+", Radicado: "+Radicado+", LCredito: "+LCredito);
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setiCodigo(0);
            respuesta.setsMsj("No se envio Correo");
        }
        
        Persona nombreUsuario = new PersonaServiceBean().personaWebFindByID(iCodigo);        
        try {
            String sMailDestino = nombreUsuario.getDatosPersonalesList().get(0).getCEmail();
            String sNombresPersona = nombreUsuario.getCNombres() + "" + nombreUsuario.getCApellidos();
            String tipoEstado = LCredito;
            String sRadicado = String.valueOf(Radicado);
            String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");

            HashMap<String, String> hashMapData = new HashMap<>();
            hashMapData.put("sNombres", sNombresPersona);
            hashMapData.put("sTipoSolicitud", tipoEstado);
            hashMapData.put("sRadicado", sRadicado);
            hashMapData.put("sObservacion", "");

            Solicitud_Correo_ServiceBean s = new Solicitud_Correo_ServiceBean();

            String crearCuerpoHtmlAprobada = s.HTMLDiligenciado(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));

            boolean enviarEmial = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtmlAprobada, "Informativo: Solicitud Diligenciada");

            if (enviarEmial /*&& enviarEmailAprobado/*sms.getStatus().equals("1x000")*/) {
                System.out.println("Envio EMAIL");
                respuesta.setbRta(Boolean.TRUE);
                respuesta.setiCodigo(1);
                respuesta.setsMsj("Se ha enviado un mail al correo registrado sobre las instrucciones a seguir");

            } else {
                System.out.println("No Envio EMAIL");
                respuesta.setbRta(Boolean.FALSE);
                respuesta.setiCodigo(1);
                respuesta.setsMsj("No se envio Correo");
            }
        } catch (Exception e) {
            System.out.println("Error Envio EMAIL");
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ha ocurrido un error inesperado, por favor intentelo de nuevo");
        }
        return respuesta;
    }

    public String HTMLDiligenciado(HashMap<String, String> hashMapData, String fecha) {
        String rta = "<body>\n"
                + "    <header style=\"height: 60px; background-color: #76c25c;\">\n"
                + "    <h2 style=\"text-align: center;\n"
                + "               margin-top: 2%;\n"
                + "               font-weight: 300;\n"
                + "               font-size: 40px;\n"
                + "               line-height: 60px;\">\n"
                + "    </h2>\n"
                + "    </header>\n"
                + "\n"
                + "<div style=\"margin-top: 5%;\"><div style=\"font-size: 20px;color: #3c86c6;\">Bogotá D.C.,<div style=\"font-size: 20px;float: right;\">" + fecha + "</div></div><div>"
                + "\n"
                + "    <h2 style=\"font-weight: 100;\n"
                + "    font-size: 27px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #3c86c6;\">Apreciad@ " + hashMapData.get("sNombres") + "</h2>\n"
                + "\n"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Nos permitimos informarle que su solicitud esta en proceso.\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Radicada con el N°: " + hashMapData.get("sRadicado") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Tipo de Credito Seleccionado:  \n</p>"
                + "<p style=\"font-weight: 100;\n"
                + "    font-size: 32px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #236EB6; font-weight: 300;\"><strong> " + hashMapData.get("sTipoSolicitud") + "</strong></p>"
                + "\n"
                + (!hashMapData.get("sObservacion").equals("") ? " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Motivo:  " + hashMapData.get("sObservacion") + " </p>" : "")
                + "\n"
                + "</body>";
        return rta;
    }

    //Esta Solicitud se Genera en la Pantalla despues de Subir el Desprendible de Pago para Informarle al Cliente que se aprobo el credito
    public RespuestaGenerica Aprobado(Long iCodigo, Long Radicado, String LCredito, Long Valor) {
        RespuestaGenerica respuesta = new RespuestaGenerica();        
        Persona nombreUsuario = new PersonaServiceBean().personaWebFindByID(iCodigo);       
        try {
            String sMailDestino = nombreUsuario.getDatosPersonalesList().get(0).getCEmail();
            String sNombresPersona = nombreUsuario.getCNombres() + "" + nombreUsuario.getCApellidos();
            String tipoEstado = LCredito;
            String sRadicado = String.valueOf(Radicado);
            String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");

            HashMap<String, String> hashMapData = new HashMap<>();

            hashMapData.put("sNombres", sNombresPersona);
            hashMapData.put("sTipoSolicitud", tipoEstado);
            hashMapData.put("sValor", String.valueOf(Valor));
            hashMapData.put("sRadicado", sRadicado);
            hashMapData.put("sObservacion", "");

            Solicitud_Correo_ServiceBean s = new Solicitud_Correo_ServiceBean();

            String crearCuerpoHtmlAprobada = s.HTMLAprobado(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));

            boolean enviarEmial = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtmlAprobada, "Informativo: Solicitud Aprobada");
            
            if (enviarEmial /*&& enviarEmailAprobado/*sms.getStatus().equals("1x000")*/) {
                System.out.println("Envio EMAIL");
                respuesta.setbRta(Boolean.TRUE);
                respuesta.setiCodigo(1);
                respuesta.setsMsj("Se ha Aprobado el Credito de la Solicitud");

            } else {
                System.out.println("No Envio EMAIL");
                respuesta.setbRta(Boolean.FALSE);
                respuesta.setiCodigo(1);
                respuesta.setsMsj("No se envio Correo");
            }
        } catch (Exception e) {
            System.out.println("Error Envio EMAIL");
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ha ocurrido un error inesperado, por favor intentelo de nuevo");
        }
        return respuesta;
    }

    public String HTMLAprobado(HashMap<String, String> hashMapData, String fecha) {
        String rta = "<body>\n"
                + "    <header style=\"height: 60px; background-color: #76c25c;\">\n"
                + "    <h2 style=\"text-align: center;\n"
                + "               margin-top: 2%;\n"
                + "               font-weight: 300;\n"
                + "               font-size: 40px;\n"
                + "               line-height: 60px;\">\n"
                + "    </h2>\n"
                + "    </header>\n"
                + "\n"
                + "<div style=\"margin-top: 5%;\"><div style=\"font-size: 20px;color: #3c86c6;\">Bogotá D.C.,<div style=\"font-size: 20px;float: right;\">" + fecha + "</div></div><div>"
                + "\n"
                + "    <h2 style=\"font-weight: 100;\n"
                + "    font-size: 27px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #3c86c6;\">Apreciad@ " + hashMapData.get("sNombres") + "</h2>\n"
                + "\n"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Nos permitimos informarle que su solicitud ha sido aprobada. \n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Con el Valor de: " + hashMapData.get("sValor") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Radicada con el N°: " + hashMapData.get("sRadicado") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> A continuacion por favor realice la firma del pagare \n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Tipo de Credito Seleccionado:  \n</p>"
                + " <p style=\"font-weight: 100;\n"
                + "    font-size: 32px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #236EB6; font-weight: 300;\"><strong> " + hashMapData.get("sTipoSolicitud") + "</strong></p>"
                + "\n"
                + (!hashMapData.get("sObservacion").equals("") ? " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Motivo:  " + hashMapData.get("sObservacion") + " </p>" : "")
                + "\n"
                + "</body>";
        return rta;
    }

    //Esta Solicitud se Genera en la Pantalla despues de Aprobar el Pago y Desembolsarlo en la Cuenta de Coopedac para Informarle al Cliente que se aprobo el credito
    public RespuestaGenerica Desembolsado(Long iCodigo, Long Radicado, String LCredito, String cEntidad, String cCuenta, String cValor) throws Exception {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        Persona nombreUsuario = new PersonaServiceBean().personaWebFindByID(iCodigo);
        
        try {
            String sMailDestino = nombreUsuario.getDatosPersonalesList().get(0).getCEmail();
            String sNombresPersona = nombreUsuario.getCNombres() + "" + nombreUsuario.getCApellidos();
            String tipoEstado = LCredito;
            String sRadicado = String.valueOf(Radicado);
            String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");

            HashMap<String, String> hashMapData = new HashMap<>();

            hashMapData.put("sNombres", sNombresPersona);
            hashMapData.put("sTipoSolicitud", tipoEstado);
            hashMapData.put("sRadicado", sRadicado);
            hashMapData.put("cEntidad", cEntidad);
            hashMapData.put("cCuenta", cCuenta);
            hashMapData.put("cValor", cValor);
            hashMapData.put("sObservacion", "");

            Solicitud_Correo_ServiceBean s = new Solicitud_Correo_ServiceBean();

            String crearCuerpoHtmlAprobada = s.HTMLDesembolsado(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));

            boolean enviarEmial = enviarEmail.SendEmailHTML(sMailDestino, sEmailRemitente, crearCuerpoHtmlAprobada, "Informativo: Solicitud Desembolsada");

            if (enviarEmial /*&& enviarEmailAprobado/*sms.getStatus().equals("1x000")*/) {
                System.out.println("Envio EMAIL");
                respuesta.setbRta(Boolean.TRUE);
                respuesta.setiCodigo(1);
                respuesta.setsMsj("Se ha Desembolsado la plata Exitosamente");

            } else {
                System.out.println("No Envio EMAIL");
                respuesta.setbRta(Boolean.FALSE);
                respuesta.setiCodigo(1);
                respuesta.setsMsj("No se envio Correo");
            }
        } catch (Exception e) {
            System.out.println("Error Envio EMAIL");
            e.printStackTrace();
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setsMsj("Ha ocurrido un error inesperado, por favor intentelo de nuevo");
        }
        return respuesta;
    }

    public String HTMLDesembolsado(HashMap<String, String> hashMapData, String fecha) {
        String rta = "<body>\n"
                + "    <header style=\"height: 60px; background-color: #76c25c;\">\n"
                + "    <h2 style=\"text-align: center;\n"
                + "               margin-top: 2%;\n"
                + "               font-weight: 300;\n"
                + "               font-size: 40px;\n"
                + "               line-height: 60px;\">\n"
                + "    </h2>\n"
                + "    </header>\n"
                + "\n"
                + "<div style=\"margin-top: 5%;\"><div style=\"font-size: 20px;color: #3c86c6;\">Bogotá D.C.,<div style=\"font-size: 20px;float: right;\">" + fecha + "</div></div><div>"
                + "\n"
                + "    <h2 style=\"font-weight: 100;\n"
                + "    font-size: 27px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #3c86c6;\">Apreciad@ " + hashMapData.get("sNombres") + "</h2>\n"
                + "\n"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Nos permitimos informarle que su credito a sido desembolsado exitosamente. \n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> N° Radicado:  " + hashMapData.get("sRadicado") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Entidad:  " + hashMapData.get("cEntidad") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> N° de Cuenta:  " + hashMapData.get("cCuenta") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Valor Consignado:  " + hashMapData.get("cValor") + "\n</p>"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Tipo de Credito Seleccionado:  \n</p>"
                + " <p style=\"font-weight: 100;\n"
                + "    font-size: 32px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #236EB6; font-weight: 300;\"><strong> " + hashMapData.get("sTipoSolicitud") + "</strong></p>"
                + "\n"
                + (!hashMapData.get("sObservacion").equals("") ? " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Motivo:  " + hashMapData.get("sObservacion") + " </p>" : "")
                + "\n"
                + "</body>";
        return rta;
    }

}
