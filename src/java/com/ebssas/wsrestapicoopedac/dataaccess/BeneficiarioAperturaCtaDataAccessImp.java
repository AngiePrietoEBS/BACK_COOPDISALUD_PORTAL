/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.BeneficiarioAperturaCta;
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
public class BeneficiarioAperturaCtaDataAccessImp extends GenericRepositoryJPAImp<BeneficiarioAperturaCta> implements BeneficiarioAperturaCtaDataAccess {

    private EntityManager em = null;

    @Override
    public BeneficiarioAperturaCta saveBeneficiarioCuenta(BeneficiarioAperturaCta beneficiarioAperturaCta) {
        return create(beneficiarioAperturaCta);
    }

    @Override
    public BeneficiarioAperturaCta updateBeneficiarioCuenta(BeneficiarioAperturaCta beneficiarioAperturaCta) {
        return update(beneficiarioAperturaCta);
    }

    @Override
    public BeneficiarioAperturaCta findBeneficiarioCtaByIdCuenta(Long idAperturaCta) {
        BeneficiarioAperturaCta bac = new BeneficiarioAperturaCta();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM BENEFICIARIO_APERTURA_CUENTA WHERE I_APERTURA_CUENTA_SOL_CRED = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, BeneficiarioAperturaCta.class);
            query.setParameter(1, idAperturaCta);

            List<BeneficiarioAperturaCta> listB = query.getResultList();
            if (listB != null && !listB.isEmpty()) {
                for (BeneficiarioAperturaCta ba : listB) {
                    if (ba.getIAperturaCuentaSolCred().getICodigo().equals(idAperturaCta)) {
                        bac = ba;
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

        return bac;
    }

    public BeneficiarioAperturaCta findBeneficiarioCtaByIdCuenta(Long idAperturaCta, String cIdentificacion) {
        BeneficiarioAperturaCta bac = new BeneficiarioAperturaCta();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM BENEFICIARIO_APERTURA_CUENTA WHERE I_APERTURA_CUENTA_SOL_CRED = ? AND C_IDENTIFICACION = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, BeneficiarioAperturaCta.class);
            query.setParameter(1, idAperturaCta);
            query.setParameter(2, cIdentificacion);

            List<BeneficiarioAperturaCta> listB = query.getResultList();
            if (listB != null && !listB.isEmpty()) {
                for (BeneficiarioAperturaCta ba : listB) {
                    if (ba.getIAperturaCuentaSolCred().getICodigo() == idAperturaCta) {
                        bac = ba;
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

        return bac;
    }

    public List<BeneficiarioAperturaCta> findAllBeneficiariosByCta(Long iAperturaCuentaSolCred) {

        List<BeneficiarioAperturaCta> list = new ArrayList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM BENEFICIARIO_APERTURA_CTA WHERE I_APERTURA_CUENTA_SOL_CRED = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, BeneficiarioAperturaCta.class);
            query.setParameter(1, iAperturaCuentaSolCred);

            List<BeneficiarioAperturaCta> listBenef = query.getResultList();
            if (!listBenef.isEmpty()) {
                list = listBenef;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }
        return list;
    }

}
