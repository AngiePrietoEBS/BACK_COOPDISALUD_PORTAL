/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.RtaCrearGiradorDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class RtaCrearGiradorDecevalDataAccessImp extends GenericRepositoryJPAImp<RtaCrearGiradorDeceval> {

    private EntityManager em = null;

    public RtaCrearGiradorDeceval saveRtaCrearGiradorDeceval(RtaCrearGiradorDeceval rtaCrearGiradorDeceval) {
        RtaCrearGiradorDeceval tc = create(rtaCrearGiradorDeceval);
        return tc;
    }

    public RtaCrearGiradorDeceval updateRtaCrearGiradorDeceval(RtaCrearGiradorDeceval rtaCrearGiradorDeceval) {
        RtaCrearGiradorDeceval tc = update(rtaCrearGiradorDeceval);
        return tc;
    }

    public RtaCrearGiradorDeceval findRtaCrearGiradorDecevalById(Long id) {
        RtaCrearGiradorDeceval tc = find(id);
        return tc;
    }

    public List<RtaCrearGiradorDeceval> findAllRtaCrearGiradorDeceval() {
        List<RtaCrearGiradorDeceval> listRtaCrearGiradorDeceval = findAll();
        return listRtaCrearGiradorDeceval;
    }

    public void deleteRtaCrearGiradorDeceval(RtaCrearGiradorDeceval rtaCrearGiradorDeceval) {
        delete(rtaCrearGiradorDeceval);
    }

}
