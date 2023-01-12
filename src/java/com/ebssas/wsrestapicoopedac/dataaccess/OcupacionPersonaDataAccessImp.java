/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class OcupacionPersonaDataAccessImp extends GenericRepositoryJPAImp<OcupacionPersona> implements OcupacionPersonaDataAccess {

    private EntityManager em = null;

    @Override
    public OcupacionPersona saveOcupacionPersona(OcupacionPersona ocupacionPersona) {
        return create(ocupacionPersona);
    }

    @Override
    public OcupacionPersona updateOcupacionPersona(OcupacionPersona ocupacionPersona) {
        return update(ocupacionPersona);
    }

    @Override
    public OcupacionPersona findOcupacionPersonaByIdPersona(Long id) {

        OcupacionPersona ocupacionPersona = new OcupacionPersona();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();

            String sentencia = "SELECT * FROM OCUPACION_PERSONA WHERE I_PERSONA = ?";
            Query query = em.createNativeQuery(sentencia, OcupacionPersona.class);
            query.setParameter(1, id);

            List<OcupacionPersona> listO = query.getResultList();

            if (listO != null && !listO.isEmpty()) {
                for (OcupacionPersona op : listO) {
                    if (op.getIPersona().getICodigo().equals(id)) {
                        ocupacionPersona = op;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return ocupacionPersona;
    }

}
