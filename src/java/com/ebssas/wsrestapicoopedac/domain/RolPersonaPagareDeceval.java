/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "ROL_PERSONA_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPersonaPagareDeceval.findAll", query = "SELECT r FROM RolPersonaPagareDeceval r"),
    @NamedQuery(name = "RolPersonaPagareDeceval.findByICodigo", query = "SELECT r FROM RolPersonaPagareDeceval r WHERE r.iCodigo = :iCodigo"),
    @NamedQuery(name = "RolPersonaPagareDeceval.findByCNombreRol", query = "SELECT r FROM RolPersonaPagareDeceval r WHERE r.cNombreRol = :cNombreRol")})
public class RolPersonaPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_NOMBRE_ROL")
    private String cNombreRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iRol")
    private Collection<CodeudoresPagareDeceval> codeudoresPagareDecevalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iRolFirmante")
    private Collection<FirmaPagareDeceval> firmaPagareDecevalCollection;

    public RolPersonaPagareDeceval() {
    }

    public RolPersonaPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCNombreRol() {
        return cNombreRol;
    }

    public void setCNombreRol(String cNombreRol) {
        this.cNombreRol = cNombreRol;
    }

    @XmlTransient
    public Collection<CodeudoresPagareDeceval> getCodeudoresPagareDecevalCollection() {
        return codeudoresPagareDecevalCollection;
    }

    public void setCodeudoresPagareDecevalCollection(Collection<CodeudoresPagareDeceval> codeudoresPagareDecevalCollection) {
        this.codeudoresPagareDecevalCollection = codeudoresPagareDecevalCollection;
    }

    @XmlTransient
    public Collection<FirmaPagareDeceval> getFirmaPagareDecevalCollection() {
        return firmaPagareDecevalCollection;
    }

    public void setFirmaPagareDecevalCollection(Collection<FirmaPagareDeceval> firmaPagareDecevalCollection) {
        this.firmaPagareDecevalCollection = firmaPagareDecevalCollection;
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
        if (!(object instanceof RolPersonaPagareDeceval)) {
            return false;
        }
        RolPersonaPagareDeceval other = (RolPersonaPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.RolPersonaPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
