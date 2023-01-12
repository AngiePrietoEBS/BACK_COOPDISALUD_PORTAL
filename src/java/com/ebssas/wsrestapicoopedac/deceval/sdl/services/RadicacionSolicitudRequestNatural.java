
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para radicacionSolicitudRequestNatural complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="radicacionSolicitudRequestNatural"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="archivosAdjuntos" type="{http://deceval.com/sdl/services/}archivoAdjuntoSolicitudVO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ciudadDomicilio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ciudadSolicitud" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="depto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="deptoDomicilio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="descripcionSolicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaExpedicion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fkIdTipoDocumentoGirador" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="header" type="{http://deceval.com/sdl/services/}headerDTO" minOccurs="0"/&gt;
 *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="novedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDocumentoOriginal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="paisDomicilio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="paisNacionalidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="primerApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoDocumentoOriginal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "radicacionSolicitudRequestNatural", propOrder = {
    "archivosAdjuntos",
    "ciudad",
    "ciudadDomicilio",
    "ciudadSolicitud",
    "depto",
    "deptoDomicilio",
    "descripcionSolicitud",
    "fechaExpedicion",
    "fechaNacimiento",
    "fkIdTipoDocumentoGirador",
    "header",
    "nombres",
    "novedad",
    "numeroDocumento",
    "numeroDocumentoOriginal",
    "pais",
    "paisDomicilio",
    "paisNacionalidad",
    "primerApellido",
    "tipoDocumentoOriginal"
})
public class RadicacionSolicitudRequestNatural {

    @XmlElement(nillable = true)
    protected List<ArchivoAdjuntoSolicitudVO> archivosAdjuntos;
    protected Integer ciudad;
    protected Integer ciudadDomicilio;
    protected Integer ciudadSolicitud;
    protected Integer depto;
    protected Integer deptoDomicilio;
    protected String descripcionSolicitud;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaExpedicion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaNacimiento;
    protected Integer fkIdTipoDocumentoGirador;
    protected HeaderDTO header;
    protected String nombres;
    protected String novedad;
    protected String numeroDocumento;
    protected String numeroDocumentoOriginal;
    protected Integer pais;
    protected Integer paisDomicilio;
    protected Integer paisNacionalidad;
    protected String primerApellido;
    protected Integer tipoDocumentoOriginal;

    /**
     * Gets the value of the archivosAdjuntos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the archivosAdjuntos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArchivosAdjuntos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArchivoAdjuntoSolicitudVO }
     * 
     * 
     */
    public List<ArchivoAdjuntoSolicitudVO> getArchivosAdjuntos() {
        if (archivosAdjuntos == null) {
            archivosAdjuntos = new ArrayList<ArchivoAdjuntoSolicitudVO>();
        }
        return this.archivosAdjuntos;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiudad(Integer value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadDomicilio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiudadDomicilio() {
        return ciudadDomicilio;
    }

    /**
     * Define el valor de la propiedad ciudadDomicilio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiudadDomicilio(Integer value) {
        this.ciudadDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiudadSolicitud() {
        return ciudadSolicitud;
    }

    /**
     * Define el valor de la propiedad ciudadSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiudadSolicitud(Integer value) {
        this.ciudadSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad depto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDepto() {
        return depto;
    }

    /**
     * Define el valor de la propiedad depto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDepto(Integer value) {
        this.depto = value;
    }

    /**
     * Obtiene el valor de la propiedad deptoDomicilio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeptoDomicilio() {
        return deptoDomicilio;
    }

    /**
     * Define el valor de la propiedad deptoDomicilio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeptoDomicilio(Integer value) {
        this.deptoDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    /**
     * Define el valor de la propiedad descripcionSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionSolicitud(String value) {
        this.descripcionSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaExpedicion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Define el valor de la propiedad fechaExpedicion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaExpedicion(XMLGregorianCalendar value) {
        this.fechaExpedicion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdTipoDocumentoGirador.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdTipoDocumentoGirador() {
        return fkIdTipoDocumentoGirador;
    }

    /**
     * Define el valor de la propiedad fkIdTipoDocumentoGirador.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdTipoDocumentoGirador(Integer value) {
        this.fkIdTipoDocumentoGirador = value;
    }

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
     * Obtiene el valor de la propiedad nombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Define el valor de la propiedad nombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombres(String value) {
        this.nombres = value;
    }

    /**
     * Obtiene el valor de la propiedad novedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedad() {
        return novedad;
    }

    /**
     * Define el valor de la propiedad novedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedad(String value) {
        this.novedad = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define el valor de la propiedad numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumentoOriginal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumentoOriginal() {
        return numeroDocumentoOriginal;
    }

    /**
     * Define el valor de la propiedad numeroDocumentoOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumentoOriginal(String value) {
        this.numeroDocumentoOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPais(Integer value) {
        this.pais = value;
    }

    /**
     * Obtiene el valor de la propiedad paisDomicilio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPaisDomicilio() {
        return paisDomicilio;
    }

    /**
     * Define el valor de la propiedad paisDomicilio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPaisDomicilio(Integer value) {
        this.paisDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad paisNacionalidad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPaisNacionalidad() {
        return paisNacionalidad;
    }

    /**
     * Define el valor de la propiedad paisNacionalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPaisNacionalidad(Integer value) {
        this.paisNacionalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Define el valor de la propiedad primerApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentoOriginal.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoDocumentoOriginal() {
        return tipoDocumentoOriginal;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoDocumentoOriginal(Integer value) {
        this.tipoDocumentoOriginal = value;
    }

}
