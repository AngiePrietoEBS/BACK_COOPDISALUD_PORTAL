/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "HISTORIA_SOL_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaSolCredito.findAll", query = "SELECT h FROM HistoriaSolCredito h"),
    @NamedQuery(name = "HistoriaSolCredito.findByICodigo", query = "SELECT h FROM HistoriaSolCredito h WHERE h.iCodigo = :iCodigo"),
    @NamedQuery(name = "HistoriaSolCredito.findByCObservacion", query = "SELECT h FROM HistoriaSolCredito h WHERE h.cObservacion = :cObservacion"),
    @NamedQuery(name = "HistoriaSolCredito.findByFFecha", query = "SELECT h FROM HistoriaSolCredito h WHERE h.fFecha = :fFecha")})
@JsonIgnoreProperties({"iSolCredito"})
public class HistoriaSolCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_HISTORIA_SOL_CREDITO", sequenceName = "SEC_HISTORIA_SOL_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_HISTORIA_SOL_CREDITO")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_OBSERVACION")
    private String cObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecha;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private SolicitudCredito iSolCredito;

    public HistoriaSolCredito() {
    }

    public HistoriaSolCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public HistoriaSolCredito(Long iCodigo, String cObservacion, Date fFecha) {
        this.iCodigo = iCodigo;
        this.cObservacion = cObservacion;
        this.fFecha = fFecha;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCObservacion() {
        return cObservacion;
    }

    public void setCObservacion(String cObservacion) {
        this.cObservacion = cObservacion;
    }

    public Date getFFecha() {
        return fFecha;
    }

    public void setFFecha(Date fFecha) {
        this.fFecha = fFecha;
    }

    @XmlTransient
    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
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
        if (!(object instanceof HistoriaSolCredito)) {
            return false;
        }
        HistoriaSolCredito other = (HistoriaSolCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistoriaSolCredito{" + "iCodigo=" + iCodigo + ", cObservacion=" + cObservacion + ", fFecha=" + fFecha + ", iSolCredito=" + iSolCredito + '}';
    }

    
}
