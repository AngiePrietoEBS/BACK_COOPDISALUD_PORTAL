/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TIPO_CANAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCanal.findAll", query = "SELECT t FROM TipoCanal t")
    , @NamedQuery(name = "TipoCanal.findByICodigo", query = "SELECT t FROM TipoCanal t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoCanal.findByCDescripcion", query = "SELECT t FROM TipoCanal t WHERE t.cDescripcion = :cDescripcion")})
public class TipoCanal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_TIPO_CANAL", sequenceName = "SEC_TIPO_CANAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_TIPO_CANAL")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Size(min = 1, max = 50)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @OneToMany(mappedBy = "iTipoCanal")
    private List<Evento> eventoList;
    @OneToMany(mappedBy = "iTipoCanal")
    private List<SessionUsuario> sessionUsuarioList;
    @OneToMany(mappedBy = "iTipoCanal")
    private List<AccesoUsuario> accesoUsuarioList;

    public TipoCanal() {
    }

    public TipoCanal(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoCanal(Long iCodigo, String cDescripcion) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
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

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<SessionUsuario> getSessionUsuarioList() {
        return sessionUsuarioList;
    }

    public void setSessionUsuarioList(List<SessionUsuario> sessionUsuarioList) {
        this.sessionUsuarioList = sessionUsuarioList;
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
        if (!(object instanceof TipoCanal)) {
            return false;
        }
        TipoCanal other = (TipoCanal) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.TipoCanal[ iCodigo=" + iCodigo + " ]";
    }
    
}
