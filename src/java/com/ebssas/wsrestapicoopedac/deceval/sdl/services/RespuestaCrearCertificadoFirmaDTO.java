
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuestaCrearCertificadoFirmaDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuestaCrearCertificadoFirmaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="exitoso" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "respuestaCrearCertificadoFirmaDTO", propOrder = {
    "codigoError",
    "descripcion",
    "exitoso",
    "infoCertificadoFirmaDTO"
})
public class RespuestaCrearCertificadoFirmaDTO {

    protected String codigoError;
    protected String descripcion;
    protected Boolean exitoso;
    protected InfoCertificadoFirmaDTO infoCertificadoFirmaDTO;

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
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad exitoso.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExitoso() {
        return exitoso;
    }

    /**
     * Define el valor de la propiedad exitoso.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExitoso(Boolean value) {
        this.exitoso = value;
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
