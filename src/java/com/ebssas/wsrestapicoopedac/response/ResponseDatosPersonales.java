/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import WSAdminCoopedac.CiudadDTO;
import WSAdminCoopedac.TipoEstadoCivilDTO;
import WSAdminCoopedac.TipoNivelesEstudioDTO;
import com.ebssas.wsrestapicoopedac.domain.Persona;

/**
 *
 * @author Administrador
 */
public class ResponseDatosPersonales {

    private Long ICodigo;
    private CiudadDTO IDepartamentoResidencia;
    private CiudadDTO ICiudadResidencia;
    private String CDireccionResidencia;
    private Long ITipoVivienda;
    private String IEstrato;
    private Long NPersonasCargo;
    private String CCabezaHogar;
    private TipoEstadoCivilDTO CEstadoCivil;
    private TipoNivelesEstudioDTO INivelEstudio;
    private String CTelefonoFijo;
    private String CNumCelular;
    private String CFacebook;
    private String CLinkedin;
    private String CEmail;
    private Persona IPersona;

    public Long getICodigo() {
        return ICodigo;
    }

    public void setICodigo(Long ICodigo) {
        this.ICodigo = ICodigo;
    }

    public CiudadDTO getIDepartamentoResidencia() {
        return IDepartamentoResidencia;
    }

    public void setIDepartamentoResidencia(CiudadDTO IDepartamentoResidencia) {
        this.IDepartamentoResidencia = IDepartamentoResidencia;
    }

    public CiudadDTO getICiudadResidencia() {
        return ICiudadResidencia;
    }

    public void setICiudadResidencia(CiudadDTO ICiudadResidencia) {
        this.ICiudadResidencia = ICiudadResidencia;
    }

    public String getCDireccionResidencia() {
        return CDireccionResidencia;
    }

    public void setCDireccionResidencia(String CDireccionResidencia) {
        this.CDireccionResidencia = CDireccionResidencia;
    }

    public Long getITipoVivienda() {
        return ITipoVivienda;
    }

    public void setITipoVivienda(Long ITipoVivienda) {
        this.ITipoVivienda = ITipoVivienda;
    }

    public String getIEstrato() {
        return IEstrato;
    }

    public void setIEstrato(String IEstrato) {
        this.IEstrato = IEstrato;
    }

    public Long getNPersonasCargo() {
        return NPersonasCargo;
    }

    public void setNPersonasCargo(Long NPersonasCargo) {
        this.NPersonasCargo = NPersonasCargo;
    }

    public String getCCabezaHogar() {
        return CCabezaHogar;
    }

    public void setCCabezaHogar(String CCabezaHogar) {
        this.CCabezaHogar = CCabezaHogar;
    }

    public TipoEstadoCivilDTO getCEstadoCivil() {
        return CEstadoCivil;
    }

    public void setCEstadoCivil(TipoEstadoCivilDTO CEstadoCivil) {
        this.CEstadoCivil = CEstadoCivil;
    }

    public TipoNivelesEstudioDTO getINivelEstudio() {
        return INivelEstudio;
    }

    public void setINivelEstudio(TipoNivelesEstudioDTO INivelEstudio) {
        this.INivelEstudio = INivelEstudio;
    }

    public String getCTelefonoFijo() {
        return CTelefonoFijo;
    }

    public void setCTelefonoFijo(String CTelefonoFijo) {
        this.CTelefonoFijo = CTelefonoFijo;
    }

    public String getCNumCelular() {
        return CNumCelular;
    }

    public void setCNumCelular(String CNumCelular) {
        this.CNumCelular = CNumCelular;
    }

    public String getCFacebook() {
        return CFacebook;
    }

    public void setCFacebook(String CFacebook) {
        this.CFacebook = CFacebook;
    }

    public String getCLinkedin() {
        return CLinkedin;
    }

    public void setCLinkedin(String CLinkedin) {
        this.CLinkedin = CLinkedin;
    }

    public String getCEmail() {
        return CEmail;
    }

    public void setCEmail(String CEmail) {
        this.CEmail = CEmail;
    }

    public Persona getIPersona() {
        return IPersona;
    }

    public void setIPersona(Persona IPersona) {
        this.IPersona = IPersona;
    }

    @Override
    public String toString() {
        return "ResponseDatosPersonales{" + "ICodigo=" + ICodigo + ", IDepartamentoResidencia=" + IDepartamentoResidencia + ", ICiudadResidencia=" + ICiudadResidencia + ", CDireccionResidencia=" + CDireccionResidencia + ", ITipoVivienda=" + ITipoVivienda + ", IEstrato=" + IEstrato + ", NPersonasCargo=" + NPersonasCargo + ", CCabezaHogar=" + CCabezaHogar + ", CEstadoCivil=" + CEstadoCivil + ", INivelEstudio=" + INivelEstudio + ", CTelefonoFijo=" + CTelefonoFijo + ", CNumCelular=" + CNumCelular + ", CFacebook=" + CFacebook + ", CLinkedin=" + CLinkedin + ", CEmail=" + CEmail + ", IPersona=" + IPersona + '}';
    }
}
