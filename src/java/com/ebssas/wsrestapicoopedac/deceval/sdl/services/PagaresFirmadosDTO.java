
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pagaresFirmadosDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pagaresFirmadosDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idDocumentoPagare" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identificacionEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mensajeRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numPagareEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagaresFirmadosDTO", propOrder = {
    "idDocumentoPagare",
    "identificacionEmisor",
    "mensajeRespuesta",
    "numPagareEntidad"
})
public class PagaresFirmadosDTO {

    protected Long idDocumentoPagare;
    protected String identificacionEmisor;
    protected String mensajeRespuesta;
    protected String numPagareEntidad;

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
     * Obtiene el valor de la propiedad identificacionEmisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacionEmisor() {
        return identificacionEmisor;
    }

    /**
     * Define el valor de la propiedad identificacionEmisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacionEmisor(String value) {
        this.identificacionEmisor = value;
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

}
