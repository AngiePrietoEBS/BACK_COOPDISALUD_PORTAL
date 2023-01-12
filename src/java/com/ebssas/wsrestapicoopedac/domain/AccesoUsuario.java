/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "ACCESO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccesoUsuario.findAll", query = "SELECT a FROM AccesoUsuario a"),
    @NamedQuery(name = "AccesoUsuario.findByICodigo", query = "SELECT a FROM AccesoUsuario a WHERE a.iCodigo = :iCodigo"),
    @NamedQuery(name = "AccesoUsuario.findByFAcceso", query = "SELECT a FROM AccesoUsuario a WHERE a.fAcceso = :fAcceso"),
    @NamedQuery(name = "AccesoUsuario.findByCEquipo", query = "SELECT a FROM AccesoUsuario a WHERE a.cEquipo = :cEquipo"),
    @NamedQuery(name = "AccesoUsuario.findByCEstado", query = "SELECT a FROM AccesoUsuario a WHERE a.cEstado = :cEstado")})
public class AccesoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_ACCESO_USUARIO", sequenceName = "SEC_ACCESO_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ACCESO_USUARIO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Column(name = "F_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fAcceso;
    @Column(name = "C_EQUIPO")
    private String cEquipo;
    
    @Column(name = "C_ESTADO")
    private String cEstado;
    @JoinColumn(name = "I_TIPO_ACCESO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoAcceso iTipoAcceso;
    @JoinColumn(name = "I_TIPO_CANAL", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private TipoCanal iTipoCanal;
    @JoinColumn(name = "I_TRANSACCION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Transaccion iTransaccion;
    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Usuario iUsuario;

    public AccesoUsuario() {
    }

    public AccesoUsuario(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AccesoUsuario(Long iCodigo, Date fAcceso, String cEstado) {
        this.iCodigo = iCodigo;
        this.fAcceso = fAcceso;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Date getFAcceso() {
        return fAcceso;
    }

    public void setFAcceso(Date fAcceso) {
        this.fAcceso = fAcceso;
    }

    public String getCEquipo() {
        return cEquipo;
    }

    public void setCEquipo(String cEquipo) {
        this.cEquipo = cEquipo;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public TipoAcceso getITipoAcceso() {
        return iTipoAcceso;
    }

    public void setITipoAcceso(TipoAcceso iTipoAcceso) {
        this.iTipoAcceso = iTipoAcceso;
    }

    public TipoCanal getITipoCanal() {
        return iTipoCanal;
    }

    public void setITipoCanal(TipoCanal iTipoCanal) {
        this.iTipoCanal = iTipoCanal;
    }

    public Transaccion getITransaccion() {
        return iTransaccion;
    }

    public void setITransaccion(Transaccion iTransaccion) {
        this.iTransaccion = iTransaccion;
    }

    public Usuario getIUsuario() {
        return iUsuario;
    }

    public void setIUsuario(Usuario iUsuario) {
        this.iUsuario = iUsuario;
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
        if (!(object instanceof AccesoUsuario)) {
            return false;
        }
        AccesoUsuario other = (AccesoUsuario) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.apifinmeridian.domain.AccesoUsuario[ iCodigo=" + iCodigo + " ]";
    }
    
}
