/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author user
 */
@Entity
@Table(name = "DATOS_PERSONALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosPersonales.findAll", query = "SELECT d FROM DatosPersonales d")
    , @NamedQuery(name = "DatosPersonales.findByICodigo", query = "SELECT d FROM DatosPersonales d WHERE d.iCodigo = :iCodigo")
    , @NamedQuery(name = "DatosPersonales.findByIDepartamentoResidencia", query = "SELECT d FROM DatosPersonales d WHERE d.iDepartamentoResidencia = :iDepartamentoResidencia")
    , @NamedQuery(name = "DatosPersonales.findByICiudadResidencia", query = "SELECT d FROM DatosPersonales d WHERE d.iCiudadResidencia = :iCiudadResidencia")
    , @NamedQuery(name = "DatosPersonales.findByCDireccionResidencia", query = "SELECT d FROM DatosPersonales d WHERE d.cDireccionResidencia = :cDireccionResidencia")
    , @NamedQuery(name = "DatosPersonales.findByITipoVivienda", query = "SELECT d FROM DatosPersonales d WHERE d.iTipoVivienda = :iTipoVivienda")
    , @NamedQuery(name = "DatosPersonales.findByIEstrato", query = "SELECT d FROM DatosPersonales d WHERE d.iEstrato = :iEstrato")
    , @NamedQuery(name = "DatosPersonales.findByNPersonasCargo", query = "SELECT d FROM DatosPersonales d WHERE d.nPersonasCargo = :nPersonasCargo")
    , @NamedQuery(name = "DatosPersonales.findByCCabezaHogar", query = "SELECT d FROM DatosPersonales d WHERE d.cCabezaHogar = :cCabezaHogar")
    , @NamedQuery(name = "DatosPersonales.findByCEstadoCivil", query = "SELECT d FROM DatosPersonales d WHERE d.cEstadoCivil = :cEstadoCivil")
    , @NamedQuery(name = "DatosPersonales.findByINivelEstudio", query = "SELECT d FROM DatosPersonales d WHERE d.iNivelEstudio = :iNivelEstudio")
    , @NamedQuery(name = "DatosPersonales.findByCTelefonoFijo", query = "SELECT d FROM DatosPersonales d WHERE d.cTelefonoFijo = :cTelefonoFijo")
    , @NamedQuery(name = "DatosPersonales.findByCNumCelular", query = "SELECT d FROM DatosPersonales d WHERE d.cNumCelular = :cNumCelular")
    , @NamedQuery(name = "DatosPersonales.findByCFacebook", query = "SELECT d FROM DatosPersonales d WHERE d.cFacebook = :cFacebook")
    , @NamedQuery(name = "DatosPersonales.findByCLinkedin", query = "SELECT d FROM DatosPersonales d WHERE d.cLinkedin = :cLinkedin")
    , @NamedQuery(name = "DatosPersonales.findByCEmail", query = "SELECT d FROM DatosPersonales d WHERE d.cEmail = :cEmail")})
public class DatosPersonales implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_DATOS_PERSONALES", sequenceName = "SEC_DATOS_PERSONALES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DATOS_PERSONALES")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Column(name = "I_DEPARTAMENTO_RESIDENCIA")
    private Long iDepartamentoResidencia;
    @Column(name = "I_CIUDAD_RESIDENCIA")
    private Long iCiudadResidencia;
    @Size(max = 255)
    @Column(name = "C_DIRECCION_RESIDENCIA")
    private String cDireccionResidencia;
    @Column(name = "I_TIPO_VIVIENDA")
    private Long iTipoVivienda;
    @Column(name = "I_ESTRATO")
    private Long iEstrato;
    @Column(name = "N_PERSONAS_CARGO")
    private Long nPersonasCargo;
    @Size(max = 2)
    @Column(name = "C_CABEZA_HOGAR")
    private String cCabezaHogar;
    @Size(max = 2)
    @Column(name = "C_ESTADO_CIVIL")
    private String cEstadoCivil;
    @Column(name = "I_NIVEL_ESTUDIO")
    private Long iNivelEstudio;
    @Size(max = 255)
    @Column(name = "C_TELEFONO_FIJO")
    private String cTelefonoFijo;
    @Size(max = 255)
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;
    @Size(max = 255)
    @Column(name = "C_FACEBOOK")
    private String cFacebook;
    @Size(max = 255)
    @Column(name = "C_LINKEDIN")
    private String cLinkedin;
    @Size(max = 255)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;
    
//    @Column(name = "F_FECHA_NACIMIENTO")
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    @Temporal(TemporalType.DATE)
//    private Date fNacimiento;
    
    public DatosPersonales() {
    }

    public DatosPersonales(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getIDepartamentoResidencia() {
        return iDepartamentoResidencia;
    }

    public void setIDepartamentoResidencia(Long iDepartamentoResidencia) {
        this.iDepartamentoResidencia = iDepartamentoResidencia;
    }

    public Long getICiudadResidencia() {
        return iCiudadResidencia;
    }

    public void setICiudadResidencia(Long iCiudadResidencia) {
        this.iCiudadResidencia = iCiudadResidencia;
    }

    public String getCDireccionResidencia() {
        return cDireccionResidencia;
    }

    public void setCDireccionResidencia(String cDireccionResidencia) {
        this.cDireccionResidencia = cDireccionResidencia;
    }

    public Long getITipoVivienda() {
        return iTipoVivienda;
    }

    public void setITipoVivienda(Long iTipoVivienda) {
        this.iTipoVivienda = iTipoVivienda;
    }

    public Long getIEstrato() {
        return iEstrato;
    }

    public void setIEstrato(Long iEstrato) {
        this.iEstrato = iEstrato;
    }

    public Long getNPersonasCargo() {
        return nPersonasCargo;
    }

    public void setNPersonasCargo(Long nPersonasCargo) {
        this.nPersonasCargo = nPersonasCargo;
    }

    public String getCCabezaHogar() {
        return cCabezaHogar;
    }

    public void setCCabezaHogar(String cCabezaHogar) {
        this.cCabezaHogar = cCabezaHogar;
    }

    public String getCEstadoCivil() {
        return cEstadoCivil;
    }

    public void setCEstadoCivil(String cEstadoCivil) {
        this.cEstadoCivil = cEstadoCivil;
    }

    public Long getINivelEstudio() {
        return iNivelEstudio;
    }

    public void setINivelEstudio(Long iNivelEstudio) {
        this.iNivelEstudio = iNivelEstudio;
    }

    public String getCTelefonoFijo() {
        return cTelefonoFijo;
    }

    public void setCTelefonoFijo(String cTelefonoFijo) {
        this.cTelefonoFijo = cTelefonoFijo;
    }

    public String getCNumCelular() {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular) {
        this.cNumCelular = cNumCelular;
    }

    public String getCFacebook() {
        return cFacebook;
    }

    public void setCFacebook(String cFacebook) {
        this.cFacebook = cFacebook;
    }

    public String getCLinkedin() {
        return cLinkedin;
    }

    public void setCLinkedin(String cLinkedin) {
        this.cLinkedin = cLinkedin;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iCodigo != null ? iCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosPersonales)) {
            return false;
        }
        DatosPersonales other = (DatosPersonales) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatosPersonales{" + "iCodigo=" + iCodigo + ", iDepartamentoResidencia=" + iDepartamentoResidencia + ", iCiudadResidencia=" + iCiudadResidencia + ", cDireccionResidencia=" + cDireccionResidencia + ", iTipoVivienda=" + iTipoVivienda + ", iEstrato=" + iEstrato + ", nPersonasCargo=" + nPersonasCargo + ", cCabezaHogar=" + cCabezaHogar + ", cEstadoCivil=" + cEstadoCivil + ", iNivelEstudio=" + iNivelEstudio + ", cTelefonoFijo=" + cTelefonoFijo + ", cNumCelular=" + cNumCelular + ", cFacebook=" + cFacebook + ", cLinkedin=" + cLinkedin + ", cEmail=" + cEmail + ", iPersona=" + iPersona + '}';
    }
}
