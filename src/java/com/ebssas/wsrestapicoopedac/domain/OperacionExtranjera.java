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
@Table(name = "OPERACION_EXTRANJERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionExtranjera.findAll", query = "SELECT o FROM OperacionExtranjera o")
    , @NamedQuery(name = "OperacionExtranjera.findByICodigo", query = "SELECT o FROM OperacionExtranjera o WHERE o.iCodigo = :iCodigo")
    , @NamedQuery(name = "OperacionExtranjera.findByCRealizaOper", query = "SELECT o FROM OperacionExtranjera o WHERE o.cRealizaOper = :cRealizaOper")
    , @NamedQuery(name = "OperacionExtranjera.findByIPais", query = "SELECT o FROM OperacionExtranjera o WHERE o.iPais = :iPais")
    , @NamedQuery(name = "OperacionExtranjera.findByITipoOper", query = "SELECT o FROM OperacionExtranjera o WHERE o.iTipoOper = :iTipoOper")
    , @NamedQuery(name = "OperacionExtranjera.findByCPoseeProd", query = "SELECT o FROM OperacionExtranjera o WHERE o.cPoseeProd = :cPoseeProd")
    , @NamedQuery(name = "OperacionExtranjera.findByITipoCuenta", query = "SELECT o FROM OperacionExtranjera o WHERE o.iTipoCuenta = :iTipoCuenta")
    , @NamedQuery(name = "OperacionExtranjera.findByIEntidadFinanciera", query = "SELECT o FROM OperacionExtranjera o WHERE o.iEntidadFinanciera = :iEntidadFinanciera")
    , @NamedQuery(name = "OperacionExtranjera.findByCNumCuenta", query = "SELECT o FROM OperacionExtranjera o WHERE o.cNumCuenta = :cNumCuenta")
    , @NamedQuery(name = "OperacionExtranjera.findByIPaisCuenta", query = "SELECT o FROM OperacionExtranjera o WHERE o.iPaisCuenta = :iPaisCuenta")
    , @NamedQuery(name = "OperacionExtranjera.findByICiudadCuenta", query = "SELECT o FROM OperacionExtranjera o WHERE o.iCiudadCuenta = :iCiudadCuenta")
    , @NamedQuery(name = "OperacionExtranjera.findByNMonto", query = "SELECT o FROM OperacionExtranjera o WHERE o.nMonto = :nMonto")})
public class OperacionExtranjera implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_REALIZA_OPER")
    private String cRealizaOper;
    @Column(name = "I_PAIS")
    private BigInteger iPais;
    @Column(name = "I_TIPO_OPER")
    private BigInteger iTipoOper;
    @Size(max = 2)
    @Column(name = "C_POSEE_PROD")
    private String cPoseeProd;
    @Column(name = "I_TIPO_CUENTA")
    private BigInteger iTipoCuenta;
    @Column(name = "I_ENTIDAD_FINANCIERA")
    private BigInteger iEntidadFinanciera;
    @Size(max = 255)
    @Column(name = "C_NUM_CUENTA")
    private String cNumCuenta;
    @Column(name = "I_PAIS_CUENTA")
    private BigInteger iPaisCuenta;
    @Column(name = "I_CIUDAD_CUENTA")
    private BigInteger iCiudadCuenta;
    @Column(name = "N_MONTO")
    private BigInteger nMonto;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;

    public OperacionExtranjera() {
    }

    public OperacionExtranjera(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public OperacionExtranjera(BigDecimal iCodigo, String cRealizaOper) {
        this.iCodigo = iCodigo;
        this.cRealizaOper = cRealizaOper;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCRealizaOper() {
        return cRealizaOper;
    }

    public void setCRealizaOper(String cRealizaOper) {
        this.cRealizaOper = cRealizaOper;
    }

    public BigInteger getIPais() {
        return iPais;
    }

    public void setIPais(BigInteger iPais) {
        this.iPais = iPais;
    }

    public BigInteger getITipoOper() {
        return iTipoOper;
    }

    public void setITipoOper(BigInteger iTipoOper) {
        this.iTipoOper = iTipoOper;
    }

    public String getCPoseeProd() {
        return cPoseeProd;
    }

    public void setCPoseeProd(String cPoseeProd) {
        this.cPoseeProd = cPoseeProd;
    }

    public BigInteger getITipoCuenta() {
        return iTipoCuenta;
    }

    public void setITipoCuenta(BigInteger iTipoCuenta) {
        this.iTipoCuenta = iTipoCuenta;
    }

    public BigInteger getIEntidadFinanciera() {
        return iEntidadFinanciera;
    }

    public void setIEntidadFinanciera(BigInteger iEntidadFinanciera) {
        this.iEntidadFinanciera = iEntidadFinanciera;
    }

    public String getCNumCuenta() {
        return cNumCuenta;
    }

    public void setCNumCuenta(String cNumCuenta) {
        this.cNumCuenta = cNumCuenta;
    }

    public BigInteger getIPaisCuenta() {
        return iPaisCuenta;
    }

    public void setIPaisCuenta(BigInteger iPaisCuenta) {
        this.iPaisCuenta = iPaisCuenta;
    }

    public BigInteger getICiudadCuenta() {
        return iCiudadCuenta;
    }

    public void setICiudadCuenta(BigInteger iCiudadCuenta) {
        this.iCiudadCuenta = iCiudadCuenta;
    }

    public BigInteger getNMonto() {
        return nMonto;
    }

    public void setNMonto(BigInteger nMonto) {
        this.nMonto = nMonto;
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
        if (!(object instanceof OperacionExtranjera)) {
            return false;
        }
        OperacionExtranjera other = (OperacionExtranjera) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.OperacionExtranjera[ iCodigo=" + iCodigo + " ]";
    }
    
}
