/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.FirmaPagareDecevalDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.FirmaPagareDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class FirmaPagareDecevalServiceBean {
    
    public FirmaPagareDeceval saveFirmaPagareDeceval(FirmaPagareDeceval firmaPagareDeceval) {
        FirmaPagareDeceval tc = new FirmaPagareDecevalDataAccessImp().saveFirmaPagareDeceval(firmaPagareDeceval);
        return tc;
    }
    
    public FirmaPagareDeceval updateFirmaPagareDeceval(FirmaPagareDeceval firmaPagareDeceval) {
        FirmaPagareDeceval tc = new FirmaPagareDecevalDataAccessImp().updateFirmaPagareDeceval(firmaPagareDeceval);
        return tc;
    }
    
    public FirmaPagareDeceval findFirmaPagareDecevalById(Long id) {
        FirmaPagareDeceval tc = new FirmaPagareDecevalDataAccessImp().findFirmaPagareDecevalById(id);
        return tc;
    }
    
    public List<FirmaPagareDeceval> findAllFirmaPagareDeceval() {
        List<FirmaPagareDeceval> listFirmaPagareDeceval = new FirmaPagareDecevalDataAccessImp().findAllFirmaPagareDeceval();
        return listFirmaPagareDeceval;
    }
    
    public void deleteFirmaPagareDeceval(FirmaPagareDeceval firmaPagareDeceval) {
        new FirmaPagareDecevalDataAccessImp().deleteFirmaPagareDeceval(firmaPagareDeceval);
    }
    
}
