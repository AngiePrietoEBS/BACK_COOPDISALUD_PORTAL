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
@Table(name = "RTA_CREAR_GIRADOR_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RtaCrearGiradorDeceval.findAll", query = "SELECT r FROM RtaCrearGiradorDeceval r"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByICodigo", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.iCodigo = :iCodigo"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByCCodError", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.cCodError = :cCodError"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByCDescripcion", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByCExitoso", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.cExitoso = :cExitoso"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByCCtaGirador", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.cCtaGirador = :cCtaGirador"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByCMensajeRespuesta", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.cMensajeRespuesta = :cMensajeRespuesta"),
    @NamedQuery(name = "RtaCrearGiradorDeceval.findByFFechaRegistro", query = "SELECT r FROM RtaCrearGiradorDeceval r WHERE r.fFechaRegistro = :fFechaRegistro")})
public class RtaCrearGiradorDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_COD_ERROR")
    private String cCodError;
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Column(name = "C_EXITOSO")
    private String cExitoso;
    @Column(name = "C_CTA_GIRADOR")
    private String cCtaGirador;
    @Column(name = "C_MENSAJE_RESPUESTA")
    private String cMensajeRespuesta;
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    @JoinColumn(name = "I_CREACION_GIRADOR_DECEVAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private CreacionGiradorDeceval iCreacionGiradorDeceval;

    public RtaCrearGiradorDeceval() {
    }

    public RtaCrearGiradorDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCCodError() {
        return cCodError;
    }

    public void setCCodError(String cCodError) {
        this.cCodError = cCodError;
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

    public String getCCtaGirador() {
        return cCtaGirador;
    }

    public void setCCtaGirador(String cCtaGirador) {
        this.cCtaGirador = cCtaGirador;
    }

    public String getCMensajeRespuesta() {
        return cMensajeRespuesta;
    }

    public void setCMensajeRespuesta(String cMensajeRespuesta) {
        this.cMensajeRespuesta = cMensajeRespuesta;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    public CreacionGiradorDeceval getICreacionGiradorDeceval() {
        return iCreacionGiradorDeceval;
    }

    public void setICreacionGiradorDeceval(CreacionGiradorDeceval iCreacionGiradorDeceval) {
        this.iCreacionGiradorDeceval = iCreacionGiradorDeceval;
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
        if (!(object instanceof RtaCrearGiradorDeceval)) {
            return false;
        }
        RtaCrearGiradorDeceval other = (RtaCrearGiradorDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.RtaCrearGiradorDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
