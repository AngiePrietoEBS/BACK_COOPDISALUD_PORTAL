/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;

/**
 *
 * @author Administrador
 */
public class ResponseSolicitudDiligenciada {

    private Boolean bRta;
    private String sMsj;
    private SolicitudCredito solicitudCredito;

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public SolicitudCredito getSolicitudCredito() {
        return solicitudCredito;
    }

    public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
        this.solicitudCredito = solicitudCredito;
    }

    @Override
    public String toString() {
        return "ResponseSolicitudDiligenciada{" + "bRta=" + bRta + ", sMsj=" + sMsj + ", solicitudCredito=" + solicitudCredito + '}';
    }

    
}
