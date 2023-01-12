/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.TipoAutorizacionSolCred;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ResponseTiposAutorizacionesSolCred {

    private Boolean bRta;
    private String sMsj;
    private List<TipoAutorizacionSolCred> listTipoAutorizacion;

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

    public List<TipoAutorizacionSolCred> getListTipoAutorizacion() {
        return listTipoAutorizacion;
    }

    public void setListTipoAutorizacion(List<TipoAutorizacionSolCred> listTipoAutorizacion) {
        this.listTipoAutorizacion = listTipoAutorizacion;
    }

}
