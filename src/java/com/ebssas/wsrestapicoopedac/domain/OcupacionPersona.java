/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "OCUPACION_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OcupacionPersona.findAll", query = "SELECT o FROM OcupacionPersona o"),
    @NamedQuery(name = "OcupacionPersona.findByICodigo", query = "SELECT o FROM OcupacionPersona o WHERE o.iCodigo = :iCodigo"),
    @NamedQuery(name = "OcupacionPersona.findByITipoOcupacion", query = "SELECT o FROM OcupacionPersona o WHERE o.iTipoOcupacion = :iTipoOcupacion"),
    @NamedQuery(name = "OcupacionPersona.findByICargo", query = "SELECT o FROM OcupacionPersona o WHERE o.iCargo = :iCargo"),
    @NamedQuery(name = "OcupacionPersona.findByISectorEconomico", query = "SELECT o FROM OcupacionPersona o WHERE o.iSectorEconomico = :iSectorEconomico"),
    @NamedQuery(name = "OcupacionPersona.findByCEmpresa", query = "SELECT o FROM OcupacionPersona o WHERE o.cEmpresa = :cEmpresa"),
    @NamedQuery(name = "OcupacionPersona.findByFFechaIngreso", query = "SELECT o FROM OcupacionPersona o WHERE o.fFechaIngreso = :fFechaIngreso"),
    @NamedQuery(name = "OcupacionPersona.findByIAntiguedad", query = "SELECT o FROM OcupacionPersona o WHERE o.iAntiguedad = :iAntiguedad"),
    @NamedQuery(name = "OcupacionPersona.findByITipoContrato", query = "SELECT o FROM OcupacionPersona o WHERE o.iTipoContrato = :iTipoContrato"),
    @NamedQuery(name = "OcupacionPersona.findByCTelefonoEmpresa", query = "SELECT o FROM OcupacionPersona o WHERE o.cTelefonoEmpresa = :cTelefonoEmpresa"),
    @NamedQuery(name = "OcupacionPersona.findByIDepartamentoEmpresa", query = "SELECT o FROM OcupacionPersona o WHERE o.iDepartamentoEmpresa = :iDepartamentoEmpresa"),
    @NamedQuery(name = "OcupacionPersona.findByICiudadEmpresa", query = "SELECT o FROM OcupacionPersona o WHERE o.iCiudadEmpresa = :iCiudadEmpresa"),
    @NamedQuery(name = "OcupacionPersona.findByCDireccionEmpresa", query = "SELECT o FROM OcupacionPersona o WHERE o.cDireccionEmpresa = :cDireccionEmpresa")})
public class OcupacionPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_OCUPACION_PERSONA", sequenceName = "SEC_OCUPACION_PERSONA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_OCUPACION_PERSONA")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Column(name = "I_TIPO_OCUPACION")
    private BigInteger iTipoOcupacion;
    @Column(name = "I_CARGO")
    private BigInteger iCargo;
    @Column(name = "I_SECTOR_ECONOMICO")
    private BigInteger iSectorEconomico;
    @Column(name = "C_EMPRESA")
    private String cEmpresa;
    @Column(name = "F_FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaIngreso;
    @Column(name = "I_ANTIGUEDAD")
    private BigInteger iAntiguedad;
    @Column(name = "I_TIPO_CONTRATO")
    private BigInteger iTipoContrato;
    @Size(max = 255)
    @Column(name = "C_TELEFONO_EMPRESA")
    private String cTelefonoEmpresa;
    @Column(name = "I_DEPARTAMENTO_EMPRESA")
    private BigInteger iDepartamentoEmpresa;
    @Column(name = "I_CIUDAD_EMPRESA")
    private BigInteger iCiudadEmpresa;
    @Size(max = 255)
    @Column(name = "C_DIRECCION_EMPRESA")
    private String cDireccionEmpresa;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;

//    @JoinColumn(name = "I_TIPO_CLIENTE", referencedColumnName = "I_CODIGO")
//    @ManyToOne(optional = false)
//    private TipoCliente iTipoCliente;
    
    public OcupacionPersona() {
    }

    public OcupacionPersona(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigInteger getITipoOcupacion() {
        return iTipoOcupacion;
    }

    public void setITipoOcupacion(BigInteger iTipoOcupacion) {
        this.iTipoOcupacion = iTipoOcupacion;
    }

    public BigInteger getICargo() {
        return iCargo;
    }

    public void setICargo(BigInteger iCargo) {
        this.iCargo = iCargo;
    }

    public BigInteger getISectorEconomico() {
        return iSectorEconomico;
    }

    public void setISectorEconomico(BigInteger iSectorEconomico) {
        this.iSectorEconomico = iSectorEconomico;
    }

    public String getCEmpresa() {
        return cEmpresa;
    }

    public void setCEmpresa(String cEmpresa) {
        this.cEmpresa = cEmpresa;
    }

    public Date getFFechaIngreso() {
        return fFechaIngreso;
    }

    public void setFFechaIngreso(Date fFechaIngreso) {
        this.fFechaIngreso = fFechaIngreso;
    }

    public BigInteger getIAntiguedad() {
        return iAntiguedad;
    }

    public void setIAntiguedad(BigInteger iAntiguedad) {
        this.iAntiguedad = iAntiguedad;
    }

    public BigInteger getITipoContrato() {
        return iTipoContrato;
    }

    public void setITipoContrato(BigInteger iTipoContrato) {
        this.iTipoContrato = iTipoContrato;
    }

    public String getCTelefonoEmpresa() {
        return cTelefonoEmpresa;
    }

    public void setCTelefonoEmpresa(String cTelefonoEmpresa) {
        this.cTelefonoEmpresa = cTelefonoEmpresa;
    }

    public BigInteger getIDepartamentoEmpresa() {
        return iDepartamentoEmpresa;
    }

    public void setIDepartamentoEmpresa(BigInteger iDepartamentoEmpresa) {
        this.iDepartamentoEmpresa = iDepartamentoEmpresa;
    }

    public BigInteger getICiudadEmpresa() {
        return iCiudadEmpresa;
    }

    public void setICiudadEmpresa(BigInteger iCiudadEmpresa) {
        this.iCiudadEmpresa = iCiudadEmpresa;
    }

    public String getCDireccionEmpresa() {
        return cDireccionEmpresa;
    }

    public void setCDireccionEmpresa(String cDireccionEmpresa) {
        this.cDireccionEmpresa = cDireccionEmpresa;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
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
        if (!(object instanceof OcupacionPersona)) {
            return false;
        }
        OcupacionPersona other = (OcupacionPersona) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OcupacionPersona{" + "cEmpresa=" + cEmpresa + ", iTipoContrato=" + iTipoContrato + ", iPersona=" + iPersona + '}';
    }

    

}
