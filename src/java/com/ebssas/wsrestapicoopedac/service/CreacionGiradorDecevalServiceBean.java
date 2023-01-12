/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.CreacionGiradorDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.CreacionGiradorDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class CreacionGiradorDecevalServiceBean {

    public CreacionGiradorDeceval saveCreacionGiradorDeceval(CreacionGiradorDeceval creacionGiradorDeceval) {
        CreacionGiradorDeceval tc = new CreacionGiradorDecevalDataAccessImp().saveCreacionGiradorDeceval(creacionGiradorDeceval);
        return tc;
    }

    public CreacionGiradorDeceval updateCreacionGiradorDeceval(CreacionGiradorDeceval creacionGiradorDeceval) {
        CreacionGiradorDeceval tc = new CreacionGiradorDecevalDataAccessImp().updateCreacionGiradorDeceval(creacionGiradorDeceval);
        return tc;
    }

    public CreacionGiradorDeceval findCreacionGiradorDecevalById(Long id) {
        CreacionGiradorDeceval tc = new CreacionGiradorDecevalDataAccessImp().findCreacionGiradorDecevalById(id);
        return tc;
    }

    public List<CreacionGiradorDeceval> findAllCreacionGiradorDeceval() {
        List<CreacionGiradorDeceval> listCreacionGiradorDeceval = new CreacionGiradorDecevalDataAccessImp().findAllCreacionGiradorDeceval();
        return listCreacionGiradorDeceval;
    }

    public void deleteCreacionGiradorDeceval(CreacionGiradorDeceval creacionGiradorDeceval) {
        new CreacionGiradorDecevalDataAccessImp().deleteCreacionGiradorDeceval(creacionGiradorDeceval);
    }

}
