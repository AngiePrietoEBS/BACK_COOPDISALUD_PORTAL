/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.TipoPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class TipoPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<TipoPagareDeceval>  {

    private EntityManager em = null;
    
    
    public TipoPagareDeceval saveTipoPagareDeceval(TipoPagareDeceval tipoPagareDeceval) {
        TipoPagareDeceval tc = create(tipoPagareDeceval);
        return tc;
    }

    
    public TipoPagareDeceval updateTipoPagareDeceval(TipoPagareDeceval tipoPagareDeceval) {
        TipoPagareDeceval tc = update(tipoPagareDeceval);
        return tc;
    }

    
    public TipoPagareDeceval findTipoPagareDecevalById(Long id) {
        TipoPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<TipoPagareDeceval> findAllTipoPagareDeceval() {
        List<TipoPagareDeceval> listTipoPagareDeceval = findAll();
        return listTipoPagareDeceval;
    }

    
    public void deleteTipoPagareDeceval(TipoPagareDeceval tipoPagareDeceval) {
        delete(tipoPagareDeceval);
    }

}
