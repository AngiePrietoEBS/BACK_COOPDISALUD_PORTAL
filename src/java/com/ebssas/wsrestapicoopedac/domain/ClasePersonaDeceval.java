/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CLASE_PERSONA_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasePersonaDeceval.findAll", query = "SELECT c FROM ClasePersonaDeceval c"),
    @NamedQuery(name = "ClasePersonaDeceval.findByICodigo", query = "SELECT c FROM ClasePersonaDeceval c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "ClasePersonaDeceval.findByCClasePersona", query = "SELECT c FROM ClasePersonaDeceval c WHERE c.cClasePersona = :cClasePersona"),
    @NamedQuery(name = "ClasePersonaDeceval.findByCEstado", query = "SELECT c FROM ClasePersonaDeceval c WHERE c.cEstado = :cEstado")})
public class ClasePersonaDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_CLASE_PERSONA")
    private String cClasePersona;
    @Column(name = "C_ESTADO")
    private String cEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iClasePersona")
    private Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection;

    public ClasePersonaDeceval() {
    }

    public ClasePersonaDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCClasePersona() {
        return cClasePersona;
    }

    public void setCClasePersona(String cClasePersona) {
        this.cClasePersona = cClasePersona;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public Collection<CreacionGiradorDeceval> getCreacionGiradorDecevalCollection() {
        return creacionGiradorDecevalCollection;
    }

    public void setCreacionGiradorDecevalCollection(Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection) {
        this.creacionGiradorDecevalCollection = creacionGiradorDecevalCollection;
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
        if (!(object instanceof ClasePersonaDeceval)) {
            return false;
        }
        ClasePersonaDeceval other = (ClasePersonaDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.ClasePersonaDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
