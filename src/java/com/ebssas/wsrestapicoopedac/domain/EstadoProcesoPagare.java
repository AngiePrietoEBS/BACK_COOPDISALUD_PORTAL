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
@Table(name = "ESTADO_PROCESO_PAGARE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProcesoPagare.findAll", query = "SELECT e FROM EstadoProcesoPagare e"),
    @NamedQuery(name = "EstadoProcesoPagare.findByICodigo", query = "SELECT e FROM EstadoProcesoPagare e WHERE e.iCodigo = :iCodigo"),
    @NamedQuery(name = "EstadoProcesoPagare.findByCEstadoProceso", query = "SELECT e FROM EstadoProcesoPagare e WHERE e.cEstadoProceso = :cEstadoProceso")})
public class EstadoProcesoPagare implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_ESTADO_PROCESO")
    private String cEstadoProceso;
    @JoinColumn(name = "I_ESTADO_PAGARE_DECEVAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private EstadoPagareDeceval iEstadoPagareDeceval;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iEstadoProceso")
    private Collection<ProcesoPagareDeceval> procesoPagareDecevalCollection;

    public EstadoProcesoPagare() {
    }

    public EstadoProcesoPagare(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCEstadoProceso() {
        return cEstadoProceso;
    }

    public void setCEstadoProceso(String cEstadoProceso) {
        this.cEstadoProceso = cEstadoProceso;
    }

    public EstadoPagareDeceval getIEstadoPagareDeceval() {
        return iEstadoPagareDeceval;
    }

    public void setIEstadoPagareDeceval(EstadoPagareDeceval iEstadoPagareDeceval) {
        this.iEstadoPagareDeceval = iEstadoPagareDeceval;
    }

    @XmlTransient
    public Collection<ProcesoPagareDeceval> getProcesoPagareDecevalCollection() {
        return procesoPagareDecevalCollection;
    }

    public void setProcesoPagareDecevalCollection(Collection<ProcesoPagareDeceval> procesoPagareDecevalCollection) {
        this.procesoPagareDecevalCollection = procesoPagareDecevalCollection;
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
        if (!(object instanceof EstadoProcesoPagare)) {
            return false;
        }
        EstadoProcesoPagare other = (EstadoProcesoPagare) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.EstadoProcesoPagare[ iCodigo=" + iCodigo + " ]";
    }
    
}
