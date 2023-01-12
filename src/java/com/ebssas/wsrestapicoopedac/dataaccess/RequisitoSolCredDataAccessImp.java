/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.RequisitosSolCred;
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
public class RequisitoSolCredDataAccessImp extends GenericRepositoryJPAImp<RequisitosSolCred> implements RequisitoSolCredDataAccess {

    private EntityManager em = null;

    @Override
    public RequisitosSolCred findById(Long id) {

        RequisitosSolCred rsc = new RequisitosSolCred();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM REQUISITO_SOL_CRED WHERE I_CODIGO = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, RequisitosSolCred.class);
            query.setParameter(1, id);

            List<RequisitosSolCred> listR = query.getResultList();
            if (listR != null && !listR.isEmpty()) {
                for (RequisitosSolCred req : listR) {
                    if (req.getICodigo().equals(id)) {
                        rsc = req;
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return rsc;
    }

    @Override
    public List<RequisitosSolCred> findByTipoRequisito(Long id) {

        List<RequisitosSolCred> listReq = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM REQUISITOS_SOL_CRED WHERE I_TIPO_REQUISITO = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, RequisitosSolCred.class);
            query.setParameter(1, id);

            listReq = query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return listReq;
    }

    @Override
    public List<RequisitosSolCred> findByTipoCredito(Long id) {
        List<RequisitosSolCred> listReq = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM REQUISITOS_SOL_CRED WHERE I_TIPO_CREDITO = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, RequisitosSolCred.class);
            query.setParameter(1, id);

            listReq = query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return listReq;
    }

    @Override
    public List<RequisitosSolCred> findByTipoReqAndTipoCred(Long idTipoReq, Long idTipoCred) {
        List<RequisitosSolCred> listReq = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM REQUISITOS_SOL_CRED WHERE I_TIPO_REQUISITO = ? AND I_TIPO_CREDITO = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, RequisitosSolCred.class);
            query.setParameter(1, idTipoReq);
            query.setParameter(2, idTipoCred);

            listReq = query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return listReq;
    }

}
