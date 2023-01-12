/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.domain.SessionUsuario;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface SessionUsuarioDataAccess {

    SessionUsuario saveSession(SessionUsuario sessionUsuario);

    SessionUsuario updateSession(SessionUsuario sessionUsuario);

    SessionUsuario findSessionByUser(Long idUsuario, Long iTipoCanal);

    List<SessionUsuario> findSessionACTByUser(Long idUsuario, Long iTipoCanal);

    SessionUsuario buscarSessionByCodUser(Long idUsuario, Long iTipoCanal);

    RespuestaGenerica cerrarSesionActivaByUser(Long idUsuario, Long idTipoCanal);

}
