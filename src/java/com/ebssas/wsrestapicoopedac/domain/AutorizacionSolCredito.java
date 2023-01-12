/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "AUTORIZACION_SOL_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorizacionSolCredito.findAll", query = "SELECT a FROM AutorizacionSolCredito a"),
    @NamedQuery(name = "AutorizacionSolCredito.findByICodigo", query = "SELECT a FROM AutorizacionSolCredito a WHERE a.iCodigo = :iCodigo"),
    @NamedQuery(name = "AutorizacionSolCredito.findByCAutorizo", query = "SELECT a FROM AutorizacionSolCredito a WHERE a.cAutorizo = :cAutorizo"),
    @NamedQuery(name = "AutorizacionSolCredito.findByCIp", query = "SELECT a FROM AutorizacionSolCredito a WHERE a.cIp = :cIp"),
    @NamedQuery(name = "AutorizacionSolCredito.findByCNavegador", query = "SELECT a FROM AutorizacionSolCredito a WHERE a.cNavegador = :cNavegador"),
    @NamedQuery(name = "AutorizacionSolCredito.findByFFechaSistema", query = "SELECT a FROM AutorizacionSolCredito a WHERE a.fFechaSistema = :fFechaSistema")})
public class AutorizacionSolCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEC_AUTORIZACION_SOL_CRED", sequenceName = "SEC_AUTORIZACION_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_AUTORIZACION_SOL_CRED")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_AUTORIZO")
    private String cAutorizo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_IP")
    private String cIp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_NAVEGADOR")
    private String cNavegador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_SISTEMA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaSistema;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private SolicitudCredito iSolCredito;
    @JoinColumn(name = "I_TIPO_AUTORIZACION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoAutorizacionSolCred iTipoAutorizacion;

    public AutorizacionSolCredito() {
    }

    public AutorizacionSolCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AutorizacionSolCredito(Long iCodigo, String cAutorizo, String cIp, String cNavegador, Date fFechaSistema) {
        this.iCodigo = iCodigo;
        this.cAutorizo = cAutorizo;
        this.cIp = cIp;
        this.cNavegador = cNavegador;
        this.fFechaSistema = fFechaSistema;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCAutorizo() {
        return cAutorizo;
    }

    public void setCAutorizo(String cAutorizo) {
        this.cAutorizo = cAutorizo;
    }

    public String getCIp() {
        return cIp;
    }

    public void setCIp(String cIp) {
        this.cIp = cIp;
    }

    public String getCNavegador() {
        return cNavegador;
    }

    public void setCNavegador(String cNavegador) {
        this.cNavegador = cNavegador;
    }

    public Date getFFechaSistema() {
        return fFechaSistema;
    }

    public void setFFechaSistema(Date fFechaSistema) {
        this.fFechaSistema = fFechaSistema;
    }

    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
    }

    public TipoAutorizacionSolCred getITipoAutorizacion() {
        return iTipoAutorizacion;
    }

    public void setITipoAutorizacion(TipoAutorizacionSolCred iTipoAutorizacion) {
        this.iTipoAutorizacion = iTipoAutorizacion;
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
        if (!(object instanceof AutorizacionSolCredito)) {
            return false;
        }
        AutorizacionSolCredito other = (AutorizacionSolCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito[ iCodigo=" + iCodigo + " ]";
    }
    
}
