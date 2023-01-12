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
public class RequestConsultaAML {

    private String sNombre;
    private String sIdentificacion;

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsIdentificacion() {
        return sIdentificacion;
    }

    public void setsIdentificacion(String sIdentificacion) {
        this.sIdentificacion = sIdentificacion;
    }

}
