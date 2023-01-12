/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ResponseAutorizacionSolCredito {

    private Boolean bRta;
    private String sMsj;
    private List<AutorizacionSolCredito> listAutorizaciones;

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

    public List<AutorizacionSolCredito> getListAutorizaciones() {
        return listAutorizaciones;
    }

    public void setListAutorizaciones(List<AutorizacionSolCredito> listAutorizaciones) {
        this.listAutorizaciones = listAutorizaciones;
    }

}
