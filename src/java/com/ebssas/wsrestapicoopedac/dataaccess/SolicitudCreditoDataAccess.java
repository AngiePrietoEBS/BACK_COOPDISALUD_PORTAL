/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface SolicitudCreditoDataAccess {
    
    SolicitudCredito saveSolicitud(SolicitudCredito solicitudCredito);

    SolicitudCredito updateSolicitud(SolicitudCredito solicitudCredito);
    
    SolicitudCredito findSolicitudCreditoById(Long id);
    
    List<SolicitudCredito> findSolCreditoByPersona(Long idPersona);
    
    List<SolicitudCredito> findAllSolicitudCreditoOrderByFechaSolCred();
    
    List<SolicitudCredito> findAllSolicitudCredito();
}
