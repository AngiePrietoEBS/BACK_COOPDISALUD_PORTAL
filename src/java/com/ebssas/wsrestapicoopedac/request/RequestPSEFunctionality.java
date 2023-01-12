/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.request;

/**
 *
 * @author Camilo
 */
public class RequestPSEFunctionality {
    
    private double pseTotalPago;
    private String pseTipoIdCliente;
    private String pseIdCliente;
    private String pseCodigoCliente;
    private String pseNombreCliente;
    private String pseApellidoCliente;
    private String pseTelefonoCliente;
    private String pseEmailCliente;
    private String ipCliente;
    private String credito;

    public double getPseTotalPago() {
        return pseTotalPago;
    }

    public void setPseTotalPago(double pseTotalPago) {
        this.pseTotalPago = pseTotalPago;
    }

    public String getPseTipoIdCliente() {
        return pseTipoIdCliente;
    }

    public void setPseTipoIdCliente(String pseTipoIdCliente) {
        this.pseTipoIdCliente = pseTipoIdCliente;
    }

    public String getPseIdCliente() {
        return pseIdCliente;
    }

    public void setPseIdCliente(String pseIdCliente) {
        this.pseIdCliente = pseIdCliente;
    }

    public String getPseCodigoCliente() {
        return pseCodigoCliente;
    }

    public void setPseCodigoCliente(String pseCodigoCliente) {
        this.pseCodigoCliente = pseCodigoCliente;
    }

    public String getPseNombreCliente() {
        return pseNombreCliente;
    }

    public void setPseNombreCliente(String pseNombreCliente) {
        this.pseNombreCliente = pseNombreCliente;
    }

    public String getPseApellidoCliente() {
        return pseApellidoCliente;
    }

    public void setPseApellidoCliente(String pseApellidoCliente) {
        this.pseApellidoCliente = pseApellidoCliente;
    }

    public String getPseTelefonoCliente() {
        return pseTelefonoCliente;
    }

    public void setPseTelefonoCliente(String pseTelefonoCliente) {
        this.pseTelefonoCliente = pseTelefonoCliente;
    }

    public String getPseEmailCliente() {
        return pseEmailCliente;
    }

    public void setPseEmailCliente(String pseEmailCliente) {
        this.pseEmailCliente = pseEmailCliente;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }
}
