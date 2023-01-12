/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.FirmaPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class FirmaPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<FirmaPagareDeceval> {

    private EntityManager em = null;

    public FirmaPagareDeceval saveFirmaPagareDeceval(FirmaPagareDeceval firmaPagareDeceval) {
        FirmaPagareDeceval tc = create(firmaPagareDeceval);
        return tc;
    }

    public FirmaPagareDeceval updateFirmaPagareDeceval(FirmaPagareDeceval firmaPagareDeceval) {
        FirmaPagareDeceval tc = update(firmaPagareDeceval);
        return tc;
    }

    public FirmaPagareDeceval findFirmaPagareDecevalById(Long id) {
        FirmaPagareDeceval tc = find(id);
        return tc;
    }

    public List<FirmaPagareDeceval> findAllFirmaPagareDeceval() {
        List<FirmaPagareDeceval> listFirmaPagareDeceval = findAll();
        return listFirmaPagareDeceval;
    }

    public void deleteFirmaPagareDeceval(FirmaPagareDeceval firmaPagareDeceval) {
        delete(firmaPagareDeceval);
    }

}
