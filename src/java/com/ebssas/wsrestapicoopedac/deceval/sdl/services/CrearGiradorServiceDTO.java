
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
 * <p>Clase Java para crearGiradorServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="crearGiradorServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="agenteAutoretenedor_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="camaraComercioNo_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="circuloNo_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correoElectronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuentaGirador" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="declarante_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="direccion1PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="direccion2PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="direccion3PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="escrituraNo_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fax1PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fax2PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fax3PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaCamara_Jur" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaConstitucion_Jur" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaEscritura_Jur" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaExpedicion_Nat" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaNacimiento_Nat" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fkIdCiudadCamara_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdCiudadDomicilio_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdCiudadExpedicion_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdCiudad_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdClasePersona" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdDepartamentoCamara_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdDepartamentoDomicilio_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdDepartamentoExpedicion_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdDepartamento_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdPaisCamara_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdPaisDomicilio_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdPaisExpedicion_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdPaisNacionalidad_Nat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdPais_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fkIdTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="identificacionEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="libroNo_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="listaRepresentantesLegales" type="{http://deceval.com/sdl/services/}representanteLegalServiceDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="mensajeRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombresNat_Nat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="notariaNo_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroCelular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pensionado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="primerApellido_Nat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="razonSocial_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="regitroSuper_Jur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="residente_Jur" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="salario" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="segundoApellido_Nat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono1PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono2PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono3PersonaGrupo_PGP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tiempoServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearGiradorServiceDTO", propOrder = {
    "agenteAutoretenedorJur",
    "camaraComercioNoJur",
    "circuloNoJur",
    "correoElectronico",
    "cuentaGirador",
    "declaranteJur",
    "direccion1PersonaGrupoPGP",
    "direccion2PersonaGrupoPGP",
    "direccion3PersonaGrupoPGP",
    "escrituraNoJur",
    "estadoCivil",
    "fax1PersonaGrupoPGP",
    "fax2PersonaGrupoPGP",
    "fax3PersonaGrupoPGP",
    "fechaCamaraJur",
    "fechaConstitucionJur",
    "fechaEscrituraJur",
    "fechaExpedicionNat",
    "fechaNacimientoNat",
    "fkIdCiudadCamaraJur",
    "fkIdCiudadDomicilioNat",
    "fkIdCiudadExpedicionNat",
    "fkIdCiudadJur",
    "fkIdClasePersona",
    "fkIdDepartamentoCamaraJur",
    "fkIdDepartamentoDomicilioNat",
    "fkIdDepartamentoExpedicionNat",
    "fkIdDepartamentoJur",
    "fkIdPaisCamaraJur",
    "fkIdPaisDomicilioNat",
    "fkIdPaisExpedicionNat",
    "fkIdPaisNacionalidadNat",
    "fkIdPaisJur",
    "fkIdTipoDocumento",
    "identificacionEmisor",
    "libroNoJur",
    "listaRepresentantesLegales",
    "mensajeRespuesta",
    "nombresNatNat",
    "notariaNoJur",
    "numeroCelular",
    "numeroDocumento",
    "pensionado",
    "primerApellidoNat",
    "razonSocialJur",
    "regitroSuperJur",
    "residenteJur",
    "salario",
    "segundoApellidoNat",
    "telefono1PersonaGrupoPGP",
    "telefono2PersonaGrupoPGP",
    "telefono3PersonaGrupoPGP",
    "tiempoServicio"
})
public class CrearGiradorServiceDTO {

    @XmlElement(name = "agenteAutoretenedor_Jur")
    protected Integer agenteAutoretenedorJur;
    @XmlElement(name = "camaraComercioNo_Jur")
    protected String camaraComercioNoJur;
    @XmlElement(name = "circuloNo_Jur")
    protected String circuloNoJur;
    protected String correoElectronico;
    protected long cuentaGirador;
    @XmlElement(name = "declarante_Jur")
    protected Integer declaranteJur;
    @XmlElement(name = "direccion1PersonaGrupo_PGP")
    protected String direccion1PersonaGrupoPGP;
    @XmlElement(name = "direccion2PersonaGrupo_PGP")
    protected String direccion2PersonaGrupoPGP;
    @XmlElement(name = "direccion3PersonaGrupo_PGP")
    protected String direccion3PersonaGrupoPGP;
    @XmlElement(name = "escrituraNo_Jur")
    protected String escrituraNoJur;
    protected String estadoCivil;
    @XmlElement(name = "fax1PersonaGrupo_PGP")
    protected String fax1PersonaGrupoPGP;
    @XmlElement(name = "fax2PersonaGrupo_PGP")
    protected String fax2PersonaGrupoPGP;
    @XmlElement(name = "fax3PersonaGrupo_PGP")
    protected String fax3PersonaGrupoPGP;
    @XmlElement(name = "fechaCamara_Jur")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCamaraJur;
    @XmlElement(name = "fechaConstitucion_Jur")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaConstitucionJur;
    @XmlElement(name = "fechaEscritura_Jur")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEscrituraJur;
    @XmlElement(name = "fechaExpedicion_Nat")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaExpedicionNat;
    @XmlElement(name = "fechaNacimiento_Nat")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaNacimientoNat;
    @XmlElement(name = "fkIdCiudadCamara_Jur")
    protected Integer fkIdCiudadCamaraJur;
    @XmlElement(name = "fkIdCiudadDomicilio_Nat")
    protected Integer fkIdCiudadDomicilioNat;
    @XmlElement(name = "fkIdCiudadExpedicion_Nat")
    protected Integer fkIdCiudadExpedicionNat;
    @XmlElement(name = "fkIdCiudad_Jur")
    protected Integer fkIdCiudadJur;
    protected Integer fkIdClasePersona;
    @XmlElement(name = "fkIdDepartamentoCamara_Jur")
    protected Integer fkIdDepartamentoCamaraJur;
    @XmlElement(name = "fkIdDepartamentoDomicilio_Nat")
    protected Integer fkIdDepartamentoDomicilioNat;
    @XmlElement(name = "fkIdDepartamentoExpedicion_Nat")
    protected Integer fkIdDepartamentoExpedicionNat;
    @XmlElement(name = "fkIdDepartamento_Jur")
    protected Integer fkIdDepartamentoJur;
    @XmlElement(name = "fkIdPaisCamara_Jur")
    protected Integer fkIdPaisCamaraJur;
    @XmlElement(name = "fkIdPaisDomicilio_Nat")
    protected Integer fkIdPaisDomicilioNat;
    @XmlElement(name = "fkIdPaisExpedicion_Nat")
    protected Integer fkIdPaisExpedicionNat;
    @XmlElement(name = "fkIdPaisNacionalidad_Nat")
    protected Integer fkIdPaisNacionalidadNat;
    @XmlElement(name = "fkIdPais_Jur")
    protected Integer fkIdPaisJur;
    protected Integer fkIdTipoDocumento;
    protected String identificacionEmisor;
    @XmlElement(name = "libroNo_Jur")
    protected String libroNoJur;
    @XmlElement(nillable = true)
    protected List<RepresentanteLegalServiceDTO> listaRepresentantesLegales;
    protected String mensajeRespuesta;
    @XmlElement(name = "nombresNat_Nat")
    protected String nombresNatNat;
    @XmlElement(name = "notariaNo_Jur")
    protected String notariaNoJur;
    protected String numeroCelular;
    protected String numeroDocumento;
    protected Boolean pensionado;
    @XmlElement(name = "primerApellido_Nat")
    protected String primerApellidoNat;
    @XmlElement(name = "razonSocial_Jur")
    protected String razonSocialJur;
    @XmlElement(name = "regitroSuper_Jur")
    protected String regitroSuperJur;
    @XmlElement(name = "residente_Jur")
    protected Integer residenteJur;
    protected Double salario;
    @XmlElement(name = "segundoApellido_Nat")
    protected String segundoApellidoNat;
    @XmlElement(name = "telefono1PersonaGrupo_PGP")
    protected String telefono1PersonaGrupoPGP;
    @XmlElement(name = "telefono2PersonaGrupo_PGP")
    protected String telefono2PersonaGrupoPGP;
    @XmlElement(name = "telefono3PersonaGrupo_PGP")
    protected String telefono3PersonaGrupoPGP;
    protected String tiempoServicio;

    /**
     * Obtiene el valor de la propiedad agenteAutoretenedorJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAgenteAutoretenedorJur() {
        return agenteAutoretenedorJur;
    }

    /**
     * Define el valor de la propiedad agenteAutoretenedorJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAgenteAutoretenedorJur(Integer value) {
        this.agenteAutoretenedorJur = value;
    }

    /**
     * Obtiene el valor de la propiedad camaraComercioNoJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamaraComercioNoJur() {
        return camaraComercioNoJur;
    }

    /**
     * Define el valor de la propiedad camaraComercioNoJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamaraComercioNoJur(String value) {
        this.camaraComercioNoJur = value;
    }

    /**
     * Obtiene el valor de la propiedad circuloNoJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCirculoNoJur() {
        return circuloNoJur;
    }

    /**
     * Define el valor de la propiedad circuloNoJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCirculoNoJur(String value) {
        this.circuloNoJur = value;
    }

    /**
     * Obtiene el valor de la propiedad correoElectronico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Define el valor de la propiedad correoElectronico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreoElectronico(String value) {
        this.correoElectronico = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaGirador.
     * 
     */
    public long getCuentaGirador() {
        return cuentaGirador;
    }

    /**
     * Define el valor de la propiedad cuentaGirador.
     * 
     */
    public void setCuentaGirador(long value) {
        this.cuentaGirador = value;
    }

    /**
     * Obtiene el valor de la propiedad declaranteJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeclaranteJur() {
        return declaranteJur;
    }

    /**
     * Define el valor de la propiedad declaranteJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeclaranteJur(Integer value) {
        this.declaranteJur = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion1PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion1PersonaGrupoPGP() {
        return direccion1PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad direccion1PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion1PersonaGrupoPGP(String value) {
        this.direccion1PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion2PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion2PersonaGrupoPGP() {
        return direccion2PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad direccion2PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion2PersonaGrupoPGP(String value) {
        this.direccion2PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion3PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion3PersonaGrupoPGP() {
        return direccion3PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad direccion3PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion3PersonaGrupoPGP(String value) {
        this.direccion3PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad escrituraNoJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEscrituraNoJur() {
        return escrituraNoJur;
    }

    /**
     * Define el valor de la propiedad escrituraNoJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEscrituraNoJur(String value) {
        this.escrituraNoJur = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoCivil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Define el valor de la propiedad estadoCivil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCivil(String value) {
        this.estadoCivil = value;
    }

    /**
     * Obtiene el valor de la propiedad fax1PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax1PersonaGrupoPGP() {
        return fax1PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad fax1PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax1PersonaGrupoPGP(String value) {
        this.fax1PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad fax2PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax2PersonaGrupoPGP() {
        return fax2PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad fax2PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax2PersonaGrupoPGP(String value) {
        this.fax2PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad fax3PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax3PersonaGrupoPGP() {
        return fax3PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad fax3PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax3PersonaGrupoPGP(String value) {
        this.fax3PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCamaraJur.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCamaraJur() {
        return fechaCamaraJur;
    }

    /**
     * Define el valor de la propiedad fechaCamaraJur.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCamaraJur(XMLGregorianCalendar value) {
        this.fechaCamaraJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaConstitucionJur.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaConstitucionJur() {
        return fechaConstitucionJur;
    }

    /**
     * Define el valor de la propiedad fechaConstitucionJur.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaConstitucionJur(XMLGregorianCalendar value) {
        this.fechaConstitucionJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEscrituraJur.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEscrituraJur() {
        return fechaEscrituraJur;
    }

    /**
     * Define el valor de la propiedad fechaEscrituraJur.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEscrituraJur(XMLGregorianCalendar value) {
        this.fechaEscrituraJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaExpedicionNat.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaExpedicionNat() {
        return fechaExpedicionNat;
    }

    /**
     * Define el valor de la propiedad fechaExpedicionNat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaExpedicionNat(XMLGregorianCalendar value) {
        this.fechaExpedicionNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimientoNat.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimientoNat() {
        return fechaNacimientoNat;
    }

    /**
     * Define el valor de la propiedad fechaNacimientoNat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimientoNat(XMLGregorianCalendar value) {
        this.fechaNacimientoNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdCiudadCamaraJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdCiudadCamaraJur() {
        return fkIdCiudadCamaraJur;
    }

    /**
     * Define el valor de la propiedad fkIdCiudadCamaraJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdCiudadCamaraJur(Integer value) {
        this.fkIdCiudadCamaraJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdCiudadDomicilioNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdCiudadDomicilioNat() {
        return fkIdCiudadDomicilioNat;
    }

    /**
     * Define el valor de la propiedad fkIdCiudadDomicilioNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdCiudadDomicilioNat(Integer value) {
        this.fkIdCiudadDomicilioNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdCiudadExpedicionNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdCiudadExpedicionNat() {
        return fkIdCiudadExpedicionNat;
    }

    /**
     * Define el valor de la propiedad fkIdCiudadExpedicionNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdCiudadExpedicionNat(Integer value) {
        this.fkIdCiudadExpedicionNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdCiudadJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdCiudadJur() {
        return fkIdCiudadJur;
    }

    /**
     * Define el valor de la propiedad fkIdCiudadJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdCiudadJur(Integer value) {
        this.fkIdCiudadJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdClasePersona.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdClasePersona() {
        return fkIdClasePersona;
    }

    /**
     * Define el valor de la propiedad fkIdClasePersona.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdClasePersona(Integer value) {
        this.fkIdClasePersona = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdDepartamentoCamaraJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdDepartamentoCamaraJur() {
        return fkIdDepartamentoCamaraJur;
    }

    /**
     * Define el valor de la propiedad fkIdDepartamentoCamaraJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdDepartamentoCamaraJur(Integer value) {
        this.fkIdDepartamentoCamaraJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdDepartamentoDomicilioNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdDepartamentoDomicilioNat() {
        return fkIdDepartamentoDomicilioNat;
    }

    /**
     * Define el valor de la propiedad fkIdDepartamentoDomicilioNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdDepartamentoDomicilioNat(Integer value) {
        this.fkIdDepartamentoDomicilioNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdDepartamentoExpedicionNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdDepartamentoExpedicionNat() {
        return fkIdDepartamentoExpedicionNat;
    }

    /**
     * Define el valor de la propiedad fkIdDepartamentoExpedicionNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdDepartamentoExpedicionNat(Integer value) {
        this.fkIdDepartamentoExpedicionNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdDepartamentoJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdDepartamentoJur() {
        return fkIdDepartamentoJur;
    }

    /**
     * Define el valor de la propiedad fkIdDepartamentoJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdDepartamentoJur(Integer value) {
        this.fkIdDepartamentoJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdPaisCamaraJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdPaisCamaraJur() {
        return fkIdPaisCamaraJur;
    }

    /**
     * Define el valor de la propiedad fkIdPaisCamaraJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdPaisCamaraJur(Integer value) {
        this.fkIdPaisCamaraJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdPaisDomicilioNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdPaisDomicilioNat() {
        return fkIdPaisDomicilioNat;
    }

    /**
     * Define el valor de la propiedad fkIdPaisDomicilioNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdPaisDomicilioNat(Integer value) {
        this.fkIdPaisDomicilioNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdPaisExpedicionNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdPaisExpedicionNat() {
        return fkIdPaisExpedicionNat;
    }

    /**
     * Define el valor de la propiedad fkIdPaisExpedicionNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdPaisExpedicionNat(Integer value) {
        this.fkIdPaisExpedicionNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdPaisNacionalidadNat.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdPaisNacionalidadNat() {
        return fkIdPaisNacionalidadNat;
    }

    /**
     * Define el valor de la propiedad fkIdPaisNacionalidadNat.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdPaisNacionalidadNat(Integer value) {
        this.fkIdPaisNacionalidadNat = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdPaisJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdPaisJur() {
        return fkIdPaisJur;
    }

    /**
     * Define el valor de la propiedad fkIdPaisJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdPaisJur(Integer value) {
        this.fkIdPaisJur = value;
    }

    /**
     * Obtiene el valor de la propiedad fkIdTipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFkIdTipoDocumento() {
        return fkIdTipoDocumento;
    }

    /**
     * Define el valor de la propiedad fkIdTipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFkIdTipoDocumento(Integer value) {
        this.fkIdTipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad identificacionEmisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacionEmisor() {
        return identificacionEmisor;
    }

    /**
     * Define el valor de la propiedad identificacionEmisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacionEmisor(String value) {
        this.identificacionEmisor = value;
    }

    /**
     * Obtiene el valor de la propiedad libroNoJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibroNoJur() {
        return libroNoJur;
    }

    /**
     * Define el valor de la propiedad libroNoJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibroNoJur(String value) {
        this.libroNoJur = value;
    }

    /**
     * Gets the value of the listaRepresentantesLegales property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaRepresentantesLegales property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaRepresentantesLegales().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RepresentanteLegalServiceDTO }
     * 
     * 
     */
    public List<RepresentanteLegalServiceDTO> getListaRepresentantesLegales() {
        if (listaRepresentantesLegales == null) {
            listaRepresentantesLegales = new ArrayList<RepresentanteLegalServiceDTO>();
        }
        return this.listaRepresentantesLegales;
    }

    /**
     * Obtiene el valor de la propiedad mensajeRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    /**
     * Define el valor de la propiedad mensajeRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeRespuesta(String value) {
        this.mensajeRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad nombresNatNat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombresNatNat() {
        return nombresNatNat;
    }

    /**
     * Define el valor de la propiedad nombresNatNat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombresNatNat(String value) {
        this.nombresNatNat = value;
    }

    /**
     * Obtiene el valor de la propiedad notariaNoJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotariaNoJur() {
        return notariaNoJur;
    }

    /**
     * Define el valor de la propiedad notariaNoJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotariaNoJur(String value) {
        this.notariaNoJur = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroCelular.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCelular() {
        return numeroCelular;
    }

    /**
     * Define el valor de la propiedad numeroCelular.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCelular(String value) {
        this.numeroCelular = value;
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
     * Obtiene el valor de la propiedad pensionado.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPensionado() {
        return pensionado;
    }

    /**
     * Define el valor de la propiedad pensionado.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPensionado(Boolean value) {
        this.pensionado = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellidoNat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellidoNat() {
        return primerApellidoNat;
    }

    /**
     * Define el valor de la propiedad primerApellidoNat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellidoNat(String value) {
        this.primerApellidoNat = value;
    }

    /**
     * Obtiene el valor de la propiedad razonSocialJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocialJur() {
        return razonSocialJur;
    }

    /**
     * Define el valor de la propiedad razonSocialJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocialJur(String value) {
        this.razonSocialJur = value;
    }

    /**
     * Obtiene el valor de la propiedad regitroSuperJur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegitroSuperJur() {
        return regitroSuperJur;
    }

    /**
     * Define el valor de la propiedad regitroSuperJur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegitroSuperJur(String value) {
        this.regitroSuperJur = value;
    }

    /**
     * Obtiene el valor de la propiedad residenteJur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResidenteJur() {
        return residenteJur;
    }

    /**
     * Define el valor de la propiedad residenteJur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResidenteJur(Integer value) {
        this.residenteJur = value;
    }

    /**
     * Obtiene el valor de la propiedad salario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * Define el valor de la propiedad salario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSalario(Double value) {
        this.salario = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoApellidoNat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoApellidoNat() {
        return segundoApellidoNat;
    }

    /**
     * Define el valor de la propiedad segundoApellidoNat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoApellidoNat(String value) {
        this.segundoApellidoNat = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono1PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono1PersonaGrupoPGP() {
        return telefono1PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad telefono1PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono1PersonaGrupoPGP(String value) {
        this.telefono1PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono2PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono2PersonaGrupoPGP() {
        return telefono2PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad telefono2PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono2PersonaGrupoPGP(String value) {
        this.telefono2PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono3PersonaGrupoPGP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono3PersonaGrupoPGP() {
        return telefono3PersonaGrupoPGP;
    }

    /**
     * Define el valor de la propiedad telefono3PersonaGrupoPGP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono3PersonaGrupoPGP(String value) {
        this.telefono3PersonaGrupoPGP = value;
    }

    /**
     * Obtiene el valor de la propiedad tiempoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiempoServicio() {
        return tiempoServicio;
    }

    /**
     * Define el valor de la propiedad tiempoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiempoServicio(String value) {
        this.tiempoServicio = value;
    }

}
