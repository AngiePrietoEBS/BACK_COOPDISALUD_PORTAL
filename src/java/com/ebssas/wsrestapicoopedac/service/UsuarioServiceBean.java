/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;


import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.AccesoDataAccessImp;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.dataaccess.UsuarioDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Acceso;
import com.ebssas.wsrestapicoopedac.domain.PerfilTransaccional;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.EncriptarSha;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
/*import com.ebssas.wsrestapicoopedac.request.RequestClaveNueva;
import com.ebssas.wsrestapicoopedac.request.RequestOlvidoClave;
import com.ebssas.wsrestapicoopedac.response.ResponseOlvidoClave;
import com.ebssas.wsrestapicoopedac.response.ResponseUsuario;
import com.ebssas.wsrestapicoopedac.response.metodoEnvioOlvidoClave;
import static com.ebssas.wsrestapicoopedac.service.SolicitudCreditoServiceBean.sendEmail;*/
//import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class UsuarioServiceBean implements UsuarioService {

    private final CygnusCoreServiceBean cygnusCoreServiceBean = new CygnusCoreServiceBean();
    private final UsuarioDataAccessImp usuarioDataAccessImp = new UsuarioDataAccessImp();
    private final AccesoServiceBean accesoServiceBean = new AccesoServiceBean();
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();

    private final Utilidad util = new Utilidad();
    private final EncriptarSha encripar = new EncriptarSha();

    @Override
    public Usuario findUsuarioById(Long id) {
        Usuario usuario = usuarioDataAccessImp.findUsuarioById(id);
        return usuario;
    }

    public Usuario buscarUsuarioId(long id) {
        Usuario usuarioWeb = new Usuario();
        usuarioWeb = usuarioDataAccessImp.findUsuarioById(id);
        if (usuarioWeb != null && usuarioWeb.getICodigo() != null) {
            usuarioWeb.setbRta(Boolean.FALSE);
            usuarioWeb.setsMensaje("Se trajeron los datos usuario con Nï¿½ de Id " + id);
        } else {
            usuarioWeb = new Usuario();
            usuarioWeb.setbRta(Boolean.TRUE);
            usuarioWeb.setsMensaje("No se pudo traer los datos del usuario con Nï¿½ de Id " + id);
        }
        return usuarioWeb;
    }

    public Usuario findUserByPersonaIdentidad(int iTipoIdent, String sIdent) {
        Usuario findUserByPersonaIdent = usuarioDataAccessImp.findUserByPersonaIdent(iTipoIdent, sIdent);
        return findUserByPersonaIdent;
    }
    
    /**
     * Método que permite buscar un usuario en base a su idCodigo
     * @param id tipo long.
     * @return un objeto tipo persona.
     */
     public Usuario findUsuarioByICodigo(Long id) {
        Usuario usuario = usuarioDataAccessImp.findUserByICodigo(id);
        return usuario;
    }

//    @Override
//    public ResponseUsuario findUserByPersonaIdent(int iTipoIdent, String sIdent) {
//        ResponseUsuario response = new ResponseUsuario();
//        Usuario usuarioWeb = usuarioDataAccessImp.findUserByPersonaIdent(iTipoIdent, sIdent);
//        if (usuarioWeb != null && usuarioWeb.getICodigo() != null) {
//            response.setFlag(Boolean.TRUE);
//            response.setsMsg("Se trajeron los datos usuario con Nï¿½ de Id " + sIdent);
//            List<Usuario> listUser = new ArrayList<>();
//            listUser.add(usuarioWeb);
//            response.setListUsuarios(listUser);
//        } else {
//            response.setFlag(Boolean.FALSE);
//            response.setsMsg("No se pudo traer los datos del usuario con Nï¿½ de Id " + sIdent);
//        }
//        return response;
//    }
//
//    @Override
//    public ResponseUsuario listarTodosUsuarios() {
//        ResponseUsuario response = new ResponseUsuario();
//        try {
//            List<Usuario> listarUsuarios = usuarioDataAccessImp.listarTodosUsuarios();
//            if (listarUsuarios != null && !listarUsuarios.isEmpty()) {
//                response.setFlag(true);
//                response.setsMsg("Lista de usuarios encontrada correctamente");
//                response.setListUsuarios(listarUsuarios);
//            } else {
//                response.setFlag(false);
//                response.setsMsg("No se ha encontrado ningï¿½n usuario");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setFlag(false);
//            response.setsMsg("Ha ocurrido un error al listar los usuarios");
//        }
//        return response;
//    }
//
//    @Override
//    public RespuestaGenerica cambiarContraseniaAdminAUsuarios(RequestClaveNueva requestClaveNueva) {
//        RespuestaGenerica response = new RespuestaGenerica();
//        try {
//            Usuario usuarioBuscado = usuarioDataAccessImp.findUsuarioById(requestClaveNueva.getiCodUsuario());
//            List<PersonasDTO> persona = cygnusCoreServiceBean.wsConsultarPersona("", String.valueOf(usuarioBuscado.getIPersona().getITipoIdent()), usuarioBuscado.getIPersona().getCIdentificacion());
//            if (usuarioBuscado != null) {
//                Acceso accesoBuscado = new AccesoDataAccessImp().findAccesoByIUsuarioAndiTransaccion(usuarioBuscado.getICodigo(), 1);
//                if (accesoBuscado != null) {
//                    if (requestClaveNueva.getxClaveNueva().equals(requestClaveNueva.getxClaveNuevaConfirma())) {
//                        String xClaveNueva = encripar.encriptar(requestClaveNueva.getxClaveNueva(), accesoBuscado.getCLlaveSeguridad());
//                        accesoBuscado.setCClave(xClaveNueva);
//                        Acceso updateAcceso = accesoServiceBean.updateAcceso(accesoBuscado);
//                        SendEmail sen = new SendEmail();
//                        HashMap<String, String> hashMapData = new HashMap<>();
//                        String nombreCompleto = usuarioBuscado.getIPersona().getCNombres() + " " + usuarioBuscado.getIPersona().getCApellidos();
//                        hashMapData.put("sNombres", usuarioBuscado.getIPersona().getCNombres());
//                        hashMapData.put("sApellidos", usuarioBuscado.getIPersona().getCApellidos());
//                        hashMapData.put("sClave", requestClaveNueva.getxClaveNueva());
//                        String crearCuerpoHtml = sendEmail.cuerpoHTMLNuevaClave(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
//                        boolean enviarCorreo = sen.enviarEmail(nombreCompleto, persona.get(0).getCEMail(), "Restablecer contraseï¿½a", crearCuerpoHtml);
//                        if (updateAcceso != null && updateAcceso.getICodigo() != null && enviarCorreo) {
//                            response.setbRta(Boolean.TRUE);
//                            response.setsMsj("La clave se ha cambiado de manera correcta, se ha enviado un correo electrï¿½nico al usuario.");
//                        } else {
//                            response.setbRta(Boolean.FALSE);
//                            response.setsMsj("Ha ocurrido un error al intentar cambiar la clave, por favor intentelo de nuevo");
//                        }
//                    } else {
//                        response.setbRta(Boolean.FALSE);
//                        response.setsMsj("Las contraseï¿½as no coinciden, por favor intentelo de nuevo");
//                    }
//                } else {
//                    response.setbRta(Boolean.FALSE);
//                    response.setsMsj("No se ha encontrado ninguna clave para el usuario, por favor comuniquese con la entidad.");
//                }
//            } else {
//                response.setbRta(Boolean.FALSE);
//                response.setsMsj("No se ha encontrado un usuario para poder cambiar la clave");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setbRta(false);
//            response.setsMsj("Ha ocurrido un error al intentar cambiar la clave, por favor intentelo de nuevo");
//        }
//        return response;
//    }
//
//    @Override
//    public RespuestaGenerica cambiarContraseniaAdmin(RequestClaveNueva requestClaveNueva) {
//        RespuestaGenerica response = new RespuestaGenerica();
//        try {
//            Usuario usuarioBuscado = usuarioDataAccessImp.findUsuarioById(requestClaveNueva.getiCodUsuario());
//            List<PersonasDTO> persona = cygnusCoreServiceBean.wsConsultarPersona("", String.valueOf(usuarioBuscado.getIPersona().getITipoIdent()), usuarioBuscado.getIPersona().getCIdentificacion());
//            if (usuarioBuscado != null) {
//                Acceso accesoBuscado = new AccesoDataAccessImp().findAccesoByIUsuarioAndiTransaccion(usuarioBuscado.getICodigo(), 1);
//                if (accesoBuscado != null) {
//                    String xClaveAnteriorEncr = encripar.encriptar(requestClaveNueva.getxClaveAnterior(), accesoBuscado.getCLlaveSeguridad());
//                    if (xClaveAnteriorEncr.equals(accesoBuscado.getCClave())) {
//                        if (requestClaveNueva.getxClaveNueva().equals(requestClaveNueva.getxClaveNuevaConfirma())) {
//                            String xClaveNueva = encripar.encriptar(requestClaveNueva.getxClaveNueva(), accesoBuscado.getCLlaveSeguridad());
//                            accesoBuscado.setCClave(xClaveNueva);
//                            Acceso updateAcceso = accesoServiceBean.updateAcceso(accesoBuscado);
//                            SendEmail sen = new SendEmail();
//                            HashMap<String, String> hashMapData = new HashMap<>();
//                            String nombreCompleto = usuarioBuscado.getIPersona().getCNombres() + " " + usuarioBuscado.getIPersona().getCApellidos();
//                            hashMapData.put("sNombres", usuarioBuscado.getIPersona().getCNombres());
//                            hashMapData.put("sApellidos", usuarioBuscado.getIPersona().getCApellidos());
//                            hashMapData.put("sClave", requestClaveNueva.getxClaveNueva());
//                            String crearCuerpoHtml = sendEmail.cuerpoHTMLNuevaClave(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
//                            boolean enviarCorreo = sen.enviarEmail(nombreCompleto, persona.get(0).getCEMail(), "Restablecer contraseï¿½a", crearCuerpoHtml);
//                            if (updateAcceso != null && updateAcceso.getICodigo() != null) {
//                                response.setbRta(Boolean.TRUE);
//                                response.setsMsj("La clave se ha cambiado de manera correcta, se ha enviado un correo electrï¿½nico al usuario.");
//                            } else {
//                                response.setbRta(Boolean.FALSE);
//                                response.setsMsj("Ha ocurrido un error al intentar cambiar la clave, por favor intentelo de nuevo");
//                            }
//                        } else {
//                            response.setbRta(Boolean.FALSE);
//                            response.setsMsj("Las contraseï¿½as no coinciden, por favor intentelo de nuevo");
//                        }
//                    } else {
//                        response.setbRta(Boolean.FALSE);
//                        response.setsMsj("La clave anterior es incorrecta, por favor intente de nuevo.");
//                    }
//                } else {
//                    response.setbRta(Boolean.FALSE);
//                    response.setsMsj("No se ha encontrado ninguna clave para el usuario, por favor comuniquese con la entidad.");
//                }
//            } else {
//                response.setbRta(Boolean.FALSE);
//                response.setsMsj("No se ha encontrado un usuario para poder cambiar la clave");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setbRta(false);
//            response.setsMsj("Ha ocurrido un error al intentar cambiar la clave, por favor intentelo de nuevo");
//        }
//        return response;
//    }
//
//    public ResponseOlvidoClave validaOlvidoClave(String xsData, Long iTipoCanal) {
//        Usuario usuario = new Usuario();
//        ResponseOlvidoClave responseOlvidoClave = new ResponseOlvidoClave();
//        try {
//            String sIdent = "";
//            int iTipoPerfil = 0, iTipoIdent = 0;
//            String sDecodeData = util.decodeBase64(xsData);
//            if (sDecodeData != null && !sDecodeData.equals("")) {
//                String sSplitParam[] = sDecodeData.split(";");
//                if (sSplitParam.length > 0) {
//                    iTipoIdent = Integer.parseInt(sSplitParam[0]);
//                    sIdent = sSplitParam[1];
//                    iTipoPerfil = Integer.parseInt(sSplitParam[2]);
//                    System.out.println("Entra aqui donde estan los datos" + iTipoIdent + " " + sIdent + " " + iTipoPerfil);
//                }
//                if (iTipoIdent != 0 && (sIdent != null && !sIdent.equals("")) && iTipoPerfil != 0) {
//                    usuario = usuarioDataAccessImp.validaOlvidoClaveForUser(iTipoIdent, sIdent, iTipoPerfil, iTipoCanal);
//                } else {
//                    usuario.setbRta(Boolean.FALSE);
//                    usuario.setsMensaje("En el momento no es posible realizar la validaciï¿½n. Por favor intente de nuevo mï¿½s tarde.");
//                }
//            } else {
//                usuario.setbRta(Boolean.FALSE);
//                usuario.setsMensaje("En el momento no es posible realizar la validaciï¿½n. Por favor intente de nuevo mï¿½s tarde.");
//            }
//
//            if (usuario.getbRta()) {
//                List<PerfilTransaccional> perfilTransaccionalList = new ArrayList<>();
//                List<metodoEnvioOlvidoClave> lstMetodoOlvidoClave = new ArrayList<>();
//
//                perfilTransaccionalList = usuario.getPerfilTransaccionalList();
//                int i = 0;
//                if (perfilTransaccionalList != null && !perfilTransaccionalList.isEmpty()) {
//                    metodoEnvioOlvidoClave envioOlvidoClave = new metodoEnvioOlvidoClave();
//                    for (PerfilTransaccional perfilTransaccional : perfilTransaccionalList) {
//                        if (perfilTransaccional.getITransaccion().getITipoTran().getICodigo() == 2) {
//                            if (perfilTransaccional.getITransaccion().getCEstado().equals("ACT")) {
//                                i = i + 1;
//                                switch (perfilTransaccional.getITransaccion().getCValidacion()) {
//                                    case "EMAIL":
//                                        String sEmailPersona = cygnusCoreServiceBean.getEmailPersona(String.valueOf(usuario.getIPersona().getICodigo()), String.valueOf(iTipoIdent), sIdent);
//                                        envioOlvidoClave.setiCodMetodoEnvio(i);
//                                        envioOlvidoClave.setsValidaMetodo(perfilTransaccional.getITransaccion().getCValidacion());
//                                        envioOlvidoClave.setsDescMetodoEnvio(perfilTransaccional.getITransaccion().getCDescripcion());
//                                        envioOlvidoClave.setsDestinoEnvioClave(util.ocultarCorreo(sEmailPersona));
//                                        break;
//                                    case "SMS":
//                                        //                                String sTelPersona = cygnusCoreServiceBean.getTelPersona(String.valueOf(usuario.getIPersona().getICodigo()), String.valueOf(iTipoIdent), sIdent);
//                                        break;
//                                    default:
//                                        break;
//                                }
//
//                                lstMetodoOlvidoClave.add(envioOlvidoClave);
//                            } else {
//                                responseOlvidoClave.setbRta(Boolean.FALSE);
//                                responseOlvidoClave.setiCodigo(0);
//                                responseOlvidoClave.setsMsj("No cuenta con un metodo de envï¿½o de informaciï¿½n activo.");
//                            }
//                        }
//                    }
//                } else {
//                    responseOlvidoClave.setbRta(Boolean.FALSE);
//                    responseOlvidoClave.setiCodigo(0);
//                    responseOlvidoClave.setsMsj("No cuenta con un metodo de envï¿½o de informaciï¿½n para realizar el proceso.");
//                }
//                if (lstMetodoOlvidoClave != null && !lstMetodoOlvidoClave.isEmpty()) {
//                    responseOlvidoClave.setbRta(Boolean.TRUE);
//                    responseOlvidoClave.setiCodigo(1);
//                    responseOlvidoClave.setsMsj("Seleccione el metodo de envï¿½o al cual desea le sea enviada la clave.");
//                    responseOlvidoClave.setMetodosEnvioInfoClave(lstMetodoOlvidoClave);
//                }
//
//            } else {
//                responseOlvidoClave.setbRta(usuario.getbRta());
//                responseOlvidoClave.setiCodigo(0);
//                responseOlvidoClave.setsMsj(usuario.getsMensaje());
//            }
//
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            usuario.setbRta(Boolean.FALSE);
//            usuario.setsMensaje("Ha ocurrido un inconveniente al intentar realizar la validaciï¿½n. Por favor intente de nuevo");
//        }
//
//        return responseOlvidoClave;
//    }
//
//    @Override
//    public RespuestaGenerica generarClaveNueva(String xsData) {
//        RespuestaGenerica rtaGenerica = new RespuestaGenerica();
//        try {
//            String sIdent = "", sValidaEnvioInfo = "";
//            int iTipoIdent = 0;
//            String sDecodeData = util.decodeBase64(xsData);
//            
//            if (sDecodeData != null && !sDecodeData.equals("")) {
//                String sSplitParam[] = sDecodeData.split(";");
//                if (sSplitParam.length > 0) {
//                    iTipoIdent = Integer.parseInt(sSplitParam[0]);
//                    sIdent = sSplitParam[1];
//                }
//                if (iTipoIdent != 0 && (sIdent != null && !sIdent.equals(""))) {
//                    String sClaveEncriptada = "", sLlaveSeg = "", sNombresPersona = "", sApellidosPersona = "";
//                    String sMinPrimerPassword = parametroServiceBean.obtenerParametroPorNombre("MIN_PRIMER_PASSWORD");
//                    String sCantSaltKeySeg = parametroServiceBean.obtenerParametroPorNombre("CANT_SALT");
//                    String sDiasVigPrimeraClave = parametroServiceBean.obtenerParametroPorNombre("DIAS_VIGENCIA_PRI_CLAVE");
//                    int iMinPrimerPassword = Integer.parseInt(sMinPrimerPassword);
//                    int iCantSaltKeySeg = Integer.parseInt(sCantSaltKeySeg);
//                    int iDiasVigPrimeraClave = Integer.parseInt(sDiasVigPrimeraClave);
//                    sLlaveSeg = util.generarAleatorio(iCantSaltKeySeg);
//                    String sClave = util.passwordRandom(iMinPrimerPassword);
//                    sClaveEncriptada = encripar.encriptar(sClave, sLlaveSeg);
//                    Usuario findUserByPersonaIdent = this.findUserByPersonaIdentidad(iTipoIdent, sIdent);
//                    if (findUserByPersonaIdent != null && findUserByPersonaIdent.getICodigo() != null) {
//                        Acceso findAccesoByiUser = accesoServiceBean.findAccesoByIUsuarioAndiTransaccion(findUserByPersonaIdent.getICodigo(), 1);
//                        if (findAccesoByiUser != null && findAccesoByiUser.getICodigo() != null) {
//                            Acceso updateAcceso = findAccesoByiUser;
//                            Date fFinPrimeraClave = util.getDateAdd(iDiasVigPrimeraClave);
//                            updateAcceso.setCClave(sClaveEncriptada);
//                            updateAcceso.setCEstado("ACT");
//                            updateAcceso.setCLlaveSeguridad(sLlaveSeg);
//                            updateAcceso.setFInicio(new Date());
//                            updateAcceso.setFFin(fFinPrimeraClave);
//                            updateAcceso.setIUsuario(findUserByPersonaIdent);
//                            updateAcceso.setITransaccion(findAccesoByiUser.getITransaccion());
//                            Acceso updateAccesoByUser = accesoServiceBean.updateAcceso(updateAcceso);
//                            if (updateAccesoByUser != null && updateAccesoByUser.getICodigo() != null) {
//                                SendEmail sen = new SendEmail();
//                                sNombresPersona = updateAccesoByUser.getIUsuario().getIPersona().getCNombres();
//                                sApellidosPersona = updateAccesoByUser.getIUsuario().getIPersona().getCApellidos();
//                                String sEmailPersona = cygnusCoreServiceBean.getEmailPersona("", String.valueOf(iTipoIdent), sIdent);
//                                HashMap<String, String> hashMapData = new HashMap<>();
//                                hashMapData.put("sDescTipoDOI", "CEDULA DE CIUDADANIA");
//                                hashMapData.put("sNumDOI", sIdent);
//                                hashMapData.put("sNombres", sNombresPersona);
//                                hashMapData.put("sApellidos", sApellidosPersona);
//                                hashMapData.put("sClave", sClave);
//                                hashMapData.put("sEmail", sEmailPersona);
//                                String crearCuerpoHtml = sendEmail.cuerpoHTMLNuevaClave(hashMapData, new Utilidad().dateToStringFormatFecha(new Date()));
//                                boolean enviarCorreo = sen.enviarEmail(sNombresPersona, sEmailPersona, "Restablecer contraseï¿½a", crearCuerpoHtml);
//                                if (enviarCorreo) {
//                                    String sCorreoOculto = "";
//                                    sCorreoOculto = util.ocultarCorreo(sEmailPersona);
//                                    rtaGenerica.setsMsj("Se ha enviado el correo electronico de manera exitosa al siguiente email " + sCorreoOculto + " Por favor revise la bandeja de entrada o en correos no deseados (SPAM).");
//                                    rtaGenerica.setbRta(Boolean.TRUE);
//                                } else {
//                                    rtaGenerica.setbRta(Boolean.FALSE);
//                                    rtaGenerica.setiCodigo(0);
//                                    rtaGenerica.setsMsj("Se ha presentado un inconveniente al enviar el correo con el cambio de clave. Por favor intente de nuevo.");
//                                }
//                            } else {
//                                rtaGenerica.setbRta(Boolean.FALSE);
//                                rtaGenerica.setiCodigo(0);
//                                rtaGenerica.setsMsj("No se ha podigo restablecer la contraseï¿½a. Por favor intente de nuevo mï¿½s tarde.");
//                            }
//                        } else {
//                            rtaGenerica.setbRta(Boolean.FALSE);
//                            rtaGenerica.setiCodigo(0);
//                            rtaGenerica.setsMsj("No se ha podido obtener los datos de acceso del usuario. Por favor intente de nuevo, si el error persiste comuniquese con el encargado.");
//                        }
//                    } else {
//                        rtaGenerica.setbRta(Boolean.FALSE);
//                        rtaGenerica.setiCodigo(0);
//                        rtaGenerica.setsMsj("No se ha podido obtener la informaciï¿½n del usuario. Por favor intente de nuevo, si el error persiste comuniquese con encargado.");
//                    }
//
//                } else {
//                    rtaGenerica.setbRta(Boolean.FALSE);
//                    rtaGenerica.setiCodigo(0);
//                    rtaGenerica.setsMsj("En el momento no es posible realizar la generaciï¿½n de la clave. Por favor intente de nuevo mï¿½s tarde.");
//                }
//            } else {
//                rtaGenerica.setbRta(Boolean.FALSE);
//                rtaGenerica.setiCodigo(0);
//                rtaGenerica.setsMsj("En el momento no es posible realizar la generaciï¿½n de la clave. Por favor intente de nuevo mï¿½s tarde.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            rtaGenerica.setbRta(Boolean.FALSE);
//            rtaGenerica.setsMsj("Se ha presentado un inconveniete al generar la nueva clave web, por favor intente de nuevo mï¿½s tarde.");
//        }
//
//        return rtaGenerica;
//    }

}
