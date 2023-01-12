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
public class RequestCambiarEstadoSolCred {

    private Long lCodSolCredito;
    private Long lCodEstado;
    private Long lCodUsuario;
    private String sObservacion;
    private String cNumRadic;
    private String cPagareCygnus;
    private String cPagareDeceval;

    public Long getlCodSolCredito() {
        return lCodSolCredito;
    }

    public void setlCodSolCredito(Long lCodSolCredito) {
        this.lCodSolCredito = lCodSolCredito;
    }

    public Long getlCodEstado() {
        return lCodEstado;
    }

    public void setlCodEstado(Long lCodEstado) {
        this.lCodEstado = lCodEstado;
    }

    public Long getlCodUsuario() {
        return lCodUsuario;
    }

    public void setlCodUsuario(Long lCodUsuario) {
        this.lCodUsuario = lCodUsuario;
    }

    public String getsObservacion() {
        return sObservacion;
    }

    public void setsObservacion(String sObservacion) {
        this.sObservacion = sObservacion;
    }
    
    public String getcNumRadic() {
        return cNumRadic;
    }

    public void setcNumRadic(String cNumRadic) {
        this.cNumRadic = cNumRadic;
    }
    
      public String getcPagareCygnus() {
        return cPagareCygnus;
    }

    public void setcPagareCygnus(String cPagareCygnus) {
        this.cPagareCygnus = cPagareCygnus;
    }
    
       public String getcPagareDeceval() {
        return cPagareDeceval;
    }

    public void setcPagareDeceval(String cPagareDeceval) {
        this.cPagareDeceval = cPagareDeceval;
    }

}
