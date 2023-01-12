
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudFirmarPagaresCaracteresDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudFirmarPagaresCaracteresDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://deceval.com/sdl/services/}headerDTO" minOccurs="0"/&gt;
 *         &lt;element name="informacionFirmaPagareCaracteresDTO" type="{http://deceval.com/sdl/services/}informacionFirmaPagareCaracteresDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudFirmarPagaresCaracteresDTO", propOrder = {
    "header",
    "informacionFirmaPagareCaracteresDTO"
})
public class SolicitudFirmarPagaresCaracteresDTO {

    protected HeaderDTO header;
    protected InformacionFirmaPagareCaracteresDTO informacionFirmaPagareCaracteresDTO;

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

    /**
     * Obtiene el valor de la propiedad informacionFirmaPagareCaracteresDTO.
     * 
     * @return
     *     possible object is
     *     {@link InformacionFirmaPagareCaracteresDTO }
     *     
     */
    public InformacionFirmaPagareCaracteresDTO getInformacionFirmaPagareCaracteresDTO() {
        return informacionFirmaPagareCaracteresDTO;
    }

    /**
     * Define el valor de la propiedad informacionFirmaPagareCaracteresDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link InformacionFirmaPagareCaracteresDTO }
     *     
     */
    public void setInformacionFirmaPagareCaracteresDTO(InformacionFirmaPagareCaracteresDTO value) {
        this.informacionFirmaPagareCaracteresDTO = value;
    }

}
