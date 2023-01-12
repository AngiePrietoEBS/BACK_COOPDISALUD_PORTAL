/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.EstadoProcesoPagare;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class EstadoProcesoPagareDataAccessImp extends GenericRepositoryJPAImp<EstadoProcesoPagare>  {

    private EntityManager em = null;
    
    
    public EstadoProcesoPagare saveEstadoProcesoPagare(EstadoProcesoPagare estadoProcesoPagare) {
        EstadoProcesoPagare tc = create(estadoProcesoPagare);
        return tc;
    }

    
    public EstadoProcesoPagare updateEstadoProcesoPagare(EstadoProcesoPagare estadoProcesoPagare) {
        EstadoProcesoPagare tc = update(estadoProcesoPagare);
        return tc;
    }

    
    public EstadoProcesoPagare findEstadoProcesoPagareById(Long id) {
        EstadoProcesoPagare tc = find(id);
        return tc; 
    }

    
    public List<EstadoProcesoPagare> findAllEstadoProcesoPagare() {
        List<EstadoProcesoPagare> listEstadoProcesoPagare = findAll();
        return listEstadoProcesoPagare;
    }

    
    public void deleteEstadoProcesoPagare(EstadoProcesoPagare estadoProcesoPagare) {
        delete(estadoProcesoPagare);
    }

}
