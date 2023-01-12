/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.*;
import com.ebssas.wsrestapicoopedac.domain.EstadoProcesoPagare;
import com.ebssas.wsrestapicoopedac.domain.ProcesoPagareDeceval;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Braya
 */
public class ProcesoPagareServiceBean {
    
    public ProcesoPagareDeceval saveProcesoPagareDeceval(ProcesoPagareDeceval procesoPagareDeceval) {
        ProcesoPagareDeceval tc = new ProcesoPagareDataAccessImp().saveProcesoPagareDeceval(procesoPagareDeceval);
        return tc;
    }
    
    public ProcesoPagareDeceval updateProcesoPagareDeceval(ProcesoPagareDeceval procesoPagareDeceval) {
        ProcesoPagareDeceval tc = new ProcesoPagareDataAccessImp().updateProcesoPagareDeceval(procesoPagareDeceval);
        return tc;
    }
    
    public ProcesoPagareDeceval findProcesoPagareDecevalById(Long id) {
        ProcesoPagareDeceval tc = new ProcesoPagareDataAccessImp().findProcesoPagareDecevalById(id);
        return tc;
    }
    
    public List<ProcesoPagareDeceval> findAllProcesoPagareDeceval() {
        List<ProcesoPagareDeceval> listProcesoPagareDeceval = new ProcesoPagareDataAccessImp().findAllProcesoPagareDeceval();
        return listProcesoPagareDeceval;
    }
    
    public void deleteProcesoPagareDeceval(ProcesoPagareDeceval procesoPagareDeceval) {
        new ProcesoPagareDataAccessImp().deleteProcesoPagareDeceval(procesoPagareDeceval);
    }
    
    public Boolean generarProcesoPagareDecevalBySolCred(SolicitudCredito solicitudCredito) {
        Boolean rta = Boolean.FALSE;
        try {
            if (solicitudCredito != null && solicitudCredito.getICodigo() != null) {
                ProcesoPagareDeceval newProcesoPagareDeceval = new ProcesoPagareDeceval();
                newProcesoPagareDeceval.setISolicitudCredito(solicitudCredito);
                newProcesoPagareDeceval.setIEstadoProceso(new EstadoProcesoPagare(BigDecimal.ONE));
                newProcesoPagareDeceval.setFFechaRegistro(new Date());
                newProcesoPagareDeceval.setFFechaHeader(new Date());
                newProcesoPagareDeceval.setFHoraHeader(new Date());
                newProcesoPagareDeceval.setCCodDepositanteHeader("904");
                newProcesoPagareDeceval.setCUsuarioHeader("86052054781");
                
                ProcesoPagareDeceval saveProcesoPagareDeceval = this.saveProcesoPagareDeceval(newProcesoPagareDeceval);
                if (saveProcesoPagareDeceval != null & saveProcesoPagareDeceval.getICodigo() != null) {
                    rta = Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            rta = Boolean.FALSE;
        }
        return rta;
    }
    
}
