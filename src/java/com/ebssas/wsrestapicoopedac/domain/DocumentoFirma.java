/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Sebastian F
 */
@Entity
@Table(name = "DOCUMENTO_FIRMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoFirma.findAll", query = "SELECT d FROM DocumentoFirma d"),
    @NamedQuery(name = "DocumentoFirma.findByICodigo", query = "SELECT d FROM DocumentoFirma d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoFirma.findByCRadicado", query = "SELECT d FROM DocumentoFirma d WHERE d.cRadicado = :cRadicado"),
    @NamedQuery(name = "DocumentoFirma.findByCAutorizacion", query = "SELECT d FROM DocumentoFirma d WHERE d.cAutorizacion = :cAutorizacion"),
    @NamedQuery(name = "DocumentoFirma.findByCDocumento", query = "SELECT d FROM DocumentoFirma d WHERE d.cDocumento = :cDocumento"),
    @NamedQuery(name = "DocumentoFirma.findByICelular", query = "SELECT d FROM DocumentoFirma d WHERE d.iCelular = :iCelular")})
public class DocumentoFirma implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Lob
    @Column(name = "C_BASE64")
    private Serializable cBase64;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_RADICADO")
    private String cRadicado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_AUTORIZACION")
    private String cAutorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_DOCUMENTO")
    private BigInteger cDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CELULAR")
    private BigInteger iCelular;

    public DocumentoFirma() {
    }

    public DocumentoFirma(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public DocumentoFirma(BigDecimal iCodigo, String cRadicado, String cAutorizacion, BigInteger cDocumento, BigInteger iCelular) {
        this.iCodigo = iCodigo;
        this.cRadicado = cRadicado;
        this.cAutorizacion = cAutorizacion;
        this.cDocumento = cDocumento;
        this.iCelular = iCelular;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Serializable getCBase64() {
        return cBase64;
    }

    public void setCBase64(Serializable cBase64) {
        this.cBase64 = cBase64;
    }

    public String getCRadicado() {
        return cRadicado;
    }

    public void setCRadicado(String cRadicado) {
        this.cRadicado = cRadicado;
    }

    public String getCAutorizacion() {
        return cAutorizacion;
    }

    public void setCAutorizacion(String cAutorizacion) {
        this.cAutorizacion = cAutorizacion;
    }

    public BigInteger getCDocumento() {
        return cDocumento;
    }

    public void setCDocumento(BigInteger cDocumento) {
        this.cDocumento = cDocumento;
    }

    public BigInteger getICelular() {
        return iCelular;
    }

    public void setICelular(BigInteger iCelular) {
        this.iCelular = iCelular;
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
        if (!(object instanceof DocumentoFirma)) {
            return false;
        }
        DocumentoFirma other = (DocumentoFirma) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.DocumentoFirma[ iCodigo=" + iCodigo + " ]";
    }
    
}
