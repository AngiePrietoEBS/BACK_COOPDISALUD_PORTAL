/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.domain.SessionUsuario;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Jonathan Ruge
 */
public class SessionUsuarioDataAccessImp extends GenericRepositoryJPAImp<SessionUsuario> implements SessionUsuarioDataAccess {

    private EntityManager em = null;

    @Override
    public SessionUsuario saveSession(SessionUsuario sessionUsuario) {
        SessionUsuario createSession = create(sessionUsuario);
        return createSession;
    }

    @Override
    public SessionUsuario updateSession(SessionUsuario sessionUsuario) {
        SessionUsuario updateSession = update(sessionUsuario);
        return updateSession;
    }

    public SessionUsuario buscarSessionByCodUser(Long idUsuario, Long iTipoCanal) {
        SessionUsuario ultimaSession = new SessionUsuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sSQLQuery = "SELECT SessionUsuario.* FROM \n"
                + "         (SELECT   su.* \n"
                + "             FROM session_usuario su \n"
                + "            WHERE i_usuario = NVL (?, i_usuario) \n"
                + "              AND c_estado = 'INA' \n"
                + "              AND I_TIPO_CANAL = ? \n"
                + "         ORDER BY i_codigo DESC)  SessionUsuario \n"
                + "                       WHERE ROWNUM = 1 ";
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery(sSQLQuery, SessionUsuario.class);

            consultDocument.setParameter(1, idUsuario);
            consultDocument.setParameter(2, iTipoCanal);

            List<SessionUsuario> listSession = consultDocument.getResultList();
            if (listSession != null && !listSession.isEmpty()) {
                ultimaSession = listSession.get(0);
            } else {
                ultimaSession = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return ultimaSession;
    }

    @Override
    public SessionUsuario findSessionByUser(Long idUsuario, Long iTipoCanal) {
        SessionUsuario ultimaSession = new SessionUsuario();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PKG_CONSULTA.PRC_CONS_ULTIMA_SESSION");
            storedProcedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(5, SessionUsuario.class, ParameterMode.REF_CURSOR);

            storedProcedureQuery.setParameter(1, Integer.parseInt(String.valueOf(idUsuario)));
            storedProcedureQuery.setParameter(2, Integer.parseInt(String.valueOf(iTipoCanal)));
            boolean execute = storedProcedureQuery.execute();
            if (execute) {
                if (storedProcedureQuery.getOutputParameterValue(4).toString().equals("TRUE")) {
                    List listaSesiones = storedProcedureQuery.getResultList();
                    if (listaSesiones.size() > 0) {
                        Object[] sesionFinal = (Object[]) listaSesiones.get(0);
                        Long codigoS = Long.parseLong(String.valueOf(sesionFinal[0]));
                        String ip = String.valueOf(sesionFinal[2]);
                        String host = String.valueOf(sesionFinal[3]);
                        String navegador = String.valueOf(sesionFinal[4]);
                        String fecha = String.valueOf(sesionFinal[5]);
                        java.util.Date fechaConexion = null;
                        try {
                            fechaConexion = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(fecha);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        String estado = String.valueOf(sesionFinal[6]);
                        ultimaSession.setICodigo(codigoS);
                        ultimaSession.setCIp(ip);
                        ultimaSession.setCHost(host);
                        ultimaSession.setCNavegador(navegador);
                        ultimaSession.setCEstado(estado);
                        ultimaSession.setFConexion(fechaConexion);
                    } else {
                        ultimaSession = null;
                    }

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return ultimaSession;
    }

    @Override
    public List<SessionUsuario> findSessionACTByUser(Long idUsuario, Long iTipoCanal) {
        List<SessionUsuario> findSessionAct = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT * FROM SESSION_USUARIO WHERE I_USUARIO = ?  AND C_ESTADO = 'ACT' ", SessionUsuario.class);

            consultDocument.setParameter(1, idUsuario);
//            consultDocument.setParameter(2, iTipoCanal);
            findSessionAct = consultDocument.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return findSessionAct;
    }

    @Override
    public RespuestaGenerica cerrarSesionActivaByUser(Long idUsuario, Long idTipoCanal) {
        RespuestaGenerica rtaGenCierreSesion = new RespuestaGenerica();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            this.em = connDBJPA.getEntityManager();
            StoredProcedureQuery storedProcedureQuery = this.em.createStoredProcedureQuery("PKG_OPERACION.PRC_OPER_CIERRA_SESSION");
            storedProcedureQuery.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

            storedProcedureQuery.setParameter(1, idUsuario);
            storedProcedureQuery.setParameter(2, idTipoCanal);
            storedProcedureQuery.execute();

            int cod_mensaje = Integer.parseInt(storedProcedureQuery.getOutputParameterValue(3).toString());
            String mensaje = storedProcedureQuery.getOutputParameterValue(4).toString();
            if (cod_mensaje == 1 && mensaje.toLowerCase().equals("true")) {
                rtaGenCierreSesion.setiCodigo(cod_mensaje);
                rtaGenCierreSesion.setbRta(Boolean.parseBoolean(mensaje));
                rtaGenCierreSesion.setsMsj("Se han cerrado las sesiones activas de manera correcta.");
            } else {
                rtaGenCierreSesion.setiCodigo(0);
                rtaGenCierreSesion.setbRta(Boolean.FALSE);
                rtaGenCierreSesion.setsMsj("Se ha presentado un problema al cerrar las sesiones activas.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            rtaGenCierreSesion.setiCodigo(0);
            rtaGenCierreSesion.setbRta(Boolean.FALSE);
            rtaGenCierreSesion.setsMsj("Se ha presentado un problema al cerrar las sesiones activas.");
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return rtaGenCierreSesion;
    }

}
