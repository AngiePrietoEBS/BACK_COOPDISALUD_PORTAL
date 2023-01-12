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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "VALIDACION_ACCESO_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValidacionAccesoPersona.findAll", query = "SELECT v FROM ValidacionAccesoPersona v"),
    @NamedQuery(name = "ValidacionAccesoPersona.findByICodigo", query = "SELECT v FROM ValidacionAccesoPersona v WHERE v.iCodigo = :iCodigo"),
    @NamedQuery(name = "ValidacionAccesoPersona.findByCToken", query = "SELECT v FROM ValidacionAccesoPersona v WHERE v.cToken = :cToken"),
    @NamedQuery(name = "ValidacionAccesoPersona.findByCKeyToken", query = "SELECT v FROM ValidacionAccesoPersona v WHERE v.cKeyToken = :cKeyToken"),
    @NamedQuery(name = "ValidacionAccesoPersona.findByFFechaInicio", query = "SELECT v FROM ValidacionAccesoPersona v WHERE v.fFechaInicio = :fFechaInicio"),
    @NamedQuery(name = "ValidacionAccesoPersona.findByFFechaFin", query = "SELECT v FROM ValidacionAccesoPersona v WHERE v.fFechaFin = :fFechaFin"),
    @NamedQuery(name = "ValidacionAccesoPersona.findByCEstado", query = "SELECT v FROM ValidacionAccesoPersona v WHERE v.cEstado = :cEstado")})
public class ValidacionAccesoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_VALIDACION_ACCESO_PERSONA", sequenceName = "SEC_VALIDACION_ACCESO_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_VALIDACION_ACCESO_PERSONA")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_TOKEN")
    private String cToken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_KEY_TOKEN")
    private String cKeyToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    public ValidacionAccesoPersona() {
    }

    public ValidacionAccesoPersona(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ValidacionAccesoPersona(Long iCodigo, String cToken, String cKeyToken, Date fFechaInicio, Date fFechaFin, String cEstado) {
        this.iCodigo = iCodigo;
        this.cToken = cToken;
        this.cKeyToken = cKeyToken;
        this.fFechaInicio = fFechaInicio;
        this.fFechaFin = fFechaFin;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCToken() {
        return cToken;
    }

    public void setCToken(String cToken) {
        this.cToken = cToken;
    }

    public String getCKeyToken() {
        return cKeyToken;
    }

    public void setCKeyToken(String cKeyToken) {
        this.cKeyToken = cKeyToken;
    }

    public Date getFFechaInicio() {
        return fFechaInicio;
    }

    public void setFFechaInicio(Date fFechaInicio) {
        this.fFechaInicio = fFechaInicio;
    }

    public Date getFFechaFin() {
        return fFechaFin;
    }

    public void setFFechaFin(Date fFechaFin) {
        this.fFechaFin = fFechaFin;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
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
        if (!(object instanceof ValidacionAccesoPersona)) {
            return false;
        }
        ValidacionAccesoPersona other = (ValidacionAccesoPersona) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.ValidacionAccesoPersona[ iCodigo=" + iCodigo + " ]";
    }
    
}
