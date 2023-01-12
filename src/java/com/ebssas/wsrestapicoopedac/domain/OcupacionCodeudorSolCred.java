/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "OCUPACION_CODEUDOR_SOL_CRED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OcupacionCodeudorSolCred.findAll", query = "SELECT o FROM OcupacionCodeudorSolCred o"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByICodigo", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.iCodigo = :iCodigo"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByCEmpresa", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.cEmpresa = :cEmpresa"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByCTelefono", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.cTelefono = :cTelefono"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByICargo", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.iCargo = :iCargo"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByIAniosServicio", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.iAniosServicio = :iAniosServicio"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByCIndependiente", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.cIndependiente = :cIndependiente"),
    @NamedQuery(name = "OcupacionCodeudorSolCred.findByCDireccion", query = "SELECT o FROM OcupacionCodeudorSolCred o WHERE o.cDireccion = :cDireccion")})
public class OcupacionCodeudorSolCred implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_OCUPACION_COD_SOL_CRED", sequenceName = "SEC_OCUPACION_COD_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_OCUPACION_COD_SOL_CRED")
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_EMPRESA")
    private String cEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "C_TELEFONO")
    private String cTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CARGO")
    private Long iCargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_ANIOS_SERVICIO")
    private Long iAniosServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_INDEPENDIENTE")
    private String cIndependiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "C_DIRECCION")
    private String cDireccion;
    @JoinColumn(name = "I_CODEUDOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CodeudorSolCred iCodeudor;

    public OcupacionCodeudorSolCred() {
    }

    public OcupacionCodeudorSolCred(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public OcupacionCodeudorSolCred(Long iCodigo, String cEmpresa, String cTelefono, Long iCargo, Long iAniosServicio, String cIndependiente, String cDireccion) {
        this.iCodigo = iCodigo;
        this.cEmpresa = cEmpresa;
        this.cTelefono = cTelefono;
        this.iCargo = iCargo;
        this.iAniosServicio = iAniosServicio;
        this.cIndependiente = cIndependiente;
        this.cDireccion = cDireccion;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCEmpresa() {
        return cEmpresa;
    }

    public void setCEmpresa(String cEmpresa) {
        this.cEmpresa = cEmpresa;
    }

    public String getCTelefono() {
        return cTelefono;
    }

    public void setCTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public Long getICargo() {
        return iCargo;
    }

    public void setICargo(Long iCargo) {
        this.iCargo = iCargo;
    }

    public Long getIAniosServicio() {
        return iAniosServicio;
    }

    public void setIAniosServicio(Long iAniosServicio) {
        this.iAniosServicio = iAniosServicio;
    }

    public String getCIndependiente() {
        return cIndependiente;
    }

    public void setCIndependiente(String cIndependiente) {
        this.cIndependiente = cIndependiente;
    }

    public String getCDireccion() {
        return cDireccion;
    }

    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    public CodeudorSolCred getICodeudor() {
        return iCodeudor;
    }

    public void setICodeudor(CodeudorSolCred iCodeudor) {
        this.iCodeudor = iCodeudor;
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
        if (!(object instanceof OcupacionCodeudorSolCred)) {
            return false;
        }
        OcupacionCodeudorSolCred other = (OcupacionCodeudorSolCred) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.OcupacionCodeudorSolCred[ iCodigo=" + iCodigo + " ]";
    }
    
}
