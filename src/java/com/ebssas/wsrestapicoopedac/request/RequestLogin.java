/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.request;

/**
 *
 * @author Brayan Silva
 */
public class RequestLogin {

    private Long tipoDocumento;
    private Long tipoPerfil;
    private String numDocumento;
    private String password;
    private String sNavegador;
    private Long iTipoCanal;

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(Long tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsNavegador() {
        return sNavegador;
    }

    public void setsNavegador(String sNavegador) {
        this.sNavegador = sNavegador;
    }

    public Long getiTipoCanal() {
        return iTipoCanal;
    }

    public void setiTipoCanal(Long iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
    }
    
}
