/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface AutorizacionSolCreditoDataAccess {

    AutorizacionSolCredito saveAutorizacion(AutorizacionSolCredito autorizacionSolCredito);

    AutorizacionSolCredito updateAutorizacion(AutorizacionSolCredito autorizacionSolCredito);

    List<AutorizacionSolCredito> findAllAutorizacionBySolCred(Long idSolCreds);

    AutorizacionSolCredito findAutorizacionByTipo(Long idTipo);
}
