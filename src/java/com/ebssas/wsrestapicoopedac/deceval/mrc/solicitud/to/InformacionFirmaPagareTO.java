
package com.deceval.mrc.solicitud.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InformacionFirmaPagareTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InformacionFirmaPagareTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoError" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DescripcionError" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="UrlFirmaPagare" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformacionFirmaPagareTO", propOrder = {
    "codigoError",
    "descripcionError",
    "urlFirmaPagare",
    "token"
})
public class InformacionFirmaPagareTO {

    @XmlElement(name = "CodigoError", required = true, nillable = true)
    protected String codigoError;
    @XmlElement(name = "DescripcionError", required = true, nillable = true)
    protected String descripcionError;
    @XmlElement(name = "UrlFirmaPagare", required = true, nillable = true)
    protected String urlFirmaPagare;
    @XmlElement(name = "Token", required = true, nillable = true)
    protected String token;

    /**
     * Obtiene el valor de la propiedad codigoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Define el valor de la propiedad codigoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionError() {
        return descripcionError;
    }

    /**
     * Define el valor de la propiedad descripcionError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionError(String value) {
        this.descripcionError = value;
    }

    /**
     * Obtiene el valor de la propiedad urlFirmaPagare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlFirmaPagare() {
        return urlFirmaPagare;
    }

    /**
     * Define el valor de la propiedad urlFirmaPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlFirmaPagare(String value) {
        this.urlFirmaPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define el valor de la propiedad token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
