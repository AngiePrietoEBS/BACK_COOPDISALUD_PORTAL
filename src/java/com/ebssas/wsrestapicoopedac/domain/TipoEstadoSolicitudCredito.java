/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "TIPO_ESTADO_SOLICITUD_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstadoSolicitudCredito.findAll", query = "SELECT t FROM TipoEstadoSolicitudCredito t")
    , @NamedQuery(name = "TipoEstadoSolicitudCredito.findByICodigo", query = "SELECT t FROM TipoEstadoSolicitudCredito t WHERE t.iCodigo = :iCodigo")
    , @NamedQuery(name = "TipoEstadoSolicitudCredito.findByCDescripcion", query = "SELECT t FROM TipoEstadoSolicitudCredito t WHERE t.cDescripcion = :cDescripcion")})
public class TipoEstadoSolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_DESCRIPCION")
    private String cDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iEstadoSolicitud")
    private List<SolicitudCredito> solicitudCreditoList;

    public TipoEstadoSolicitudCredito() {
    }

    public TipoEstadoSolicitudCredito(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public TipoEstadoSolicitudCredito(Long iCodigo, String cDescripcion) {
        this.iCodigo = iCodigo;
        this.cDescripcion = cDescripcion;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    @XmlTransient
    public List<SolicitudCredito> getSolicitudCreditoList() {
        return solicitudCreditoList;
    }

    public void setSolicitudCreditoList(List<SolicitudCredito> solicitudCreditoList) {
        this.solicitudCreditoList = solicitudCreditoList;
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
        if (!(object instanceof TipoEstadoSolicitudCredito)) {
            return false;
        }
        TipoEstadoSolicitudCredito other = (TipoEstadoSolicitudCredito) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoEstadoSolicitudCredito{" + "iCodigo=" + iCodigo + ", cDescripcion=" + cDescripcion + ", solicitudCreditoList=" + solicitudCreditoList + '}';
    }

}
