/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CREACION_PAGARE_DECEVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreacionPagareDeceval.findAll", query = "SELECT c FROM CreacionPagareDeceval c"),
    @NamedQuery(name = "CreacionPagareDeceval.findByICodigo", query = "SELECT c FROM CreacionPagareDeceval c WHERE c.iCodigo = :iCodigo"),
    @NamedQuery(name = "CreacionPagareDeceval.findByIClaseDefinicionDocumento", query = "SELECT c FROM CreacionPagareDeceval c WHERE c.iClaseDefinicionDocumento = :iClaseDefinicionDocumento"),
    @NamedQuery(name = "CreacionPagareDeceval.findByCOtorganteCta", query = "SELECT c FROM CreacionPagareDeceval c WHERE c.cOtorganteCta = :cOtorganteCta"),
    @NamedQuery(name = "CreacionPagareDeceval.findByCOtorganteNumDoc", query = "SELECT c FROM CreacionPagareDeceval c WHERE c.cOtorganteNumDoc = :cOtorganteNumDoc"),
    @NamedQuery(name = "CreacionPagareDeceval.findByIOtorganteTipoDoc", query = "SELECT c FROM CreacionPagareDeceval c WHERE c.iOtorganteTipoDoc = :iOtorganteTipoDoc"),
    @NamedQuery(name = "CreacionPagareDeceval.findByCNitEmisor", query = "SELECT c FROM CreacionPagareDeceval c WHERE c.cNitEmisor = :cNitEmisor")})
public class CreacionPagareDeceval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "I_CODIGO")
    private BigDecimal iCodigo;
    @Column(name = "I_CLASE_DEFINICION_DOCUMENTO")
    private Integer iClaseDefinicionDocumento;
    @Column(name = "C_OTORGANTE_CTA")
    private String cOtorganteCta;
    @Column(name = "C_OTORGANTE_NUM_DOC")
    private String cOtorganteNumDoc;
    @Column(name = "I_OTORGANTE_TIPO_DOC")
    private BigInteger iOtorganteTipoDoc;
    @Column(name = "C_NIT_EMISOR")
    private String cNitEmisor;
    @JoinColumn(name = "I_CIUDAD_DESEMBOLSO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Ciudad iCiudadDesembolso;
    @JoinColumn(name = "I_DEPARTAMENTO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Departamento iDepartamento;
    @JoinColumn(name = "I_PAIS", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Pais iPais;
    @JoinColumn(name = "I_PROCESO_PAGARE_DECEVAL", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private ProcesoPagareDeceval iProcesoPagareDeceval;
    @JoinColumn(name = "I_TIPO_PAGARE", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoPagareDeceval iTipoPagare;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCreacionPagareDeceval")
    private Collection<RtaCrearPagareDeceval> rtaCrearPagareDecevalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iCrearPagare")
    private Collection<CodeudoresPagareDeceval> codeudoresPagareDecevalCollection;

    public CreacionPagareDeceval() {
    }

    public CreacionPagareDeceval(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Integer getIClaseDefinicionDocumento() {
        return iClaseDefinicionDocumento;
    }

    public void setIClaseDefinicionDocumento(Integer iClaseDefinicionDocumento) {
        this.iClaseDefinicionDocumento = iClaseDefinicionDocumento;
    }

    public String getCOtorganteCta() {
        return cOtorganteCta;
    }

    public void setCOtorganteCta(String cOtorganteCta) {
        this.cOtorganteCta = cOtorganteCta;
    }

    public String getCOtorganteNumDoc() {
        return cOtorganteNumDoc;
    }

    public void setCOtorganteNumDoc(String cOtorganteNumDoc) {
        this.cOtorganteNumDoc = cOtorganteNumDoc;
    }

    public BigInteger getIOtorganteTipoDoc() {
        return iOtorganteTipoDoc;
    }

    public void setIOtorganteTipoDoc(BigInteger iOtorganteTipoDoc) {
        this.iOtorganteTipoDoc = iOtorganteTipoDoc;
    }

    public String getCNitEmisor() {
        return cNitEmisor;
    }

    public void setCNitEmisor(String cNitEmisor) {
        this.cNitEmisor = cNitEmisor;
    }

    public Ciudad getICiudadDesembolso() {
        return iCiudadDesembolso;
    }

    public void setICiudadDesembolso(Ciudad iCiudadDesembolso) {
        this.iCiudadDesembolso = iCiudadDesembolso;
    }

    public Departamento getIDepartamento() {
        return iDepartamento;
    }

    public void setIDepartamento(Departamento iDepartamento) {
        this.iDepartamento = iDepartamento;
    }

    public Pais getIPais() {
        return iPais;
    }

    public void setIPais(Pais iPais) {
        this.iPais = iPais;
    }

    public ProcesoPagareDeceval getIProcesoPagareDeceval() {
        return iProcesoPagareDeceval;
    }

    public void setIProcesoPagareDeceval(ProcesoPagareDeceval iProcesoPagareDeceval) {
        this.iProcesoPagareDeceval = iProcesoPagareDeceval;
    }

    public TipoPagareDeceval getITipoPagare() {
        return iTipoPagare;
    }

    public void setITipoPagare(TipoPagareDeceval iTipoPagare) {
        this.iTipoPagare = iTipoPagare;
    }

    @XmlTransient
    public Collection<RtaCrearPagareDeceval> getRtaCrearPagareDecevalCollection() {
        return rtaCrearPagareDecevalCollection;
    }

    public void setRtaCrearPagareDecevalCollection(Collection<RtaCrearPagareDeceval> rtaCrearPagareDecevalCollection) {
        this.rtaCrearPagareDecevalCollection = rtaCrearPagareDecevalCollection;
    }

    @XmlTransient
    public Collection<CodeudoresPagareDeceval> getCodeudoresPagareDecevalCollection() {
        return codeudoresPagareDecevalCollection;
    }

    public void setCodeudoresPagareDecevalCollection(Collection<CodeudoresPagareDeceval> codeudoresPagareDecevalCollection) {
        this.codeudoresPagareDecevalCollection = codeudoresPagareDecevalCollection;
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
        if (!(object instanceof CreacionPagareDeceval)) {
            return false;
        }
        CreacionPagareDeceval other = (CreacionPagareDeceval) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.CreacionPagareDeceval[ iCodigo=" + iCodigo + " ]";
    }
    
}
