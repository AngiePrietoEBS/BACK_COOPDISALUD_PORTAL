/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "DOCUMENTO_TRANSUNION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoTransunion.findAll", query = "SELECT d FROM DocumentoTransunion d"),
    @NamedQuery(name = "DocumentoTransunion.findByICodigo", query = "SELECT d FROM DocumentoTransunion d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoTransunion.findByCNombre", query = "SELECT d FROM DocumentoTransunion d WHERE d.cNombre = :cNombre"),
    @NamedQuery(name = "DocumentoTransunion.findByCTipoArchivo", query = "SELECT d FROM DocumentoTransunion d WHERE d.cTipoArchivo = :cTipoArchivo")})
public class DocumentoTransunion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_DOC_TU", sequenceName = "SEC_DOC_TU", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DOC_TU")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(max = 1000)
    @NotNull
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "C_BASE64")
    private byte[] cBase64;
    @Size(max = 100)
    @NotNull
    @Column(name = "C_TIPO_ARCHIVO")
    private String cTipoArchivo;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolCredito;

    public DocumentoTransunion() {
    }

    public DocumentoTransunion(Long iCodigo) {
        this.iCodigo = iCodigo;
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

    public byte[] getCBase64() {
        return cBase64;
    }

    public void setCBase64(byte[] cBase64) {
        this.cBase64 = cBase64;
    }

    public String getCTipoArchivo() {
        return cTipoArchivo;
    }

    public void setCTipoArchivo(String cTipoArchivo) {
        this.cTipoArchivo = cTipoArchivo;
    }

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
        if (!(object instanceof DocumentoTransunion)) {
            return false;
        }
        DocumentoTransunion other = (DocumentoTransunion) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    public DocumentoTransunion(Long iCodigo, String cNombre, byte[] cBase64, String cTipoArchivo, SolicitudCredito iSolCredito) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
        this.cBase64 = cBase64;
        this.cTipoArchivo = cTipoArchivo;
        this.iSolCredito = iSolCredito;
    }
    
    

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.DocumentoTransunion[ iCodigo=" + iCodigo + " ]";
    }
    
}
