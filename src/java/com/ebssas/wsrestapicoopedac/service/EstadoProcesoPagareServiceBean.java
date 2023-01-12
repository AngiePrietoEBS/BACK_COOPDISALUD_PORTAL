/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.EstadoProcesoPagareDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.EstadoProcesoPagare;
import java.util.List;

/**
 *
 * @author Braya
 */
public class EstadoProcesoPagareServiceBean {
    
    public EstadoProcesoPagare saveEstadoProcesoPagare(EstadoProcesoPagare estadoProcesoPagare) {
        EstadoProcesoPagare tc = new EstadoProcesoPagareDataAccessImp().saveEstadoProcesoPagare(estadoProcesoPagare);
        return tc;
    }
    
    public EstadoProcesoPagare updateEstadoProcesoPagare(EstadoProcesoPagare estadoProcesoPagare) {
        EstadoProcesoPagare tc = new EstadoProcesoPagareDataAccessImp().updateEstadoProcesoPagare(estadoProcesoPagare);
        return tc;
    }
    
    public EstadoProcesoPagare findEstadoProcesoPagareById(Long id) {
        EstadoProcesoPagare tc = new EstadoProcesoPagareDataAccessImp().findEstadoProcesoPagareById(id);
        return tc;
    }
    
    public List<EstadoProcesoPagare> findAllEstadoProcesoPagare() {
        List<EstadoProcesoPagare> listEstadoProcesoPagare = new EstadoProcesoPagareDataAccessImp().findAllEstadoProcesoPagare();
        return listEstadoProcesoPagare;
    }
    
    public void deleteEstadoProcesoPagare(EstadoProcesoPagare estadoProcesoPagare) {
        new EstadoProcesoPagareDataAccessImp().deleteEstadoProcesoPagare(estadoProcesoPagare);
    }
    
}
