/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.TipoCanal;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class TipoCanalDataAccessImp extends GenericRepositoryJPAImp<TipoCanal> implements TipoCanalDataAccess {

    private EntityManager em = null;
    
    @Override
    public TipoCanal saveTipoCanal(TipoCanal tipoCanal) {
        TipoCanal tc = create(tipoCanal);
        return tc;
    }

    @Override
    public TipoCanal updateTipoCanal(TipoCanal tipoCanal) {
        TipoCanal tc = update(tipoCanal);
        return tc;
    }

    @Override
    public TipoCanal findTipoCanalById(Long id) {
        TipoCanal tc = find(id);
        return tc;
    }

    @Override
    public List<TipoCanal> findAllTipoCanal() {
        List<TipoCanal> listTipoCanal = findAll();
        return listTipoCanal;
    }

    @Override
    public void deleteTipoCanal(TipoCanal tipoCanal) {
        delete(tipoCanal);
    }

}
