/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class SolicitudCreditoDataAccessImp extends GenericRepositoryJPAImp<SolicitudCredito> implements SolicitudCreditoDataAccess {

    private EntityManager em = null;

    @Override
    public SolicitudCredito saveSolicitud(SolicitudCredito solicitudCredito) {
        SolicitudCredito sSolicitudCreditoC = create(solicitudCredito);
        return sSolicitudCreditoC;
    }

    @Override
    public SolicitudCredito updateSolicitud(SolicitudCredito solicitudCredito) {
        SolicitudCredito sSolicitudCreditoC = update(solicitudCredito);
        return sSolicitudCreditoC;
    }

    @Override
    public List<SolicitudCredito> findAllSolicitudCredito() {
        return findAll();
    }

    @Override
    public List<SolicitudCredito> findAllSolicitudCreditoOrderByFechaSolCred() {
        return findAllOrderByCampo("DESC", "fFechaSolicitud");
    }

    @Override
    public SolicitudCredito findSolicitudCreditoById(Long id) {
        return find(id);
    }

    @Override
    public List<SolicitudCredito> findSolCreditoByPersona(Long idPersona) {
        List<SolicitudCredito> listaConsulta = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE SC.I_PERSONA = ? ";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idPersona);
            listaConsulta = consulta.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return listaConsulta;
    }

    public SolicitudCredito findSolCreditoDiligenciada(Long idPersona) {
        SolicitudCredito sc = new SolicitudCredito();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT * FROM  SOLICITUD_CREDITO WHERE I_PERSONA = ? AND I_ESTADO_SOLICITUD = 1";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idPersona);
            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (!listaConsulta.isEmpty()) {
                for (SolicitudCredito credito : listaConsulta) {
                    if (credito.getIPersona().getICodigo().equals(idPersona)) {
                        sc = credito;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return sc;
    }
    
    public SolicitudCredito findSolCreditoByLineaByPersonaByEstado(Long codLinea, Long idPersona, String codEstado) {
        SolicitudCredito sc = new SolicitudCredito();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT * FROM  SOLICITUD_CREDITO WHERE I_PERSONA = ? AND I_ESTADO_SOLICITUD = ? AND I_TIPO_CREDITO = ?";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idPersona);
            consulta.setParameter(2, codEstado);
            consulta.setParameter(3, codLinea);
            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (!listaConsulta.isEmpty()) {
                for (SolicitudCredito credito : listaConsulta) {
                    if (credito.getIPersona().getICodigo().equals(idPersona)) {
                        sc = credito;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return sc;
    }
    
    public SolicitudCredito findSolCreditoByLinea(Long codLinea, Long idPersona) {
        SolicitudCredito sc = new SolicitudCredito();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT * FROM  SOLICITUD_CREDITO WHERE I_PERSONA = ? AND I_ESTADO_SOLICITUD = 3 AND I_TIPO_CREDITO = ?";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, idPersona);
            consulta.setParameter(2, codLinea);
            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (!listaConsulta.isEmpty()) {
                for (SolicitudCredito credito : listaConsulta) {
                    if (credito.getIPersona().getICodigo().equals(idPersona)) {
                        sc = credito;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return sc;
    }

    public SolicitudCredito findSolCreditoByRadicado(String sNumRadicado) {
        SolicitudCredito credito = new SolicitudCredito();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE SC.I_NUM_RADIC = ? ";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, sNumRadicado);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (!listaConsulta.isEmpty()) {
                for (SolicitudCredito sc : listaConsulta) {
                    if (sc.getINumRadic().equals(sNumRadicado)) {
                        credito = sc;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return credito;
    }
    
    public List<SolicitudCredito> buscarSolCredbyPersona(Long xCodPersona) {
        List<SolicitudCredito> credito = null;
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE SC.I_PERSONA = ? ";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, xCodPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            credito = listaConsulta;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return credito;
    }

    public SolicitudCredito validarSolCred(Long codPersona) {
        SolicitudCredito credito = new SolicitudCredito();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT SC.* FROM  SOLICITUD_CREDITO SC WHERE SC.I_PERSONA = ? AND I_ESTADO_SOLICITUD = ?";
            Query consulta = em.createNativeQuery(sql, SolicitudCredito.class);
            consulta.setParameter(1, codPersona);

            List<SolicitudCredito> listaConsulta = consulta.getResultList();
            if (!listaConsulta.isEmpty()) {
                for (SolicitudCredito sc : listaConsulta) {
                    if (sc.getIPersona().getICodigo().equals(codPersona)) {
                        credito = sc;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return credito;
    }

}
