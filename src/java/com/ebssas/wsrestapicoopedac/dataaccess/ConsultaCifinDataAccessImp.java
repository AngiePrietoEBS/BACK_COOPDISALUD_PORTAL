/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ConsultaCifin;
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
public class ConsultaCifinDataAccessImp extends GenericRepositoryJPAImp<ConsultaCifin>{
 
    private EntityManager em = null;

    public ConsultaCifin saveConsumo(ConsultaCifin xData) {
        return create(xData);
    }

    public List<ConsultaCifin> findByTipoIdentAndIdent(String xiTipoIdent, String xIdent) {
        List<ConsultaCifin> listRta = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("select c.* from CONSULTA_CIFIN c where c.I_TIPO_IDENT =? and c.C_IDENT=?", ConsultaCifin.class);
            consultDocument.setParameter(1, xiTipoIdent);
            consultDocument.setParameter(2, xIdent);
            List<ConsultaCifin> listRequest = consultDocument.getResultList();
            if (listRequest != null && !listRequest.isEmpty()) {
                listRta = listRequest;
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
        return listRta;

    }
}
