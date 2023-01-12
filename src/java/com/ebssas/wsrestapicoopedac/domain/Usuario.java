/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByICodigo", query = "SELECT u FROM Usuario u WHERE u.iCodigo = :iCodigo")
    , @NamedQuery(name = "Usuario.findByCEstado", query = "SELECT u FROM Usuario u WHERE u.cEstado = :cEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_USUARIO", sequenceName = "SEC_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_USUARIO")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    //@OneToMany(mappedBy = "iUsuarioCreador")
    //private List<SolicitudCredito> solicitudCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iUsuario")
    private List<PerfilTransaccional> perfilTransaccionalList;
    @OneToMany(mappedBy = "iUsuario")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iUsuario")
    private List<Acceso> accesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iUsuario")
    private List<SessionUsuario> sessionUsuarioList;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;
    @JoinColumn(name = "I_PERFIL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoPerfil iPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iUsuario")
    private List<AccesoUsuario> accesoUsuarioList;

    transient private int cCodMensaje;
    transient private String sMensaje;
    transient private Boolean bRta;
    public int getcCodMensaje() {
        return cCodMensaje;
    }

    public void setcCodMensaje(int cCodMensaje) {
        this.cCodMensaje = cCodMensaje;
    }

    public String getsMensaje() {
        return sMensaje;
    }

    public void setsMensaje(String sMensaje) {
        this.sMensaje = sMensaje;
    }

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }
    
    public Usuario() {
    }

    public Usuario(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Usuario(Long iCodigo, String cEstado) {
        this.iCodigo = iCodigo;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    /*@XmlTransient
    public List<SolicitudCredito> getSolicitudCreditoList() {
        return solicitudCreditoList;
    }

    public void setSolicitudCreditoList(List<SolicitudCredito> solicitudCreditoList) {
        this.solicitudCreditoList = solicitudCreditoList;
    }*/

    @XmlTransient
    public List<PerfilTransaccional> getPerfilTransaccionalList() {
        return perfilTransaccionalList;
    }

    public void setPerfilTransaccionalList(List<PerfilTransaccional> perfilTransaccionalList) {
        this.perfilTransaccionalList = perfilTransaccionalList;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    @XmlTransient
    public List<SessionUsuario> getSessionUsuarioList() {
        return sessionUsuarioList;
    }

    public void setSessionUsuarioList(List<SessionUsuario> sessionUsuarioList) {
        this.sessionUsuarioList = sessionUsuarioList;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
    }

    public TipoPerfil getIPerfil() {
        return iPerfil;
    }

    public void setIPerfil(TipoPerfil iPerfil) {
        this.iPerfil = iPerfil;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "iCodigo=" + iCodigo + ", cEstado=" + cEstado + ", perfilTransaccionalList=" + perfilTransaccionalList + ", eventoList=" + eventoList + ", accesoList=" + accesoList + ", sessionUsuarioList=" + sessionUsuarioList + ", iPersona=" + iPersona + ", iPerfil=" + iPerfil + ", accesoUsuarioList=" + accesoUsuarioList + ", cCodMensaje=" + cCodMensaje + ", sMensaje=" + sMensaje + ", bRta=" + bRta + '}';
    }

    
}
