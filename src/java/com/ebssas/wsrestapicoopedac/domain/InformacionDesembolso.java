/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "INFORMACION_DESEMBOLSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionDesembolso.findAll", query = "SELECT i FROM InformacionDesembolso i"),
    @NamedQuery(name = "InformacionDesembolso.findByICodigo", query = "SELECT i FROM InformacionDesembolso i WHERE i.iCodigo = :iCodigo"),
    @NamedQuery(name = "InformacionDesembolso.findByCNumCuenta", query = "SELECT i FROM InformacionDesembolso i WHERE i.cNumCuenta = :cNumCuenta"),
    @NamedQuery(name = "InformacionDesembolso.findByIEntidadFinanciera", query = "SELECT i FROM InformacionDesembolso i WHERE i.iEntidadFinanciera = :iEntidadFinanciera"),
    @NamedQuery(name = "InformacionDesembolso.findByITipoCuenta", query = "SELECT i FROM InformacionDesembolso i WHERE i.iTipoCuenta = :iTipoCuenta"),
    @NamedQuery(name = "InformacionDesembolso.findByCNombresTitular", query = "SELECT i FROM InformacionDesembolso i WHERE i.cNombresTitular = :cNombresTitular"),
    @NamedQuery(name = "InformacionDesembolso.findByITipoIdent", query = "SELECT i FROM InformacionDesembolso i WHERE i.iTipoIdent = :iTipoIdent"),
    @NamedQuery(name = "InformacionDesembolso.findByCIdentificacion", query = "SELECT i FROM InformacionDesembolso i WHERE i.cIdentificacion = :cIdentificacion")})
@JsonIgnoreProperties({"iSolCredito"})
public class InformacionDesembolso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_INFO_DESEM_SOL_CRED", sequenceName = "SEC_INFO_DESEM_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_INFO_DESEM_SOL_CRED")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)

    @Size(min = 1, max = 255)
    @Column(name = "C_NUM_CUENTA")
    private String cNumCuenta;
    @Basic(optional = false)

    @Size(min = 1, max = 255)
    @Column(name = "I_ENTIDAD_FINANCIERA")
    private String iEntidadFinanciera;
    @Basic(optional = false)

    @Column(name = "I_TIPO_CUENTA")
    private BigInteger iTipoCuenta;
    @Basic(optional = false)

    @Size(min = 1, max = 255)
    @Column(name = "C_NOMBRES_TITULAR")
    private String cNombresTitular;
    @Basic(optional = false)

    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;
    @Basic(optional = false)

    @Size(min = 1, max = 255)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private SolicitudCredito iSolCredito; 
    @JoinColumn(name = "I_TIPO_DESEMBOLSO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoDesembolso iTipoDesembolso;

    public InformacionDesembolso() {
    }

    public InformacionDesembolso(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InformacionDesembolso(Long iCodigo, String cNumCuenta, String iEntidadFinanciera, BigInteger iTipoCuenta, String cNombresTitular, BigInteger iTipoIdent, String cIdentificacion) {
        this.iCodigo = iCodigo;
        this.cNumCuenta = cNumCuenta;
        this.iEntidadFinanciera = iEntidadFinanciera;
        this.iTipoCuenta = iTipoCuenta;
        this.cNombresTitular = cNombresTitular;
        this.iTipoIdent = iTipoIdent;
        this.cIdentificacion = cIdentificacion;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNumCuenta() {
        return cNumCuenta;
    }

    public void setCNumCuenta(String cNumCuenta) {
        this.cNumCuenta = cNumCuenta;
    }

    public String getIEntidadFinanciera() {
        return iEntidadFinanciera;
    }

    public void setIEntidadFinanciera(String iEntidadFinanciera) {
        this.iEntidadFinanciera = iEntidadFinanciera;
    }

    public BigInteger getITipoCuenta() {
        return iTipoCuenta;
    }

    public void setITipoCuenta(BigInteger iTipoCuenta) {
        this.iTipoCuenta = iTipoCuenta;
    }

    public String getCNombresTitular() {
        return cNombresTitular;
    }

    public void setCNombresTitular(String cNombresTitular) {
        this.cNombresTitular = cNombresTitular;
    }

    public BigInteger getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(BigInteger iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdentificacion() {
        return cIdentificacion;
    }

    public void setCIdentificacion(String cIdentificacion) {
        this.cIdentificacion = cIdentificacion;
    }

    @XmlTransient
    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
    }

    public TipoDesembolso getITipoDesembolso() {
        return iTipoDesembolso;
    }

    public void setITipoDesembolso(TipoDesembolso iTipoDesembolso) {
        this.iTipoDesembolso = iTipoDesembolso;
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
        if (!(object instanceof InformacionDesembolso)) {
            return false;
        }
        InformacionDesembolso other = (InformacionDesembolso) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InformacionDesembolso{" + "cNumCuenta=" + cNumCuenta + ", iTipoCuenta=" + iTipoCuenta + ", iSolCredito=" + iSolCredito + '}';
    }

}
