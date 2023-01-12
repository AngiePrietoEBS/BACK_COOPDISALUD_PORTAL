/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "APERTURA_CUENTA_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AperturaCuentaSolCred.findAll", query = "SELECT a FROM AperturaCuentaSolCred a"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByICodigo", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.iCodigo = :iCodigo"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByITipoIdent", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByCIdentificacion", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByCNombres", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.cNombres = :cNombres"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByCApellidos", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.cApellidos = :cApellidos"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByFFechaExpedicion", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.fFechaExpedicion = :fFechaExpedicion"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByCDireccion", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.cDireccion = :cDireccion"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByICiudad", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.iCiudad = :iCiudad"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByCTelefono", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.cTelefono = :cTelefono"),
    @NamedQuery(name = "AperturaCuentaSolCred.findByCTipoCuenta", query = "SELECT a FROM AperturaCuentaSolCred a WHERE a.cTipoCuenta = :cTipoCuenta")})
public class AperturaCuentaSolCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_APER_CTA_SOL_CRED", sequenceName = "SEC_APER_CTA_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_APER_CTA_SOL_CRED")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_TIPO_IDENT")
    private Long iTipoIdent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_NOMBRES")
    private String cNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_APELLIDOS")
    private String cApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_EXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaExpedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_DIRECCION")
    private String cDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CIUDAD")
    private Long iCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "C_TELEFONO")
    private String cTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "C_TIPO_CUENTA")
    private String cTipoCuenta;
    @JoinColumn(name = "I_TIPO_CONDICION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CondicionCuenta iTipoCondicion;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolCredito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iAperturaCuentaSolCred", fetch = FetchType.EAGER)
    private List<BeneficiarioAperturaCta> beneficiarioAperturaCtaList;

    public AperturaCuentaSolCred() {
    }

    public AperturaCuentaSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public AperturaCuentaSolCred(Long iCodigo, Long iTipoIdent, String cIdentificacion, String cNombres, String cApellidos, Date fFechaExpedicion, String cDireccion, Long iCiudad, String cTelefono, String cTipoCuenta) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.fFechaExpedicion = fFechaExpedicion;
        this.cDireccion = cDireccion;
        this.iCiudad = iCiudad;
        this.cTelefono = cTelefono;
        this.cTipoCuenta = cTipoCuenta;
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

    public Date getFFechaExpedicion() {
        return fFechaExpedicion;
    }

    public void setFFechaExpedicion(Date fFechaExpedicion) {
        this.fFechaExpedicion = fFechaExpedicion;
    }

    public Date getfFechaNacimiento() {
        return fFechaNacimiento;
    }

    public void setfFechaNacimiento(Date fFechaNacimiento) {
        this.fFechaNacimiento = fFechaNacimiento;
    }

    public String getCDireccion() {
        return cDireccion;
    }

    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    public Long getICiudad() {
        return iCiudad;
    }

    public void setICiudad(Long iCiudad) {
        this.iCiudad = iCiudad;
    }

    public String getCTelefono() {
        return cTelefono;
    }

    public void setCTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public String getCTipoCuenta() {
        return cTipoCuenta;
    }

    public void setCTipoCuenta(String cTipoCuenta) {
        this.cTipoCuenta = cTipoCuenta;
    }

    public CondicionCuenta getITipoCondicion() {
        return iTipoCondicion;
    }

    public void setITipoCondicion(CondicionCuenta iTipoCondicion) {
        this.iTipoCondicion = iTipoCondicion;
    }

    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
    }

    @XmlTransient
    public List<BeneficiarioAperturaCta> getBeneficiarioAperturaCtaList() {
        return beneficiarioAperturaCtaList;
    }

    public void setBeneficiarioAperturaCtaList(List<BeneficiarioAperturaCta> beneficiarioAperturaCtaList) {
        this.beneficiarioAperturaCtaList = beneficiarioAperturaCtaList;
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
        if (!(object instanceof AperturaCuentaSolCred)) {
            return false;
        }
        AperturaCuentaSolCred other = (AperturaCuentaSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AperturaCuentaSolCred{" + "iCodigo=" + iCodigo + ", iTipoIdent=" + iTipoIdent + ", cIdentificacion=" + cIdentificacion + ", cNombres=" + cNombres + ", cApellidos=" + cApellidos + ", fFechaExpedicion=" + fFechaExpedicion + ", fFechaNacimiento=" + fFechaNacimiento + ", cDireccion=" + cDireccion + ", iCiudad=" + iCiudad + ", cTelefono=" + cTelefono + ", cTipoCuenta=" + cTipoCuenta + ", iTipoCondicion=" + iTipoCondicion + ", iSolCredito=" + iSolCredito + ", beneficiarioAperturaCtaList=" + beneficiarioAperturaCtaList + '}';
    }

    

}
