/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "INFORMACION_CONYUGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionConyuge.findAll", query = "SELECT i FROM InformacionConyuge i")
    , @NamedQuery(name = "InformacionConyuge.findByICodigo", query = "SELECT i FROM InformacionConyuge i WHERE i.iCodigo = :iCodigo")
    , @NamedQuery(name = "InformacionConyuge.findByCNombres", query = "SELECT i FROM InformacionConyuge i WHERE i.cNombres = :cNombres")
    , @NamedQuery(name = "InformacionConyuge.findByITipoIdent", query = "SELECT i FROM InformacionConyuge i WHERE i.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "InformacionConyuge.findByCIdentificacion", query = "SELECT i FROM InformacionConyuge i WHERE i.cIdentificacion = :cIdentificacion")
    , @NamedQuery(name = "InformacionConyuge.findByFFechaNacimiento", query = "SELECT i FROM InformacionConyuge i WHERE i.fFechaNacimiento = :fFechaNacimiento")
    , @NamedQuery(name = "InformacionConyuge.findByINivelEstudio", query = "SELECT i FROM InformacionConyuge i WHERE i.iNivelEstudio = :iNivelEstudio")
    , @NamedQuery(name = "InformacionConyuge.findByIProfesion", query = "SELECT i FROM InformacionConyuge i WHERE i.iProfesion = :iProfesion")
    , @NamedQuery(name = "InformacionConyuge.findByICargo", query = "SELECT i FROM InformacionConyuge i WHERE i.iCargo = :iCargo")
    , @NamedQuery(name = "InformacionConyuge.findByNSalario", query = "SELECT i FROM InformacionConyuge i WHERE i.nSalario = :nSalario")
    , @NamedQuery(name = "InformacionConyuge.findByCEmail", query = "SELECT i FROM InformacionConyuge i WHERE i.cEmail = :cEmail")
    , @NamedQuery(name = "InformacionConyuge.findByCNumCelular", query = "SELECT i FROM InformacionConyuge i WHERE i.cNumCelular = :cNumCelular")})
public class InformacionConyuge implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_NOMBRES")
    private String cNombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaNacimiento;
    @Column(name = "I_NIVEL_ESTUDIO")
    private BigInteger iNivelEstudio;
    @Column(name = "I_PROFESION")
    private BigInteger iProfesion;
    @Column(name = "I_CARGO")
    private BigInteger iCargo;
    @Column(name = "N_SALARIO")
    private BigInteger nSalario;
    @Size(max = 255)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @Size(max = 255)
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;

    public InformacionConyuge() {
    }

    public InformacionConyuge(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InformacionConyuge(BigDecimal iCodigo, String cNombres, BigInteger iTipoIdent, String cIdentificacion, Date fFechaNacimiento) {
        this.iCodigo = iCodigo;
        this.cNombres = cNombres;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.fFechaNacimiento = fFechaNacimiento;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public BigInteger getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(BigInteger iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public Date getFFechaNacimiento() {
        return fFechaNacimiento;
    }

    public void setFFechaNacimiento(Date fFechaNacimiento) {
        this.fFechaNacimiento = fFechaNacimiento;
    }

    public BigInteger getINivelEstudio() {
        return iNivelEstudio;
    }

    public void setINivelEstudio(BigInteger iNivelEstudio) {
        this.iNivelEstudio = iNivelEstudio;
    }

    public BigInteger getIProfesion() {
        return iProfesion;
    }

    public void setIProfesion(BigInteger iProfesion) {
        this.iProfesion = iProfesion;
    }

    public BigInteger getICargo() {
        return iCargo;
    }

    public void setICargo(BigInteger iCargo) {
        this.iCargo = iCargo;
    }

    public BigInteger getNSalario() {
        return nSalario;
    }

    public void setNSalario(BigInteger nSalario) {
        this.nSalario = nSalario;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCNumCelular() {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular) {
        this.cNumCelular = cNumCelular;
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
        if (!(object instanceof InformacionConyuge)) {
            return false;
        }
        InformacionConyuge other = (InformacionConyuge) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.InformacionConyuge[ iCodigo=" + iCodigo + " ]";
    }
    
}
