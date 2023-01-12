/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import WSAdminCoopedac.ActividadEconomicaDTO;
import WSAdminCoopedac.CargoDTO;
import WSAdminCoopedac.CiudadDTO;
import WSAdminCoopedac.ProfesionDTO;
import WSAdminCoopedac.TipoContratoDTO;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class ResponseOcupacionPersona {

    private Long ICodigo;
    private ProfesionDTO ITipoOcupacion;
    private CargoDTO ICargo;
    private ActividadEconomicaDTO ISectorEconomico;
    private String CEmpresa;
    private Date FFechaIngreso;
    private Long IAntiguedad;
    private TipoContratoDTO ITipoContrato;
    private String CTelefonoEmpresa;
    private CiudadDTO IDepartamentoEmpresa; 
    private CiudadDTO ICiudadEmpresa;
    private String CDireccionEmpresa;
    private Persona IPersona;

    public Long getICodigo() {
        return ICodigo;
    }

    public void setICodigo(Long ICodigo) {
        this.ICodigo = ICodigo;
    }

    public ProfesionDTO getITipoOcupacion() {
        return ITipoOcupacion;
    }

    public void setITipoOcupacion(ProfesionDTO ITipoOcupacion) {
        this.ITipoOcupacion = ITipoOcupacion;
    }

    public CargoDTO getICargo() {
        return ICargo;
    }

    public void setICargo(CargoDTO ICargo) {
        this.ICargo = ICargo;
    }

    public ActividadEconomicaDTO getISectorEconomico() {
        return ISectorEconomico;
    }

    public void setISectorEconomico(ActividadEconomicaDTO ISectorEconomico) {
        this.ISectorEconomico = ISectorEconomico;
    }

    public String getCEmpresa() {
        return CEmpresa;
    }

    public void setCEmpresa(String CEmpresa) {
        this.CEmpresa = CEmpresa;
    }

    public Date getFFechaIngreso() {
        return FFechaIngreso;
    }

    public void setFFechaIngreso(Date FFechaIngreso) {
        this.FFechaIngreso = FFechaIngreso;
    }

    public Long getIAntiguedad() {
        return IAntiguedad;
    }

    public void setIAntiguedad(Long IAntiguedad) {
        this.IAntiguedad = IAntiguedad;
    }

    public TipoContratoDTO getITipoContrato() {
        return ITipoContrato;
    }

    public void setITipoContrato(TipoContratoDTO ITipoContrato) {
        this.ITipoContrato = ITipoContrato;
    }

    public String getCTelefonoEmpresa() {
        return CTelefonoEmpresa;
    }

    public void setCTelefonoEmpresa(String CTelefonoEmpresa) {
        this.CTelefonoEmpresa = CTelefonoEmpresa;
    }

    public CiudadDTO getIDepartamentoEmpresa() {
        return IDepartamentoEmpresa;
    }

    public void setIDepartamentoEmpresa(CiudadDTO IDepartamentoEmpresa) {
        this.IDepartamentoEmpresa = IDepartamentoEmpresa;
    }

    public CiudadDTO getICiudadEmpresa() {
        return ICiudadEmpresa;
    }

    public void setICiudadEmpresa(CiudadDTO ICiudadEmpresa) {
        this.ICiudadEmpresa = ICiudadEmpresa;
    }

    public String getCDireccionEmpresa() {
        return CDireccionEmpresa;
    }

    public void setCDireccionEmpresa(String CDireccionEmpresa) {
        this.CDireccionEmpresa = CDireccionEmpresa;
    }

    public Persona getIPersona() {
        return IPersona;
    }

    public void setIPersona(Persona IPersona) {
        this.IPersona = IPersona;
    }

    @Override
    public String toString() {
        return "ResponseOcupacionPersona{" + "ICodigo=" + ICodigo + ", ITipoOcupacion=" + ITipoOcupacion + ", ICargo=" + ICargo + ", ISectorEconomico=" + ISectorEconomico + ", CEmpresa=" + CEmpresa + ", FFechaIngreso=" + FFechaIngreso + ", IAntiguedad=" + IAntiguedad + ", ITipoContrato=" + ITipoContrato + ", CTelefonoEmpresa=" + CTelefonoEmpresa + ", IDepartamentoEmpresa=" + IDepartamentoEmpresa + ", ICiudadEmpresa=" + ICiudadEmpresa + ", CDireccionEmpresa=" + CDireccionEmpresa + ", IPersona=" + IPersona + '}';
    }

    
}
