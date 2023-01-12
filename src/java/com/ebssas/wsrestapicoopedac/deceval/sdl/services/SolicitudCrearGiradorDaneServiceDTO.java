
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudCrearGiradorDaneServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudCrearGiradorDaneServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="crearGiradorDTO" type="{http://deceval.com/sdl/services/}crearGiradorDaneServiceDTO" minOccurs="0"/&gt;
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
@XmlType(name = "solicitudCrearGiradorDaneServiceDTO", propOrder = {
    "crearGiradorDTO",
    "header"
})
public class SolicitudCrearGiradorDaneServiceDTO {

    protected CrearGiradorDaneServiceDTO crearGiradorDTO;
    protected HeaderDTO header;

    /**
     * Obtiene el valor de la propiedad crearGiradorDTO.
     * 
     * @return
     *     possible object is
     *     {@link CrearGiradorDaneServiceDTO }
     *     
     */
    public CrearGiradorDaneServiceDTO getCrearGiradorDTO() {
        return crearGiradorDTO;
    }

    /**
     * Define el valor de la propiedad crearGiradorDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link CrearGiradorDaneServiceDTO }
     *     
     */
    public void setCrearGiradorDTO(CrearGiradorDaneServiceDTO value) {
        this.crearGiradorDTO = value;
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
