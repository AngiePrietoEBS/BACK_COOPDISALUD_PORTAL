/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseTipoEstadoSolCredito;
import java.util.List;

/**
 *
 * @author joseph
 */
public interface TipoEstadoSolCreditoService {

    TipoEstadoSolicitudCredito findByID(long id);

    List<ResponseTipoEstadoSolCredito> findAllTipoEstado();

    //List<ResponseTipoEstadoSolCredito> findTipoEstadoByIdCurrentTipoSolCred(Long IdCurrentTipoSolCred);
}
