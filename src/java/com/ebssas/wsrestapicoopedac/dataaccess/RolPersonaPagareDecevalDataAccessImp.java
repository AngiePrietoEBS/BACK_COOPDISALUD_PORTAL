/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.RolPersonaPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class RolPersonaPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<RolPersonaPagareDeceval>  {

    private EntityManager em = null;
    
    
    public RolPersonaPagareDeceval saveRolPersonaPagareDeceval(RolPersonaPagareDeceval rolPersonaPagareDeceval) {
        RolPersonaPagareDeceval tc = create(rolPersonaPagareDeceval);
        return tc;
    }

    
    public RolPersonaPagareDeceval updateRolPersonaPagareDeceval(RolPersonaPagareDeceval rolPersonaPagareDeceval) {
        RolPersonaPagareDeceval tc = update(rolPersonaPagareDeceval);
        return tc;
    }

    
    public RolPersonaPagareDeceval findRolPersonaPagareDecevalById(Long id) {
        RolPersonaPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<RolPersonaPagareDeceval> findAllRolPersonaPagareDeceval() {
        List<RolPersonaPagareDeceval> listRolPersonaPagareDeceval = findAll();
        return listRolPersonaPagareDeceval;
    }

    
    public void deleteRolPersonaPagareDeceval(RolPersonaPagareDeceval rolPersonaPagareDeceval) {
        delete(rolPersonaPagareDeceval);
    }

}
