/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;

/**
 *
 * @author Administrador
 */
public interface AperturaCuentaSolCredDataAccess {

    AperturaCuentaSolCred saveAperturaCuenta(AperturaCuentaSolCred cuentaSolCred);

    AperturaCuentaSolCred updateAperturaCuenta(AperturaCuentaSolCred cuentaSolCred);

    AperturaCuentaSolCred findAperturaCuentaByIdSolCred(Long idSolCred);
}
