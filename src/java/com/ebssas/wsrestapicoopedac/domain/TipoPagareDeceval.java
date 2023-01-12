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
@Table(name = "TIPO_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPagareDeceval.findAll", query = "SELECT t FROM TipoPagareDeceval t"),
    @NamedQuery(name = "TipoPagareDeceval.findByICodigo", query = "SELECT t FROM TipoPagareDeceval t WHERE t.iCodigo = :iCodigo"),
    @NamedQuery(name = "TipoPagareDeceval.findByCTipoPagare", query = "SELECT t FROM TipoPagareDeceval t WHERE t.cTipoPagare = :cTipoPagare")})
public class TipoPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_TIPO_PAGARE")
    private String cTipoPagare;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTipoPagare")
    private Collection<CreacionPagareDeceval> creacionPagareDecevalCollection;

    public TipoPagareDeceval() {
    }

    public TipoPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCTipoPagare() {
        return cTipoPagare;
    }

    public void setCTipoPagare(String cTipoPagare) {
        this.cTipoPagare = cTipoPagare;
    }

    @XmlTransient
    public Collection<CreacionPagareDeceval> getCreacionPagareDecevalCollection() {
        return creacionPagareDecevalCollection;
    }

    public void setCreacionPagareDecevalCollection(Collection<CreacionPagareDeceval> creacionPagareDecevalCollection) {
        this.creacionPagareDecevalCollection = creacionPagareDecevalCollection;
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
        if (!(object instanceof TipoPagareDeceval)) {
            return false;
        }
        TipoPagareDeceval other = (TipoPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.TipoPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
