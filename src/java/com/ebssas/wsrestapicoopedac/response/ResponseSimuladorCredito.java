/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import WSSimuladorCreditoCoopedac.ArrayOfLiquidacionAtr;
import java.math.BigDecimal;

/**
 *
 * @author Administrador
 */
public class ResponseSimuladorCredito {

    private Boolean bRta;
    private String sMsj;
    private BigDecimal bdValorCuota;
    private String sTasa;
    private ArrayOfLiquidacionAtr rLiquidacion;

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

    public BigDecimal getBdValorCuota() {
        return bdValorCuota;
    }

    public void setBdValorCuota(BigDecimal bdValorCuota) {
        this.bdValorCuota = bdValorCuota;
    }

    public String getsTasa() {
        return sTasa;
    }

    public void setsTasa(String sTasa) {
        this.sTasa = sTasa;
    }

    public ArrayOfLiquidacionAtr getrLiquidacion() {
        return rLiquidacion;
    }

    public void setrLiquidacion(ArrayOfLiquidacionAtr rLiquidacion) {
        this.rLiquidacion = rLiquidacion;
    }

}
