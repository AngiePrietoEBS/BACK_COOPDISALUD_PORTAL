/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.RtaCrearPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.RtaCrearPagareDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class RtaCrearPagareDecevalServiceBean {

    public RtaCrearPagareDeceval saveRtaCrearPagareDeceval(RtaCrearPagareDeceval rtaCrearPagareDeceval) {
        RtaCrearPagareDeceval tc = new RtaCrearPagareDecevalDataAccessImp().saveRtaCrearPagareDeceval(rtaCrearPagareDeceval);
        return tc;
    }

    public RtaCrearPagareDeceval updateRtaCrearPagareDeceval(RtaCrearPagareDeceval rtaCrearPagareDeceval) {
        RtaCrearPagareDeceval tc = new RtaCrearPagareDecevalDataAccessImp().updateRtaCrearPagareDeceval(rtaCrearPagareDeceval);
        return tc;
    }

    public RtaCrearPagareDeceval findRtaCrearPagareDecevalById(Long id) {
        RtaCrearPagareDeceval tc = new RtaCrearPagareDecevalDataAccessImp().findRtaCrearPagareDecevalById(id);
        return tc;
    }

    public List<RtaCrearPagareDeceval> findAllRtaCrearPagareDeceval() {
        List<RtaCrearPagareDeceval> listRtaCrearPagareDeceval = new RtaCrearPagareDecevalDataAccessImp().findAllRtaCrearPagareDeceval();
        return listRtaCrearPagareDeceval;
    }

    public void deleteRtaCrearPagareDeceval(RtaCrearPagareDeceval rtaCrearPagareDeceval) {
        new RtaCrearPagareDecevalDataAccessImp().deleteRtaCrearPagareDeceval(rtaCrearPagareDeceval);
    }

}
