/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

/**
 *
 * @author Administrador
 */
public class ResponseCupoMaximo {

    private Boolean bRta;
    private String sMsj;
    private String sCupoMaximo;
    private String sPlazoMaximo;
    private String sTasaInteres;
    private String sValorCuota;

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

    public String getsCupoMaximo() {
        return sCupoMaximo;
    }

    public void setsCupoMaximo(String sCupoMaximo) {
        this.sCupoMaximo = sCupoMaximo;
    }

    public String getsPlazoMaximo() {
        return sPlazoMaximo;
    }

    public void setsPlazoMaximo(String sPlazoMaximo) {
        this.sPlazoMaximo = sPlazoMaximo;
    }

    public String getsTasaInteres() {
        return sTasaInteres;
    }

    public void setsTasaInteres(String sTasaInteres) {
        this.sTasaInteres = sTasaInteres;
    }

    public String getsValorCuota() {
        return sValorCuota;
    }

    public void setsValorCuota(String sValorCuota) {
        this.sValorCuota = sValorCuota;
    }
    
    
    
    @Override
    public String toString() {
        return "ResponseCupoMaximo{" + "bRta=" + bRta + ", sMsj=" + sMsj + ", sCupoMaximo=" + sCupoMaximo + ", sPlazoMaximo=" + sPlazoMaximo + ", sTasaInteres=" + sTasaInteres + '}';
    }
}
