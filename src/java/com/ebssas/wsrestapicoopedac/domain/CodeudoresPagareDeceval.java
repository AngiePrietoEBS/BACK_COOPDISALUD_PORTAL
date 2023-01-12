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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andysierra
 */
@Entity
@Table(name = "CODEUDORES_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeudoresPagareDeceval.findAll", query = "SELECT c FROM CodeudoresPagareDeceval c"),
    @NamedQuery(name = "CodeudoresPagareDeceval.findByICodigo", query = "SELECT c FROM CodeudoresPagareDeceval c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "CodeudoresPagareDeceval.findByIGiradorTipoDoc", query = "SELECT c FROM CodeudoresPagareDeceval c WHERE c.iGiradorTipoDoc = :iGiradorTipoDoc"),
    @NamedQuery(name = "CodeudoresPagareDeceval.findByCGiradorNumDoc", query = "SELECT c FROM CodeudoresPagareDeceval c WHERE c.cGiradorNumDoc = :cGiradorNumDoc"),
    @NamedQuery(name = "CodeudoresPagareDeceval.findByCGiradorCta", query = "SELECT c FROM CodeudoresPagareDeceval c WHERE c.cGiradorCta = :cGiradorCta"),
    @NamedQuery(name = "CodeudoresPagareDeceval.findByCPersonaRepresentada", query = "SELECT c FROM CodeudoresPagareDeceval c WHERE c.cPersonaRepresentada = :cPersonaRepresentada")})
public class CodeudoresPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "I_GIRADOR_TIPO_DOC")
    private BigInteger iGiradorTipoDoc;
    @Column(name = "C_GIRADOR_NUM_DOC")
    private String cGiradorNumDoc;
    @Column(name = "C_GIRADOR_CTA")
    private String cGiradorCta;
    @Column(name = "C_PERSONA_REPRESENTADA")
    private String cPersonaRepresentada;
    @JoinColumn(name = "I_CREAR_PAGARE", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private CreacionPagareDeceval iCrearPagare;
    @JoinColumn(name = "I_ROL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private RolPersonaPagareDeceval iRol;

    public CodeudoresPagareDeceval() {
    }

    public CodeudoresPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigInteger getIGiradorTipoDoc() {
        return iGiradorTipoDoc;
    }

    public void setIGiradorTipoDoc(BigInteger iGiradorTipoDoc) {
        this.iGiradorTipoDoc = iGiradorTipoDoc;
    }

    public String getCGiradorNumDoc() {
        return cGiradorNumDoc;
    }

    public void setCGiradorNumDoc(String cGiradorNumDoc) {
        this.cGiradorNumDoc = cGiradorNumDoc;
    }

    public String getCGiradorCta() {
        return cGiradorCta;
    }

    public void setCGiradorCta(String cGiradorCta) {
        this.cGiradorCta = cGiradorCta;
    }

    public String getCPersonaRepresentada() {
        return cPersonaRepresentada;
    }

    public void setCPersonaRepresentada(String cPersonaRepresentada) {
        this.cPersonaRepresentada = cPersonaRepresentada;
    }

    public CreacionPagareDeceval getICrearPagare() {
        return iCrearPagare;
    }

    public void setICrearPagare(CreacionPagareDeceval iCrearPagare) {
        this.iCrearPagare = iCrearPagare;
    }

    public RolPersonaPagareDeceval getIRol() {
        return iRol;
    }

    public void setIRol(RolPersonaPagareDeceval iRol) {
        this.iRol = iRol;
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
        if (!(object instanceof CodeudoresPagareDeceval)) {
            return false;
        }
        CodeudoresPagareDeceval other = (CodeudoresPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.CodeudoresPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
