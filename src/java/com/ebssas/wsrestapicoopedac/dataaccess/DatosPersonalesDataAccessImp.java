/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class DatosPersonalesDataAccessImp extends GenericRepositoryJPAImp<DatosPersonales> implements DatosPersonalesDataAccess {

    private EntityManager em = null;

    @Override
    public DatosPersonales saveDatosPersonale(DatosPersonales datosPersonales) {
        return create(datosPersonales);
    }

    @Override
    public DatosPersonales updateDatosPersonales(DatosPersonales datosPersonales) {
        return update(datosPersonales);
    }

    @Override
    public DatosPersonales findDatosPersonalesByIdPersona(Long id) {

        DatosPersonales datosPersonales = new DatosPersonales();

        try {
            ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
            em = connDBJPA.getEntityManager();
            String sentencia = "SELECT * FROM DATOS_PERSONALES WHERE I_PERSONA = ?";
            Query query = em.createNativeQuery(sentencia, DatosPersonales.class);
            query.setParameter(1, id);

            List<DatosPersonales> listDatos = query.getResultList();

            if (listDatos != null && !listDatos.isEmpty()) {
                for (DatosPersonales dp : listDatos) {
                    if (dp.getIPersona().getICodigo().equals(id)) {
                        datosPersonales = dp;
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

        return datosPersonales;
    }

}
