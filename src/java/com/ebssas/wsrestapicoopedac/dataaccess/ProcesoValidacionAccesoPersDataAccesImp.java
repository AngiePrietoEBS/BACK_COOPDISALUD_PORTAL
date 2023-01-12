/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ProcesoValidacionAccesoPers;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;

/**
 *
 * @author Administrador
 */
public class ProcesoValidacionAccesoPersDataAccesImp extends GenericRepositoryJPAImp<ProcesoValidacionAccesoPers> implements ProcesoValidacionAccesoPersDataAcces {

    private EntityManager em = null;

    @Override
    public ProcesoValidacionAccesoPers save(ProcesoValidacionAccesoPers procesoValidacionAccesoPers) {
        return create(procesoValidacionAccesoPers);
    }

    @Override
    public List<ProcesoValidacionAccesoPers> findProcesoByEmailAndCelular(String email, String celular) {

        List<ProcesoValidacionAccesoPers> listProcesos = new ArrayList<>();
        ConnectionDBJPA connBDJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM PROCESO_VALIDACION_ACCESO_PERS WHERE C_EMAIL = ? AND C_CELULAR = ? ";

        try {
            this.em = connBDJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, ProcesoValidacionAccesoPers.class);
            query.setParameter(1, email);
            query.setParameter(2, celular);

            listProcesos = query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return listProcesos;
    }

}
