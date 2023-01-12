/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.RtaCrearPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class RtaCrearPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<RtaCrearPagareDeceval>  {

    private EntityManager em = null;
    
    
    public RtaCrearPagareDeceval saveRtaCrearPagareDeceval(RtaCrearPagareDeceval rtaCrearPagareDeceval) {
        RtaCrearPagareDeceval tc = create(rtaCrearPagareDeceval);
        return tc;
    }

    
    public RtaCrearPagareDeceval updateRtaCrearPagareDeceval(RtaCrearPagareDeceval rtaCrearPagareDeceval) {
        RtaCrearPagareDeceval tc = update(rtaCrearPagareDeceval);
        return tc;
    }

    
    public RtaCrearPagareDeceval findRtaCrearPagareDecevalById(Long id) {
        RtaCrearPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<RtaCrearPagareDeceval> findAllRtaCrearPagareDeceval() {
        List<RtaCrearPagareDeceval> listRtaCrearPagareDeceval = findAll();
        return listRtaCrearPagareDeceval;
    }

    
    public void deleteRtaCrearPagareDeceval(RtaCrearPagareDeceval rtaCrearPagareDeceval) {
        delete(rtaCrearPagareDeceval);
    }

}
