
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para informacionPagareServiceNopdfDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="informacionPagareServiceNopdfDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="estadoPagare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaFirmaPagare" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaGrabacionPagare" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idEstadoPagare" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idPagareDeceval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nombreOtorgante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numPagareEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDocumentoOtorgante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoDocumentoOtorgante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "informacionPagareServiceNopdfDTO", propOrder = {
    "estadoPagare",
    "fechaFirmaPagare",
    "fechaGrabacionPagare",
    "idEstadoPagare",
    "idPagareDeceval",
    "nombreOtorgante",
    "numPagareEntidad",
    "numeroDocumentoOtorgante",
    "tipoDocumentoOtorgante"
})
public class InformacionPagareServiceNopdfDTO {

    protected String estadoPagare;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFirmaPagare;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaGrabacionPagare;
    protected Integer idEstadoPagare;
    protected Integer idPagareDeceval;
    protected String nombreOtorgante;
    protected String numPagareEntidad;
    protected String numeroDocumentoOtorgante;
    protected String tipoDocumentoOtorgante;

    /**
     * Obtiene el valor de la propiedad estadoPagare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoPagare() {
        return estadoPagare;
    }

    /**
     * Define el valor de la propiedad estadoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoPagare(String value) {
        this.estadoPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFirmaPagare.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFirmaPagare() {
        return fechaFirmaPagare;
    }

    /**
     * Define el valor de la propiedad fechaFirmaPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFirmaPagare(XMLGregorianCalendar value) {
        this.fechaFirmaPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaGrabacionPagare.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaGrabacionPagare() {
        return fechaGrabacionPagare;
    }

    /**
     * Define el valor de la propiedad fechaGrabacionPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaGrabacionPagare(XMLGregorianCalendar value) {
        this.fechaGrabacionPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad idEstadoPagare.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEstadoPagare() {
        return idEstadoPagare;
    }

    /**
     * Define el valor de la propiedad idEstadoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEstadoPagare(Integer value) {
        this.idEstadoPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad idPagareDeceval.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPagareDeceval() {
        return idPagareDeceval;
    }

    /**
     * Define el valor de la propiedad idPagareDeceval.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPagareDeceval(Integer value) {
        this.idPagareDeceval = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreOtorgante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreOtorgante() {
        return nombreOtorgante;
    }

    /**
     * Define el valor de la propiedad nombreOtorgante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreOtorgante(String value) {
        this.nombreOtorgante = value;
    }

    /**
     * Obtiene el valor de la propiedad numPagareEntidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumPagareEntidad() {
        return numPagareEntidad;
    }

    /**
     * Define el valor de la propiedad numPagareEntidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumPagareEntidad(String value) {
        this.numPagareEntidad = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumentoOtorgante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumentoOtorgante() {
        return numeroDocumentoOtorgante;
    }

    /**
     * Define el valor de la propiedad numeroDocumentoOtorgante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumentoOtorgante(String value) {
        this.numeroDocumentoOtorgante = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentoOtorgante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoOtorgante() {
        return tipoDocumentoOtorgante;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoOtorgante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoOtorgante(String value) {
        this.tipoDocumentoOtorgante = value;
    }

}
