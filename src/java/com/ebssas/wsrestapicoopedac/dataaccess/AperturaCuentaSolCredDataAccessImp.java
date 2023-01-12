/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class AperturaCuentaSolCredDataAccessImp extends GenericRepositoryJPAImp<AperturaCuentaSolCred> implements AperturaCuentaSolCredDataAccess {

    private EntityManager em = null;

    @Override
    public AperturaCuentaSolCred saveAperturaCuenta(AperturaCuentaSolCred cuentaSolCred) {
        return create(cuentaSolCred);
    }

    @Override
    public AperturaCuentaSolCred updateAperturaCuenta(AperturaCuentaSolCred cuentaSolCred) {
        return update(cuentaSolCred);
    }

    @Override
    public AperturaCuentaSolCred findAperturaCuentaByIdSolCred(Long idSolCred) {

        AperturaCuentaSolCred acsc = new AperturaCuentaSolCred();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();

        try {

            this.em = connDBJPA.getEntityManager();

            String sentencia = "SELECT * FROM APERTURA_CUENTA_SOL_CRED WHERE I_SOL_CREDITO = ?";
            Query query = this.em.createNativeQuery(sentencia, AperturaCuentaSolCred.class);
            query.setParameter(1, idSolCred);

            List<AperturaCuentaSolCred> listA = query.getResultList();
            if (listA != null && !listA.isEmpty()) {
                for (AperturaCuentaSolCred ac : listA) {
                    if (ac.getISolCredito().getICodigo().equals(idSolCred)) {
                        acsc = ac;
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

        return acsc;
    }

}
