/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.TipoRepresentanteDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class TipoRepresentanteDecevalDataAccessImp extends GenericRepositoryJPAImp<TipoRepresentanteDeceval>  {

    private EntityManager em = null;
    
    
    public TipoRepresentanteDeceval saveTipoRepresentanteDeceval(TipoRepresentanteDeceval tipoRepresentanteDeceval) {
        TipoRepresentanteDeceval tc = create(tipoRepresentanteDeceval);
        return tc;
    }

    
    public TipoRepresentanteDeceval updateTipoRepresentanteDeceval(TipoRepresentanteDeceval tipoRepresentanteDeceval) {
        TipoRepresentanteDeceval tc = update(tipoRepresentanteDeceval);
        return tc;
    }

    
    public TipoRepresentanteDeceval findTipoRepresentanteDecevalById(Long id) {
        TipoRepresentanteDeceval tc = find(id);
        return tc; 
    }

    
    public List<TipoRepresentanteDeceval> findAllTipoRepresentanteDeceval() {
        List<TipoRepresentanteDeceval> listTipoRepresentanteDeceval = findAll();
        return listTipoRepresentanteDeceval;
    }

    
    public void deleteTipoRepresentanteDeceval(TipoRepresentanteDeceval tipoRepresentanteDeceval) {
        delete(tipoRepresentanteDeceval);
    }

}
