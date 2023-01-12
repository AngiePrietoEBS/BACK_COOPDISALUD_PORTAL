/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "SOLICITUD_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCredito.findAll", query = "SELECT s FROM SolicitudCredito s"),
    @NamedQuery(name = "SolicitudCredito.findByICodigo", query = "SELECT s FROM SolicitudCredito s WHERE s.iCodigo = :iCodigo"),
    @NamedQuery(name = "SolicitudCredito.findByINumRadic", query = "SELECT s FROM SolicitudCredito s WHERE s.iNumRadic = :iNumRadic"),
//    @NamedQuery(name = "SolicitudCredito.findByICodCred", query = "SELECT s FROM SolicitudCredito s WHERE s.iCodCred = :iCodCred"),
    @NamedQuery(name = "SolicitudCredito.findByFFechaSolicitud", query = "SELECT s FROM SolicitudCredito s WHERE s.fFechaSolicitud = :fFechaSolicitud"),
    @NamedQuery(name = "SolicitudCredito.findByNMontoSolicitado", query = "SELECT s FROM SolicitudCredito s WHERE s.nMontoSolicitado = :nMontoSolicitado"),
    @NamedQuery(name = "SolicitudCredito.findByIPlazo", query = "SELECT s FROM SolicitudCredito s WHERE s.iPlazo = :iPlazo"),
    @NamedQuery(name = "SolicitudCredito.findByNValorCuota", query = "SELECT s FROM SolicitudCredito s WHERE s.nValorCuota = :nValorCuota"),
    @NamedQuery(name = "SolicitudCredito.findByICodPeriodo", query = "SELECT s FROM SolicitudCredito s WHERE s.iCodPeriodo = :iCodPeriodo"),
    @NamedQuery(name = "SolicitudCredito.findByCRequiereCodeudor", query = "SELECT s FROM SolicitudCredito s WHERE s.cRequiereCodeudor = :cRequiereCodeudor"),
    @NamedQuery(name = "SolicitudCredito.findByCPagareCygnus", query = "SELECT s FROM SolicitudCredito s WHERE s.cPagareCygnus = :cPagareCygnus"),
    @NamedQuery(name = "SolicitudCredito.findByCPagareDeceval", query = "SELECT s FROM SolicitudCredito s WHERE s.cPagareDeceval = :cPagareDeceval")})
@JsonIgnoreProperties({"iNumeroCuenta"})
public class SolicitudCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEC_SOLICITUD_CREDITO", sequenceName = "SEC_SOLICITUD_CREDITO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_SOLICITUD_CREDITO")
    @NotNull
    @Column(name = "I_CODIGO")
    private Long iCodigo;
    @Column(name = "I_NUM_RADIC")
    private String iNumRadic;
//    @Column(name = "I_COD_CRED")
//    private BigInteger iCodCred;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaSolicitud;
    @Column(name = "N_MONTO_SOLICITADO")
    private Long nMontoSolicitado;
    @Column(name = "I_PLAZO")
    private Long iPlazo;
    @Column(name = "N_VALOR_CUOTA")
    private Long nValorCuota;
    @Column(name = "I_COD_PERIODO")
    private Long iCodPeriodo;
    @Size(max = 2)
    @Column(name = "C_REQUIERE_CODEUDOR")
    private String cRequiereCodeudor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iSolCredito")
    private List<ReferenciaSolCredito> referenciaSolCreditoList;
//    @JoinColumn(name = "I_CORRESPONDENCIA", referencedColumnName = "I_CODIGO")
//    @ManyToOne
//  private CorrespondenciaSolCredito iCorrespondencia;
    @JoinColumn(name = "I_ESTADO_SOLICITUD", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoEstadoSolicitudCredito iEstadoSolicitud;
    @JoinColumn(name = "I_TIPO_CREDITO", referencedColumnName = "I_CODIGO")
    @ManyToOne(optional = false)
    private TipoCredito iTipoCredito;
    @JoinColumn(name = "I_PERSONA", referencedColumnName = "I_CODIGO")
    @ManyToOne
    private Persona iPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iSolCredito")
    private List<InformacionDesembolso> informacionDesembolsoList;
    @OneToMany(mappedBy = "iSolCredito")
    private List<Comunicacion> comunicacionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iSolCredito")
    private List<HistoriaSolCredito> historiaSolCreditoList;

    @JoinColumn(name = "I_USUARIO_MODIFICADOR", referencedColumnName = "I_CODIGO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iUsuarioModificador;

    @Column(name = "F_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fFechaModificacion;
    
    @Size(max = 2)
    @Column(name = "C_NUM_RADIC")
    private String cNumRadic;
    
    @Column(name = "C_PAGARE_CYGNUS")
    private String cPagareCygnus;
    
    @Column(name = "C_PAGARE_DECEVAL")
    private String cPagareDeceval;
    
    @Lob
    @Column(name = "C_BASE64")
    private byte[] cBase64;
    
    @Transient
    private String iNumeroCuenta;
     
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iSolicitudCredito")
    private List<ProcesoPagareDeceval> procesoPagareDecevalCollection;
    
    public SolicitudCredito() {
        
    }
    
    public Long getICodigo() {
        return iCodigo;
    }

    public void setICodigo(Long iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String getINumRadic() {
        return iNumRadic;
    }

    public void setINumRadic(String iNumRadic) {
        this.iNumRadic = iNumRadic;
    }

    public Date getFFechaSolicitud() {
        return fFechaSolicitud;
    }

    public void setFFechaSolicitud(Date fFechaSolicitud) {
        this.fFechaSolicitud = fFechaSolicitud;
    }

    public Long getNMontoSolicitado() {
        return nMontoSolicitado;
    }

    public void setNMontoSolicitado(Long nMontoSolicitado) {
        this.nMontoSolicitado = nMontoSolicitado;
    }

    public Long getIPlazo() {
        return iPlazo;
    }

    public void setIPlazo(Long iPlazo) {
        this.iPlazo = iPlazo;
    }

    public Long getNValorCuota() {
        return nValorCuota;
    }

    public void setNValorCuota(Long nValorCuota) {
        this.nValorCuota = nValorCuota;
    }

    public Long getICodPeriodo() {
        return iCodPeriodo;
    }

    public void setICodPeriodo(Long iCodPeriodo) {
        this.iCodPeriodo = iCodPeriodo;
    }

    public String getCRequiereCodeudor() {
        return cRequiereCodeudor;
    }

    public void setCRequiereCodeudor(String cRequiereCodeudor) {
        this.cRequiereCodeudor = cRequiereCodeudor;
    }

    public List<ReferenciaSolCredito> getReferenciaSolCreditoList() {
        return referenciaSolCreditoList;
    }

    public void setReferenciaSolCreditoList(List<ReferenciaSolCredito> referenciaSolCreditoList) {
        this.referenciaSolCreditoList = referenciaSolCreditoList;
    }

    public TipoEstadoSolicitudCredito getIEstadoSolicitud() {
        return iEstadoSolicitud;
    }

    public void setIEstadoSolicitud(TipoEstadoSolicitudCredito iEstadoSolicitud) {
        this.iEstadoSolicitud = iEstadoSolicitud;
    }

    public TipoCredito getITipoCredito() {
        return iTipoCredito;
    }

    public void setITipoCredito(TipoCredito iTipoCredito) {
        this.iTipoCredito = iTipoCredito;
    }

    public Persona getIPersona() {
        return iPersona;
    }

    public void setIPersona(Persona iPersona) {
        this.iPersona = iPersona;
    }

    public List<InformacionDesembolso> getInformacionDesembolsoList() {
        return informacionDesembolsoList;
    }

    public void setInformacionDesembolsoList(List<InformacionDesembolso> informacionDesembolsoList) {
        this.informacionDesembolsoList = informacionDesembolsoList;
    }

    public List<Comunicacion> getComunicacionList() {
        return comunicacionList;
    }

    public void setComunicacionList(List<Comunicacion> comunicacionList) {
        this.comunicacionList = comunicacionList;
    }

    public List<HistoriaSolCredito> getHistoriaSolCreditoList() {
        return historiaSolCreditoList;
    }

    public void setHistoriaSolCreditoList(List<HistoriaSolCredito> historiaSolCreditoList) {
        this.historiaSolCreditoList = historiaSolCreditoList;
    }

    public Usuario getiUsuarioModificador() {
        return iUsuarioModificador;
    }

    public void setiUsuarioModificador(Usuario iUsuarioModificador) {
        this.iUsuarioModificador = iUsuarioModificador;
    }

    public Date getFFechaModificacion() {
        return fFechaModificacion;
    }

    public void setFFechaModificacion(Date fFechaModificacion) {
        this.fFechaModificacion = fFechaModificacion;
    }

    public String getCNumRadic() {
        return cNumRadic;
    }

    public void setCNumRadic(String cNumRadic) {
        this.cNumRadic = cNumRadic;
    }

    @XmlTransient
    public List<ProcesoPagareDeceval> getProcesoPagareDecevalCollection() {
        return procesoPagareDecevalCollection;
    }

    public void setProcesoPagareDecevalCollection(List<ProcesoPagareDeceval> procesoPagareDecevalCollection) {
        this.procesoPagareDecevalCollection = procesoPagareDecevalCollection;
    }
    
    public String getCPagareCygnus() {
        return cPagareCygnus;
    }

    public void setCPagareCygnus(String cPagareCygnus) {
        this.cPagareCygnus = cPagareCygnus;
    }
    
    public String getCPagareDeceval() {
        return cPagareDeceval;
    }

    public void setCPagareDeceval(String cPagareDeceval) {
        this.cPagareDeceval = cPagareDeceval;
    }
    
    public byte[] getCBase64() {
        return cBase64;
    }

    public void setCBase64(byte[] cBase64) {
        this.cBase64 = cBase64;
    }
    
  
    public String getINumeroCuenta() {
        return iNumeroCuenta;
    }
    
    
    public void setINumeroCuenta(String iNumeroCuenta) {
        this.iNumeroCuenta = iNumeroCuenta;
    }
    
    @Override
    public String toString() {
        return "SolicitudCredito{" + "iCodigo=" + iCodigo + ", iNumRadic=" + iNumRadic + ", fFechaSolicitud=" + fFechaSolicitud + ", nMontoSolicitado=" + nMontoSolicitado + ", iPlazo=" + iPlazo + ", nValorCuota=" + nValorCuota + ", iCodPeriodo=" + iCodPeriodo + ", cRequiereCodeudor=" + cRequiereCodeudor + ", iEstadoSolicitud=" + iEstadoSolicitud + ", iTipoCredito=" + iTipoCredito + ", iPersona=" + iPersona + ", iUsuarioModificador=" + iUsuarioModificador + ", fFechaModificacion=" + fFechaModificacion + '}';
    }    

}
