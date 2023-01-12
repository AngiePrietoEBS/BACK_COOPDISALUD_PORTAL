
package com.deceval.mrc.solicitud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.deceval.mrc.solicitud.to.InformacionFirmaPagareTO;


/**
 * <p>Clase Java para generarTokenResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarTokenResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{java:com.deceval.mrc.solicitud.model}InformacionFirmaPagareTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarTokenResponse", propOrder = {
    "_return"
})
public class GenerarTokenResponse {

    @XmlElement(name = "return")
    protected InformacionFirmaPagareTO _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link InformacionFirmaPagareTO }
     *     
     */
    public InformacionFirmaPagareTO getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link InformacionFirmaPagareTO }
     *     
     */
    public void setReturn(InformacionFirmaPagareTO value) {
        this._return = value;
    }

}
