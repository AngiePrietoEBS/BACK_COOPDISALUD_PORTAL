/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseNuevaSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseValidarSolCred;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;

/**
 *
 * @author juan_
 */
public interface SolicitudCreditoService {

    public ResponseSolicitudCredito buscarTodasSolCredito();

    public SolicitudCredito findSolCreditoByRadicado(String sNumRadic);

    public ResponseSolCredito findSolCreditoByRadicado2(String sNumRadic);

    public ResponseNuevaSolicitudCredito saveSolicitudCredito(SolicitudCredito solicitudCredito);

    public ResponseValidarSolCred validarSolicitudCredito(Long codPersona);

    public SolicitudCredito updateSolCreditoByRadicado(SolicitudCredito solicitudCredito);
}
