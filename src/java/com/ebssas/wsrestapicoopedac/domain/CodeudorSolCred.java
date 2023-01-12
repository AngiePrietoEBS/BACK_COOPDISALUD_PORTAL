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
@Table(name = "CODEUDOR_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeudorSolCred.findAll", query = "SELECT c FROM CodeudorSolCred c"),
    @NamedQuery(name = "CodeudorSolCred.findByICodigo", query = "SELECT c FROM CodeudorSolCred c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "CodeudorSolCred.findByITipoIdent", query = "SELECT c FROM CodeudorSolCred c WHERE c.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "CodeudorSolCred.findByCIdentificacion", query = "SELECT c FROM CodeudorSolCred c WHERE c.cIdentificacion = :cIdentificacion"),
    @NamedQuery(name = "CodeudorSolCred.findByCNombres", query = "SELECT c FROM CodeudorSolCred c WHERE c.cNombres = :cNombres"),
    @NamedQuery(name = "CodeudorSolCred.findByCApellidos", query = "SELECT c FROM CodeudorSolCred c WHERE c.cApellidos = :cApellidos"),
    @NamedQuery(name = "CodeudorSolCred.findByFFechaNacimiento", query = "SELECT c FROM CodeudorSolCred c WHERE c.fFechaNacimiento = :fFechaNacimiento"),
    @NamedQuery(name = "CodeudorSolCred.findByFFechaExpedicion", query = "SELECT c FROM CodeudorSolCred c WHERE c.fFechaExpedicion = :fFechaExpedicion"),
    @NamedQuery(name = "CodeudorSolCred.findByCEstadoCivil", query = "SELECT c FROM CodeudorSolCred c WHERE c.cEstadoCivil = :cEstadoCivil"),
    @NamedQuery(name = "CodeudorSolCred.findByINumHijos", query = "SELECT c FROM CodeudorSolCred c WHERE c.iNumHijos = :iNumHijos"),
    @NamedQuery(name = "CodeudorSolCred.findByCProfesional", query = "SELECT c FROM CodeudorSolCred c WHERE c.cProfesional = :cProfesional"),
    @NamedQuery(name = "CodeudorSolCred.findByCProfesion", query = "SELECT c FROM CodeudorSolCred c WHERE c.cProfesion = :cProfesion"),
    @NamedQuery(name = "CodeudorSolCred.findByIEspecialidad", query = "SELECT c FROM CodeudorSolCred c WHERE c.iEspecialidad = :iEspecialidad"),
    @NamedQuery(name = "CodeudorSolCred.findByCDirResidencia", query = "SELECT c FROM CodeudorSolCred c WHERE c.cDirResidencia = :cDirResidencia"),
    @NamedQuery(name = "CodeudorSolCred.findByCBarrio", query = "SELECT c FROM CodeudorSolCred c WHERE c.cBarrio = :cBarrio"),
    @NamedQuery(name = "CodeudorSolCred.findByICiudad", query = "SELECT c FROM CodeudorSolCred c WHERE c.iCiudad = :iCiudad"),
    @NamedQuery(name = "CodeudorSolCred.findByCEmail", query = "SELECT c FROM CodeudorSolCred c WHERE c.cEmail = :cEmail")})
public class CodeudorSolCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_CODEUDOR_SOL_CRED", sequenceName = "SEC_CODEUDOR_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CODEUDOR_SOL_CRED")
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
    @Column(name = "F_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_EXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaExpedicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_ESTADO_CIVIL")
    private String cEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_NUM_HIJOS")
    private Long iNumHijos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_PROFESIONAL")
    private String cProfesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_PROFESION")
    private String cProfesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_ESPECIALIDAD")
    private Long iEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_DIR_RESIDENCIA")
    private String cDirResidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_BARRIO")
    private String cBarrio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CIUDAD")
    private Long iCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_EMAIL")
    private String cEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCodeudor", fetch = FetchType.EAGER)
    private List<ConyugueCodeudor> conyugueCodeudorList;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SolicitudCredito iSolCredito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCodeudor", fetch = FetchType.EAGER)
    private List<OcupacionCodeudorSolCred> ocupacionCodeudorSolCredList;

    public CodeudorSolCred() {
    }

    public CodeudorSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public CodeudorSolCred(Long iCodigo, Long iTipoIdent, String cIdentificacion, String cNombres, String cApellidos, Date fFechaNacimiento, Date fFechaExpedicion, String cEstadoCivil, Long iNumHijos, String cProfesional, String cProfesion, Long iEspecialidad, String cDirResidencia, String cBarrio, Long iCiudad, String cEmail) {
        this.iCodigo = iCodigo;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.fFechaNacimiento = fFechaNacimiento;
        this.fFechaExpedicion = fFechaExpedicion;
        this.cEstadoCivil = cEstadoCivil;
        this.iNumHijos = iNumHijos;
        this.cProfesional = cProfesional;
        this.cProfesion = cProfesion;
        this.iEspecialidad = iEspecialidad;
        this.cDirResidencia = cDirResidencia;
        this.cBarrio = cBarrio;
        this.iCiudad = iCiudad;
        this.cEmail = cEmail;
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

    public String getCEstadoCivil() {
        return cEstadoCivil;
    }

    public void setCEstadoCivil(String cEstadoCivil) {
        this.cEstadoCivil = cEstadoCivil;
    }

    public Long getINumHijos() {
        return iNumHijos;
    }

    public void setINumHijos(Long iNumHijos) {
        this.iNumHijos = iNumHijos;
    }

    public String getCProfesional() {
        return cProfesional;
    }

    public void setCProfesional(String cProfesional) {
        this.cProfesional = cProfesional;
    }

    public String getCProfesion() {
        return cProfesion;
    }

    public void setCProfesion(String cProfesion) {
        this.cProfesion = cProfesion;
    }

    public Long getIEspecialidad() {
        return iEspecialidad;
    }

    public void setIEspecialidad(Long iEspecialidad) {
        this.iEspecialidad = iEspecialidad;
    }

    public String getCDirResidencia() {
        return cDirResidencia;
    }

    public void setCDirResidencia(String cDirResidencia) {
        this.cDirResidencia = cDirResidencia;
    }

    public String getCBarrio() {
        return cBarrio;
    }

    public void setCBarrio(String cBarrio) {
        this.cBarrio = cBarrio;
    }

    public Long getICiudad() {
        return iCiudad;
    }

    public void setICiudad(Long iCiudad) {
        this.iCiudad = iCiudad;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    @XmlTransient
    public List<ConyugueCodeudor> getConyugueCodeudorList() {
        return conyugueCodeudorList;
    }

    public void setConyugueCodeudorList(List<ConyugueCodeudor> conyugueCodeudorList) {
        this.conyugueCodeudorList = conyugueCodeudorList;
    }

    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
    }

    @XmlTransient
    public List<OcupacionCodeudorSolCred> getOcupacionCodeudorSolCredList() {
        return ocupacionCodeudorSolCredList;
    }

    public void setOcupacionCodeudorSolCredList(List<OcupacionCodeudorSolCred> ocupacionCodeudorSolCredList) {
        this.ocupacionCodeudorSolCredList = ocupacionCodeudorSolCredList;
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
        if (!(object instanceof CodeudorSolCred)) {
            return false;
        }
        CodeudorSolCred other = (CodeudorSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.CodeudorSolCred[ iCodigo=" + iCodigo + " ]";
    }
    
}
