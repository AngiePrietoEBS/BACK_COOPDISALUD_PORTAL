/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.dataaccess.SessionUsuarioDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.TipoCanalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.SessionUsuario;
import com.ebssas.wsrestapicoopedac.domain.TipoCanal;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class SessionUsuarioServiceBean implements SessionUsuarioService {

    private SessionUsuarioDataAccessImp session = new SessionUsuarioDataAccessImp();
    private Utilidad util = new Utilidad();

    @Override
    public SessionUsuario saveSession(Usuario sessionUsu, String xcNavegador, int iTipoCanal) {
        SessionUsuario saveSessionUsuario = new SessionUsuario();
        try {
            SessionUsuario sessionUsuario = new SessionUsuario();
            Long idTipoCanal = new Long(String.valueOf(iTipoCanal));
            TipoCanal tc = new TipoCanalDataAccessImp().findTipoCanalById(idTipoCanal);
            sessionUsuario.setCEstado("ACT");
            sessionUsuario.setCIp(util.getIp());
            sessionUsuario.setCHost(util.getHost());
            sessionUsuario.setFConexion(new Date());
            sessionUsuario.setCNavegador(xcNavegador);
            sessionUsuario.setIUsuario(sessionUsu);
            sessionUsuario.setITipoCanal(tc);
            saveSessionUsuario = session.saveSession(sessionUsuario);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return saveSessionUsuario;
    }

    @Override
    public SessionUsuario updateSession(SessionUsuario sessionUsuario) {
        return session.updateSession(sessionUsuario);
    }

    @Override
    public SessionUsuario findSessionByUser(Long idUsuario, Long iTipoCanal) {
        return session.buscarSessionByCodUser(idUsuario, iTipoCanal);
    }

    @Override
    public List<SessionUsuario> findSessionACTByUser(Long idUsuario, Long idTipoCanal) {
        return session.findSessionACTByUser(idUsuario, idTipoCanal);
    }

    @Override
    public RespuestaGenerica cerrarSesionActivaByUser(Long idUsuario, Long idTipoCanal) {
        return session.cerrarSesionActivaByUser(idUsuario, idTipoCanal);
    }
}
