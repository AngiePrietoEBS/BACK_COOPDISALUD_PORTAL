/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.CreacionGiradorDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class CreacionGiradorDecevalDataAccessImp extends GenericRepositoryJPAImp<CreacionGiradorDeceval>  {

    private EntityManager em = null;
    
    
    public CreacionGiradorDeceval saveCreacionGiradorDeceval(CreacionGiradorDeceval creacionGiradorDeceval) {
        CreacionGiradorDeceval tc = create(creacionGiradorDeceval);
        return tc;
    }

    
    public CreacionGiradorDeceval updateCreacionGiradorDeceval(CreacionGiradorDeceval creacionGiradorDeceval) {
        CreacionGiradorDeceval tc = update(creacionGiradorDeceval);
        return tc;
    }

    
    public CreacionGiradorDeceval findCreacionGiradorDecevalById(Long id) {
        CreacionGiradorDeceval tc = find(id);
        return tc; 
    }

    
    public List<CreacionGiradorDeceval> findAllCreacionGiradorDeceval() {
        List<CreacionGiradorDeceval> listCreacionGiradorDeceval = findAll();
        return listCreacionGiradorDeceval;
    }

    
    public void deleteCreacionGiradorDeceval(CreacionGiradorDeceval creacionGiradorDeceval) {
        delete(creacionGiradorDeceval);
    }

}
