/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface TipoEstadoSolCreditoDataAccess {
    TipoEstadoSolicitudCredito findByID(long id);
    
    List<TipoEstadoSolicitudCredito> findAllTipoEstado();
}

