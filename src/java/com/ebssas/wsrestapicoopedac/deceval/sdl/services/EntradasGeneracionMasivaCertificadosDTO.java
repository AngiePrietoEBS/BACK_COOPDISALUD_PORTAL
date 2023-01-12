
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para entradasGeneracionMasivaCertificadosDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="entradasGeneracionMasivaCertificadosDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoDeceval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noPagareDeceval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entradasGeneracionMasivaCertificadosDTO", propOrder = {
    "codigoDeceval",
    "noPagareDeceval"
})
public class EntradasGeneracionMasivaCertificadosDTO {

    protected String codigoDeceval;
    protected String noPagareDeceval;

    /**
     * Obtiene el valor de la propiedad codigoDeceval.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDeceval() {
        return codigoDeceval;
    }

    /**
     * Define el valor de la propiedad codigoDeceval.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDeceval(String value) {
        this.codigoDeceval = value;
    }

    /**
     * Obtiene el valor de la propiedad noPagareDeceval.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoPagareDeceval() {
        return noPagareDeceval;
    }

    /**
     * Define el valor de la propiedad noPagareDeceval.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoPagareDeceval(String value) {
        this.noPagareDeceval = value;
    }

}
