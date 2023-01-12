/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Comunicacion;
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
public class ComunicacionDataAccessImp extends GenericRepositoryJPAImp<Comunicacion> implements ComunicacionDataAccess {

    private EntityManager em = null;

    @Override
    public Comunicacion saveComunicacion(Comunicacion comunicacion) {
        return create(comunicacion);
    }

    @Override
    public List<Comunicacion> findAllComunicacion(Long idsolCred) {
        List<Comunicacion> listaComunicaciones = new ArrayList<>();

        try {
            ConnectionDBJPA conn = new ConnectionDBJPA();
            this.em = conn.getEntityManager();

            Query query = this.em.createNativeQuery("SELECT * FROM COMUNICACION WHERE I_SOL_CREDITO = ?", Comunicacion.class);
            query.setParameter(1, idsolCred);

            listaComunicaciones = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaComunicaciones;
    }

}
