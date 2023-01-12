/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.request;

/**
 *
 * @author Administrador
 */
public class RequestCupoMaxSolCred {

    private String sIdentificacion;
    private String sCodCredito;
    private String sPeriodicidad;

    public String getsIdentificacion() {
        return sIdentificacion;
    }

    public void setsIdentificacion(String sIdentificacion) {
        this.sIdentificacion = sIdentificacion;
    }

    public String getsCodCredito() {
        return sCodCredito;
    }

    public void setsCodCredito(String sCodCredito) {
        this.sCodCredito = sCodCredito;
    }

    public String getsPeriodicidad() {
        return sPeriodicidad;
    }

    public void setsPeriodicidad(String sPeriodicidad) {
        this.sPeriodicidad = sPeriodicidad;
    }

}
