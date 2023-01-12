
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudCertificadoFirmaPDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudCertificadoFirmaPDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://deceval.com/sdl/services/}headerDTO" minOccurs="0"/&gt;
 *         &lt;element name="infoCertificadoFirmaDTO" type="{http://deceval.com/sdl/services/}infoCertificadoFirmaDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudCertificadoFirmaPDTO", propOrder = {
    "header",
    "infoCertificadoFirmaDTO"
})
public class SolicitudCertificadoFirmaPDTO {

    protected HeaderDTO header;
    protected InfoCertificadoFirmaDTO infoCertificadoFirmaDTO;

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
     * Obtiene el valor de la propiedad infoCertificadoFirmaDTO.
     * 
     * @return
     *     possible object is
     *     {@link InfoCertificadoFirmaDTO }
     *     
     */
    public InfoCertificadoFirmaDTO getInfoCertificadoFirmaDTO() {
        return infoCertificadoFirmaDTO;
    }

    /**
     * Define el valor de la propiedad infoCertificadoFirmaDTO.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoCertificadoFirmaDTO }
     *     
     */
    public void setInfoCertificadoFirmaDTO(InfoCertificadoFirmaDTO value) {
        this.infoCertificadoFirmaDTO = value;
    }

}
