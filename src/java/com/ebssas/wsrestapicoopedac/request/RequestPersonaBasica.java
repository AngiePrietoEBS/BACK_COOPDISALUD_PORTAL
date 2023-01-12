/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andre
 */
public class RequestPersonaBasica {
    private String cTipoPersona;
    private String cIdentificacion;
    private String cTipoIdentificacion;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fNacimiento;
    private String cNnombre;
    private String cApellido;
    private String cDireccion;
    private String cCodigoCiudadNacimiento;
    private String cTelefono;
    private String cCorreoElectronico;
    private String cTipoCli;
    private String cCodExpCiudad;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fExpDocumento;
    private String cNatResAux;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fInicioRes;
    private String cSexo;
    private String cTesoro;
    private String cEstadoCivil;
    private String cNumPersonasCargo;
    private String cCodOfi;
    private String cNacionalidad;
    private String cNacionalidad2;
    private String cNumHijos;
    private String cNatApellido1;
    private String cNatApellido2;
    private String cEstrato;
    private String cMujerCabFamilia;
    private String cOperacionExt;
    private String cCodResCiudad;
    private String cEstadoAct;
    private String cVinculacionLab;
    private String cAsesorCom;
    private String cSalario;
    private String cNivelEstudio;
    private String cProfesion;
    private String cCargo;
    private String cTipoCont;
    private String cModeloScoring;
    private String cRut;

    /**
     * @return the cTipoPersona
     */
    public String getCTipoPersona() {
        return cTipoPersona;
    }

    /**
     * @param cTipoPersona the cTipoPersona to set
     */
    public void setCTipoPersona(String cTipoPersona) {
        this.cTipoPersona = cTipoPersona;
    }

    /**
     * @return the cIdentificacion
     */
    public String getCIdentificacion() {
        return cIdentificacion;
    }

    /**
     * @param cIdentificacion the cIdentificacion to set
     */
    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    /**
     * @return the cTipoIdentificacion
     */
    public String getCTipoIdentificacion() {
        return cTipoIdentificacion;
    }

    /**
     * @param cTipoIdentificacion the cTipoIdentificacion to set
     */
    public void setCTipoIdentificacion(String cTipoIdentificacion) {
        this.cTipoIdentificacion = cTipoIdentificacion;
    }

    /**
     * @return the fNacimiento
     */
    public Date getFNacimiento() {
        return fNacimiento;
    }

    /**
     * @param fNacimiento the fNacimiento to set
     */
    public void setFNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    /**
     * @return the cNnombre
     */
    public String getCNnombre() {
        return cNnombre;
    }

    /**
     * @param cNnombre the cNnombre to set
     */
    public void setCNnombre(String cNnombre) {
        this.cNnombre = cNnombre;
    }

    /**
     * @return the cApellido
     */
    public String getCApellido() {
        return cApellido;
    }

    /**
     * @param cApellido the cApellido to set
     */
    public void setCApellido(String cApellido) {
        this.cApellido = cApellido;
    }

    /**
     * @return the cDireccion
     */
    public String getCDireccion() {
        return cDireccion;
    }

    /**
     * @param cDireccion the cDireccion to set
     */
    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    /**
     * @return the cCodigoCiudadNacimiento
     */
    public String getCCodigoCiudadNacimiento() {
        return cCodigoCiudadNacimiento;
    }

    /**
     * @param cCodigoCiudadNacimiento the cCodigoCiudadNacimiento to set
     */
    public void setCCodigoCiudadNacimiento(String cCodigoCiudadNacimiento) {
        this.cCodigoCiudadNacimiento = cCodigoCiudadNacimiento;
    }

    /**
     * @return the cTelefono
     */
    public String getCTelefono() {
        return cTelefono;
    }

    /**
     * @param cTelefono the cTelefono to set
     */
    public void setCTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    /**
     * @return the cCorreoElectronico
     */
    public String getCCorreoElectronico() {
        return cCorreoElectronico;
    }

    /**
     * @param cCorreoElectronico the cCorreoElectronico to set
     */
    public void setCCorreoElectronico(String cCorreoElectronico) {
        this.cCorreoElectronico = cCorreoElectronico;
    }

    /**
     * @return the cTipoCli
     */
    public String getCTipoCli() {
        return cTipoCli;
    }

    /**
     * @param cTipoCli the cTipoCli to set
     */
    public void setCTipoCli(String cTipoCli) {
        this.cTipoCli = cTipoCli;
    }

    /**
     * @return the cCodExpCiudad
     */
    public String getCCodExpCiudad() {
        return cCodExpCiudad;
    }

    /**
     * @param cCodExpCiudad the cCodExpCiudad to set
     */
    public void setCCodExpCiudad(String cCodExpCiudad) {
        this.cCodExpCiudad = cCodExpCiudad;
    }

    /**
     * @return the fExpDocumento
     */
    public Date getFExpDocumento() {
        return fExpDocumento;
    }

    /**
     * @param fExpDocumento the fExpDocumento to set
     */
    public void setFExpDocumento(Date fExpDocumento) {
        this.fExpDocumento = fExpDocumento;
    }

    /**
     * @return the cNatResAux
     */
    public String getCNatResAux() {
        return cNatResAux;
    }

    /**
     * @param cNatResAux the cNatResAux to set
     */
    public void setCNatResAux(String cNatResAux) {
        this.cNatResAux = cNatResAux;
    }

    /**
     * @return the fInicioRes
     */
    public Date getFInicioRes() {
        return fInicioRes;
    }

    /**
     * @param fInicioRes the fInicioRes to set
     */
    public void setFInicioRes(Date fInicioRes) {
        this.fInicioRes = fInicioRes;
    }

    /**
     * @return the cSexo
     */
    public String getCSexo() {
        return cSexo;
    }

    /**
     * @param cSexo the cSexo to set
     */
    public void setCSexo(String cSexo) {
        this.cSexo = cSexo;
    }

    /**
     * @return the cTesoro
     */
    public String getCTesoro() {
        return cTesoro;
    }

    /**
     * @param cTesoro the cTesoro to set
     */
    public void setCTesoro(String cTesoro) {
        this.cTesoro = cTesoro;
    }

    /**
     * @return the cEstadoCivil
     */
    public String getCEstadoCivil() {
        return cEstadoCivil;
    }

    /**
     * @param cEstadoCivil the cEstadoCivil to set
     */
    public void setCEstadoCivil(String cEstadoCivil) {
        this.cEstadoCivil = cEstadoCivil;
    }

    /**
     * @return the cNumPersonasCargo
     */
    public String getCNumPersonasCargo() {
        return cNumPersonasCargo;
    }

    /**
     * @param cNumPersonasCargo the cNumPersonasCargo to set
     */
    public void setCNumPersonasCargo(String cNumPersonasCargo) {
        this.cNumPersonasCargo = cNumPersonasCargo;
    }

    /**
     * @return the cCodOfi
     */
    public String getCCodOfi() {
        return cCodOfi;
    }

    /**
     * @param cCodOfi the cCodOfi to set
     */
    public void setCCodOfi(String cCodOfi) {
        this.cCodOfi = cCodOfi;
    }

    /**
     * @return the cNacionalidad
     */
    public String getCNacionalidad() {
        return cNacionalidad;
    }

    /**
     * @param cNacionalidad the cNacionalidad to set
     */
    public void setCNacionalidad(String cNacionalidad) {
        this.cNacionalidad = cNacionalidad;
    }

    /**
     * @return the cNacionalidad2
     */
    public String getCNacionalidad2() {
        return cNacionalidad2;
    }

    /**
     * @param cNacionalidad2 the cNacionalidad2 to set
     */
    public void setCNacionalidad2(String cNacionalidad2) {
        this.cNacionalidad2 = cNacionalidad2;
    }

    /**
     * @return the cNumHijos
     */
    public String getCNumHijos() {
        return cNumHijos;
    }

    /**
     * @param cNumHijos the cNumHijos to set
     */
    public void setCNumHijos(String cNumHijos) {
        this.cNumHijos = cNumHijos;
    }

    /**
     * @return the cNatApellido1
     */
    public String getCNatApellido1() {
        return cNatApellido1;
    }

    /**
     * @param cNatApellido1 the cNatApellido1 to set
     */
    public void setCNatApellido1(String cNatApellido1) {
        this.cNatApellido1 = cNatApellido1;
    }

    /**
     * @return the cNatApellido2
     */
    public String getCNatApellido2() {
        return cNatApellido2;
    }

    /**
     * @param cNatApellido2 the cNatApellido2 to set
     */
    public void setCNatApellido2(String cNatApellido2) {
        this.cNatApellido2 = cNatApellido2;
    }

    /**
     * @return the cEstrato
     */
    public String getCEstrato() {
        return cEstrato;
    }

    /**
     * @param cEstrato the cEstrato to set
     */
    public void setCEstrato(String cEstrato) {
        this.cEstrato = cEstrato;
    }

    /**
     * @return the cMujerCabFamilia
     */
    public String getCMujerCabFamilia() {
        return cMujerCabFamilia;
    }

    /**
     * @param cMujerCabFamilia the cMujerCabFamilia to set
     */
    public void setCMujerCabFamilia(String cMujerCabFamilia) {
        this.cMujerCabFamilia = cMujerCabFamilia;
    }

    /**
     * @return the cOperacionExt
     */
    public String getCOperacionExt() {
        return cOperacionExt;
    }

    /**
     * @param cOperacionExt the cOperacionExt to set
     */
    public void setCOperacionExt(String cOperacionExt) {
        this.cOperacionExt = cOperacionExt;
    }

    /**
     * @return the cCodResCiudad
     */
    public String getCCodResCiudad() {
        return cCodResCiudad;
    }

    /**
     * @param cCodResCiudad the cCodResCiudad to set
     */
    public void setCCodResCiudad(String cCodResCiudad) {
        this.cCodResCiudad = cCodResCiudad;
    }

    /**
     * @return the cEstadoAct
     */
    public String getCEstadoAct() {
        return cEstadoAct;
    }

    /**
     * @param cEstadoAct the cEstadoAct to set
     */
    public void setCEstadoAct(String cEstadoAct) {
        this.cEstadoAct = cEstadoAct;
    }

    /**
     * @return the cVinculacionLab
     */
    public String getCVinculacionLab() {
        return cVinculacionLab;
    }

    /**
     * @param cVinculacionLab the cVinculacionLab to set
     */
    public void setCVinculacionLab(String cVinculacionLab) {
        this.cVinculacionLab = cVinculacionLab;
    }

    /**
     * @return the cAsesorCom
     */
    public String getCAsesorCom() {
        return cAsesorCom;
    }

    /**
     * @param cAsesorCom the cAsesorCom to set
     */
    public void setCAsesorCom(String cAsesorCom) {
        this.cAsesorCom = cAsesorCom;
    }

    /**
     * @return the cSalario
     */
    public String getCSalario() {
        return cSalario;
    }

    /**
     * @param cSalario the cSalario to set
     */
    public void setCSalario(String cSalario) {
        this.cSalario = cSalario;
    }

    /**
     * @return the cNivelEstudio
     */
    public String getCNivelEstudio() {
        return cNivelEstudio;
    }

    /**
     * @param cNivelEstudio the cNivelEstudio to set
     */
    public void setCNivelEstudio(String cNivelEstudio) {
        this.cNivelEstudio = cNivelEstudio;
    }

    /**
     * @return the cProfesion
     */
    public String getCProfesion() {
        return cProfesion;
    }

    /**
     * @param cProfesion the cProfesion to set
     */
    public void setCProfesion(String cProfesion) {
        this.cProfesion = cProfesion;
    }

    /**
     * @return the cCargo
     */
    public String getCCargo() {
        return cCargo;
    }

    /**
     * @param cCargo the cCargo to set
     */
    public void setCCargo(String cCargo) {
        this.cCargo = cCargo;
    }

    /**
     * @return the cTipoCont
     */
    public String getCTipoCont() {
        return cTipoCont;
    }

    /**
     * @param cTipoCont the cTipoCont to set
     */
    public void setCTipoCont(String cTipoCont) {
        this.cTipoCont = cTipoCont;
    }

    /**
     * @return the cModeloScoring
     */
    public String getCModeloScoring() {
        return cModeloScoring;
    }

    /**
     * @param cModeloScoring the cModeloScoring to set
     */
    public void setCModeloScoring(String cModeloScoring) {
        this.cModeloScoring = cModeloScoring;
    }

    /**
     * @return the cRut
     */
    public String getCRut() {
        return cRut;
    }

    /**
     * @param cRut the cRut to set
     */
    public void setCRut(String cRut) {
        this.cRut = cRut;
    }

    public RequestPersonaBasica(){
    
    }
}
