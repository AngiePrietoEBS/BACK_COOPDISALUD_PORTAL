/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "CREACION_GIRADOR_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreacionGiradorDeceval.findAll", query = "SELECT c FROM CreacionGiradorDeceval c"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByICodigo", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCNombres", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cNombres = :cNombres"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCPrimerApellido", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cPrimerApellido = :cPrimerApellido"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCSegundoApellido", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cSegundoApellido = :cSegundoApellido"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByITipoDocumento", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.iTipoDocumento = :iTipoDocumento"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCNumDocumento", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cNumDocumento = :cNumDocumento"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByFFechaNacimiento", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.fFechaNacimiento = :fFechaNacimiento"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByFFechaExpedicion", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.fFechaExpedicion = :fFechaExpedicion"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCIdentificacionEmisor", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cIdentificacionEmisor = :cIdentificacionEmisor"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCCorreo", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cCorreo = :cCorreo"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCNumCelular", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cNumCelular = :cNumCelular"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCTelefono1", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cTelefono1 = :cTelefono1"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCTelefono2", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cTelefono2 = :cTelefono2"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCTelefono3", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cTelefono3 = :cTelefono3"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCDireccion1", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cDireccion1 = :cDireccion1"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCDireccion2", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cDireccion2 = :cDireccion2"),
    @NamedQuery(name = "CreacionGiradorDeceval.findByCDireccion3", query = "SELECT c FROM CreacionGiradorDeceval c WHERE c.cDireccion3 = :cDireccion3")})
public class CreacionGiradorDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_NOMBRES")
    private String cNombres;
    @Column(name = "C_PRIMER_APELLIDO")
    private String cPrimerApellido;
    @Column(name = "C_SEGUNDO_APELLIDO")
    private String cSegundoApellido;
    @Column(name = "I_TIPO_DOCUMENTO")
    private BigInteger iTipoDocumento;
    @Column(name = "C_NUM_DOCUMENTO")
    private String cNumDocumento;
    @Column(name = "F_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaNacimiento;
    @Column(name = "F_FECHA_EXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaExpedicion;
    @Column(name = "C_IDENTIFICACION_EMISOR")
    private String cIdentificacionEmisor;
    @Column(name = "C_CORREO")
    private String cCorreo;
    @Column(name = "C_NUM_CELULAR")
    private String cNumCelular;
    @Column(name = "C_TELEFONO_1")
    private String cTelefono1;
    @Column(name = "C_TELEFONO_2")
    private String cTelefono2;
    @Column(name = "C_TELEFONO_3")
    private String cTelefono3;
    @Column(name = "C_DIRECCION_1")
    private String cDireccion1;
    @Column(name = "C_DIRECCION_2")
    private String cDireccion2;
    @Column(name = "C_DIRECCION_3")
    private String cDireccion3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCreacionGiradorDeceval")
    private Collection<RtaCrearGiradorDeceval> rtaCrearGiradorDecevalCollection;
    @JoinColumn(name = "I_CIUDAD_EXPEDICION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Ciudad iCiudadExpedicion;
    @JoinColumn(name = "I_CIUDAD_DOMICILIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Ciudad iCiudadDomicilio;
    @JoinColumn(name = "I_CLASE_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private ClasePersonaDeceval iClasePersona;
    @JoinColumn(name = "I_DEPARTAMENTO_EXPEDICION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Departamento iDepartamentoExpedicion;
    @JoinColumn(name = "I_DEPARTAMENTO_DOMICILIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Departamento iDepartamentoDomicilio;
    @JoinColumn(name = "I_PAIS_NACIONALIDAD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Pais iPaisNacionalidad;
    @JoinColumn(name = "I_PAIS_DOMICILIO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Pais iPaisDomicilio;
    @JoinColumn(name = "I_PAIS_EXPEDICION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Pais iPaisExpedicion;
    @JoinColumn(name = "I_PROCESO_PAGARE_DECEVAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private ProcesoPagareDeceval iProcesoPagareDeceval;

    public CreacionGiradorDeceval() {
    }

    public CreacionGiradorDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
    }

    public String getCPrimerApellido() {
        return cPrimerApellido;
    }

    public void setCPrimerApellido(String cPrimerApellido) {
        this.cPrimerApellido = cPrimerApellido;
    }

    public String getCSegundoApellido() {
        return cSegundoApellido;
    }

    public void setCSegundoApellido(String cSegundoApellido) {
        this.cSegundoApellido = cSegundoApellido;
    }

    public BigInteger getITipoDocumento() {
        return iTipoDocumento;
    }

    public void setITipoDocumento(BigInteger iTipoDocumento) {
        this.iTipoDocumento = iTipoDocumento;
    }

    public String getCNumDocumento() {
        return cNumDocumento;
    }

    public void setCNumDocumento(String cNumDocumento) {
        this.cNumDocumento = cNumDocumento;
    }

    public Date getFFechaNacimiento() {
        return fFechaNacimiento;
    }

    public void setFFechaNacimiento(Date fFechaNacimiento) {
        this.fFechaNacimiento = fFechaNacimiento;
    }

    public Date getFFechaExpedicion() {
        return fFechaExpedicion;
    }

    public void setFFechaExpedicion(Date fFechaExpedicion) {
        this.fFechaExpedicion = fFechaExpedicion;
    }

    public String getCIdentificacionEmisor() {
        return cIdentificacionEmisor;
    }

    public void setCIdentificacionEmisor(String cIdentificacionEmisor) {
        this.cIdentificacionEmisor = cIdentificacionEmisor;
    }

    public String getCCorreo() {
        return cCorreo;
    }

    public void setCCorreo(String cCorreo) {
        this.cCorreo = cCorreo;
    }

    public String getCNumCelular() {
        return cNumCelular;
    }

    public void setCNumCelular(String cNumCelular) {
        this.cNumCelular = cNumCelular;
    }

    public String getCTelefono1() {
        return cTelefono1;
    }

    public void setCTelefono1(String cTelefono1) {
        this.cTelefono1 = cTelefono1;
    }

    public String getCTelefono2() {
        return cTelefono2;
    }

    public void setCTelefono2(String cTelefono2) {
        this.cTelefono2 = cTelefono2;
    }

    public String getCTelefono3() {
        return cTelefono3;
    }

    public void setCTelefono3(String cTelefono3) {
        this.cTelefono3 = cTelefono3;
    }

    public String getCDireccion1() {
        return cDireccion1;
    }

    public void setCDireccion1(String cDireccion1) {
        this.cDireccion1 = cDireccion1;
    }

    public String getCDireccion2() {
        return cDireccion2;
    }

    public void setCDireccion2(String cDireccion2) {
        this.cDireccion2 = cDireccion2;
    }

    public String getCDireccion3() {
        return cDireccion3;
    }

    public void setCDireccion3(String cDireccion3) {
        this.cDireccion3 = cDireccion3;
    }

    @XmlTransient
    public Collection<RtaCrearGiradorDeceval> getRtaCrearGiradorDecevalCollection() {
        return rtaCrearGiradorDecevalCollection;
    }

    public void setRtaCrearGiradorDecevalCollection(Collection<RtaCrearGiradorDeceval> rtaCrearGiradorDecevalCollection) {
        this.rtaCrearGiradorDecevalCollection = rtaCrearGiradorDecevalCollection;
    }

    public Ciudad getICiudadExpedicion() {
        return iCiudadExpedicion;
    }

    public void setICiudadExpedicion(Ciudad iCiudadExpedicion) {
        this.iCiudadExpedicion = iCiudadExpedicion;
    }

    public Ciudad getICiudadDomicilio() {
        return iCiudadDomicilio;
    }

    public void setICiudadDomicilio(Ciudad iCiudadDomicilio) {
        this.iCiudadDomicilio = iCiudadDomicilio;
    }

    public ClasePersonaDeceval getIClasePersona() {
        return iClasePersona;
    }

    public void setIClasePersona(ClasePersonaDeceval iClasePersona) {
        this.iClasePersona = iClasePersona;
    }

    public Departamento getIDepartamentoExpedicion() {
        return iDepartamentoExpedicion;
    }

    public void setIDepartamentoExpedicion(Departamento iDepartamentoExpedicion) {
        this.iDepartamentoExpedicion = iDepartamentoExpedicion;
    }

    public Departamento getIDepartamentoDomicilio() {
        return iDepartamentoDomicilio;
    }

    public void setIDepartamentoDomicilio(Departamento iDepartamentoDomicilio) {
        this.iDepartamentoDomicilio = iDepartamentoDomicilio;
    }

    public Pais getIPaisNacionalidad() {
        return iPaisNacionalidad;
    }

    public void setIPaisNacionalidad(Pais iPaisNacionalidad) {
        this.iPaisNacionalidad = iPaisNacionalidad;
    }

    public Pais getIPaisDomicilio() {
        return iPaisDomicilio;
    }

    public void setIPaisDomicilio(Pais iPaisDomicilio) {
        this.iPaisDomicilio = iPaisDomicilio;
    }

    public Pais getIPaisExpedicion() {
        return iPaisExpedicion;
    }

    public void setIPaisExpedicion(Pais iPaisExpedicion) {
        this.iPaisExpedicion = iPaisExpedicion;
    }

    public ProcesoPagareDeceval getIProcesoPagareDeceval() {
        return iProcesoPagareDeceval;
    }

    public void setIProcesoPagareDeceval(ProcesoPagareDeceval iProcesoPagareDeceval) {
        this.iProcesoPagareDeceval = iProcesoPagareDeceval;
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
        if (!(object instanceof CreacionGiradorDeceval)) {
            return false;
        }
        CreacionGiradorDeceval other = (CreacionGiradorDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.CreacionGiradorDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
