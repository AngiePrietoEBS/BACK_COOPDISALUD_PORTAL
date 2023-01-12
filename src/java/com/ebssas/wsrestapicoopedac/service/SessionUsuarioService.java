/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.domain.SessionUsuario;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public interface SessionUsuarioService {

    SessionUsuario saveSession(Usuario sessionUsu, String xcNavegador, int iTipoCanal);

    SessionUsuario updateSession(SessionUsuario sessionUsuario);

    SessionUsuario findSessionByUser(Long idUsuario, Long iTipoCanal);

    List<SessionUsuario> findSessionACTByUser(Long idUsuario, Long idTipoCanal);

    RespuestaGenerica cerrarSesionActivaByUser(Long idUsuario, Long idTipoCanal);
}
