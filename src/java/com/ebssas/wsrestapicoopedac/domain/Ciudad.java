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
import java.util.List;
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
@Table(name = "CIUDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByICodigo", query = "SELECT c FROM Ciudad c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "Ciudad.findByCCiudad", query = "SELECT c FROM Ciudad c WHERE c.cCiudad = :cCiudad"),
    @NamedQuery(name = "Ciudad.findByICiudadDeceval", query = "SELECT c FROM Ciudad c WHERE c.iCiudadDeceval = :iCiudadDeceval")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id    
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Column(name = "C_CIUDAD")
    private String cCiudad;
    
    @Column(name = "I_CIUDAD_DECEVAL")
    private BigInteger iCiudadDeceval;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCiudadDesembolso")
    private List<CreacionPagareDeceval> creacionPagareDecevalCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCiudadExpedicion")
    private List<CreacionGiradorDeceval> creacionGiradorDecevalCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCiudadDomicilio")
    private List<CreacionGiradorDeceval> creacionGiradorDecevalCollection1;
    
    @JoinColumn(name = "I_DEPARTAMENTO", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private Departamento iDepartamento;

    public Ciudad() {
    }

    public Ciudad(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCCiudad() {
        return cCiudad;
    }

    public void setCCiudad(String cCiudad) {
        this.cCiudad = cCiudad;
    }

    public BigInteger getICiudadDeceval() {
        return iCiudadDeceval;
    }

    public void setICiudadDeceval(BigInteger iCiudadDeceval) {
        this.iCiudadDeceval = iCiudadDeceval;
    }

    @XmlTransient
    public List<CreacionPagareDeceval> getCreacionPagareDecevalCollection() {
        return creacionPagareDecevalCollection;
    }

    public void setCreacionPagareDecevalCollection(List<CreacionPagareDeceval> creacionPagareDecevalCollection) {
        this.creacionPagareDecevalCollection = creacionPagareDecevalCollection;
    }

    @XmlTransient
    public List<CreacionGiradorDeceval> getCreacionGiradorDecevalCollection() {
        return creacionGiradorDecevalCollection;
    }

    public void setCreacionGiradorDecevalCollection(List<CreacionGiradorDeceval> creacionGiradorDecevalCollection) {
        this.creacionGiradorDecevalCollection = creacionGiradorDecevalCollection;
    }

    @XmlTransient
    public List<CreacionGiradorDeceval> getCreacionGiradorDecevalCollection1() {
        return creacionGiradorDecevalCollection1;
    }

    public void setCreacionGiradorDecevalCollection1(List<CreacionGiradorDeceval> creacionGiradorDecevalCollection1) {
        this.creacionGiradorDecevalCollection1 = creacionGiradorDecevalCollection1;
    }

    public Departamento getIDepartamento() {
        return iDepartamento;
    }

    public void setIDepartamento(Departamento iDepartamento) {
        this.iDepartamento = iDepartamento;
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
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.Ciudad[ iCodigo=" + iCodigo + " ]";
    }
    
}
