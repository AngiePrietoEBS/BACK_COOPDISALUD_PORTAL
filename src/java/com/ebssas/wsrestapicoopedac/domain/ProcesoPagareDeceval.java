/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "PROCESO_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoPagareDeceval.findAll", query = "SELECT p FROM ProcesoPagareDeceval p"),
    @NamedQuery(name = "ProcesoPagareDeceval.findByICodigo", query = "SELECT p FROM ProcesoPagareDeceval p WHERE p.iCodigo = :iCodigo"),
    @NamedQuery(name = "ProcesoPagareDeceval.findByFFechaRegistro", query = "SELECT p FROM ProcesoPagareDeceval p WHERE p.fFechaRegistro = :fFechaRegistro"),
    @NamedQuery(name = "ProcesoPagareDeceval.findByFFechaHeader", query = "SELECT p FROM ProcesoPagareDeceval p WHERE p.fFechaHeader = :fFechaHeader"),
    @NamedQuery(name = "ProcesoPagareDeceval.findByFHoraHeader", query = "SELECT p FROM ProcesoPagareDeceval p WHERE p.fHoraHeader = :fHoraHeader"),
    @NamedQuery(name = "ProcesoPagareDeceval.findByCCodDepositanteHeader", query = "SELECT p FROM ProcesoPagareDeceval p WHERE p.cCodDepositanteHeader = :cCodDepositanteHeader"),
    @NamedQuery(name = "ProcesoPagareDeceval.findByCUsuarioHeader", query = "SELECT p FROM ProcesoPagareDeceval p WHERE p.cUsuarioHeader = :cUsuarioHeader")})
public class ProcesoPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PROC_PAGARE_DECEVAL", sequenceName = "SEC_PROC_PAGARE_DECEVAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PROC_PAGARE_DECEVAL")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    
    @Column(name = "F_FECHA_HEADER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaHeader;
    
    @Column(name = "F_HORA_HEADER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fHoraHeader;
    
    @Column(name = "C_COD_DEPOSITANTE_HEADER")
    private String cCodDepositanteHeader;
    
    @Column(name = "C_USUARIO_HEADER")
    private String cUsuarioHeader;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iProcesoPagareDeceval")
    private Collection<CreacionPagareDeceval> creacionPagareDecevalCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iProcesoPagareDeceval")
    private Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iProcesoPagare")
    private Collection<FirmaPagareDeceval> firmaPagareDecevalCollection;
    
    @JoinColumn(name = "I_ESTADO_PROCESO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private EstadoProcesoPagare iEstadoProceso;
    
    @JoinColumn(name = "I_SOLICITUD_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private SolicitudCredito iSolicitudCredito;

    public ProcesoPagareDeceval() {
    }

    public ProcesoPagareDeceval(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    public Date getFFechaHeader() {
        return fFechaHeader;
    }

    public void setFFechaHeader(Date fFechaHeader) {
        this.fFechaHeader = fFechaHeader;
    }

    public Date getFHoraHeader() {
        return fHoraHeader;
    }

    public void setFHoraHeader(Date fHoraHeader) {
        this.fHoraHeader = fHoraHeader;
    }

    public String getCCodDepositanteHeader() {
        return cCodDepositanteHeader;
    }

    public void setCCodDepositanteHeader(String cCodDepositanteHeader) {
        this.cCodDepositanteHeader = cCodDepositanteHeader;
    }

    public String getCUsuarioHeader() {
        return cUsuarioHeader;
    }

    public void setCUsuarioHeader(String cUsuarioHeader) {
        this.cUsuarioHeader = cUsuarioHeader;
    }

    @XmlTransient
    public Collection<CreacionPagareDeceval> getCreacionPagareDecevalCollection() {
        return creacionPagareDecevalCollection;
    }

    public void setCreacionPagareDecevalCollection(Collection<CreacionPagareDeceval> creacionPagareDecevalCollection) {
        this.creacionPagareDecevalCollection = creacionPagareDecevalCollection;
    }

    @XmlTransient
    public Collection<CreacionGiradorDeceval> getCreacionGiradorDecevalCollection() {
        return creacionGiradorDecevalCollection;
    }

    public void setCreacionGiradorDecevalCollection(Collection<CreacionGiradorDeceval> creacionGiradorDecevalCollection) {
        this.creacionGiradorDecevalCollection = creacionGiradorDecevalCollection;
    }

    @XmlTransient
    public Collection<FirmaPagareDeceval> getFirmaPagareDecevalCollection() {
        return firmaPagareDecevalCollection;
    }

    public void setFirmaPagareDecevalCollection(Collection<FirmaPagareDeceval> firmaPagareDecevalCollection) {
        this.firmaPagareDecevalCollection = firmaPagareDecevalCollection;
    }

    public EstadoProcesoPagare getIEstadoProceso() {
        return iEstadoProceso;
    }

    public void setIEstadoProceso(EstadoProcesoPagare iEstadoProceso) {
        this.iEstadoProceso = iEstadoProceso;
    }

    public SolicitudCredito getISolicitudCredito() {
        return iSolicitudCredito;
    }

    public void setISolicitudCredito(SolicitudCredito iSolicitudCredito) {
        this.iSolicitudCredito = iSolicitudCredito;
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
        if (!(object instanceof ProcesoPagareDeceval)) {
            return false;
        }
        ProcesoPagareDeceval other = (ProcesoPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.ProcesoPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
