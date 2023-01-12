/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseAperturaCuentaSolCred;

/**
 *
 * @author Administrador
 */
public interface AperturaCuentaSolCredService {

    AperturaCuentaSolCred saveAperturaCuentaSolCred(AperturaCuentaSolCred aperturaCuentaSolCred);

    AperturaCuentaSolCred updateAperturaCuentaSolCred(AperturaCuentaSolCred aperturaCuentaSolCred);

    AperturaCuentaSolCred findAperturaCuentaBySolCred(Long id);

    ResponseAperturaCuentaSolCred findAperturaCuentaBySolCredR(Long id);
}
