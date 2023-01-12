/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.sms;

/**
 *
 * @author Brayan F Silva R
 */
public class infoSendSMS {

    private String id;
    private String numero;
    private String sms;
    private String fecha_envio;
    private String ind_area_nom;
    private String precio_sms;
    private int resultado_t;
    private int resultado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getInd_area_nom() {
        return ind_area_nom;
    }

    public void setInd_area_nom(String ind_area_nom) {
        this.ind_area_nom = ind_area_nom;
    }

    public String getPrecio_sms() {
        return precio_sms;
    }

    public void setPrecio_sms(String precio_sms) {
        this.precio_sms = precio_sms;
    }

    public int getResultado_t() {
        return resultado_t;
    }

    public void setResultado_t(int resultado_t) {
        this.resultado_t = resultado_t;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
