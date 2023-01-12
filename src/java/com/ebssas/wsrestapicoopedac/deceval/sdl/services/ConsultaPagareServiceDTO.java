
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultaPagareServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultaPagareServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoDeceval" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idEstadoPagare" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idTipoIdentificacionFirmante" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="numIdentificacionFirmante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numPagareEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaPagareServiceDTO", propOrder = {
    "codigoDeceval",
    "idEstadoPagare",
    "idTipoIdentificacionFirmante",
    "numIdentificacionFirmante",
    "numPagareEntidad"
})
public class ConsultaPagareServiceDTO {

    protected Long codigoDeceval;
    protected Integer idEstadoPagare;
    protected Integer idTipoIdentificacionFirmante;
    protected String numIdentificacionFirmante;
    protected String numPagareEntidad;

    /**
     * Obtiene el valor de la propiedad codigoDeceval.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodigoDeceval() {
        return codigoDeceval;
    }

    /**
     * Define el valor de la propiedad codigoDeceval.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodigoDeceval(Long value) {
        this.codigoDeceval = value;
    }

    /**
     * Obtiene el valor de la propiedad idEstadoPagare.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEstadoPagare() {
        return idEstadoPagare;
    }

    /**
     * Define el valor de la propiedad idEstadoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEstadoPagare(Integer value) {
        this.idEstadoPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoIdentificacionFirmante.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTipoIdentificacionFirmante() {
        return idTipoIdentificacionFirmante;
    }

    /**
     * Define el valor de la propiedad idTipoIdentificacionFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTipoIdentificacionFirmante(Integer value) {
        this.idTipoIdentificacionFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad numIdentificacionFirmante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumIdentificacionFirmante() {
        return numIdentificacionFirmante;
    }

    /**
     * Define el valor de la propiedad numIdentificacionFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumIdentificacionFirmante(String value) {
        this.numIdentificacionFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad numPagareEntidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumPagareEntidad() {
        return numPagareEntidad;
    }

    /**
     * Define el valor de la propiedad numPagareEntidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumPagareEntidad(String value) {
        this.numPagareEntidad = value;
    }

}
