/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

//Biginteget 
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByICodigo", query = "SELECT p FROM Persona p WHERE p.iCodigo = :iCodigo"),
    @NamedQuery(name = "Persona.findByITipoIdent", query = "SELECT p FROM Persona p WHERE p.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "Persona.findByCIdentificacion", query = "SELECT p FROM Persona p WHERE p.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "Persona.findByCNombres", query = "SELECT p FROM Persona p WHERE p.cNombres = :cNombres"),
    @NamedQuery(name = "Persona.findByCApellidos", query = "SELECT p FROM Persona p WHERE p.cApellidos = :cApellidos"),
    @NamedQuery(name = "Persona.findByCEstado", query = "SELECT p FROM Persona p WHERE p.cEstado = :cEstado")})
public class Persona implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "I_TIPO_IDENT")
    private Long iTipoIdent;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_PERSONA", sequenceName = "SEC_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_PERSONA")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 200)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;

    @Size(min = 1, max = 500)
    @Column(name = "C_NOMBRES")
    private String cNombres;

    @Size(min = 1, max = 500)
    @Column(name = "C_APELLIDOS")
    private String cApellidos;

    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<InformacionConyuge> informacionConyugeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<DatosPersonales> datosPersonalesList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<InformacionPep> informacionPepList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<OcupacionPersona> ocupacionPersonaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<Usuario> usuarioList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<OperacionExtranjera> operacionExtranjeraList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iPersona")
    private List<OperacionFinanciera> operacionFinancieraList;

    public Persona() {
    }

    public Persona(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Persona(Long iCodigo, Long iTipoIdent, String cIdentificacion, String cNombres, String cApellidos, String cEstado) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(Long iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCApellidos() {
        return cApellidos;
    }

    public void setCApellidos(String cApellidos) {
        this.cApellidos = cApellidos;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    @XmlTransient
    public List<InformacionConyuge> getInformacionConyugeList() {
        return informacionConyugeList;
    }

    public void setInformacionConyugeList(List<InformacionConyuge> informacionConyugeList) {
        this.informacionConyugeList = informacionConyugeList;
    }

    @XmlTransient
    public List<DatosPersonales> getDatosPersonalesList() {
        return datosPersonalesList;
    }

    public void setDatosPersonalesList(List<DatosPersonales> datosPersonalesList) {
        this.datosPersonalesList = datosPersonalesList;
    }

    @XmlTransient
    public List<InformacionPep> getInformacionPepList() {
        return informacionPepList;
    }

    public void setInformacionPepList(List<InformacionPep> informacionPepList) {
        this.informacionPepList = informacionPepList;
    }

    @XmlTransient
    public List<OcupacionPersona> getOcupacionPersonaList() {
        return ocupacionPersonaList;
    }

    public void setOcupacionPersonaList(List<OcupacionPersona> ocupacionPersonaList) {
        this.ocupacionPersonaList = ocupacionPersonaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<OperacionExtranjera> getOperacionExtranjeraList() {
        return operacionExtranjeraList;
    }

    public void setOperacionExtranjeraList(List<OperacionExtranjera> operacionExtranjeraList) {
        this.operacionExtranjeraList = operacionExtranjeraList;
    }

    @XmlTransient
    public List<OperacionFinanciera> getOperacionFinancieraList() {
        return operacionFinancieraList;
    }

    public void setOperacionFinancieraList(List<OperacionFinanciera> operacionFinancieraList) {
        this.operacionFinancieraList = operacionFinancieraList;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.Persona[ iCodigo=" + iCodigo + " ]";
    }

   
    

}
