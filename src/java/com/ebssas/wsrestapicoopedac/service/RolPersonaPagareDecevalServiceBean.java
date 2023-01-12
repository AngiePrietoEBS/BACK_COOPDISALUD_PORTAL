/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.RolPersonaPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.RolPersonaPagareDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class RolPersonaPagareDecevalServiceBean {

    public RolPersonaPagareDeceval saveRolPersonaPagareDeceval(RolPersonaPagareDeceval rolPersonaPagareDeceval) {
        RolPersonaPagareDeceval tc = new RolPersonaPagareDecevalDataAccessImp().saveRolPersonaPagareDeceval(rolPersonaPagareDeceval);
        return tc;
    }

    public RolPersonaPagareDeceval updateRolPersonaPagareDeceval(RolPersonaPagareDeceval rolPersonaPagareDeceval) {
        RolPersonaPagareDeceval tc = new RolPersonaPagareDecevalDataAccessImp().updateRolPersonaPagareDeceval(rolPersonaPagareDeceval);
        return tc;
    }

    public RolPersonaPagareDeceval findRolPersonaPagareDecevalById(Long id) {
        RolPersonaPagareDeceval tc = new RolPersonaPagareDecevalDataAccessImp().findRolPersonaPagareDecevalById(id);
        return tc;
    }

    public List<RolPersonaPagareDeceval> findAllRolPersonaPagareDeceval() {
        List<RolPersonaPagareDeceval> listRolPersonaPagareDeceval = new RolPersonaPagareDecevalDataAccessImp().findAllRolPersonaPagareDeceval();
        return listRolPersonaPagareDeceval;
    }

    public void deleteRolPersonaPagareDeceval(RolPersonaPagareDeceval rolPersonaPagareDeceval) {
        new RolPersonaPagareDecevalDataAccessImp().deleteRolPersonaPagareDeceval(rolPersonaPagareDeceval);
    }

}
