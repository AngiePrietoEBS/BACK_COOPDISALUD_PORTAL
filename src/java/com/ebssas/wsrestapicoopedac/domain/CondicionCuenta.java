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
@Table(name = "CONDICION_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionCuenta.findAll", query = "SELECT c FROM CondicionCuenta c"),
    @NamedQuery(name = "CondicionCuenta.findByICodigo", query = "SELECT c FROM CondicionCuenta c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "CondicionCuenta.findByCNombre", query = "SELECT c FROM CondicionCuenta c WHERE c.cNombre = :cNombre"),
    @NamedQuery(name = "CondicionCuenta.findByCDescripcion", query = "SELECT c FROM CondicionCuenta c WHERE c.cDescripcion = :cDescripcion"),
    @NamedQuery(name = "CondicionCuenta.findByCEstado", query = "SELECT c FROM CondicionCuenta c WHERE c.cEstado = :cEstado")})
public class CondicionCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_CONDICION_CTA_SOL_CRED", sequenceName = "SEC_CONDICION_CTA_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CONDICION_CTA_SOL_CRED")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    public CondicionCuenta() {
    }

    public CondicionCuenta(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public CondicionCuenta(Long iCodigo, String cNombre, String cDescripcion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cNombre = cNombre;
        this.cDescripcion = cDescripcion;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
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
        if (!(object instanceof CondicionCuenta)) {
            return false;
        }
        CondicionCuenta other = (CondicionCuenta) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.CondicionCuenta[ iCodigo=" + iCodigo + " ]";
    }
    
}
