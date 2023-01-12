/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import com.ebssas.wsrestapicoopedac.domain.TipoAutorizacionSolCred;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class TipoAutorizacionSolCredDataAccessImp extends GenericRepositoryJPAImp<TipoAutorizacionSolCred> implements TipoAutorizacionSolCredDataAccess {

    @Override
    public List<TipoAutorizacionSolCred> findAllTipoAutorizacion() {
        return findAll();
    }
}
