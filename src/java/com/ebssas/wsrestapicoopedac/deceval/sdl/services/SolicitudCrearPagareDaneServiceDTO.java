
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudCrearPagareDaneServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudCrearPagareDaneServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="documentoPagareServiceDTO" type="{http://deceval.com/sdl/services/}documentoPagareDaneServiceDTO" minOccurs="0"/&gt;
 *         &lt;element name="header" type="{http://deceval.com/sdl/services/}headerDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudCrearPagareDaneServiceDTO", propOrder = {
    "documentoPagareServiceDTO",
    "header"
})
public class SolicitudCrearPagareDaneServiceDTO {

    protected DocumentoPagareDaneServiceDTO documentoPagareServiceDTO;
    protected HeaderDTO header;

    /**
     * Obtiene el valor de la propiedad documentoPagareServiceDTO.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoPagareDaneServiceDTO }
     *     
     */
    public DocumentoPagareDaneServiceDTO getDocumentoPagareServiceDTO() {
        return documentoPagareServiceDTO;
    }

    /**
     * Define el valor de la propiedad documentoPagareServiceDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoPagareDaneServiceDTO }
     *     
     */
    public void setDocumentoPagareServiceDTO(DocumentoPagareDaneServiceDTO value) {
        this.documentoPagareServiceDTO = value;
    }

    /**
     * Obtiene el valor de la propiedad header.
     * 
     * @return
     *     possible object is
     *     {@link HeaderDTO }
     *     
     */
    public HeaderDTO getHeader() {
        return header;
    }

    /**
     * Define el valor de la propiedad header.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderDTO }
     *     
     */
    public void setHeader(HeaderDTO value) {
        this.header = value;
    }

}
