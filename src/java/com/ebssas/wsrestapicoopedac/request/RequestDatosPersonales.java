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
public class RequestDatosPersonales {

    private Long codPersona;
    private Long idSolCred;

    public Long getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Long codPersona) {
        this.codPersona = codPersona;
    }

    public Long getIdSolCred() {
        return idSolCred;
    }

    public void setIdSolCred(Long idSolCred) {
        this.idSolCred = idSolCred;
    }

    @Override
    public String toString() {
        return "RequestDatosPersonales{" + "codPersona=" + codPersona + ", idSolCred=" + idSolCred + '}';
    }
}
