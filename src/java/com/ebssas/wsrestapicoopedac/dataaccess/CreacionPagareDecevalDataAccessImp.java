/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.CreacionPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class CreacionPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<CreacionPagareDeceval>  {

    private EntityManager em = null;
    
    
    public CreacionPagareDeceval saveCreacionPagareDeceval(CreacionPagareDeceval creacionPagareDeceval) {
        CreacionPagareDeceval tc = create(creacionPagareDeceval);
        return tc;
    }

    
    public CreacionPagareDeceval updateCreacionPagareDeceval(CreacionPagareDeceval creacionPagareDeceval) {
        CreacionPagareDeceval tc = update(creacionPagareDeceval);
        return tc;
    }

    
    public CreacionPagareDeceval findCreacionPagareDecevalById(Long id) {
        CreacionPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<CreacionPagareDeceval> findAllCreacionPagareDeceval() {
        List<CreacionPagareDeceval> listCreacionPagareDeceval = findAll();
        return listCreacionPagareDeceval;
    }

    
    public void deleteCreacionPagareDeceval(CreacionPagareDeceval creacionPagareDeceval) {
        delete(creacionPagareDeceval);
    }

}
