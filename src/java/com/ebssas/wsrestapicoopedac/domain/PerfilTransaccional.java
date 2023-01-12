/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PERFIL_TRANSACCIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilTransaccional.findAll", query = "SELECT p FROM PerfilTransaccional p")
    , @NamedQuery(name = "PerfilTransaccional.findByICodigo", query = "SELECT p FROM PerfilTransaccional p WHERE p.iCodigo = :iCodigo")
    , @NamedQuery(name = "PerfilTransaccional.findByNValor", query = "SELECT p FROM PerfilTransaccional p WHERE p.nValor = :nValor")
    , @NamedQuery(name = "PerfilTransaccional.findByINumTran", query = "SELECT p FROM PerfilTransaccional p WHERE p.iNumTran = :iNumTran")
    , @NamedQuery(name = "PerfilTransaccional.findByCEstado", query = "SELECT p FROM PerfilTransaccional p WHERE p.cEstado = :cEstado")})
public class PerfilTransaccional implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "N_VALOR")
    private BigInteger nValor;
    @Column(name = "I_NUM_TRAN")
    private BigInteger iNumTran;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @JoinColumn(name = "I_TRANSACCION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Transaccion iTransaccion;
    @JoinColumn(name = "I_USUARIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Usuario iUsuario;

    public PerfilTransaccional() {
    }

    public PerfilTransaccional(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public PerfilTransaccional(BigDecimal iCodigo, String cEstado) {
        this.iCodigo = iCodigo;
        this.cEstado = cEstado;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigInteger getNValor() {
        return nValor;
    }

    public void setNValor(BigInteger nValor) {
        this.nValor = nValor;
    }

    public BigInteger getINumTran() {
        return iNumTran;
    }

    public void setINumTran(BigInteger iNumTran) {
        this.iNumTran = iNumTran;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
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
        if (!(object instanceof PerfilTransaccional)) {
            return false;
        }
        PerfilTransaccional other = (PerfilTransaccional) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.PerfilTransaccional[ iCodigo=" + iCodigo + " ]";
    }
    
}
