/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.responseAML;

/**
 *
 * @author EBS_OPER_17
 */
public class DatosAmlNews {
    private String title;
    private String url;
    private String fecha;
    private String buscado;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    @Override
    public String toString() {
        return "DatosAmlNews{" + "title=" + title + ", url=" + url + ", fecha=" + fecha + ", buscado=" + buscado + '}';
    }

    
}
