/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByICodigo", query = "SELECT d FROM Departamento d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "Departamento.findByCDepartamento", query = "SELECT d FROM Departamento d WHERE d.cDepartamento = :cDepartamento"),
    @NamedQuery(name = "Departamento.findByICodDepDeceval", query = "SELECT d FROM Departamento d WHERE d.iCodDepDeceval = :iCodDepDeceval")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_DEPARTAMENTO")
    private String cDepartamento;
    @Column(name = "I_COD_DEP_DECEVAL")
    private BigInteger iCodDepDeceval;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDepartamento")
    private Collection<CreacionPagareDeceval> creacionPagareDecevalCollection;
    @JoinColumn(name = "I_PAIS", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private Pais iPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDepartamentoExpedicion")
    private Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDepartamentoDomicilio")
    private Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection1;
    @OneToMany(mappedBy = "iDepartamento")
    private Collection<Ciudad> ciudadCollection;

    public Departamento() {
    }

    public Departamento(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCDepartamento() {
        return cDepartamento;
    }

    public void setCDepartamento(String cDepartamento) {
        this.cDepartamento = cDepartamento;
    }

    public BigInteger getICodDepDeceval() {
        return iCodDepDeceval;
    }

    public void setICodDepDeceval(BigInteger iCodDepDeceval) {
        this.iCodDepDeceval = iCodDepDeceval;
    }

    @XmlTransient
    public Collection<CreacionPagareDeceval> getCreacionPagareDecevalCollection() {
        return creacionPagareDecevalCollection;
    }

    public void setCreacionPagareDecevalCollection(Collection<CreacionPagareDeceval> creacionPagareDecevalCollection) {
        this.creacionPagareDecevalCollection = creacionPagareDecevalCollection;
    }

    public Pais getIPais() {
        return iPais;
    }

    public void setIPais(Pais iPais) {
        this.iPais = iPais;
    }

    @XmlTransient
    public Collection<CreacionGiradorDeceval> getCreacionGiradorDecevalCollection() {
        return creacionGiradorDecevalCollection;
    }

    public void setCreacionGiradorDecevalCollection(Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection) {
        this.creacionGiradorDecevalCollection = creacionGiradorDecevalCollection;
    }

    @XmlTransient
    public Collection<CreacionGiradorDeceval> getCreacionGiradorDecevalCollection1() {
        return creacionGiradorDecevalCollection1;
    }

    public void setCreacionGiradorDecevalCollection1(Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection1) {
        this.creacionGiradorDecevalCollection1 = creacionGiradorDecevalCollection1;
    }

    @XmlTransient
    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
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
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.Departamento[ iCodigo=" + iCodigo + " ]";
    }
    
}
