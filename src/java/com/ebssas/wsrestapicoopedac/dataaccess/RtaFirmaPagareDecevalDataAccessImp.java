/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.RtaFirmaPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class RtaFirmaPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<RtaFirmaPagareDeceval> {

    private EntityManager em = null;

    public RtaFirmaPagareDeceval saveRtaFirmaPagareDeceval(RtaFirmaPagareDeceval rtaFirmaPagareDeceval) {
        RtaFirmaPagareDeceval tc = create(rtaFirmaPagareDeceval);
        return tc;
    }

    public RtaFirmaPagareDeceval updateRtaFirmaPagareDeceval(RtaFirmaPagareDeceval rtaFirmaPagareDeceval) {
        RtaFirmaPagareDeceval tc = update(rtaFirmaPagareDeceval);
        return tc;
    }

    public RtaFirmaPagareDeceval findRtaFirmaPagareDecevalById(Long id) {
        RtaFirmaPagareDeceval tc = find(id);
        return tc;
    }

    public List<RtaFirmaPagareDeceval> findAllRtaFirmaPagareDeceval() {
        List<RtaFirmaPagareDeceval> listRtaFirmaPagareDeceval = findAll();
        return listRtaFirmaPagareDeceval;
    }

    public void deleteRtaFirmaPagareDeceval(RtaFirmaPagareDeceval rtaFirmaPagareDeceval) {
        delete(rtaFirmaPagareDeceval);
    }

}
