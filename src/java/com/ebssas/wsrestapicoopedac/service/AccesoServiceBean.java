package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.AccesoDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.PersonaDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.SessionUsuarioDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.UsuarioDataAccessImp;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.domain.SessionUsuario;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.EncriptarSha;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestLogin;
import com.ebssas.wsrestapicoopedac.response.RespuestaPersona;
import com.ebssas.wsrestapicoopedac.seguridad.JwtTokenHelper;
import java.util.HashMap;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Brayan F Silva R
 */
public class AccesoServiceBean implements AccesoService {

    //CAPA DE NEGOCIO
    private final JwtTokenHelper jwtTokenHelper = new JwtTokenHelper();

    //UTILIDADES U OTROS
    private final EncriptarSha encripta = new EncriptarSha();
    private final Utilidad util = new Utilidad();

    @Override
    public String validarLogin(RequestLogin loginEmpleado) {
        String rta = "";
        HashMap<String, Object> valToken = new HashMap<>();
        try {

            if (loginEmpleado.getNumDocumento() == null || loginEmpleado.getPassword() == null || loginEmpleado.getTipoDocumento() == null
                    || loginEmpleado.getTipoPerfil() == null || loginEmpleado.getiTipoCanal() == null || loginEmpleado.getsNavegador() == null) {
                valToken.put("bRta", false);
                valToken.put("sMsj", "Todos los datos son necesarios para iniciar sesión");
                rta = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                rta = json.toString();
                return rta;
            }
            

            String sIdent = util.decodeBase64(loginEmpleado.getNumDocumento());
            String sClave = util.decodeBase64(loginEmpleado.getPassword());
            Usuario usuarioBuscado = new UsuarioDataAccessImp().findUserByPersonaIdent(Integer.parseInt(loginEmpleado.getTipoDocumento().toString()), sIdent);
            if (usuarioBuscado == null || usuarioBuscado.getICodigo() == null) {
                valToken.put("bRta", false);
                valToken.put("sMsj", "No se ha encontrado un usuario con identificación: " + loginEmpleado.getNumDocumento());
                rta = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                rta = json.toString();
                return rta;
            }

            AccesoDataAccessImp accesoDataAccessImp = new AccesoDataAccessImp();

            //String sIdent = util.decodeBase64(loginEmpleado.getNumDocumento());
            //String sClave = util.decodeBase64(loginEmpleado.getPassword());
            
            String sLlaveSeguridad = accesoDataAccessImp.getLlaveSeguridadAcceso(loginEmpleado.getTipoDocumento().intValue(), sIdent, "1", loginEmpleado.getTipoPerfil().intValue(), loginEmpleado.getiTipoCanal().intValue());
            if (sLlaveSeguridad == null || sLlaveSeguridad.equals("") || sLlaveSeguridad.equals("0")) {
                valToken.put("bRta", Boolean.FALSE);
                valToken.put("sMsj", "La clave del usuario ha expirado o aún no ha sido registrado.");
                rta = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                rta = json.toString();
                return rta;
            }

            String claveEncriptada = encripta.encriptar(sClave, sLlaveSeguridad);
            if (claveEncriptada == null || claveEncriptada.equals("")) {
                valToken.put("bRta", Boolean.FALSE);
                valToken.put("sMsj", "No se ha podido validar la clave. Por favor intente de nuevo.");
                rta = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                rta = json.toString();
                return rta;
            }

            Usuario respValClave = accesoDataAccessImp.validarPrimeraClave(loginEmpleado.getTipoDocumento().intValue(), sIdent, claveEncriptada, loginEmpleado.getTipoPerfil().intValue(), loginEmpleado.getiTipoCanal().intValue());
            if (respValClave == null || respValClave.getcCodMensaje() != 1) {
                valToken.put("bRta", Boolean.FALSE);
                valToken.put("sMsj", respValClave.getsMensaje());
                rta = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                rta = json.toString();
                return rta;
            }

            /*SessionUsuarioServiceBean sessionUsuario = new SessionUsuarioServiceBean();
            Long lTipoCanal = new Long(String.valueOf(loginEmpleado.getiTipoCanal()));
            sessionUsuario.saveSession(respValClave, loginEmpleado.getsNavegador(), loginEmpleado.getiTipoCanal().intValue());
            SessionUsuario consultaUltimaConexion = sessionUsuario.findSessionByUser(respValClave.getICodigo(), lTipoCanal);
            String fechaConexion = "";
            if (consultaUltimaConexion != null) {
                fechaConexion = new Utilidad().dateToStringFormatFechaHora(consultaUltimaConexion.getFConexion());
            } else {
                fechaConexion = "N/A";
            }*/

            String nombres = respValClave.getIPersona().getCNombres() + " " + respValClave.getIPersona().getCApellidos();
            valToken.put("bRta", respValClave.getbRta());
            valToken.put("codMsj", respValClave.getcCodMensaje());
            valToken.put("sMsj", respValClave.getsMensaje());
            valToken.put("codUser", respValClave.getICodigo());
            valToken.put("tipoPerfil", respValClave.getIPerfil().getICodigo());
            valToken.put("codPersona", respValClave.getIPersona().getICodigo());
            //valToken.put("ultimaConexion", fechaConexion);
            valToken.put("nombres", nombres);
            rta = jwtTokenHelper.generateJwtTokenSucces(valToken);
            JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
            rta = json.toString();
            return rta;

        } catch (Exception e) {
            e.printStackTrace();
            valToken.put("bRta", false);
            valToken.put("sMsj", "Ha ocurrido un error inesperado");
            rta = jwtTokenHelper.generateJwtTokenError(valToken);
            JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
            rta = json.toString();
            return rta;
        }
    }

    @Override
    public RespuestaPersona validarPersona(int xiTipoIden, String xcIdentificacion) {
        RespuestaPersona personaWeb = new RespuestaPersona();

        Persona persona = new PersonaDataAccessImp().personaWebFindByCIdentificacion(xiTipoIden, xcIdentificacion);
        if (persona == null || persona.getICodigo() == null) {
            personaWeb.setbRta(Boolean.FALSE);
            personaWeb.setsMsj("No se ha encontrado registro de la persona en el portal de FINMERIDIAN.");
            return personaWeb;
        }

        personaWeb.setbRta(Boolean.TRUE);
        personaWeb.setsMsj("El usuario con N° de documento " + xcIdentificacion + " se encuentra registrado en el portal de FINMERIDIAN.");
        return personaWeb;
    }

    @Override
    public RespuestaGenerica cerrarSession(Long idUsuario, Long idTipoCanal) {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        respuesta = new SessionUsuarioDataAccessImp().cerrarSesionActivaByUser(idUsuario, idTipoCanal);
        if (respuesta == null || respuesta.getbRta() != null || respuesta.getbRta()) {
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setiCodigo(2);
            respuesta.setsMsj("No se han encontrado sesiones activas para cerrar.");
            return respuesta;
        }
        respuesta.setbRta(Boolean.TRUE);
        respuesta.setiCodigo(1);
        respuesta.setsMsj("Se ha cerrado la sesión correctamente");
        return respuesta;
    }

}
