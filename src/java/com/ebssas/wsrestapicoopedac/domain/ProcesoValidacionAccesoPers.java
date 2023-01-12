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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROCESO_VALIDACION_ACCESO_PERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoValidacionAccesoPers.findAll", query = "SELECT p FROM ProcesoValidacionAccesoPers p"),
    @NamedQuery(name = "ProcesoValidacionAccesoPers.findByICodigo", query = "SELECT p FROM ProcesoValidacionAccesoPers p WHERE p.iCodigo = :iCodigo"),
    @NamedQuery(name = "ProcesoValidacionAccesoPers.findByCEmail", query = "SELECT p FROM ProcesoValidacionAccesoPers p WHERE p.cEmail = :cEmail"),
    @NamedQuery(name = "ProcesoValidacionAccesoPers.findByCCelular", query = "SELECT p FROM ProcesoValidacionAccesoPers p WHERE p.cCelular = :cCelular"),
    @NamedQuery(name = "ProcesoValidacionAccesoPers.findByFFechaRegistro", query = "SELECT p FROM ProcesoValidacionAccesoPers p WHERE p.fFechaRegistro = :fFechaRegistro")})
public class ProcesoValidacionAccesoPers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PROCESO_ACCESO_PERSONA", sequenceName = "SEC_PROCESO_ACCESO_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PROCESO_ACCESO_PERSONA")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "C_CELULAR")
    private String cCelular;
    @Column(name = "F_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaRegistro;
    @JoinColumn(name = "I_VALIDACION_ACCESO_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ValidacionAccesoPersona iValidacionAccesoPersona;

    public ProcesoValidacionAccesoPers() {
    }

    public ProcesoValidacionAccesoPers(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ProcesoValidacionAccesoPers(Long iCodigo, String cEmail, String cCelular) {
        this.iCodigo = iCodigo;
        this.cEmail = cEmail;
        this.cCelular = cCelular;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCCelular() {
        return cCelular;
    }

    public void setCCelular(String cCelular) {
        this.cCelular = cCelular;
    }

    public Date getFFechaRegistro() {
        return fFechaRegistro;
    }

    public void setFFechaRegistro(Date fFechaRegistro) {
        this.fFechaRegistro = fFechaRegistro;
    }

    public ValidacionAccesoPersona getIValidacionAccesoPersona() {
        return iValidacionAccesoPersona;
    }

    public void setIValidacionAccesoPersona(ValidacionAccesoPersona iValidacionAccesoPersona) {
        this.iValidacionAccesoPersona = iValidacionAccesoPersona;
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
        if (!(object instanceof ProcesoValidacionAccesoPers)) {
            return false;
        }
        ProcesoValidacionAccesoPers other = (ProcesoValidacionAccesoPers) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ebs.fec.domain.ProcesoValidacionAccesoPers[ iCodigo=" + iCodigo + " ]";
    }
    
}
