/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.TipoRepresentanteDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.TipoRepresentanteDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class TipoRepresentanteDecevalServiceBean {

    public TipoRepresentanteDeceval saveTipoRepresentanteDeceval(TipoRepresentanteDeceval tipoRepresentanteDeceval) {
        TipoRepresentanteDeceval tc = new TipoRepresentanteDecevalDataAccessImp().saveTipoRepresentanteDeceval(tipoRepresentanteDeceval);
        return tc;
    }

    public TipoRepresentanteDeceval updateTipoRepresentanteDeceval(TipoRepresentanteDeceval tipoRepresentanteDeceval) {
        TipoRepresentanteDeceval tc = new TipoRepresentanteDecevalDataAccessImp().updateTipoRepresentanteDeceval(tipoRepresentanteDeceval);
        return tc;
    }

    public TipoRepresentanteDeceval findTipoRepresentanteDecevalById(Long id) {
        TipoRepresentanteDeceval tc = new TipoRepresentanteDecevalDataAccessImp().findTipoRepresentanteDecevalById(id);
        return tc;
    }

    public List<TipoRepresentanteDeceval> findAllTipoRepresentanteDeceval() {
        List<TipoRepresentanteDeceval> listTipoRepresentanteDeceval = new TipoRepresentanteDecevalDataAccessImp().findAllTipoRepresentanteDeceval();
        return listTipoRepresentanteDeceval;
    }

    public void deleteTipoRepresentanteDeceval(TipoRepresentanteDeceval tipoRepresentanteDeceval) {
        new TipoRepresentanteDecevalDataAccessImp().deleteTipoRepresentanteDeceval(tipoRepresentanteDeceval);
    }

}
