
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultaGiradorServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultaGiradorServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="giradorCuenta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="giradorNumId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giradorTipoId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="idPersonaRepresentada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idRol" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaGiradorServiceDTO", propOrder = {
    "giradorCuenta",
    "giradorNumId",
    "giradorTipoId",
    "idPersonaRepresentada",
    "idRol"
})
public class ConsultaGiradorServiceDTO {

    protected Integer giradorCuenta;
    protected String giradorNumId;
    protected Integer giradorTipoId;
    protected Long idPersonaRepresentada;
    protected Integer idRol;

    /**
     * Obtiene el valor de la propiedad giradorCuenta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiradorCuenta() {
        return giradorCuenta;
    }

    /**
     * Define el valor de la propiedad giradorCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGiradorCuenta(Integer value) {
        this.giradorCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad giradorNumId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiradorNumId() {
        return giradorNumId;
    }

    /**
     * Define el valor de la propiedad giradorNumId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiradorNumId(String value) {
        this.giradorNumId = value;
    }

    /**
     * Obtiene el valor de la propiedad giradorTipoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiradorTipoId() {
        return giradorTipoId;
    }

    /**
     * Define el valor de la propiedad giradorTipoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGiradorTipoId(Integer value) {
        this.giradorTipoId = value;
    }

    /**
     * Obtiene el valor de la propiedad idPersonaRepresentada.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPersonaRepresentada() {
        return idPersonaRepresentada;
    }

    /**
     * Define el valor de la propiedad idPersonaRepresentada.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPersonaRepresentada(Long value) {
        this.idPersonaRepresentada = value;
    }

    /**
     * Obtiene el valor de la propiedad idRol.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * Define el valor de la propiedad idRol.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdRol(Integer value) {
        this.idRol = value;
    }

}
