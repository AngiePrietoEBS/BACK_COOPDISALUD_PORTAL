/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.RtaCrearGiradorDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.RtaCrearGiradorDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class RtaCrearGiradorDecevalServiceBean {

    public RtaCrearGiradorDeceval saveRtaCrearGiradorDeceval(RtaCrearGiradorDeceval rtaCrearGiradorDeceval) {
        RtaCrearGiradorDeceval tc = new RtaCrearGiradorDecevalDataAccessImp().saveRtaCrearGiradorDeceval(rtaCrearGiradorDeceval);
        return tc;
    }

    public RtaCrearGiradorDeceval updateRtaCrearGiradorDeceval(RtaCrearGiradorDeceval rtaCrearGiradorDeceval) {
        RtaCrearGiradorDeceval tc = new RtaCrearGiradorDecevalDataAccessImp().updateRtaCrearGiradorDeceval(rtaCrearGiradorDeceval);
        return tc;
    }

    public RtaCrearGiradorDeceval findRtaCrearGiradorDecevalById(Long id) {
        RtaCrearGiradorDeceval tc = new RtaCrearGiradorDecevalDataAccessImp().findRtaCrearGiradorDecevalById(id);
        return tc;
    }

    public List<RtaCrearGiradorDeceval> findAllRtaCrearGiradorDeceval() {
        List<RtaCrearGiradorDeceval> listRtaCrearGiradorDeceval = new RtaCrearGiradorDecevalDataAccessImp().findAllRtaCrearGiradorDeceval();
        return listRtaCrearGiradorDeceval;
    }

    public void deleteRtaCrearGiradorDeceval(RtaCrearGiradorDeceval rtaCrearGiradorDeceval) {
        new RtaCrearGiradorDecevalDataAccessImp().deleteRtaCrearGiradorDeceval(rtaCrearGiradorDeceval);
    }

}
