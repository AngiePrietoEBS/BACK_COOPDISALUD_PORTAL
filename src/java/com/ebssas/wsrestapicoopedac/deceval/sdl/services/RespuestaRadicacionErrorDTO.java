
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuestaRadicacionErrorDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuestaRadicacionErrorDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="errores" type="{http://deceval.com/sdl/services/}errorDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="valido" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaRadicacionErrorDTO", propOrder = {
    "errores",
    "valido"
})
public class RespuestaRadicacionErrorDTO {

    @XmlElement(nillable = true)
    protected List<ErrorDTO> errores;
    protected boolean valido;

    /**
     * Gets the value of the errores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorDTO }
     * 
     * 
     */
    public List<ErrorDTO> getErrores() {
        if (errores == null) {
            errores = new ArrayList<ErrorDTO>();
        }
        return this.errores;
    }

    /**
     * Obtiene el valor de la propiedad valido.
     * 
     */
    public boolean isValido() {
        return valido;
    }

    /**
     * Define el valor de la propiedad valido.
     * 
     */
    public void setValido(boolean value) {
        this.valido = value;
    }

}
