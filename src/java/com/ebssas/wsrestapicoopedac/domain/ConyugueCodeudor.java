/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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


/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "CONYUGUE_CODEUDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConyugueCodeudor.findAll", query = "SELECT c FROM ConyugueCodeudor c"),
    @NamedQuery(name = "ConyugueCodeudor.findByICodigo", query = "SELECT c FROM ConyugueCodeudor c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "ConyugueCodeudor.findByCNombres", query = "SELECT c FROM ConyugueCodeudor c WHERE c.cNombres = :cNombres"),
    @NamedQuery(name = "ConyugueCodeudor.findByCIdentificacion", query = "SELECT c FROM ConyugueCodeudor c WHERE c.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "ConyugueCodeudor.findByCProfesion", query = "SELECT c FROM ConyugueCodeudor c WHERE c.cProfesion = :cProfesion"),
    @NamedQuery(name = "ConyugueCodeudor.findByCEmpresa", query = "SELECT c FROM ConyugueCodeudor c WHERE c.cEmpresa = :cEmpresa"),
    @NamedQuery(name = "ConyugueCodeudor.findByICargo", query = "SELECT c FROM ConyugueCodeudor c WHERE c.iCargo = :iCargo"),
    @NamedQuery(name = "ConyugueCodeudor.findByCTelefono", query = "SELECT c FROM ConyugueCodeudor c WHERE c.cTelefono = :cTelefono")})
public class ConyugueCodeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_CONYUGUE_CODEUDOR", sequenceName = "SEC_CONYUGUE_CODEUDOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CONYUGUE_CODEUDOR")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRES")
    private String cNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_PROFESION")
    private String cProfesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_EMPRESA")
    private String cEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CARGO")
    private Long iCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "C_TELEFONO")
    private String cTelefono;
    @JoinColumn(name = "I_CODEUDOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CodeudorSolCred iCodeudor;

    public ConyugueCodeudor() {
    }

    public ConyugueCodeudor(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ConyugueCodeudor(Long iCodigo, String cNombres, String cIdentificacion, String cProfesion, String cEmpresa, Long iCargo, String cTelefono) {
        this.iCodigo = iCodigo;
        this.cNombres = cNombres;
        this.cIdentificacion = cIdentificacion;
        this.cProfesion = cProfesion;
        this.cEmpresa = cEmpresa;
        this.iCargo = iCargo;
        this.cTelefono = cTelefono;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getCProfesion() {
        return cProfesion;
    }

    public void setCProfesion(String cProfesion) {
        this.cProfesion = cProfesion;
    }

    public String getCEmpresa() {
        return cEmpresa;
    }

    public void setCEmpresa(String cEmpresa) {
        this.cEmpresa = cEmpresa;
    }

    public Long getICargo() {
        return iCargo;
    }

    public void setICargo(Long iCargo) {
        this.iCargo = iCargo;
    }

    public String getCTelefono() {
        return cTelefono;
    }

    public void setCTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public CodeudorSolCred getICodeudor() {
        return iCodeudor;
    }

    public void setICodeudor(CodeudorSolCred iCodeudor) {
        this.iCodeudor = iCodeudor;
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
        if (!(object instanceof ConyugueCodeudor)) {
            return false;
        }
        ConyugueCodeudor other = (ConyugueCodeudor) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.ConyugueCodeudor[ iCodigo=" + iCodigo + " ]";
    }
    
}
