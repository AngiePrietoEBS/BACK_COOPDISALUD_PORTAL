
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudConsultarPagareDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudConsultarPagareDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="consultaPagareServiceDTO" type="{http://deceval.com/sdl/services/}consultaPagareServiceDTO" minOccurs="0"/&gt;
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
@XmlType(name = "solicitudConsultarPagareDTO", propOrder = {
    "consultaPagareServiceDTO",
    "header"
})
public class SolicitudConsultarPagareDTO {

    protected ConsultaPagareServiceDTO consultaPagareServiceDTO;
    protected HeaderDTO header;

    /**
     * Obtiene el valor de la propiedad consultaPagareServiceDTO.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaPagareServiceDTO }
     *     
     */
    public ConsultaPagareServiceDTO getConsultaPagareServiceDTO() {
        return consultaPagareServiceDTO;
    }

    /**
     * Define el valor de la propiedad consultaPagareServiceDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaPagareServiceDTO }
     *     
     */
    public void setConsultaPagareServiceDTO(ConsultaPagareServiceDTO value) {
        this.consultaPagareServiceDTO = value;
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
