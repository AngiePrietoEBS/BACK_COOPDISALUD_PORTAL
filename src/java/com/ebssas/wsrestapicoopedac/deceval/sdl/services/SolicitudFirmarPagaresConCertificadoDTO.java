
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitudFirmarPagaresConCertificadoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitudFirmarPagaresConCertificadoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://deceval.com/sdl/services/}solicitudFirmarPagaresDTO"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudFirmarPagaresConCertificadoDTO", propOrder = {
    "numeroReferencia"
})
public class SolicitudFirmarPagaresConCertificadoDTO
    extends SolicitudFirmarPagaresDTO
{

    protected String numeroReferencia;

    /**
     * Obtiene el valor de la propiedad numeroReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    /**
     * Define el valor de la propiedad numeroReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroReferencia(String value) {
        this.numeroReferencia = value;
    }

}
