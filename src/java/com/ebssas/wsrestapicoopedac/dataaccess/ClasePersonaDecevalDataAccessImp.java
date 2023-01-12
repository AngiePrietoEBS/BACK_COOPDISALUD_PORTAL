/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ClasePersonaDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class ClasePersonaDecevalDataAccessImp extends GenericRepositoryJPAImp<ClasePersonaDeceval>  {

    private EntityManager em = null;
    
    
    public ClasePersonaDeceval saveClasePersonaDeceval(ClasePersonaDeceval clasePersonaDeceval) {
        ClasePersonaDeceval tc = create(clasePersonaDeceval);
        return tc;
    }

    
    public ClasePersonaDeceval updateClasePersonaDeceval(ClasePersonaDeceval clasePersonaDeceval) {
        ClasePersonaDeceval tc = update(clasePersonaDeceval);
        return tc;
    }

    
    public ClasePersonaDeceval findClasePersonaDecevalById(Long id) {
        ClasePersonaDeceval tc = find(id);
        return tc; 
    }

    
    public List<ClasePersonaDeceval> findAllClasePersonaDeceval() {
        List<ClasePersonaDeceval> listClasePersonaDeceval = findAll();
        return listClasePersonaDeceval;
    }

    
    public void deleteClasePersonaDeceval(ClasePersonaDeceval clasePersonaDeceval) {
        delete(clasePersonaDeceval);
    }

}
