/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.request;

import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;
import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;

/**
 *
 * @author Administrador
 */
public class RequestDatosPersona {

    private Persona persona; //MY
    private DatosPersonales datosPersonales;
    private OcupacionPersona ocupacionPersona;
    private OperacionFinanciera operacionFinanciera;
    private InformacionDesembolso informacionDesembolso;
    //private PersonaPep personasPep[];
    private String sInformacionDesembolso;
    private String sNumRadicSolCred;
    private String cIdentificacionVendedor;

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public OcupacionPersona getOcupacionPersona() {
        return ocupacionPersona;
    }

    public void setOcupacionPersona(OcupacionPersona ocupacionPersona) {
        this.ocupacionPersona = ocupacionPersona;
    }

    public OperacionFinanciera getOperacionFinanciera() {
        return operacionFinanciera;
    }

    public void setOperacionFinanciera(OperacionFinanciera operacionFinanciera) {
        this.operacionFinanciera = operacionFinanciera;
    }

    public String getsNumRadicSolCred() {
        return sNumRadicSolCred;
    }

    public void setsNumRadicSolCred(String sNumRadicSolCred) {
        this.sNumRadicSolCred = sNumRadicSolCred;
    }

    public String getsInformacionDesembolso() {
        return sInformacionDesembolso;
    }

    public void setsInformacionDesembolso(String sInformacionDesembolso) {
        this.sInformacionDesembolso = sInformacionDesembolso;
    }

    public InformacionDesembolso getInformacionDesembolso() {
        return informacionDesembolso;
    }

    public void setInformacionDesembolso(InformacionDesembolso informacionDesembolso) {
        this.informacionDesembolso = informacionDesembolso;
    }

    @Override
    public String toString() {
        return "RequestDatosPersona{" + "datosPersonales=" + datosPersonales + ", ocupacionPersona=" + ocupacionPersona + ", operacionFinanciera=" + operacionFinanciera + ", informacionDesembolso=" + informacionDesembolso + ", sInformacionDesembolso=" + sInformacionDesembolso + ", sNumRadicSolCred=" + sNumRadicSolCred + '}';
    }

    /**
     * MY
     *
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * MY
     *
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the cIdentificacionVendedor
     */
    public String getCIdentificacionVendedor() {
        return cIdentificacionVendedor;
    }

    /**
     * @param cIdentificacionVendedor the CIdentificacionVendedor to set
     */
    public void setCIdentificacionVendedor(String cIdentificacionVendedor) {
        this.cIdentificacionVendedor = cIdentificacionVendedor;
    }

//    public PersonaPep[] getPersonasPep() {
//        return personasPep;
//    }
//
//    public void setPersonasPep(PersonaPep[] personasPep) {
//        this.personasPep = personasPep;
//    }

}
