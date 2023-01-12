/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.EstadoPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.EstadoPagareDeceval;

import java.util.List;

/**
 *
 * @author Braya
 */
public class EstadoPagareDecevalServiceBean {

    public EstadoPagareDeceval saveEstadoPagareDeceval(EstadoPagareDeceval estadoPagareDeceval) {
        EstadoPagareDeceval tc = new EstadoPagareDecevalDataAccessImp().saveEstadoPagareDeceval(estadoPagareDeceval);
        return tc;
    }

    public EstadoPagareDeceval updateEstadoPagareDeceval(EstadoPagareDeceval estadoPagareDeceval) {
        EstadoPagareDeceval tc = new EstadoPagareDecevalDataAccessImp().updateEstadoPagareDeceval(estadoPagareDeceval);
        return tc;
    }

    public EstadoPagareDeceval findEstadoPagareDecevalById(Long id) {
        EstadoPagareDeceval tc = new EstadoPagareDecevalDataAccessImp().findEstadoPagareDecevalById(id);
        return tc;
    }

    public List<EstadoPagareDeceval> findAllEstadoPagareDeceval() {
        List<EstadoPagareDeceval> listEstadoPagareDeceval = new EstadoPagareDecevalDataAccessImp().findAllEstadoPagareDeceval();
        return listEstadoPagareDeceval;
    }

    public void deleteEstadoPagareDeceval(EstadoPagareDeceval estadoPagareDeceval) {
        new EstadoPagareDecevalDataAccessImp().deleteEstadoPagareDeceval(estadoPagareDeceval);
    }

}
