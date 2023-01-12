/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.CreacionPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.CreacionPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class CreacionPagareDecevalServiceBean {

    public CreacionPagareDeceval saveCreacionPagareDeceval(CreacionPagareDeceval creacionPagareDeceval) {
        CreacionPagareDeceval tc = new CreacionPagareDecevalDataAccessImp().saveCreacionPagareDeceval(creacionPagareDeceval);
        return tc;
    }

    public CreacionPagareDeceval updateCreacionPagareDeceval(CreacionPagareDeceval creacionPagareDeceval) {
        CreacionPagareDeceval tc = new CreacionPagareDecevalDataAccessImp().updateCreacionPagareDeceval(creacionPagareDeceval);
        return tc;
    }

    public CreacionPagareDeceval findCreacionPagareDecevalById(Long id) {
        CreacionPagareDeceval tc = new CreacionPagareDecevalDataAccessImp().findCreacionPagareDecevalById(id);
        return tc;
    }

    public List<CreacionPagareDeceval> findAllCreacionPagareDeceval() {
        List<CreacionPagareDeceval> listCreacionPagareDeceval = new CreacionPagareDecevalDataAccessImp().findAllCreacionPagareDeceval();
        return listCreacionPagareDeceval;
    }

    public void deleteCreacionPagareDeceval(CreacionPagareDeceval creacionPagareDeceval) {
        new CreacionPagareDecevalDataAccessImp().deleteCreacionPagareDeceval(creacionPagareDeceval);
    }

}
