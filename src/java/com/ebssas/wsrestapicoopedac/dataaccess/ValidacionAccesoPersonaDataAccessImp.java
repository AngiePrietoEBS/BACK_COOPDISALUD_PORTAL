/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import com.ebssas.wsrestapicoopedac.domain.ValidacionAccesoPersona;

/**
 *
 * @author Administrador
 */
public class ValidacionAccesoPersonaDataAccessImp extends GenericRepositoryJPAImp<ValidacionAccesoPersona> implements ValidacionAccesoPersonaDataAccess {

    private EntityManager em = null;

    @Override
    public ValidacionAccesoPersona save(ValidacionAccesoPersona identSolCred) {

        return create(identSolCred);
    }

    @Override
    public void inactivarTokens(Long id) {

        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "UPDATE VALIDACION_ACCESO_PERSONA SET C_ESTADO = 'INA' WHERE I_CODIGO = ? AND C_ESTADO = 'ACT' ";

        try {
            em = connDBJPA.getEntityManager();

            Query query = em.createNativeQuery(sentencia);
            query.setParameter(1, id);
            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

    }

    @Override
    public ValidacionAccesoPersona findByIdSolCred(Long id) {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM VALIDACION_ACCESO_PERSONA WHERE I_CODIGO = ? AND C_ESTADO = 'ACT' ";
        ValidacionAccesoPersona cred = new ValidacionAccesoPersona();

        try {
            em = connDBJPA.getEntityManager();

            Query query = em.createNativeQuery(sentencia, ValidacionAccesoPersona.class);
            query.setParameter(1, id);

            List<ValidacionAccesoPersona> list = query.getResultList();
            if (list != null && !list.isEmpty()) {
                cred = list.get(0);
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        
        return cred;
    }

}
