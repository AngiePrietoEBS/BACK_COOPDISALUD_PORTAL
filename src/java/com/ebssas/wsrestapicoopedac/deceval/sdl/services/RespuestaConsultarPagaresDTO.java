
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuestaConsultarPagaresDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuestaConsultarPagaresDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="exitoso" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="listaRespuesta" type="{http://deceval.com/sdl/services/}informacionPagareServiceDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaConsultarPagaresDTO", propOrder = {
    "codigoError",
    "descripcion",
    "exitoso",
    "listaRespuesta"
})
public class RespuestaConsultarPagaresDTO {

    protected String codigoError;
    protected String descripcion;
    protected Boolean exitoso;
    @XmlElement(nillable = true)
    protected List<InformacionPagareServiceDTO> listaRespuesta;

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
     * Gets the value of the listaRespuesta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaRespuesta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaRespuesta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformacionPagareServiceDTO }
     * 
     * 
     */
    public List<InformacionPagareServiceDTO> getListaRespuesta() {
        if (listaRespuesta == null) {
            listaRespuesta = new ArrayList<InformacionPagareServiceDTO>();
        }
        return this.listaRespuesta;
    }

}
