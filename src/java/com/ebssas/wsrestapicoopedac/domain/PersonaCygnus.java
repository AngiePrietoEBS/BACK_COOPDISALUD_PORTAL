/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class PersonaCygnus implements Serializable {
     private static final long serialVersionUID = 1L;

    private String Resultado;
    private String MensajeError;
    private String CodigoCygnus;

    public PersonaCygnus() {
    }

    public PersonaCygnus(String Resultado, String MensajeError, String CodigoCygnus) {
        this.Resultado = Resultado;
        this.MensajeError = MensajeError;
        this.CodigoCygnus = CodigoCygnus;
    }

    /**
     * @return the Resultado
     */
    public String getResultado() {
        return Resultado;
    }

    /**
     * @param Resultado the Resultado to set
     */
    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    /**
     * @return the MensajeError
     */
    public String getMensajeError() {
        return MensajeError;
    }

    /**
     * @param MensajeError the MensajeError to set
     */
    public void setMensajeError(String MensajeError) {
        this.MensajeError = MensajeError;
    }

    /**
     * @return the CodigoCygnus
     */
    public String getCodigoCygnus() {
        return CodigoCygnus;
    }

    /**
     * @param CodigoCygnus the CodigoCygnus to set
     */
    public void setCodigoCygnus(String CodigoCygnus) {
        this.CodigoCygnus = CodigoCygnus;
    }
}
