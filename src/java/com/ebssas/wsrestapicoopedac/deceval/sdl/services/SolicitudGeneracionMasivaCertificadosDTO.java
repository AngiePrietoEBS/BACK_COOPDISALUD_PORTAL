
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudGeneracionMasivaCertificadosDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudGeneracionMasivaCertificadosDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://deceval.com/sdl/services/}headerDTO" minOccurs="0"/&gt;
 *         &lt;element name="noPagareEntidad" type="{http://deceval.com/sdl/services/}entradasGeneracionMasivaCertificadosDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tipoCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoPagare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudGeneracionMasivaCertificadosDTO", propOrder = {
    "header",
    "noPagareEntidad",
    "tipoCertificado",
    "tipoPagare"
})
public class SolicitudGeneracionMasivaCertificadosDTO {

    protected HeaderDTO header;
    @XmlElement(nillable = true)
    protected List<EntradasGeneracionMasivaCertificadosDTO> noPagareEntidad;
    protected String tipoCertificado;
    protected String tipoPagare;

    /**
     * Obtiene el valor de la propiedad header.
     * 
     * @return
     *     possible object is
     *     {@link HeaderDTO }
     *     
     */
    public HeaderDTO getHeader() {
        return header;
    }

    /**
     * Define el valor de la propiedad header.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderDTO }
     *     
     */
    public void setHeader(HeaderDTO value) {
        this.header = value;
    }

    /**
     * Gets the value of the noPagareEntidad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noPagareEntidad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoPagareEntidad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntradasGeneracionMasivaCertificadosDTO }
     * 
     * 
     */
    public List<EntradasGeneracionMasivaCertificadosDTO> getNoPagareEntidad() {
        if (noPagareEntidad == null) {
            noPagareEntidad = new ArrayList<EntradasGeneracionMasivaCertificadosDTO>();
        }
        return this.noPagareEntidad;
    }

    /**
     * Obtiene el valor de la propiedad tipoCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCertificado() {
        return tipoCertificado;
    }

    /**
     * Define el valor de la propiedad tipoCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCertificado(String value) {
        this.tipoCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPagare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPagare() {
        return tipoPagare;
    }

    /**
     * Define el valor de la propiedad tipoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPagare(String value) {
        this.tipoPagare = value;
    }

}
