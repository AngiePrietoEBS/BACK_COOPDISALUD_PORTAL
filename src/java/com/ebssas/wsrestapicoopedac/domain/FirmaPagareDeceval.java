/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "FIRMA_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FirmaPagareDeceval.findAll", query = "SELECT f FROM FirmaPagareDeceval f"),
    @NamedQuery(name = "FirmaPagareDeceval.findByICodigo", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.iCodigo = :iCodigo"),
    @NamedQuery(name = "FirmaPagareDeceval.findByCClave", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.cClave = :cClave"),
    @NamedQuery(name = "FirmaPagareDeceval.findByCDocPagare", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.cDocPagare = :cDocPagare"),
    @NamedQuery(name = "FirmaPagareDeceval.findByITipoDoc", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.iTipoDoc = :iTipoDoc"),
    @NamedQuery(name = "FirmaPagareDeceval.findByCNumDoc", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.cNumDoc = :cNumDoc"),
    @NamedQuery(name = "FirmaPagareDeceval.findByCOtpPagare", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.cOtpPagare = :cOtpPagare"),
    @NamedQuery(name = "FirmaPagareDeceval.findByCOtpProcedimiento", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.cOtpProcedimiento = :cOtpProcedimiento"),
    @NamedQuery(name = "FirmaPagareDeceval.findByCMotivo", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.cMotivo = :cMotivo"),
    @NamedQuery(name = "FirmaPagareDeceval.findByFFechaRegistro", query = "SELECT f FROM FirmaPagareDeceval f WHERE f.fFechaRegistro = :fFechaRegistro")})
public class FirmaPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_CLAVE")
    private String cClave;
    @Column(name = "C_DOC_PAGARE")
    private String cDocPagare;
    @Column(name = "I_TIPO_DOC")
    private BigInteger iTipoDoc;
    @Column(name = "C_NUM_DOC")
    private String cNumDoc;
    @Column(name = "C_OTP_PAGARE")
    private String cOtpPagare;
    @Column(name = "C_OTP_PROCEDIMIENTO")
    private String cOtpProcedimiento;
    @Column(name = "C_MOTIVO")
    private String cMotivo;
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iFirmaPagareDeceval")
    private Collection<RtaFirmaPagareDeceval> rtaFirmaPagareDecevalCollection;
    @JoinColumn(name = "I_PROCESO_PAGARE", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private ProcesoPagareDeceval iProcesoPagare;
    @JoinColumn(name = "I_ROL_FIRMANTE", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private RolPersonaPagareDeceval iRolFirmante;

    public FirmaPagareDeceval() {
    }

    public FirmaPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCClave() {
        return cClave;
    }

    public void setCClave(String cClave) {
        this.cClave = cClave;
    }

    public String getCDocPagare() {
        return cDocPagare;
    }

    public void setCDocPagare(String cDocPagare) {
        this.cDocPagare = cDocPagare;
    }

    public BigInteger getITipoDoc() {
        return iTipoDoc;
    }

    public void setITipoDoc(BigInteger iTipoDoc) {
        this.iTipoDoc = iTipoDoc;
    }

    public String getCNumDoc() {
        return cNumDoc;
    }

    public void setCNumDoc(String cNumDoc) {
        this.cNumDoc = cNumDoc;
    }

    public String getCOtpPagare() {
        return cOtpPagare;
    }

    public void setCOtpPagare(String cOtpPagare) {
        this.cOtpPagare = cOtpPagare;
    }

    public String getCOtpProcedimiento() {
        return cOtpProcedimiento;
    }

    public void setCOtpProcedimiento(String cOtpProcedimiento) {
        this.cOtpProcedimiento = cOtpProcedimiento;
    }

    public String getCMotivo() {
        return cMotivo;
    }

    public void setCMotivo(String cMotivo) {
        this.cMotivo = cMotivo;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    @XmlTransient
    public Collection<RtaFirmaPagareDeceval> getRtaFirmaPagareDecevalCollection() {
        return rtaFirmaPagareDecevalCollection;
    }

    public void setRtaFirmaPagareDecevalCollection(Collection<RtaFirmaPagareDeceval> rtaFirmaPagareDecevalCollection) {
        this.rtaFirmaPagareDecevalCollection = rtaFirmaPagareDecevalCollection;
    }

    public ProcesoPagareDeceval getIProcesoPagare() {
        return iProcesoPagare;
    }

    public void setIProcesoPagare(ProcesoPagareDeceval iProcesoPagare) {
        this.iProcesoPagare = iProcesoPagare;
    }

    public RolPersonaPagareDeceval getIRolFirmante() {
        return iRolFirmante;
    }

    public void setIRolFirmante(RolPersonaPagareDeceval iRolFirmante) {
        this.iRolFirmante = iRolFirmante;
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
        if (!(object instanceof FirmaPagareDeceval)) {
            return false;
        }
        FirmaPagareDeceval other = (FirmaPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.FirmaPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
