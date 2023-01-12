
package com.deceval.mrc.solicitud.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InformacionPagareTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InformacionPagareTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EntidadBancariaId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TipoDocumentoEntidad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NumeroIdentificacionEntidad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TipoDocumentoFirmante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NumeroDocumentoFirmante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NombreFirmante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ApellidoFirmante" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IpOrigen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformacionPagareTO", propOrder = {
    "entidadBancariaId",
    "estado",
    "tipoDocumentoEntidad",
    "numeroIdentificacionEntidad",
    "tipoDocumentoFirmante",
    "numeroDocumentoFirmante",
    "nombreFirmante",
    "apellidoFirmante",
    "ipOrigen"
})
public class InformacionPagareTO {

    @XmlElement(name = "EntidadBancariaId", required = true, nillable = true)
    protected String entidadBancariaId;
    @XmlElement(name = "Estado", required = true, nillable = true)
    protected String estado;
    @XmlElement(name = "TipoDocumentoEntidad", required = true, nillable = true)
    protected String tipoDocumentoEntidad;
    @XmlElement(name = "NumeroIdentificacionEntidad", required = true, nillable = true)
    protected String numeroIdentificacionEntidad;
    @XmlElement(name = "TipoDocumentoFirmante", required = true, nillable = true)
    protected String tipoDocumentoFirmante;
    @XmlElement(name = "NumeroDocumentoFirmante", required = true, nillable = true)
    protected String numeroDocumentoFirmante;
    @XmlElement(name = "NombreFirmante", required = true, nillable = true)
    protected String nombreFirmante;
    @XmlElement(name = "ApellidoFirmante", required = true, nillable = true)
    protected String apellidoFirmante;
    @XmlElement(name = "IpOrigen", required = true, nillable = true)
    protected String ipOrigen;

    /**
     * Obtiene el valor de la propiedad entidadBancariaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntidadBancariaId() {
        return entidadBancariaId;
    }

    /**
     * Define el valor de la propiedad entidadBancariaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntidadBancariaId(String value) {
        this.entidadBancariaId = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentoEntidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoEntidad() {
        return tipoDocumentoEntidad;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoEntidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoEntidad(String value) {
        this.tipoDocumentoEntidad = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroIdentificacionEntidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacionEntidad() {
        return numeroIdentificacionEntidad;
    }

    /**
     * Define el valor de la propiedad numeroIdentificacionEntidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacionEntidad(String value) {
        this.numeroIdentificacionEntidad = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentoFirmante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoFirmante() {
        return tipoDocumentoFirmante;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoFirmante(String value) {
        this.tipoDocumentoFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumentoFirmante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumentoFirmante() {
        return numeroDocumentoFirmante;
    }

    /**
     * Define el valor de la propiedad numeroDocumentoFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumentoFirmante(String value) {
        this.numeroDocumentoFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreFirmante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFirmante() {
        return nombreFirmante;
    }

    /**
     * Define el valor de la propiedad nombreFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFirmante(String value) {
        this.nombreFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoFirmante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoFirmante() {
        return apellidoFirmante;
    }

    /**
     * Define el valor de la propiedad apellidoFirmante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoFirmante(String value) {
        this.apellidoFirmante = value;
    }

    /**
     * Obtiene el valor de la propiedad ipOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpOrigen() {
        return ipOrigen;
    }

    /**
     * Define el valor de la propiedad ipOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpOrigen(String value) {
        this.ipOrigen = value;
    }

}
