/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIPO_COMUNICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoComunicacion.findAll", query = "SELECT t FROM TipoComunicacion t")
    , @NamedQuery(name = "TipoComunicacion.findByICodigo", query = "SELECT t FROM TipoComunicacion t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoComunicacion.findByCDescripcion", query = "SELECT t FROM TipoComunicacion t WHERE t.cDescripcion = :cDescripcion")
    , @NamedQuery(name = "TipoComunicacion.findByCEstado", query = "SELECT t FROM TipoComunicacion t WHERE t.cEstado = :cEstado")
    , @NamedQuery(name = "TipoComunicacion.findByIMaxCaracteres", query = "SELECT t FROM TipoComunicacion t WHERE t.iMaxCaracteres = :iMaxCaracteres")})
public class TipoComunicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_MAX_CARACTERES")
    private Long iMaxCaracteres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iTipoComunicacion")
    private List<Comunicacion> comunicacionList;

    public TipoComunicacion() {
    }

    public TipoComunicacion(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoComunicacion(Long iCodigo, String cDescripcion, String cEstado, Long iMaxCaracteres) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
        this.cEstado = cEstado;
        this.iMaxCaracteres = iMaxCaracteres;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
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

    public Long getIMaxCaracteres() {
        return iMaxCaracteres;
    }

    public void setIMaxCaracteres(Long iMaxCaracteres) {
        this.iMaxCaracteres = iMaxCaracteres;
    }

    @XmlTransient
    public List<Comunicacion> getComunicacionList() {
        return comunicacionList;
    }

    public void setComunicacionList(List<Comunicacion> comunicacionList) {
        this.comunicacionList = comunicacionList;
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
        if (!(object instanceof TipoComunicacion)) {
            return false;
        }
        TipoComunicacion other = (TipoComunicacion) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.TipoComunicacion[ iCodigo=" + iCodigo + " ]";
    }
    
}
