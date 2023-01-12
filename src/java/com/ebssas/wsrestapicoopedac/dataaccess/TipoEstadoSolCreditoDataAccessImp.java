/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class TipoEstadoSolCreditoDataAccessImp extends GenericRepositoryJPAImp<TipoEstadoSolicitudCredito> implements TipoEstadoSolCreditoDataAccess {

    @Override
    public TipoEstadoSolicitudCredito findByID(long id) {
        TipoEstadoSolicitudCredito tpe = find(id);
        return tpe;
    }

    @Override
    public List<TipoEstadoSolicitudCredito> findAllTipoEstado() {

        List<TipoEstadoSolicitudCredito> listTipoEstadoSol = new ArrayList<>();
        listTipoEstadoSol = findAll();
        return listTipoEstadoSol;

    }

}
