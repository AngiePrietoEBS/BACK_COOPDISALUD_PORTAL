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
@Table(name = "BENEFICIARIO_APERTURA_CTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeneficiarioAperturaCta.findAll", query = "SELECT b FROM BeneficiarioAperturaCta b"),
    @NamedQuery(name = "BeneficiarioAperturaCta.findByICodigo", query = "SELECT b FROM BeneficiarioAperturaCta b WHERE b.iCodigo = :iCodigo"),
    @NamedQuery(name = "BeneficiarioAperturaCta.findByCNombres", query = "SELECT b FROM BeneficiarioAperturaCta b WHERE b.cNombres = :cNombres"),
    @NamedQuery(name = "BeneficiarioAperturaCta.findByCApellidos", query = "SELECT b FROM BeneficiarioAperturaCta b WHERE b.cApellidos = :cApellidos"),
    @NamedQuery(name = "BeneficiarioAperturaCta.findByICiudad", query = "SELECT b FROM BeneficiarioAperturaCta b WHERE b.iCiudad = :iCiudad"),
    @NamedQuery(name = "BeneficiarioAperturaCta.findByCTelefono", query = "SELECT b FROM BeneficiarioAperturaCta b WHERE b.cTelefono = :cTelefono"),
    @NamedQuery(name = "BeneficiarioAperturaCta.findByNPorcentaje", query = "SELECT b FROM BeneficiarioAperturaCta b WHERE b.nPorcentaje = :nPorcentaje")})
public class BeneficiarioAperturaCta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_BEN_APER_CTA_SOL_CRED", sequenceName = "SEC_BEN_APER_CTA_SOL_CRED", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_BEN_APER_CTA_SOL_CRED")
    @Column(name = "I_CODIGO")
    private Long iCodigo;

    @Size(min = 1, max = 200)
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
    @Column(name = "I_CIUDAD")
    private Long iCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "C_TELEFONO")
    private String cTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_PORCENTAJE")
    private Long nPorcentaje;
    @JoinColumn(name = "I_APERTURA_CUENTA_SOL_CRED", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AperturaCuentaSolCred iAperturaCuentaSolCred;

    public BeneficiarioAperturaCta() {
    }

    public BeneficiarioAperturaCta(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BeneficiarioAperturaCta(Long iCodigo, String cIdentificacion, String cNombres, String cApellidos, Long iCiudad, String cTelefono, Long nPorcentaje) {
        this.iCodigo = iCodigo;
        this.cIdentificacion = cIdentificacion;
        this.cNombres = cNombres;
        this.cApellidos = cApellidos;
        this.iCiudad = iCiudad;
        this.cTelefono = cTelefono;
        this.nPorcentaje = nPorcentaje;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
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

    public Long getNPorcentaje() {
        return nPorcentaje;
    }

    public void setNPorcentaje(Long nPorcentaje) {
        this.nPorcentaje = nPorcentaje;
    }
    public AperturaCuentaSolCred getIAperturaCuentaSolCred() {
        return iAperturaCuentaSolCred;
    }

    public void setIAperturaCuentaSolCred(AperturaCuentaSolCred iAperturaCuentaSolCred) {
        this.iAperturaCuentaSolCred = iAperturaCuentaSolCred;
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
        if (!(object instanceof BeneficiarioAperturaCta)) {
            return false;
        }
        BeneficiarioAperturaCta other = (BeneficiarioAperturaCta) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BeneficiarioAperturaCta{" + "iCodigo=" + iCodigo + ", cIdentificacion=" + cIdentificacion + ", cNombres=" + cNombres + ", cApellidos=" + cApellidos + ", iCiudad=" + iCiudad + ", cTelefono=" + cTelefono + ", nPorcentaje=" + nPorcentaje + ", iAperturaCuentaSolCred=" + iAperturaCuentaSolCred + '}';
    }

    

}
