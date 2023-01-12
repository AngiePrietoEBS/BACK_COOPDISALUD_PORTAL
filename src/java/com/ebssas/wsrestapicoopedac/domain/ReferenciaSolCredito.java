/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "REFERENCIA_SOL_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenciaSolCredito.findAll", query = "SELECT r FROM ReferenciaSolCredito r")
    , @NamedQuery(name = "ReferenciaSolCredito.findByICodigo", query = "SELECT r FROM ReferenciaSolCredito r WHERE r.iCodigo = :iCodigo")
    , @NamedQuery(name = "ReferenciaSolCredito.findByCNombres", query = "SELECT r FROM ReferenciaSolCredito r WHERE r.cNombres = :cNombres")
    , @NamedQuery(name = "ReferenciaSolCredito.findByCNumCelular", query = "SELECT r FROM ReferenciaSolCredito r WHERE r.cNumCelular = :cNumCelular")})
@JsonIgnoreProperties({"iSolCredito"})
public class ReferenciaSolCredito implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private SolicitudCredito iSolCredito;
    @JoinColumn(name = "I_PARENTESCO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoParentesco iParentesco;
    @JoinColumn(name = "I_TIPO_REFERENCIA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoReferencia iTipoReferencia;

    public ReferenciaSolCredito() {
    }

    public ReferenciaSolCredito(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ReferenciaSolCredito(BigDecimal iCodigo, String cNombres, String cNumCelular) {
        this.iCodigo = iCodigo;
        this.cNombres = cNombres;
        this.cNumCelular = cNumCelular;
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

    public String getCNumCelular() {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular) {
        this.cNumCelular = cNumCelular;
    }

    @XmlTransient
    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
    }

    public TipoParentesco getIParentesco() {
        return iParentesco;
    }

    public void setIParentesco(TipoParentesco iParentesco) {
        this.iParentesco = iParentesco;
    }

    public TipoReferencia getITipoReferencia() {
        return iTipoReferencia;
    }

    public void setITipoReferencia(TipoReferencia iTipoReferencia) {
        this.iTipoReferencia = iTipoReferencia;
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
        if (!(object instanceof ReferenciaSolCredito)) {
            return false;
        }
        ReferenciaSolCredito other = (ReferenciaSolCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.ReferenciaSolCredito[ iCodigo=" + iCodigo + " ]";
    }
    
}
