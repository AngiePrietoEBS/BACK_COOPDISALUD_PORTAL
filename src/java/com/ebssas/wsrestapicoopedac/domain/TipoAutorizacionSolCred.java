/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "TIPO_AUTORIZACION_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAutorizacionSolCred.findAll", query = "SELECT t FROM TipoAutorizacionSolCred t"),
    @NamedQuery(name = "TipoAutorizacionSolCred.findByICodigo", query = "SELECT t FROM TipoAutorizacionSolCred t WHERE t.iCodigo = :iCodigo"),
    @NamedQuery(name = "TipoAutorizacionSolCred.findByCDescripcion", query = "SELECT t FROM TipoAutorizacionSolCred t WHERE t.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "TipoAutorizacionSolCred.findByCNombre", query = "SELECT t FROM TipoAutorizacionSolCred t WHERE t.cNombre = :cNombre"),
    @NamedQuery(name = "TipoAutorizacionSolCred.findByCEstado", query = "SELECT t FROM TipoAutorizacionSolCred t WHERE t.cEstado = :cEstado"),})
public class TipoAutorizacionSolCred implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTipoAutorizacion")
    private List<AutorizacionSolCredito> autorizacionSolCreditoList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    public TipoAutorizacionSolCred() {
    }

    public TipoAutorizacionSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoAutorizacionSolCred(Long iCodigo, String cDescripcion, String cNombre, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cNombre = cNombre;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
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
        if (!(object instanceof TipoAutorizacionSolCred)) {
            return false;
        }
        TipoAutorizacionSolCred other = (TipoAutorizacionSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.TipoAutorizacionSolCred[ iCodigo=" + iCodigo + " ]";
    }

    @XmlTransient
    public List<AutorizacionSolCredito> getAutorizacionSolCreditoList() {
        return autorizacionSolCreditoList;
    }

    public void setAutorizacionSolCreditoList(List<AutorizacionSolCredito> autorizacionSolCreditoList) {
        this.autorizacionSolCreditoList = autorizacionSolCreditoList;
    }

}
