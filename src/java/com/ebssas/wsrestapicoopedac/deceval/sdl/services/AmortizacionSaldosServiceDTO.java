
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para amortizacionSaldosServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="amortizacionSaldosServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoAdministrador_AntCta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigoEmisor_AntCta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigoISIN_DocPag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuentaBeneficiario_DocPag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="exitoso" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="idDocumentoPagare_DocPag" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idUsuarioSession" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="mensajeRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombreUsuarioSession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numPagareEntidad_DocPag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="otrosValores_DetOpe" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorAmortizacionCapital_DetOpe" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorInteresesCtes_DetOpe" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorInteresesMora_DetOpe" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorPagado_DetOpe" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorSeguro_DetOpe" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "amortizacionSaldosServiceDTO", propOrder = {
    "codigoAdministradorAntCta",
    "codigoEmisorAntCta",
    "codigoISINDocPag",
    "cuentaBeneficiarioDocPag",
    "exitoso",
    "idDocumentoPagareDocPag",
    "idUsuarioSession",
    "mensajeRespuesta",
    "nombreUsuarioSession",
    "numPagareEntidadDocPag",
    "otrosValoresDetOpe",
    "valorAmortizacionCapitalDetOpe",
    "valorInteresesCtesDetOpe",
    "valorInteresesMoraDetOpe",
    "valorPagadoDetOpe",
    "valorSeguroDetOpe"
})
public class AmortizacionSaldosServiceDTO {

    @XmlElement(name = "codigoAdministrador_AntCta")
    protected String codigoAdministradorAntCta;
    @XmlElement(name = "codigoEmisor_AntCta")
    protected String codigoEmisorAntCta;
    @XmlElement(name = "codigoISIN_DocPag")
    protected String codigoISINDocPag;
    @XmlElement(name = "cuentaBeneficiario_DocPag")
    protected String cuentaBeneficiarioDocPag;
    protected Boolean exitoso;
    @XmlElement(name = "idDocumentoPagare_DocPag")
    protected Long idDocumentoPagareDocPag;
    protected Long idUsuarioSession;
    protected String mensajeRespuesta;
    protected String nombreUsuarioSession;
    @XmlElement(name = "numPagareEntidad_DocPag")
    protected String numPagareEntidadDocPag;
    @XmlElement(name = "otrosValores_DetOpe")
    protected BigDecimal otrosValoresDetOpe;
    @XmlElement(name = "valorAmortizacionCapital_DetOpe")
    protected BigDecimal valorAmortizacionCapitalDetOpe;
    @XmlElement(name = "valorInteresesCtes_DetOpe")
    protected BigDecimal valorInteresesCtesDetOpe;
    @XmlElement(name = "valorInteresesMora_DetOpe")
    protected BigDecimal valorInteresesMoraDetOpe;
    @XmlElement(name = "valorPagado_DetOpe")
    protected BigDecimal valorPagadoDetOpe;
    @XmlElement(name = "valorSeguro_DetOpe")
    protected BigDecimal valorSeguroDetOpe;

    /**
     * Obtiene el valor de la propiedad codigoAdministradorAntCta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAdministradorAntCta() {
        return codigoAdministradorAntCta;
    }

    /**
     * Define el valor de la propiedad codigoAdministradorAntCta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAdministradorAntCta(String value) {
        this.codigoAdministradorAntCta = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoEmisorAntCta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEmisorAntCta() {
        return codigoEmisorAntCta;
    }

    /**
     * Define el valor de la propiedad codigoEmisorAntCta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEmisorAntCta(String value) {
        this.codigoEmisorAntCta = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoISINDocPag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoISINDocPag() {
        return codigoISINDocPag;
    }

    /**
     * Define el valor de la propiedad codigoISINDocPag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoISINDocPag(String value) {
        this.codigoISINDocPag = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaBeneficiarioDocPag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuentaBeneficiarioDocPag() {
        return cuentaBeneficiarioDocPag;
    }

    /**
     * Define el valor de la propiedad cuentaBeneficiarioDocPag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuentaBeneficiarioDocPag(String value) {
        this.cuentaBeneficiarioDocPag = value;
    }

    /**
     * Obtiene el valor de la propiedad exitoso.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExitoso() {
        return exitoso;
    }

    /**
     * Define el valor de la propiedad exitoso.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExitoso(Boolean value) {
        this.exitoso = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumentoPagareDocPag.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDocumentoPagareDocPag() {
        return idDocumentoPagareDocPag;
    }

    /**
     * Define el valor de la propiedad idDocumentoPagareDocPag.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDocumentoPagareDocPag(Long value) {
        this.idDocumentoPagareDocPag = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuarioSession.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdUsuarioSession() {
        return idUsuarioSession;
    }

    /**
     * Define el valor de la propiedad idUsuarioSession.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdUsuarioSession(Long value) {
        this.idUsuarioSession = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajeRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    /**
     * Define el valor de la propiedad mensajeRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeRespuesta(String value) {
        this.mensajeRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreUsuarioSession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreUsuarioSession() {
        return nombreUsuarioSession;
    }

    /**
     * Define el valor de la propiedad nombreUsuarioSession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreUsuarioSession(String value) {
        this.nombreUsuarioSession = value;
    }

    /**
     * Obtiene el valor de la propiedad numPagareEntidadDocPag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumPagareEntidadDocPag() {
        return numPagareEntidadDocPag;
    }

    /**
     * Define el valor de la propiedad numPagareEntidadDocPag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumPagareEntidadDocPag(String value) {
        this.numPagareEntidadDocPag = value;
    }

    /**
     * Obtiene el valor de la propiedad otrosValoresDetOpe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtrosValoresDetOpe() {
        return otrosValoresDetOpe;
    }

    /**
     * Define el valor de la propiedad otrosValoresDetOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtrosValoresDetOpe(BigDecimal value) {
        this.otrosValoresDetOpe = value;
    }

    /**
     * Obtiene el valor de la propiedad valorAmortizacionCapitalDetOpe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorAmortizacionCapitalDetOpe() {
        return valorAmortizacionCapitalDetOpe;
    }

    /**
     * Define el valor de la propiedad valorAmortizacionCapitalDetOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorAmortizacionCapitalDetOpe(BigDecimal value) {
        this.valorAmortizacionCapitalDetOpe = value;
    }

    /**
     * Obtiene el valor de la propiedad valorInteresesCtesDetOpe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorInteresesCtesDetOpe() {
        return valorInteresesCtesDetOpe;
    }

    /**
     * Define el valor de la propiedad valorInteresesCtesDetOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorInteresesCtesDetOpe(BigDecimal value) {
        this.valorInteresesCtesDetOpe = value;
    }

    /**
     * Obtiene el valor de la propiedad valorInteresesMoraDetOpe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorInteresesMoraDetOpe() {
        return valorInteresesMoraDetOpe;
    }

    /**
     * Define el valor de la propiedad valorInteresesMoraDetOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorInteresesMoraDetOpe(BigDecimal value) {
        this.valorInteresesMoraDetOpe = value;
    }

    /**
     * Obtiene el valor de la propiedad valorPagadoDetOpe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPagadoDetOpe() {
        return valorPagadoDetOpe;
    }

    /**
     * Define el valor de la propiedad valorPagadoDetOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPagadoDetOpe(BigDecimal value) {
        this.valorPagadoDetOpe = value;
    }

    /**
     * Obtiene el valor de la propiedad valorSeguroDetOpe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorSeguroDetOpe() {
        return valorSeguroDetOpe;
    }

    /**
     * Define el valor de la propiedad valorSeguroDetOpe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorSeguroDetOpe(BigDecimal value) {
        this.valorSeguroDetOpe = value;
    }

}
