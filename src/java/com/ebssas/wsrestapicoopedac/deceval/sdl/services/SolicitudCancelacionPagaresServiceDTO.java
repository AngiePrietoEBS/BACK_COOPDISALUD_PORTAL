
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudCancelacionPagaresServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudCancelacionPagaresServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cancelacionPagaresDTO" type="{http://deceval.com/sdl/services/}cancelacionPagaresServiceDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "solicitudCancelacionPagaresServiceDTO", propOrder = {
    "cancelacionPagaresDTO",
    "header"
})
public class SolicitudCancelacionPagaresServiceDTO {

    @XmlElement(nillable = true)
    protected List<CancelacionPagaresServiceDTO> cancelacionPagaresDTO;
    protected HeaderDTO header;

    /**
     * Gets the value of the cancelacionPagaresDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelacionPagaresDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelacionPagaresDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelacionPagaresServiceDTO }
     * 
     * 
     */
    public List<CancelacionPagaresServiceDTO> getCancelacionPagaresDTO() {
        if (cancelacionPagaresDTO == null) {
            cancelacionPagaresDTO = new ArrayList<CancelacionPagaresServiceDTO>();
        }
        return this.cancelacionPagaresDTO;
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
