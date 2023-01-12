/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.TipoPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.TipoPagareDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class TipoPagareDecevalServiceBean {

    public TipoPagareDeceval saveTipoPagareDeceval(TipoPagareDeceval tipoPagareDeceval) {
        TipoPagareDeceval tc = new TipoPagareDecevalDataAccessImp().saveTipoPagareDeceval(tipoPagareDeceval);
        return tc;
    }

    public TipoPagareDeceval updateTipoPagareDeceval(TipoPagareDeceval tipoPagareDeceval) {
        TipoPagareDeceval tc = new TipoPagareDecevalDataAccessImp().updateTipoPagareDeceval(tipoPagareDeceval);
        return tc;
    }

    public TipoPagareDeceval findTipoPagareDecevalById(Long id) {
        TipoPagareDeceval tc = new TipoPagareDecevalDataAccessImp().findTipoPagareDecevalById(id);
        return tc;
    }

    public List<TipoPagareDeceval> findAllTipoPagareDeceval() {
        List<TipoPagareDeceval> listTipoPagareDeceval = new TipoPagareDecevalDataAccessImp().findAllTipoPagareDeceval();
        return listTipoPagareDeceval;
    }

    public void deleteTipoPagareDeceval(TipoPagareDeceval tipoPagareDeceval) {
        new TipoPagareDecevalDataAccessImp().deleteTipoPagareDeceval(tipoPagareDeceval);
    }

}
