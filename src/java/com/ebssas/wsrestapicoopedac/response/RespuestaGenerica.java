/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

/**
 *
 * @author Brayan F Silva R
 */
public class RespuestaGenerica {

    private int iCodigo;
    private Boolean bRta;
    private String sMsj;

    public RespuestaGenerica() {

    }

    public RespuestaGenerica(int iCodigo) {
        this.iCodigo = iCodigo;
    }

    public int getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(int iCodigo) {
        this.iCodigo = iCodigo;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.iCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RespuestaGenerica other = (RespuestaGenerica) obj;
        if (this.iCodigo != other.iCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "respuestaGenerica{" + "iCodigo=" + iCodigo + '}';
    }

}
