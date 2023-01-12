/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.responseAML.AmlResponseDTO;

/**
 *
 * @author Administrador
 */
public class ResponseDatosPersonalesSolCred {

    private Boolean bRTa;
    private String sMjs;
    private ResponseDatosPersonales datosPersonales;
    private ResponseOcupacionPersona ocupacionPersona;
    private OperacionFinanciera operacionFinanciera;
    private InformacionDesembolso informacionDesembolso;
    private AperturaCuentaSolCred aperturaCuentaSolCred;
//    private AmlResponseDTO amlResponseDTO;
    
    public ResponseDatosPersonalesSolCred() {}

    public Boolean getbRTa() {
        return bRTa;
    }

    public void setbRTa(Boolean bRTa) {
        this.bRTa = bRTa;
    }

    public String getsMjs() {
        return sMjs;
    }

    public void setsMjs(String sMjs) {
        this.sMjs = sMjs;
    }

    public ResponseDatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(ResponseDatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public ResponseOcupacionPersona getOcupacionPersona() {
        return ocupacionPersona;
    }

    public void setOcupacionPersona(ResponseOcupacionPersona ocupacionPersona) {
        this.ocupacionPersona = ocupacionPersona;
    }

    public OperacionFinanciera getOperacionFinanciera() {
        return operacionFinanciera;
    }

    public void setOperacionFinanciera(OperacionFinanciera operacionFinanciera) {
        this.operacionFinanciera = operacionFinanciera;
    }

    public InformacionDesembolso getInformacionDesembolso() {
        return informacionDesembolso;
    }

    public void setInformacionDesembolso(InformacionDesembolso informacionDesembolso) {
        this.informacionDesembolso = informacionDesembolso;
    }

//    public AmlResponseDTO getAmlResponseDTO() {
//        return amlResponseDTO;
//    }
//
//    public void setAmlResponseDTO(AmlResponseDTO amlResponseDTO) {
//        this.amlResponseDTO = amlResponseDTO;
//    }

    public AperturaCuentaSolCred getAperturaCuentaSolCred() {
        return aperturaCuentaSolCred;
    }

    public void setAperturaCuentaSolCred(AperturaCuentaSolCred aperturaCuentaSolCred) {
        this.aperturaCuentaSolCred = aperturaCuentaSolCred;
    }

    @Override
    public String toString() {
        return "ResponseDatosPersonalesSolCred{" + "bRTa=" + bRTa + ", sMjs=" + sMjs + ", datosPersonales=" + datosPersonales.toString() + ", ocupacionPersona=" + ocupacionPersona + ", operacionFinanciera=" + operacionFinanciera + ", informacionDesembolso=" + informacionDesembolso + ", aperturaCuentaSolCred=" + aperturaCuentaSolCred + '}';
    }
}
