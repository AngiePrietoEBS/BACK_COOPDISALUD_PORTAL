/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "REQUISITOS_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitosSolCred.findAll", query = "SELECT r FROM RequisitosSolCred r"),
    @NamedQuery(name = "RequisitosSolCred.findByICodigo", query = "SELECT r FROM RequisitosSolCred r WHERE r.iCodigo = :iCodigo"),
    @NamedQuery(name = "RequisitosSolCred.findByCNombre", query = "SELECT r FROM RequisitosSolCred r WHERE r.cNombre = :cNombre"),
    @NamedQuery(name = "RequisitosSolCred.findByCDescripcion", query = "SELECT r FROM RequisitosSolCred r WHERE r.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "RequisitosSolCred.findByCEstructura", query = "SELECT r FROM RequisitosSolCred r WHERE r.cEstructura = :cEstructura"),
    @NamedQuery(name = "RequisitosSolCred.findByCEstado", query = "SELECT r FROM RequisitosSolCred r WHERE r.cEstado = :cEstado")})
public class RequisitosSolCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_ESTRUCTURA")
    private String cEstructura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iRequisito", fetch = FetchType.EAGER)
    private List<DocumentoSolCred> documentoSolCredList;
    @JoinColumn(name = "I_TIPO_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCredito iTipoCredito;
    @JoinColumn(name = "I_TIPO_REQUISITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoRequisito iTipoRequisito;

    public RequisitosSolCred() {
    }

    public RequisitosSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public RequisitosSolCred(Long iCodigo, String cNombre, String cDescripcion, String cEstructura, String cEstado) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
        this.cDescripcion = cDescripcion;
        this.cEstructura = cEstructura;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getCEstructura() {
        return cEstructura;
    }

    public void setCEstructura(String cEstructura) {
        this.cEstructura = cEstructura;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<DocumentoSolCred> getDocumentoSolCredList() {
        return documentoSolCredList;
    }

    public void setDocumentoSolCredList(List<DocumentoSolCred> documentoSolCredList) {
        this.documentoSolCredList = documentoSolCredList;
    }

    public TipoCredito getITipoCredito() {
        return iTipoCredito;
    }

    public void setITipoCredito(TipoCredito iTipoCredito) {
        this.iTipoCredito = iTipoCredito;
    }

    public TipoRequisito getITipoRequisito() {
        return iTipoRequisito;
    }

    public void setITipoRequisito(TipoRequisito iTipoRequisito) {
        this.iTipoRequisito = iTipoRequisito;
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
        if (!(object instanceof RequisitosSolCred)) {
            return false;
        }
        RequisitosSolCred other = (RequisitosSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.RequisitosSolCred[ iCodigo=" + iCodigo + " ]";
    }
    
}
