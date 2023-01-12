
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para informacionFirmaPagareDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="informacionFirmaPagareDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OTPPagare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OTPProcedimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="archivosAdjuntos" type="{http://deceval.com/sdl/services/}archivoAdjuntoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idDocumentoPagare" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idRolFirmante" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="motivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoDocumento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "informacionFirmaPagareDTO", propOrder = {
    "otpPagare",
    "otpProcedimiento",
    "archivosAdjuntos",
    "clave",
    "idDocumentoPagare",
    "idRolFirmante",
    "motivo",
    "numeroDocumento",
    "tipoDocumento"
})
public class InformacionFirmaPagareDTO {

    @XmlElement(name = "OTPPagare")
    protected String otpPagare;
    @XmlElement(name = "OTPProcedimiento")
    protected String otpProcedimiento;
    @XmlElement(nillable = true)
    protected List<ArchivoAdjuntoDTO> archivosAdjuntos;
    protected String clave;
    protected Long idDocumentoPagare;
    protected Long idRolFirmante;
    protected String motivo;
    protected String numeroDocumento;
    protected Integer tipoDocumento;

    /**
     * Obtiene el valor de la propiedad otpPagare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTPPagare() {
        return otpPagare;
    }

    /**
     * Define el valor de la propiedad otpPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTPPagare(String value) {
        this.otpPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad otpProcedimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTPProcedimiento() {
        return otpProcedimiento;
    }

    /**
     * Define el valor de la propiedad otpProcedimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTPProcedimiento(String value) {
        this.otpProcedimiento = value;
    }

    /**
     * Gets the value of the archivosAdjuntos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the archivosAdjuntos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArchivosAdjuntos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArchivoAdjuntoDTO }
     * 
     * 
     */
    public List<ArchivoAdjuntoDTO> getArchivosAdjuntos() {
        if (archivosAdjuntos == null) {
            archivosAdjuntos = new ArrayList<ArchivoAdjuntoDTO>();
        }
        return this.archivosAdjuntos;
    }

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumentoPagare.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDocumentoPagare() {
        return idDocumentoPagare;
    }

    /**
     * Define el valor de la propiedad idDocumentoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDocumentoPagare(Long value) {
        this.idDocumentoPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad idRolFirmante.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdRolFirmante() {
        return idRolFirmante;
    }

    /**
     * Define el valor de la propiedad idRolFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdRolFirmante(Long value) {
        this.idRolFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Define el valor de la propiedad motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define el valor de la propiedad numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoDocumento(Integer value) {
        this.tipoDocumento = value;
    }

}
