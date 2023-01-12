/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import WSAdminCoopedac.CiudadDTO;
import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.domain.CondicionCuenta;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class ResponseAperturaCuentaSolCred extends AperturaCuentaSolCred {

    private CiudadDTO ciudad;

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

}
