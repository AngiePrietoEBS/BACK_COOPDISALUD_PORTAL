/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.ProcesoValidacionAccesoPersDataAccesImp;
import com.ebssas.wsrestapicoopedac.request.RequestValidCodigo;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.general.EncriptarSha;
import com.ebssas.wsrestapicoopedac.general.CrearEmailHTML;
//import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.dataaccess.ValidacionAccesoPersonaDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.domain.ProcesoValidacionAccesoPers;
import com.ebssas.wsrestapicoopedac.domain.ValidacionAccesoPersona;
;
import com.ebssas.wsrestapicoopedac.seguridad.JwtTokenHelper;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.sms.ResponseSendSMSV3;
import com.ebssas.wsrestapicoopedac.sms.sendSMS;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Administrador
 */


public class ValidacionAccesoPersonaServiceBean implements ValidacionAccesoPersonaService {

    private final Utilidad util = new Utilidad();
    private final EncriptarSha sha = new EncriptarSha();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final JwtTokenHelper jwtTokenHelper = new JwtTokenHelper();
    private final ProcesoValidacionAccesoPersDataAccesImp pvapdai = new ProcesoValidacionAccesoPersDataAccesImp();
    private final RegistroNuevoUsuarioServiceBean nuevoUsuarioServiceBean = new RegistroNuevoUsuarioServiceBean();

    @Override
    public RespuestaGenerica generarCodigo(String email, String celular) {
        RespuestaGenerica generica = new RespuestaGenerica();

        try {
            if (email != null && celular != null) {
                if (email.contains("@")) {
                    String sCantDigKeyToken = parametroServiceBean.obtenerParametroPorNombre("CANT_KEY_SOL_CRED");

                    int iCantDigKey = Integer.parseInt(sCantDigKeyToken);
                    String sTokenRandom = util.generarAleatorio(iCantDigKey);

                    String sCantDigKeyToken2 = parametroServiceBean.obtenerParametroPorNombre("CANT_KEY_SOL_CRED");
                    String sMinVigToken = parametroServiceBean.obtenerParametroPorNombre("MINUTOS_VIG_TOKEN_SOL_CRED");
                    this.inactivarTokens(email, celular);
                    int iMinutosVigToken = Integer.parseInt(sMinVigToken);
                    int iCantDigKey2 = Integer.parseInt(sCantDigKeyToken2);
                    Date dateInicio = new Date();
                    Date dateFin = util.getDateAddMinutos(dateInicio, iMinutosVigToken);
                    String sKeyRandomSHA = util.passwordRandom(iCantDigKey2);
                    String sEncodeKey = util.encodeBase64(sKeyRandomSHA);
                    String sTokenSha = sha.encriptar(sTokenRandom, sKeyRandomSHA);

                    ValidacionAccesoPersona validarIdentSolCredN = new ValidacionAccesoPersona();
                    validarIdentSolCredN.setFFechaInicio(dateInicio);
                    validarIdentSolCredN.setFFechaFin(dateFin);
                    validarIdentSolCredN.setCToken(sTokenSha);
                    validarIdentSolCredN.setCKeyToken(sEncodeKey);
                    validarIdentSolCredN.setCEstado("ACT");
                    ValidacionAccesoPersona validarIdentSolCredC = new ValidacionAccesoPersonaDataAccessImp().save(validarIdentSolCredN);
                    if (validarIdentSolCredC != null && validarIdentSolCredC.getICodigo() != null && !validarIdentSolCredC.getCEstado().equals("")) {
                        ProcesoValidacionAccesoPers accesoPers = new ProcesoValidacionAccesoPers();
                        accesoPers.setCEmail(email);
                        accesoPers.setCCelular(celular);
                        accesoPers.setFFechaRegistro(new Date());
                        accesoPers.setIValidacionAccesoPersona(validarIdentSolCredN);

                        ProcesoValidacionAccesoPers accesImp = new ProcesoValidacionAccesoPersDataAccesImp().create(accesoPers);
                        HashMap<String, String> hashMapData = new HashMap<>();
                        hashMapData.put("sCodigo", sTokenRandom);
                        String sEmailRemitente = parametroServiceBean.obtenerParametroPorNombre("CORREO_MAIL");
                        String sCorreoOculto = util.ocultarCorreo(email);
                        String sEmailHTML = new CrearEmailHTML().emailCodigoVerificacionRegUsu(hashMapData);

                        String sCelularOculto = util.ocultarTelefono(celular);

                        String mensaje = "El siguiente codigo de verificacion es generado para la validacion de identidad " + sTokenRandom;

                        // andysierra log
                        System.err.println("\n**********************************************");
                        System.err.println(mensaje);
                        System.err.println("\n");

                        Boolean bRtaSendMailHTML = new SendEmailSMTP().SendEmailHTML(email, sEmailRemitente, sEmailHTML, "CÓDIGO DE VERIFICACIÓN ACCESO AL PORTAL WEB");
                        ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", celular, mensaje, "0");
//Activar SMS Sebastian Forero
//                        ResponseSendSMSV3 sms = new sendSMS().envioSMS_SencilloV3("57", celular, mensaje, "1");
//                        if (sms.getStatus().equals("1x000") || bRtaSendMailHTML) {
                        if (bRtaSendMailHTML) {
                            generica.setbRta(Boolean.TRUE);
                            generica.setiCodigo(2);
                            generica.setsMsj("Se ha reenviado el código de verificación al número de celular " + sCelularOculto + " y al correo " + sCorreoOculto + ".");
                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setiCodigo(0);
                            generica.setsMsj("No se ha podido enviar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con la entidad.");
                        }

                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con la entidad.");
                    }
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setiCodigo(0);
                    generica.setsMsj("El correo o el número del celular no son validos.");
                }

            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setiCodigo(0);
                generica.setsMsj("Todos los datos son necesarios para validar la identidad.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("No se ha podido generar el código de verificación. Por favor intente de nuevo, si el error persiste comuniquese con la entidad.");
        }

        return generica;
    }

    @Override
    public RespuestaGenerica validarCodigo(RequestValidCodigo requestValidCodigo) {
        RespuestaGenerica generica = new RespuestaGenerica();

        try {
            ValidacionAccesoPersona validarIdentSolCred = this.findById(requestValidCodigo.getsCorreo(), requestValidCodigo.getsCelular());
            if (validarIdentSolCred != null && validarIdentSolCred.getICodigo() != null) {
                if (new Date().after(validarIdentSolCred.getFFechaInicio()) && new Date().before(validarIdentSolCred.getFFechaFin())) {
                    HashMap<String, Object> valToken = new HashMap<String, Object>();

                    String jwt = "";

                    String sDecodeKey = util.decodeBase64(validarIdentSolCred.getCKeyToken());
                    String sToken = validarIdentSolCred.getCToken();
                    String sSHAToken = sha.encriptar(requestValidCodigo.getsCodigo(), sDecodeKey);

                    if (sSHAToken.equals(sToken)) {

                        CygnusCoreServiceBean coreServiceBean = new CygnusCoreServiceBean();

                        List<PersonasDTO> personaCore = coreServiceBean.wsConsultarPersona("", requestValidCodigo.getsTipoDocumento(), requestValidCodigo.getsDocumento());

                        if (personaCore != null && !personaCore.isEmpty()) {

                            PersonasDTO personaDTO = personaCore.get(0);

                            List<PersonasDTO> empresaCore = coreServiceBean.wsConsultarPersona(personaDTO.getICodEmp(), "", "");
                            PersonasDTO empresaDTO = null;
                            if (empresaCore != null && !empresaCore.isEmpty()) {
                                empresaDTO = empresaCore.get(0);
                            }

                            PersonaServiceBean consultarPersona = new PersonaServiceBean();
                            Persona personaC = consultarPersona.personaWebFindByCIdentificacion(Integer.parseInt(requestValidCodigo.getsTipoDocumento()), requestValidCodigo.getsDocumento());
                            if (personaC.getICodigo() == null) {
                                // Consultar codigo de persona en el core
                                Persona persona = new Persona();
                                persona.setICodigo(Long.parseLong(personaDTO.getICodigo()));
                                persona.setITipoIdent(Long.parseLong(requestValidCodigo.getsTipoDocumento()));
                                persona.setCIdentificacion(requestValidCodigo.getsDocumento());

                                String nombresApellidos = coreServiceBean.getNombre("", requestValidCodigo.getsTipoDocumento(), requestValidCodigo.getsDocumento());
                                String nombreSeparado[] = nombresApellidos.split("-");
                                if (nombreSeparado.length > 1) {
                                    persona.setCNombres(nombreSeparado[0]);
                                    persona.setCApellidos(nombreSeparado[1]);
                                    valToken.put("sNombre", persona.getCNombres());
                                    valToken.put("sApellido", persona.getCApellidos());
                                } else {
                                    persona.setCNombres(nombreSeparado[0]);
                                    valToken.put("sNombre", persona.getCNombres());
                                }

                                if (empresaDTO != null) {
                                    valToken.put("sEmpresa", empresaDTO.getCRazonSoc());
                                } else {
                                    valToken.put("sEmpresa", "");
                                }

                                String sClaveUsuEncriptada = "", sLlaveSeg = "", sEmailPersona = "", sNombreCompletoPersona = "";
                                String sMinPrimerPassword = parametroServiceBean.obtenerParametroPorNombre("CANT_SALT");
                                int iMinPrimerPassword = Integer.parseInt(sMinPrimerPassword);
                                sLlaveSeg = util.generarAleatorio(iMinPrimerPassword);
                                sClaveUsuEncriptada = sha.encriptar(requestValidCodigo.getsDocumento(), sLlaveSeg);

                                RespuestaGenerica rtaGenRegistroUsuNuevo = new RespuestaGenerica();
                                rtaGenRegistroUsuNuevo = nuevoUsuarioServiceBean.realizarRegistroNuevoUsuario(persona, sClaveUsuEncriptada, sLlaveSeg, 3, 1);

                                valToken.put("codPersona", persona.getICodigo());
                                valToken.put("sMsj", rtaGenRegistroUsuNuevo);
                                jwt = jwtTokenHelper.generateJwtTokenSucces(valToken);
                                JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                                generica.setbRta(Boolean.TRUE);
                                generica.setiCodigo(1);
                                generica.setsMsj(json.toString());

                            } else {
                                valToken.put("codPersona", personaC.getICodigo());
                                valToken.put("sNombre", personaC.getCNombres());
                                valToken.put("sApellido", personaC.getCApellidos());
                                if (empresaDTO != null) {
                                    valToken.put("sEmpresa", empresaDTO.getCRazonSoc());
                                } else {
                                    valToken.put("sEmpresa", "");
                                }
                                valToken.put("sMsj", "Consulta exitosa...");
                                jwt = jwtTokenHelper.generateJwtTokenSucces(valToken);
                                JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
                                generica.setbRta(Boolean.TRUE);
                                generica.setiCodigo(1);
                                generica.setsMsj(json.toString());
                            }
                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setiCodigo(0);
                            generica.setsMsj("No es encontro registros con el número de documento " + requestValidCodigo.getsDocumento() + ".");
                        }

                        /*SessionUsuarioServiceBean sessionUsuario = new SessionUsuarioServiceBean();
                    sessionUsuario.saveSession(new Usuario(requestValidCodigo.getlCodUsuario()), requestValidCodigo.getsNavegador(), requestValidCodigo.getlTipoCanal());*/
                        //valToken.put("codUsuario", requestValidCodigo.getlCodUsuario());
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setiCodigo(0);
                        generica.setsMsj("Por favor verifique el código ingresado, no corresponde al enviado.");
                    }

                } else {
                    generica = this.generarCodigo(requestValidCodigo.getsCorreo(), requestValidCodigo.getsCelular());
                }
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setiCodigo(0);
                generica.setsMsj("Estimado señor@ no cuenta con un código de verificación.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("Se ha presentado un problema al validar el código por favor intente más tarde.");
            //throw new RuntimeException(e.getMessage());
        }

        return generica;
    }

    @Override
    public void inactivarTokens(String email, String celular) {

        List<ProcesoValidacionAccesoPers> listProcesosE = this.pvapdai.findProcesoByEmailAndCelular(email, celular);

        if (listProcesosE != null && !listProcesosE.isEmpty()) {
            for (ProcesoValidacionAccesoPers proceso : listProcesosE) {
                new ValidacionAccesoPersonaDataAccessImp().inactivarTokens(proceso.getICodigo());
            }
        }
    }

    @Override
    public ValidacionAccesoPersona findById(String email, String celular) {

        ValidacionAccesoPersona validacionAccesoPersona = new ValidacionAccesoPersona();
        List<ProcesoValidacionAccesoPers> listProcesosE = this.pvapdai.findProcesoByEmailAndCelular(email, celular);
        if (listProcesosE != null && !listProcesosE.isEmpty()) {
            for (ProcesoValidacionAccesoPers proceso : listProcesosE) {
                ValidacionAccesoPersona accesoPersona = new ValidacionAccesoPersonaDataAccessImp().findByIdSolCred(proceso.getICodigo());
                if (accesoPersona.getICodigo() != null && accesoPersona.getCEstado().equals("ACT")) {
                    validacionAccesoPersona = accesoPersona;
                }
            }
        }

        return validacionAccesoPersona;
    }

}
