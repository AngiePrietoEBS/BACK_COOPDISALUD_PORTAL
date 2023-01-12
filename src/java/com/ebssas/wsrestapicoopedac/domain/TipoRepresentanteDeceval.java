/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "TIPO_REPRESENTANTE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRepresentanteDeceval.findAll", query = "SELECT t FROM TipoRepresentanteDeceval t"),
    @NamedQuery(name = "TipoRepresentanteDeceval.findByICodigo", query = "SELECT t FROM TipoRepresentanteDeceval t WHERE t.iCodigo = :iCodigo"),
    @NamedQuery(name = "TipoRepresentanteDeceval.findByCTipoRepresentante", query = "SELECT t FROM TipoRepresentanteDeceval t WHERE t.cTipoRepresentante = :cTipoRepresentante")})
public class TipoRepresentanteDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "C_TIPO_REPRESENTANTE")
    private String cTipoRepresentante;

    public TipoRepresentanteDeceval() {
    }

    public TipoRepresentanteDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCTipoRepresentante() {
        return cTipoRepresentante;
    }

    public void setCTipoRepresentante(String cTipoRepresentante) {
        this.cTipoRepresentante = cTipoRepresentante;
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
        if (!(object instanceof TipoRepresentanteDeceval)) {
            return false;
        }
        TipoRepresentanteDeceval other = (TipoRepresentanteDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.TipoRepresentanteDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
