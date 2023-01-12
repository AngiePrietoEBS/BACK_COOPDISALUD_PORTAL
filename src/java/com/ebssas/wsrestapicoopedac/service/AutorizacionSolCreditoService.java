/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseAutorizacionSolCredito;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface AutorizacionSolCreditoService {

    ResponseAutorizacionSolCredito findAllAutorizacionBySolCred(Long idSolCred);

    RespuestaGenerica saveAutorizacion(List<AutorizacionSolCredito> ascs);

    AutorizacionSolCredito updateAutorizacion(AutorizacionSolCredito autorizacionSolCredito);
}
