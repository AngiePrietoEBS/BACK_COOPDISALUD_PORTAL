package com.ebssas.wsrestapicoopedac.service;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.request.RequestLogin;
import com.ebssas.wsrestapicoopedac.response.RespuestaPersona;

/**
 *
 * @author Brian Cardenas
 */
public interface AccesoService {

    String validarLogin(RequestLogin loginEmpleado);
            
    RespuestaPersona validarPersona(int xiTipoIden, String xcIdentificacion);

    RespuestaGenerica cerrarSession(Long idUsuario, Long idTipoCanal);

}
