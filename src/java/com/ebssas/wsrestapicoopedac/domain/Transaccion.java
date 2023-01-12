/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByICodigo", query = "SELECT t FROM Transaccion t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "Transaccion.findByCDescripcion", query = "SELECT t FROM Transaccion t WHERE t.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "Transaccion.findByCValidacion", query = "SELECT t FROM Transaccion t WHERE t.cValidacion = :cValidacion")
    , @NamedQuery(name = "Transaccion.findByCEstado", query = "SELECT t FROM Transaccion t WHERE t.cEstado = :cEstado")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "C_VALIDACION")
    private String cValidacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @JoinColumn(name = "I_TIPO_TRAN", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoTransaccion iTipoTran;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTransaccion")
    private List<PerfilTransaccional> perfilTransaccionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTransaccion")
    private List<Acceso> accesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTransaccion")
    private List<AccesoUsuario> accesoUsuarioList;

    public Transaccion() {
    }

    public Transaccion(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Transaccion(BigDecimal iCodigo, String cDescripcion, String cValidacion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cValidacion = cValidacion;
        this.cEstado = cEstado;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getCValidacion() {
        return cValidacion;
    }

    public void setCValidacion(String cValidacion) {
        this.cValidacion = cValidacion;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public TipoTransaccion getITipoTran() {
        return iTipoTran;
    }

    public void setITipoTran(TipoTransaccion iTipoTran) {
        this.iTipoTran = iTipoTran;
    }

    @XmlTransient
    public List<PerfilTransaccional> getPerfilTransaccionalList() {
        return perfilTransaccionalList;
    }

    public void setPerfilTransaccionalList(List<PerfilTransaccional> perfilTransaccionalList) {
        this.perfilTransaccionalList = perfilTransaccionalList;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    @XmlTransient
    public List<AccesoUsuario> getAccesoUsuarioList() {
        return accesoUsuarioList;
    }

    public void setAccesoUsuarioList(List<AccesoUsuario> accesoUsuarioList) {
        this.accesoUsuarioList = accesoUsuarioList;
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
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.Transaccion[ iCodigo=" + iCodigo + " ]";
    }
    
}
