/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ProcesoPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class ProcesoPagareDataAccessImp extends GenericRepositoryJPAImp<ProcesoPagareDeceval>  {

    private EntityManager em = null;
    
    
    public ProcesoPagareDeceval saveProcesoPagareDeceval(ProcesoPagareDeceval procesoPagareDeceval) {
        ProcesoPagareDeceval tc = create(procesoPagareDeceval);
        return tc;
    }

    
    public ProcesoPagareDeceval updateProcesoPagareDeceval(ProcesoPagareDeceval procesoPagareDeceval) {
        ProcesoPagareDeceval tc = update(procesoPagareDeceval);
        return tc;
    }

    
    public ProcesoPagareDeceval findProcesoPagareDecevalById(Long id) {
        ProcesoPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<ProcesoPagareDeceval> findAllProcesoPagareDeceval() {
        List<ProcesoPagareDeceval> listProcesoPagareDeceval = findAll();
        return listProcesoPagareDeceval;
    }

    
    public void deleteProcesoPagareDeceval(ProcesoPagareDeceval procesoPagareDeceval) {
        delete(procesoPagareDeceval);
    }

}
