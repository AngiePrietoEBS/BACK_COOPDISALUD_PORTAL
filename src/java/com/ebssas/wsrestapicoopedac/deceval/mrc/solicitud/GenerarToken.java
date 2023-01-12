
package com.deceval.mrc.solicitud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.deceval.mrc.solicitud.to.InformacionPagareTO;


/**
 * <p>Clase Java para generarToken complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarToken"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="informacionPagareTO" type="{java:com.deceval.mrc.solicitud.model}InformacionPagareTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarToken", propOrder = {
    "informacionPagareTO"
})
public class GenerarToken {

    protected InformacionPagareTO informacionPagareTO;

    /**
     * Obtiene el valor de la propiedad informacionPagareTO.
     * 
     * @return
     *     possible object is
     *     {@link InformacionPagareTO }
     *     
     */
    public InformacionPagareTO getInformacionPagareTO() {
        return informacionPagareTO;
    }

    /**
     * Define el valor de la propiedad informacionPagareTO.
     * 
     * @param value
     *     allowed object is
     *     {@link InformacionPagareTO }
     *     
     */
    public void setInformacionPagareTO(InformacionPagareTO value) {
        this.informacionPagareTO = value;
    }

}
