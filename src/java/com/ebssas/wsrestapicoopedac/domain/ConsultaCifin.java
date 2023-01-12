/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Administrador
 */

@Entity
@Table(name = "CONSULTA_CIFIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaCifin.findAll", query = "SELECT c FROM ConsultaCifin c")
    , @NamedQuery(name = "ConsultaCifin.findByICodigo", query = "SELECT c FROM ConsultaCifin c WHERE c.iCodigo = :iCodigo")
    , @NamedQuery(name = "ConsultaCifin.findByFFecConsulta", query = "SELECT c FROM ConsultaCifin c WHERE c.fFecConsulta = :fFecConsulta")
    , @NamedQuery(name = "ConsultaCifin.findByITipoIdent", query = "SELECT c FROM ConsultaCifin c WHERE c.iTipoIdent = :iTipoIdent")
    , @NamedQuery(name = "ConsultaCifin.findByCIdent", query = "SELECT c FROM ConsultaCifin c WHERE c.cIdent = :cIdent")})
public class ConsultaCifin {
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "I_CODIGO")
    @SequenceGenerator(name = "SEC_CONS_CIFIN", sequenceName = "SEC_CONS_CIFIN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CONS_CIFIN")
    private Long iCodigo;
    
    @Column(name = "F_FEC_CONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFecConsulta;
    @Column(name = "I_TIPO_IDENT")
    private Long iTipoIdent;
    @Size(min = 1, max = 255)
    @Column(name = "C_IDENT")
    private String cIdent;
    @Lob
    @Column(name = "C_RESPUESTA")
    private String cRespuesta;

    public ConsultaCifin() {
    }

    public ConsultaCifin(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public ConsultaCifin(Long iCodigo, Date fFecConsulta, Long iTipoIdent, String cIdent, String cRespuesta) {
        this.iCodigo = iCodigo;
        this.fFecConsulta = fFecConsulta;
        this.iTipoIdent = iTipoIdent;
        this.cIdent = cIdent;
        this.cRespuesta = cRespuesta;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Date getFFecConsulta() {
        return fFecConsulta;
    }

    public void setFFecConsulta(Date fFecConsulta) {
        this.fFecConsulta = fFecConsulta;
    }

    public Long getITipoIdent() {
        return iTipoIdent;
    }

    public void setITipoIdent(Long iTipoIdent) {
        this.iTipoIdent = iTipoIdent;
    }

    public String getCIdent() {
        return cIdent;
    }

    public void setCIdent(String cIdent) {
        this.cIdent = cIdent;
    }

    public String getCRespuesta() {
        return cRespuesta;
    }

    public void setCRespuesta(String cRespuesta) {
        this.cRespuesta = cRespuesta;
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
        if (!(object instanceof ConsultaCifin)) {
            return false;
        }
        ConsultaCifin other = (ConsultaCifin) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConsultaCifin{" + "iCodigo=" + iCodigo + ", fFecConsulta=" + fFecConsulta + ", iTipoIdent=" + iTipoIdent + ", cIdent=" + cIdent + ", cRespuesta=" + cRespuesta + '}';
    }
    
    
    
}
