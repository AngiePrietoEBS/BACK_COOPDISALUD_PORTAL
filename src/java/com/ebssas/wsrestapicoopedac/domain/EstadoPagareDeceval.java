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
@Table(name = "ESTADO_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPagareDeceval.findAll", query = "SELECT e FROM EstadoPagareDeceval e"),
    @NamedQuery(name = "EstadoPagareDeceval.findByICodigo", query = "SELECT e FROM EstadoPagareDeceval e WHERE e.iCodigo = :iCodigo"),
    @NamedQuery(name = "EstadoPagareDeceval.findByCEstadoPagare", query = "SELECT e FROM EstadoPagareDeceval e WHERE e.cEstadoPagare = :cEstadoPagare")})
public class EstadoPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_ESTADO_PAGARE")
    private String cEstadoPagare;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iEstadoPagareDeceval")
    private Collection<EstadoProcesoPagare> estadoProcesoPagareCollection;

    public EstadoPagareDeceval() {
    }

    public EstadoPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCEstadoPagare() {
        return cEstadoPagare;
    }

    public void setCEstadoPagare(String cEstadoPagare) {
        this.cEstadoPagare = cEstadoPagare;
    }

    @XmlTransient
    public Collection<EstadoProcesoPagare> getEstadoProcesoPagareCollection() {
        return estadoProcesoPagareCollection;
    }

    public void setEstadoProcesoPagareCollection(Collection<EstadoProcesoPagare> estadoProcesoPagareCollection) {
        this.estadoProcesoPagareCollection = estadoProcesoPagareCollection;
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
        if (!(object instanceof EstadoPagareDeceval)) {
            return false;
        }
        EstadoPagareDeceval other = (EstadoPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.EstadoPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
