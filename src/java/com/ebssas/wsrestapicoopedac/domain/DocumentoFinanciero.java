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
@Table(name = "DOCUMENTO_FINANCIERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoFinanciero.findAll", query = "SELECT d FROM DocumentoFinanciero d"),
    @NamedQuery(name = "DocumentoFinanciero.findByCDescripcion", query = "SELECT d FROM DocumentoFinanciero d WHERE d.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "DocumentoFinanciero.findByCEntidadFin", query = "SELECT d FROM DocumentoFinanciero d WHERE d.cEntidadFin = :cEntidadFin"),
    @NamedQuery(name = "DocumentoFinanciero.findByCNumcuenta", query = "SELECT d FROM DocumentoFinanciero d WHERE d.cNumcuenta = :cNumcuenta"),
    @NamedQuery(name = "DocumentoFinanciero.findByITipocuenta", query = "SELECT d FROM DocumentoFinanciero d WHERE d.iTipocuenta = :iTipocuenta"),
    @NamedQuery(name = "DocumentoFinanciero.findByICodigo", query = "SELECT d FROM DocumentoFinanciero d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoFinanciero.findByCDocumento", query = "SELECT d FROM DocumentoFinanciero d WHERE d.cDocumento = :cDocumento"),
    @NamedQuery(name = "DocumentoFinanciero.findByINumRadicado", query = "SELECT d FROM DocumentoFinanciero d WHERE d.iNumRadicado = :iNumRadicado"),
})
public class DocumentoFinanciero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "C_BASE64")
    private byte[] cBase64;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_ENTIDAD_FIN")
    private String cEntidadFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_NUMCUENTA")
    private Long cNumcuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_TIPOCUENTA")
    private Long iTipocuenta;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "I_CODIGO")
    private String iCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_DOCUMENTO")
    private Long cDocumento;
    @Column(name = "I_NUM_RADICADO")
    private String iNumRadicado;

    public DocumentoFinanciero() {
    }

    public DocumentoFinanciero(String iCodigo) {
        this.iCodigo = iCodigo;
    }

    public DocumentoFinanciero(String iCodigo, String cDescripcion, String cEntidadFin, Long cNumcuenta, Long iTipocuenta, Long cDocumento, String iNumRadicado, byte[] cBase64 ) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cEntidadFin = cEntidadFin;
        this.cNumcuenta = cNumcuenta;
        this.iTipocuenta = iTipocuenta;
        this.cDocumento = cDocumento;
        this.iNumRadicado = iNumRadicado;
        this.cBase64 = cBase64;
    }

    public byte[] getCBase64() {
        return cBase64;
    }

    public void setCBase64(byte[] cBase64) {
        this.cBase64 = cBase64;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getCEntidadFin() {
        return cEntidadFin;
    }

    public void setCEntidadFin(String cEntidadFin) {
        this.cEntidadFin = cEntidadFin;
    }

    public Long getCNumcuenta() {
        return cNumcuenta;
    }

    public void setCNumcuenta(Long cNumcuenta) {
        this.cNumcuenta = cNumcuenta;
    }

    public Long getITipocuenta() {
        return iTipocuenta;
    }

    public void setITipocuenta(Long iTipocuenta) {
        this.iTipocuenta = iTipocuenta;
    }

    public String getICodigo() {
        return iCodigo;
    }

    public void setICodigo(String iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getCDocumento() {
        return cDocumento;
    }

    public void setCDocumento(Long cDocumento) {
        this.cDocumento = cDocumento;
    }

    public void setINumRadicado(String iNumRadicado) {
        this.iNumRadicado = iNumRadicado;
    }

    public String getINumRadicado() {
        return iNumRadicado;
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
        if (!(object instanceof DocumentoFinanciero)) {
            return false;
        }
        DocumentoFinanciero other = (DocumentoFinanciero) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.DocumentoFinanciero[ iCodigo=" + iCodigo + " ]";
    }
    
}
