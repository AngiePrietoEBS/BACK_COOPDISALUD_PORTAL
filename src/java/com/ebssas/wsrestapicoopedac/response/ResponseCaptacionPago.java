/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

/**
 *
 * @author EBS-USER
 */
public class ResponseCaptacionPago {

    private String sMsj;
    private Long Cedula;
    private Long Valor;

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public Long getCedula() {
        return Cedula;
    }

    public void setCedula(Long Cedula) {
        this.Cedula = Cedula;
    }

    public Long getValor() {
        return Valor;
    }

    public void setValor(Long Valor) {
        this.Valor = Valor;
    }

}
