/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.ClasePersonaDeceval;
import com.ebssas.wsrestapicoopedac.dataaccess.ClasePersonaDecevalDataAccessImp;
import java.util.List;

/**
 *
 * @author Braya
 */
public class ClasePersonaDecevalServiceBean {

    public ClasePersonaDeceval saveClasePersonaDeceval(ClasePersonaDeceval clasePersonaDeceval) {
        ClasePersonaDeceval tc = new ClasePersonaDecevalDataAccessImp().saveClasePersonaDeceval(clasePersonaDeceval);
        return tc;
    }

    public ClasePersonaDeceval updateClasePersonaDeceval(ClasePersonaDeceval clasePersonaDeceval) {
        ClasePersonaDeceval tc = new ClasePersonaDecevalDataAccessImp().updateClasePersonaDeceval(clasePersonaDeceval);
        return tc;
    }

    public ClasePersonaDeceval findClasePersonaDecevalById(Long id) {
        ClasePersonaDeceval tc = new ClasePersonaDecevalDataAccessImp().findClasePersonaDecevalById(id);
        return tc;
    }

    public List<ClasePersonaDeceval> findAllClasePersonaDeceval() {
        List<ClasePersonaDeceval> listClasePersonaDeceval = new ClasePersonaDecevalDataAccessImp().findAllClasePersonaDeceval();
        return listClasePersonaDeceval;
    }

    public void deleteClasePersonaDeceval(ClasePersonaDeceval clasePersonaDeceval) {
        new ClasePersonaDecevalDataAccessImp().deleteClasePersonaDeceval(clasePersonaDeceval);
    }

}
