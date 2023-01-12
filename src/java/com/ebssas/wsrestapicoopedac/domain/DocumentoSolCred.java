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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "DOCUMENTO_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoSolCred.findAll", query = "SELECT d FROM DocumentoSolCred d"),
    @NamedQuery(name = "DocumentoSolCred.findByICodigo", query = "SELECT d FROM DocumentoSolCred d WHERE d.iCodigo = :iCodigo"),
    @NamedQuery(name = "DocumentoSolCred.findByCNombreDocumento", query = "SELECT d FROM DocumentoSolCred d WHERE d.cNombreDocumento = :cNombreDocumento"),
    @NamedQuery(name = "DocumentoSolCred.findByCTipoArchivo", query = "SELECT d FROM DocumentoSolCred d WHERE d.cTipoArchivo = :cTipoArchivo")})
public class DocumentoSolCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_DOC_SOL_CREDITO", sequenceName = "SEC_DOC_SOL_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_DOC_SOL_CREDITO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "C_BASE64")
    private byte[] cBase64;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRE_DOCUMENTO")
    private String cNombreDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "C_TIPO_ARCHIVO")
    private String cTipoArchivo;
    @JoinColumn(name = "I_REQUISITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RequisitosSolCred iRequisito;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolCredito;

    public DocumentoSolCred() {
    }

    public DocumentoSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public DocumentoSolCred(Long iCodigo, byte[] cBase64, String cNombreDocumento, String cTipoArchivo) {
        this.iCodigo = iCodigo;
        this.cBase64 = cBase64;
        this.cNombreDocumento = cNombreDocumento;
        this.cTipoArchivo = cTipoArchivo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public byte[] getCBase64() {
        return cBase64;
    }

    public void setCBase64(byte[] cBase64) {
        this.cBase64 = cBase64;
    }

    public String getCNombreDocumento() {
        return cNombreDocumento;
    }

    public void setCNombreDocumento(String cNombreDocumento) {
        this.cNombreDocumento = cNombreDocumento;
    }

    public String getCTipoArchivo() {
        return cTipoArchivo;
    }

    public void setCTipoArchivo(String cTipoArchivo) {
        this.cTipoArchivo = cTipoArchivo;
    }

    public RequisitosSolCred getIRequisito() {
        return iRequisito;
    }

    public void setIRequisito(RequisitosSolCred iRequisito) {
        this.iRequisito = iRequisito;
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
        if (!(object instanceof DocumentoSolCred)) {
            return false;
        }
        DocumentoSolCred other = (DocumentoSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentoSolCred{" + "iCodigo=" + iCodigo + ", cBase64=" + cBase64 + ", cNombreDocumento=" + cNombreDocumento + ", cTipoArchivo=" + cTipoArchivo + ", iRequisito=" + iRequisito + ", iSolCredito=" + iSolCredito + '}';
    }
}
