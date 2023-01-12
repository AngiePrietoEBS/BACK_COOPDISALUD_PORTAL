/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "RTA_CREAR_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RtaCrearPagareDeceval.findAll", query = "SELECT r FROM RtaCrearPagareDeceval r"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByICodigo", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.iCodigo = :iCodigo"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByCCodigoErro", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.cCodigoErro = :cCodigoErro"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByCDescripcion", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByCExitoso", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.cExitoso = :cExitoso"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByCMensajeRespuesta", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.cMensajeRespuesta = :cMensajeRespuesta"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByCCodigoDocPagare", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.cCodigoDocPagare = :cCodigoDocPagare"),
    @NamedQuery(name = "RtaCrearPagareDeceval.findByFFechaRegistro", query = "SELECT r FROM RtaCrearPagareDeceval r WHERE r.fFechaRegistro = :fFechaRegistro")})
public class RtaCrearPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_CODIGO_ERRO")
    private String cCodigoErro;
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Column(name = "C_EXITOSO")
    private String cExitoso;
    @Column(name = "C_MENSAJE_RESPUESTA")
    private String cMensajeRespuesta;
    @Column(name = "C_CODIGO_DOC_PAGARE")
    private BigInteger cCodigoDocPagare;
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    @JoinColumn(name = "I_CREACION_PAGARE_DECEVAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private CreacionPagareDeceval iCreacionPagareDeceval;

    public RtaCrearPagareDeceval() {
    }

    public RtaCrearPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCCodigoErro() {
        return cCodigoErro;
    }

    public void setCCodigoErro(String cCodigoErro) {
        this.cCodigoErro = cCodigoErro;
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

    public String getCMensajeRespuesta() {
        return cMensajeRespuesta;
    }

    public void setCMensajeRespuesta(String cMensajeRespuesta) {
        this.cMensajeRespuesta = cMensajeRespuesta;
    }

    public BigInteger getCCodigoDocPagare() {
        return cCodigoDocPagare;
    }

    public void setCCodigoDocPagare(BigInteger cCodigoDocPagare) {
        this.cCodigoDocPagare = cCodigoDocPagare;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    public CreacionPagareDeceval getICreacionPagareDeceval() {
        return iCreacionPagareDeceval;
    }

    public void setICreacionPagareDeceval(CreacionPagareDeceval iCreacionPagareDeceval) {
        this.iCreacionPagareDeceval = iCreacionPagareDeceval;
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
        if (!(object instanceof RtaCrearPagareDeceval)) {
            return false;
        }
        RtaCrearPagareDeceval other = (RtaCrearPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.RtaCrearPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
