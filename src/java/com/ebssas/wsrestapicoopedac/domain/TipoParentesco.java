/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TIPO_PARENTESCO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoParentesco.findAll", query = "SELECT t FROM TipoParentesco t")
    , @NamedQuery(name = "TipoParentesco.findByICodigo", query = "SELECT t FROM TipoParentesco t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoParentesco.findByCDescripcion", query = "SELECT t FROM TipoParentesco t WHERE t.cDescripcion = :cDescripcion")})
public class TipoParentesco implements Serializable {

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
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iParentesco")
    private List<ReferenciaSolCredito> referenciaSolCreditoList;
    @OneToMany(mappedBy = "iParentesco")
    private List<InformacionPep> informacionPepList;

    public TipoParentesco() {
    }

    public TipoParentesco(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoParentesco(BigDecimal iCodigo, String cDescripcion) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    @XmlTransient
    public List<ReferenciaSolCredito> getReferenciaSolCreditoList() {
        return referenciaSolCreditoList;
    }

    public void setReferenciaSolCreditoList(List<ReferenciaSolCredito> referenciaSolCreditoList) {
        this.referenciaSolCreditoList = referenciaSolCreditoList;
    }

    @XmlTransient
    public List<InformacionPep> getInformacionPepList() {
        return informacionPepList;
    }

    public void setInformacionPepList(List<InformacionPep> informacionPepList) {
        this.informacionPepList = informacionPepList;
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
        if (!(object instanceof TipoParentesco)) {
            return false;
        }
        TipoParentesco other = (TipoParentesco) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.TipoParentesco[ iCodigo=" + iCodigo + " ]";
    }
    
}
