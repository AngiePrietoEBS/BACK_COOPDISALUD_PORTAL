/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.RtaFirmaPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.RtaFirmaPagareDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class RtaFirmaPagareDecevalServiceBean {

    public RtaFirmaPagareDeceval saveRtaFirmaPagareDeceval(RtaFirmaPagareDeceval rtaFirmaPagareDeceval) {
        RtaFirmaPagareDeceval tc = new RtaFirmaPagareDecevalDataAccessImp().saveRtaFirmaPagareDeceval(rtaFirmaPagareDeceval);
        return tc;
    }

    public RtaFirmaPagareDeceval updateRtaFirmaPagareDeceval(RtaFirmaPagareDeceval rtaFirmaPagareDeceval) {
        RtaFirmaPagareDeceval tc = new RtaFirmaPagareDecevalDataAccessImp().updateRtaFirmaPagareDeceval(rtaFirmaPagareDeceval);
        return tc;
    }

    public RtaFirmaPagareDeceval findRtaFirmaPagareDecevalById(Long id) {
        RtaFirmaPagareDeceval tc = new RtaFirmaPagareDecevalDataAccessImp().findRtaFirmaPagareDecevalById(id);
        return tc;
    }

    public List<RtaFirmaPagareDeceval> findAllRtaFirmaPagareDeceval() {
        List<RtaFirmaPagareDeceval> listRtaFirmaPagareDeceval = new RtaFirmaPagareDecevalDataAccessImp().findAllRtaFirmaPagareDeceval();
        return listRtaFirmaPagareDeceval;
    }

    public void deleteRtaFirmaPagareDeceval(RtaFirmaPagareDeceval rtaFirmaPagareDeceval) {
        new RtaFirmaPagareDecevalDataAccessImp().deleteRtaFirmaPagareDeceval(rtaFirmaPagareDeceval);
    }

}
