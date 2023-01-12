
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para informacionPagareServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="informacionPagareServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="estadoPagare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaFirmaPagare" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaGrabacionPagare" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idPagareDeceval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nombreOtorgante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numPagareEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDocumentoOtorgante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pdfPagare" type="{http://deceval.com/sdl/services/}archivoAdjuntoDTO" minOccurs="0"/&gt;
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
@XmlType(name = "informacionPagareServiceDTO", propOrder = {
    "estadoPagare",
    "fechaFirmaPagare",
    "fechaGrabacionPagare",
    "idPagareDeceval",
    "nombreOtorgante",
    "numPagareEntidad",
    "numeroDocumentoOtorgante",
    "pdfPagare",
    "tipoDocumentoOtorgante"
})
public class InformacionPagareServiceDTO {

    protected String estadoPagare;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFirmaPagare;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaGrabacionPagare;
    protected Integer idPagareDeceval;
    protected String nombreOtorgante;
    protected String numPagareEntidad;
    protected String numeroDocumentoOtorgante;
    protected ArchivoAdjuntoDTO pdfPagare;
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
     * Obtiene el valor de la propiedad pdfPagare.
     * 
     * @return
     *     possible object is
     *     {@link ArchivoAdjuntoDTO }
     *     
     */
    public ArchivoAdjuntoDTO getPdfPagare() {
        return pdfPagare;
    }

    /**
     * Define el valor de la propiedad pdfPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchivoAdjuntoDTO }
     *     
     */
    public void setPdfPagare(ArchivoAdjuntoDTO value) {
        this.pdfPagare = value;
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
