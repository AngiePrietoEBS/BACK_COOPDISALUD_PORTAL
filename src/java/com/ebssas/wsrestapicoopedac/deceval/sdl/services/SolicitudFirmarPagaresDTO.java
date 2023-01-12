
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudFirmarPagaresDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudFirmarPagaresDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://deceval.com/sdl/services/}headerDTO" minOccurs="0"/&gt;
 *         &lt;element name="informacionFirmaPagareDTO" type="{http://deceval.com/sdl/services/}informacionFirmaPagareDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudFirmarPagaresDTO", propOrder = {
    "header",
    "informacionFirmaPagareDTO"
})
@XmlSeeAlso({
    SolicitudFirmarPagaresConCertificadoDTO.class
})
public class SolicitudFirmarPagaresDTO {

    protected HeaderDTO header;
    protected InformacionFirmaPagareDTO informacionFirmaPagareDTO;

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
     * Obtiene el valor de la propiedad informacionFirmaPagareDTO.
     * 
     * @return
     *     possible object is
     *     {@link InformacionFirmaPagareDTO }
     *     
     */
    public InformacionFirmaPagareDTO getInformacionFirmaPagareDTO() {
        return informacionFirmaPagareDTO;
    }

    /**
     * Define el valor de la propiedad informacionFirmaPagareDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link InformacionFirmaPagareDTO }
     *     
     */
    public void setInformacionFirmaPagareDTO(InformacionFirmaPagareDTO value) {
        this.informacionFirmaPagareDTO = value;
    }

}
