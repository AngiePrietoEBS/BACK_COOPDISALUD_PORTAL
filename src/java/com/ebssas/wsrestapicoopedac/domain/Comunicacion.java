/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "COMUNICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunicacion.findAll", query = "SELECT c FROM Comunicacion c")
    , @NamedQuery(name = "Comunicacion.findByICodigo", query = "SELECT c FROM Comunicacion c WHERE c.iCodigo = :iCodigo")
    , @NamedQuery(name = "Comunicacion.findByCMensaje", query = "SELECT c FROM Comunicacion c WHERE c.cMensaje = :cMensaje")
    , @NamedQuery(name = "Comunicacion.findByFFechaComunicacion", query = "SELECT c FROM Comunicacion c WHERE c.fFechaComunicacion = :fFechaComunicacion")
    , @NamedQuery(name = "Comunicacion.findByCEstado", query = "SELECT c FROM Comunicacion c WHERE c.cEstado = :cEstado")})
@JsonIgnoreProperties({"iSolCredito"})
public class Comunicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_COMUNICACION", sequenceName = "SEC_COMUNICACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_COMUNICACION")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "C_MENSAJE")
    private String cMensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_COMUNICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaComunicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "C_ESTADO")
    private String cEstado;
    @JoinColumn(name = "I_SOL_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private SolicitudCredito iSolCredito;
    @JoinColumn(name = "I_TIPO_COMUNICACION", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoComunicacion iTipoComunicacion;
    @JoinColumn(name = "I_TIPO_MENSAJE", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoMensaje iTipoMensaje;

    public Comunicacion() {
    }

    public Comunicacion(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Comunicacion(Long iCodigo, String cMensaje, Date fFechaComunicacion, String cEstado) {
        this.iCodigo = iCodigo;
        this.cMensaje = cMensaje;
        this.fFechaComunicacion = fFechaComunicacion;
        this.cEstado = cEstado;
    }

    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getCMensaje() {
        return cMensaje;
    }

    public void setCMensaje(String cMensaje) {
        this.cMensaje = cMensaje;
    }

    public Date getFFechaComunicacion() {
        return fFechaComunicacion;
    }

    public void setFFechaComunicacion(Date fFechaComunicacion) {
        this.fFechaComunicacion = fFechaComunicacion;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }
    @XmlTransient
    public SolicitudCredito getISolCredito() {
        return iSolCredito;
    }

    public void setISolCredito(SolicitudCredito iSolCredito) {
        this.iSolCredito = iSolCredito;
    }

    public TipoComunicacion getITipoComunicacion() {
        return iTipoComunicacion;
    }

    public void setITipoComunicacion(TipoComunicacion iTipoComunicacion) {
        this.iTipoComunicacion = iTipoComunicacion;
    }

    public TipoMensaje getITipoMensaje() {
        return iTipoMensaje;
    }

    public void setITipoMensaje(TipoMensaje iTipoMensaje) {
        this.iTipoMensaje = iTipoMensaje;
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
        if (!(object instanceof Comunicacion)) {
            return false;
        }
        Comunicacion other = (Comunicacion) object;
        if ((this.iCodigo == null && other.iCodigo != null) || (this.iCodigo != null && !this.iCodigo.equals(other.iCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comunicacion{" + "iCodigo=" + iCodigo + ", cMensaje=" + cMensaje + ", fFechaComunicacion=" + fFechaComunicacion + ", cEstado=" + cEstado + ", iSolCredito=" + iSolCredito + ", iTipoComunicacion=" + iTipoComunicacion + ", iTipoMensaje=" + iTipoMensaje + '}';
    }

}
