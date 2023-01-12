
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudDesembolsoAnotarCuentaDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudDesembolsoAnotarCuentaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="desembolsoAnotarCuentaDTO" type="{http://deceval.com/sdl/services/}desembolsoAnotarCuentaDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "solicitudDesembolsoAnotarCuentaDTO", propOrder = {
    "desembolsoAnotarCuentaDTO",
    "header"
})
public class SolicitudDesembolsoAnotarCuentaDTO {

    @XmlElement(nillable = true)
    protected List<DesembolsoAnotarCuentaDTO> desembolsoAnotarCuentaDTO;
    protected HeaderDTO header;

    /**
     * Gets the value of the desembolsoAnotarCuentaDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the desembolsoAnotarCuentaDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDesembolsoAnotarCuentaDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DesembolsoAnotarCuentaDTO }
     * 
     * 
     */
    public List<DesembolsoAnotarCuentaDTO> getDesembolsoAnotarCuentaDTO() {
        if (desembolsoAnotarCuentaDTO == null) {
            desembolsoAnotarCuentaDTO = new ArrayList<DesembolsoAnotarCuentaDTO>();
        }
        return this.desembolsoAnotarCuentaDTO;
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
