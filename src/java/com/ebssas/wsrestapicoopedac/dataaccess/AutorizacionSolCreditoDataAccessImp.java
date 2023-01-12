/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito;
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
public class AutorizacionSolCreditoDataAccessImp extends GenericRepositoryJPAImp<AutorizacionSolCredito> implements AutorizacionSolCreditoDataAccess {

    private EntityManager em = null;

    @Override
    public AutorizacionSolCredito saveAutorizacion(AutorizacionSolCredito autorizacionSolCredito) {
        return create(autorizacionSolCredito);
    }

    @Override
    public AutorizacionSolCredito updateAutorizacion(AutorizacionSolCredito autorizacionSolCredito) {
        return update(autorizacionSolCredito);
    }

    @Override
    public List<AutorizacionSolCredito> findAllAutorizacionBySolCred(Long idSolCred) {

        List<AutorizacionSolCredito> listA = new ArrayList<>();
        String sentencia = "SELECT * FROM AUTORIZACION_SOL_CREDITO WHERE I_SOL_CREDITO = ?";
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();

            Query query = this.em.createNativeQuery(sentencia, AutorizacionSolCredito.class);
            query.setParameter(1, idSolCred);

            listA = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listA;
    }

    @Override
    public AutorizacionSolCredito findAutorizacionByTipo(Long idTipo) {
        AutorizacionSolCredito autorizacion = new AutorizacionSolCredito();
        String sentencia = "SELECT * FROM AUTORIZACION_SOL_CREDITO WHERE I_TIPO_AUTORIZACION = ?";
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();

            Query query = this.em.createNativeQuery(sentencia, AutorizacionSolCredito.class);
            query.setParameter(1, idTipo);
            List<AutorizacionSolCredito> listA = query.getResultList();
            if (!listA.isEmpty()) {
                for (AutorizacionSolCredito aut : listA) {
                    if (aut.getITipoAutorizacion().getICodigo().equals(idTipo)) {
                        autorizacion = aut;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return autorizacion;
    }

}
