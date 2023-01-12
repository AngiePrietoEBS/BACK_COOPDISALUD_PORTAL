/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class InformacionDesembolsoDataAccessImp extends GenericRepositoryJPAImp<InformacionDesembolso> implements InformacionDesembolsoDataAccess {

    private EntityManager em = null;

    @Override
    public InformacionDesembolso saveInformacionDesembolso(InformacionDesembolso informacionDesembolso) {
        return create(informacionDesembolso);
    }

    @Override
    public InformacionDesembolso updateInformacionDesembolso(InformacionDesembolso informacionDesembolso) {
        return update(informacionDesembolso);
    }

    @Override
    public InformacionDesembolso findInformacionDesembolsoBySolCred(Long idSolCred) {

        InformacionDesembolso informacionDesembolso = new InformacionDesembolso();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM INFORMACION_DESEMBOLSO WHERE I_SOL_CREDITO = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, InformacionDesembolso.class);
            query.setParameter(1, idSolCred);

            List<InformacionDesembolso> list = query.getResultList();

            if (!list.isEmpty()) {
                for (InformacionDesembolso id : list) {
                    if (id.getISolCredito().getICodigo().equals(idSolCred)) {
                        informacionDesembolso = id;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return informacionDesembolso;

    }

}
