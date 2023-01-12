/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "RTA_FIRMA_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RtaFirmaPagareDeceval.findAll", query = "SELECT r FROM RtaFirmaPagareDeceval r"),
    @NamedQuery(name = "RtaFirmaPagareDeceval.findByICodigo", query = "SELECT r FROM RtaFirmaPagareDeceval r WHERE r.iCodigo = :iCodigo"),
    @NamedQuery(name = "RtaFirmaPagareDeceval.findByCCodRespuesta", query = "SELECT r FROM RtaFirmaPagareDeceval r WHERE r.cCodRespuesta = :cCodRespuesta"),
    @NamedQuery(name = "RtaFirmaPagareDeceval.findByCDescripcion", query = "SELECT r FROM RtaFirmaPagareDeceval r WHERE r.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "RtaFirmaPagareDeceval.findByCExitoso", query = "SELECT r FROM RtaFirmaPagareDeceval r WHERE r.cExitoso = :cExitoso"),
    @NamedQuery(name = "RtaFirmaPagareDeceval.findByFFechaRegistro", query = "SELECT r FROM RtaFirmaPagareDeceval r WHERE r.fFechaRegistro = :fFechaRegistro")})
public class RtaFirmaPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_COD_RESPUESTA")
    private String cCodRespuesta;
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Column(name = "C_EXITOSO")
    private String cExitoso;
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    @JoinColumn(name = "I_FIRMA_PAGARE_DECEVAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private FirmaPagareDeceval iFirmaPagareDeceval;

    public RtaFirmaPagareDeceval() {
    }

    public RtaFirmaPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCCodRespuesta() {
        return cCodRespuesta;
    }

    public void setCCodRespuesta(String cCodRespuesta) {
        this.cCodRespuesta = cCodRespuesta;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getCExitoso() {
        return cExitoso;
    }

    public void setCExitoso(String cExitoso) {
        this.cExitoso = cExitoso;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    public FirmaPagareDeceval getIFirmaPagareDeceval() {
        return iFirmaPagareDeceval;
    }

    public void setIFirmaPagareDeceval(FirmaPagareDeceval iFirmaPagareDeceval) {
        this.iFirmaPagareDeceval = iFirmaPagareDeceval;
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
        if (!(object instanceof RtaFirmaPagareDeceval)) {
            return false;
        }
        RtaFirmaPagareDeceval other = (RtaFirmaPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.RtaFirmaPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
