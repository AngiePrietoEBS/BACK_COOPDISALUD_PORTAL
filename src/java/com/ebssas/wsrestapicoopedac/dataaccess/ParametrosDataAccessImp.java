/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brayan F Silva R
 */
public class ParametrosDataAccessImp extends GenericRepositoryJPAImp<Parametros> implements ParametroDataAccess {

    private EntityManager em = null;

    @Override
    public String getValorParametroByNombre(String sNombreParametros) {
        String sValorParametros = "";
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            TypedQuery<Parametros> consultDocument = em.createNamedQuery("Parametros.findByCNombre", Parametros.class);
            consultDocument.setParameter("cNombre", sNombreParametros);
            List<Parametros> listParametros = consultDocument.getResultList();
            if (listParametros != null && !listParametros.isEmpty()) {
                for (Parametros param : listParametros) {
                    if (param.getCNombre().equals(sNombreParametros)) {
                        sValorParametros = param.getCValor();
                        break;
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
        return sValorParametros;
    }

}
