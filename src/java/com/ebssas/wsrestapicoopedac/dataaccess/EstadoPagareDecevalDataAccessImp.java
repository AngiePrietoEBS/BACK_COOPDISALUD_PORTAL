/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.EstadoPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class EstadoPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<EstadoPagareDeceval>  {

    private EntityManager em = null;
    
    
    public EstadoPagareDeceval saveEstadoPagareDeceval(EstadoPagareDeceval estadoPagareDeceval) {
        EstadoPagareDeceval tc = create(estadoPagareDeceval);
        return tc;
    }

    
    public EstadoPagareDeceval updateEstadoPagareDeceval(EstadoPagareDeceval estadoPagareDeceval) {
        EstadoPagareDeceval tc = update(estadoPagareDeceval);
        return tc;
    }

    
    public EstadoPagareDeceval findEstadoPagareDecevalById(Long id) {
        EstadoPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<EstadoPagareDeceval> findAllEstadoPagareDeceval() {
        List<EstadoPagareDeceval> listEstadoPagareDeceval = findAll();
        return listEstadoPagareDeceval;
    }

    
    public void deleteEstadoPagareDeceval(EstadoPagareDeceval estadoPagareDeceval) {
        delete(estadoPagareDeceval);
    }

}
