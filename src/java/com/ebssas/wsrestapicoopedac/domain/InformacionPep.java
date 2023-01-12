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
@Table(name = "INFORMACION_PEP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionPep.findAll", query = "SELECT i FROM InformacionPep i")
    , @NamedQuery(name = "InformacionPep.findByICodigo", query = "SELECT i FROM InformacionPep i WHERE i.iCodigo = :iCodigo")
    , @NamedQuery(name = "InformacionPep.findByCReconocimientoPub", query = "SELECT i FROM InformacionPep i WHERE i.cReconocimientoPub = :cReconocimientoPub")
    , @NamedQuery(name = "InformacionPep.findByCRecursosPub", query = "SELECT i FROM InformacionPep i WHERE i.cRecursosPub = :cRecursosPub")
    , @NamedQuery(name = "InformacionPep.findByCEmpleadoPub", query = "SELECT i FROM InformacionPep i WHERE i.cEmpleadoPub = :cEmpleadoPub")
    , @NamedQuery(name = "InformacionPep.findByCRelacionPersonaPub", query = "SELECT i FROM InformacionPep i WHERE i.cRelacionPersonaPub = :cRelacionPersonaPub")
    , @NamedQuery(name = "InformacionPep.findByCNombres", query = "SELECT i FROM InformacionPep i WHERE i.cNombres = :cNombres")
    , @NamedQuery(name = "InformacionPep.findByITipoIdent", query = "SELECT i FROM InformacionPep i WHERE i.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "InformacionPep.findByCIdentificacion", query = "SELECT i FROM InformacionPep i WHERE i.cIdentificacion = :cIdentificacion")})
public class InformacionPep implements Serializable {

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
    @Column(name = "C_RECONOCIMIENTO_PUB")
    private String cReconocimientoPub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_RECURSOS_PUB")
    private String cRecursosPub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "C_EMPLEADO_PUB")
    private String cEmpleadoPub;
    @Size(max = 2)
    @Column(name = "C_RELACION_PERSONA_PUB")
    private String cRelacionPersonaPub;
    @Size(max = 255)
    @Column(name = "C_NOMBRES")
    private String cNombres;
    @Column(name = "I_TIPO_IDENT")
    private BigInteger iTipoIdent;
    @Size(max = 255)
    @Column(name = "C_IDENTIFICACION")
    private String cIdentificacion;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private Persona iPersona;
    @JoinColumn(name = "I_PARENTESCO", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private TipoParentesco iParentesco;

    public InformacionPep() {
    }

    public InformacionPep(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public InformacionPep(BigDecimal iCodigo, String cReconocimientoPub, String cRecursosPub, String cEmpleadoPub) {
        this.iCodigo = iCodigo;
        this.cReconocimientoPub = cReconocimientoPub;
        this.cRecursosPub = cRecursosPub;
        this.cEmpleadoPub = cEmpleadoPub;
    }

    public BigDecimal getICodigo() {
        return iCodigo;
    }

    public void setICodigo(BigDecimal iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCReconocimientoPub() {
        return cReconocimientoPub;
    }

    public void setCReconocimientoPub(String cReconocimientoPub) {
        this.cReconocimientoPub = cReconocimientoPub;
    }

    public String getCRecursosPub() {
        return cRecursosPub;
    }

    public void setCRecursosPub(String cRecursosPub) {
        this.cRecursosPub = cRecursosPub;
    }

    public String getCEmpleadoPub() {
        return cEmpleadoPub;
    }

    public void setCEmpleadoPub(String cEmpleadoPub) {
        this.cEmpleadoPub = cEmpleadoPub;
    }

    public String getCRelacionPersonaPub() {
        return cRelacionPersonaPub;
    }

    public void setCRelacionPersonaPub(String cRelacionPersonaPub) {
        this.cRelacionPersonaPub = cRelacionPersonaPub;
    }

    public String getCNombres() {
        return cNombres;
    }

    public void setCNombres(String cNombres) {
        this.cNombres = cNombres;
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

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
    }

    public TipoParentesco getIParentesco() {
        return iParentesco;
    }

    public void setIParentesco(TipoParentesco iParentesco) {
        this.iParentesco = iParentesco;
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
        if (!(object instanceof InformacionPep)) {
            return false;
        }
        InformacionPep other = (InformacionPep) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebssas.wsrestapicoopedac.domain.InformacionPep[ iCodigo=" + iCodigo + " ]";
    }
    
}
