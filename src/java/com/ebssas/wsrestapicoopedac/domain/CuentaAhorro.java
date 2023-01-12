package com.ebssas.wsrestapicoopedac.domain;

public class CuentaAhorro 
{
    protected String numeroCuenta;
    protected String linea;
    protected String nombreLinea;
    protected String destino;
    protected String saldoTotal;
    protected String fechaApertura;
    
    public CuentaAhorro(){}
    public CuentaAhorro(String numeroCuenta, String linea, String nombreLinea, String destino, String saldoTotal, String fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.linea = linea;
        this.nombreLinea = nombreLinea;
        this.destino = destino;
        this.saldoTotal = saldoTotal;
        this.fechaApertura = fechaApertura;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(String saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" + "numeroCuenta=" + numeroCuenta + ", linea=" + linea + ", nombreLinea=" + nombreLinea + ", destino=" + destino + ", saldoTotal=" + saldoTotal + ", fechaApertura=" + fechaApertura + '}';
    }
}
