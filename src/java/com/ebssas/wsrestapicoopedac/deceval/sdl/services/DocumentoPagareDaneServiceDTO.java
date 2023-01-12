
package com.ebssas.wsrestapicoopedac.deceval.sdl.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para documentoPagareDaneServiceDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="documentoPagareDaneServiceDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="adquisicionVivienda" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="apoderadoCuenta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="apoderadoNumId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="apoderadoTipoId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="archivosAdjuntos" type="{http://deceval.com/sdl/services/}archivoAdjuntoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="autorizaDebitoAutomatico" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="aval" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="baseLiquidacionPlazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="baseLiquidacionTasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ciCEApartirDelMes" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ciCEPagaderaCada" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ciConCuotasExtras" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ciConPeriodoGracia" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ciNumCuotasExtras" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ciValorCuotaExtra" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ciudadCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ciudadDesembolso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codOficina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigoGeoreferenciacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="construccionViviendaIndividual" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="creditoReembolsableEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deptoCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="destinoOperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="diaPago" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="dtfDessembolso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="dtfEA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="empresaOtorgante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaDesembolso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaFirmaFisico" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaGrabacionPagare" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaPagoPrimerCuota" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaPagoPrimerCuotaCapital" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaPagoPrimerCuotaInteres" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaPagoPrimerCuotaMensual" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaPagoPrimerCuotaSemestral" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaVencimientoFinanciero" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="garantiaAdicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idClaseDefinicionDocumento" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idDocumentoPagare" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idGestorDocumental" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="listaAmortizaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="listaApoderadoRepresentantePagare" type="{http://deceval.com/sdl/services/}consultaGiradorServiceDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="listaCodeudoresAvalistasPagare" type="{http://deceval.com/sdl/services/}consultaGiradorServiceDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="margenRedescuento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="mejoramientoViviendaInterSoci" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="mensajeRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="modalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modalidadPagoCapital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modalidadPagosInteres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nitEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noVis" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="numCredito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numCuotas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="numCuotasLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numPagareEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numUnidadesUVR" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="otorganteCuenta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="otorganteNumId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="otorganteTipoId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="otraModalidadPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="otroDestino" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paisCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodicidadGracia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodicidadMuerto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodicidadPlazo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoGracia" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="periodoGraciaDe" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="periodoGraciaHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="periodoGraciaLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoGraciaNumero" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="periodoMuerto" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="periodoMuertoDe" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="periodoMuertoHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="periodoMuertoLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoMuertoNumero" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="plazoCreditoDe" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="plazoCreditoHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="plazoLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="plazoNumero" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="porcentAmortizacionMensual" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="porcentAmortizacionSemestral" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="porcentajeCobertura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="porcentajeComision" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="puntosPorcentualesRedescuento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="regional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="seguroVida" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="spreed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tasaInteres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tasaInteresMora" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tasaInteresMoraLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tasaInteresRenumEA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tasaInteresRenumEALetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tasaNominal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tasaNominalLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tasaRedescuento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="textoAdicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoPagare" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="valorCapitalLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorCapitalNumero" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorCuotaPesos" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorCuotaPesosLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorCuotaUVR" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorCuotaUVRLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorDesembolsoUVRLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorInteresesLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorInteresesNumero" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorPesosActual" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorPesosDesembolso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="valorPesosDesembolsoLetras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorPesosDiligenciamiento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="vis" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentoPagareDaneServiceDTO", propOrder = {
    "adquisicionVivienda",
    "apoderadoCuenta",
    "apoderadoNumId",
    "apoderadoTipoId",
    "archivosAdjuntos",
    "autorizaDebitoAutomatico",
    "aval",
    "baseLiquidacionPlazo",
    "baseLiquidacionTasa",
    "ciCEApartirDelMes",
    "ciCEPagaderaCada",
    "ciConCuotasExtras",
    "ciConPeriodoGracia",
    "ciNumCuotasExtras",
    "ciValorCuotaExtra",
    "ciudadCreacion",
    "ciudadDesembolso",
    "codOficina",
    "codigoGeoreferenciacion",
    "construccionViviendaIndividual",
    "creditoReembolsableEn",
    "cuenta",
    "departamento",
    "deptoCreacion",
    "destinoOperacion",
    "diaPago",
    "dtfDessembolso",
    "dtfEA",
    "empresaOtorgante",
    "fechaDesembolso",
    "fechaFirmaFisico",
    "fechaGrabacionPagare",
    "fechaPagoPrimerCuota",
    "fechaPagoPrimerCuotaCapital",
    "fechaPagoPrimerCuotaInteres",
    "fechaPagoPrimerCuotaMensual",
    "fechaPagoPrimerCuotaSemestral",
    "fechaVencimientoFinanciero",
    "garantiaAdicional",
    "idClaseDefinicionDocumento",
    "idDocumentoPagare",
    "idGestorDocumental",
    "listaAmortizaciones",
    "listaApoderadoRepresentantePagare",
    "listaCodeudoresAvalistasPagare",
    "margenRedescuento",
    "mejoramientoViviendaInterSoci",
    "mensajeRespuesta",
    "modalidad",
    "modalidadPagoCapital",
    "modalidadPagosInteres",
    "nitEmisor",
    "noVis",
    "numCredito",
    "numCuotas",
    "numCuotasLetras",
    "numPagareEntidad",
    "numReferencia",
    "numUnidadesUVR",
    "otorganteCuenta",
    "otorganteNumId",
    "otorganteTipoId",
    "otraModalidadPago",
    "otroDestino",
    "pais",
    "paisCreacion",
    "periodicidadGracia",
    "periodicidadMuerto",
    "periodicidadPlazo",
    "periodoGracia",
    "periodoGraciaDe",
    "periodoGraciaHasta",
    "periodoGraciaLetras",
    "periodoGraciaNumero",
    "periodoMuerto",
    "periodoMuertoDe",
    "periodoMuertoHasta",
    "periodoMuertoLetras",
    "periodoMuertoNumero",
    "plazoCreditoDe",
    "plazoCreditoHasta",
    "plazoLetras",
    "plazoNumero",
    "porcentAmortizacionMensual",
    "porcentAmortizacionSemestral",
    "porcentajeCobertura",
    "porcentajeComision",
    "puntosPorcentualesRedescuento",
    "regional",
    "seguroVida",
    "spreed",
    "tasaInteres",
    "tasaInteresMora",
    "tasaInteresMoraLetras",
    "tasaInteresRenumEA",
    "tasaInteresRenumEALetras",
    "tasaNominal",
    "tasaNominalLetras",
    "tasaRedescuento",
    "textoAdicional",
    "tipoPagare",
    "valorCapitalLetras",
    "valorCapitalNumero",
    "valorCuotaPesos",
    "valorCuotaPesosLetras",
    "valorCuotaUVR",
    "valorCuotaUVRLetras",
    "valorDesembolsoUVRLetras",
    "valorInteresesLetras",
    "valorInteresesNumero",
    "valorPesosActual",
    "valorPesosDesembolso",
    "valorPesosDesembolsoLetras",
    "valorPesosDiligenciamiento",
    "vis"
})
public class DocumentoPagareDaneServiceDTO {

    protected Boolean adquisicionVivienda;
    protected Integer apoderadoCuenta;
    protected String apoderadoNumId;
    protected Integer apoderadoTipoId;
    @XmlElement(nillable = true)
    protected List<ArchivoAdjuntoDTO> archivosAdjuntos;
    protected Boolean autorizaDebitoAutomatico;
    protected BigDecimal aval;
    protected String baseLiquidacionPlazo;
    protected String baseLiquidacionTasa;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ciCEApartirDelMes;
    protected Integer ciCEPagaderaCada;
    protected Boolean ciConCuotasExtras;
    protected Boolean ciConPeriodoGracia;
    protected Integer ciNumCuotasExtras;
    protected BigDecimal ciValorCuotaExtra;
    protected String ciudadCreacion;
    protected String ciudadDesembolso;
    protected String codOficina;
    protected String codigoGeoreferenciacion;
    protected Boolean construccionViviendaIndividual;
    protected String creditoReembolsableEn;
    protected String cuenta;
    protected String departamento;
    protected String deptoCreacion;
    protected String destinoOperacion;
    protected Integer diaPago;
    protected BigDecimal dtfDessembolso;
    protected String dtfEA;
    protected String empresaOtorgante;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDesembolso;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFirmaFisico;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaGrabacionPagare;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPagoPrimerCuota;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPagoPrimerCuotaCapital;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPagoPrimerCuotaInteres;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPagoPrimerCuotaMensual;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPagoPrimerCuotaSemestral;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaVencimientoFinanciero;
    protected String garantiaAdicional;
    protected Long idClaseDefinicionDocumento;
    protected Long idDocumentoPagare;
    protected String idGestorDocumental;
    protected String listaAmortizaciones;
    @XmlElement(nillable = true)
    protected List<ConsultaGiradorServiceDTO> listaApoderadoRepresentantePagare;
    @XmlElement(nillable = true)
    protected List<ConsultaGiradorServiceDTO> listaCodeudoresAvalistasPagare;
    protected BigDecimal margenRedescuento;
    protected Boolean mejoramientoViviendaInterSoci;
    @XmlElement(nillable = true)
    protected List<String> mensajeRespuesta;
    protected String modalidad;
    protected String modalidadPagoCapital;
    protected String modalidadPagosInteres;
    protected String nitEmisor;
    protected Boolean noVis;
    protected String numCredito;
    protected Integer numCuotas;
    protected String numCuotasLetras;
    protected String numPagareEntidad;
    protected String numReferencia;
    protected BigDecimal numUnidadesUVR;
    protected Integer otorganteCuenta;
    protected String otorganteNumId;
    protected Integer otorganteTipoId;
    protected String otraModalidadPago;
    protected Boolean otroDestino;
    protected String pais;
    protected String paisCreacion;
    protected String periodicidadGracia;
    protected String periodicidadMuerto;
    protected String periodicidadPlazo;
    protected Boolean periodoGracia;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodoGraciaDe;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodoGraciaHasta;
    protected String periodoGraciaLetras;
    protected BigDecimal periodoGraciaNumero;
    protected Boolean periodoMuerto;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodoMuertoDe;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periodoMuertoHasta;
    protected String periodoMuertoLetras;
    protected BigDecimal periodoMuertoNumero;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plazoCreditoDe;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plazoCreditoHasta;
    protected String plazoLetras;
    protected BigDecimal plazoNumero;
    protected BigDecimal porcentAmortizacionMensual;
    protected BigDecimal porcentAmortizacionSemestral;
    protected BigDecimal porcentajeCobertura;
    protected BigDecimal porcentajeComision;
    protected BigDecimal puntosPorcentualesRedescuento;
    protected String regional;
    protected BigDecimal seguroVida;
    protected BigDecimal spreed;
    protected String tasaInteres;
    protected BigDecimal tasaInteresMora;
    protected String tasaInteresMoraLetras;
    protected BigDecimal tasaInteresRenumEA;
    protected String tasaInteresRenumEALetras;
    protected BigDecimal tasaNominal;
    protected String tasaNominalLetras;
    protected BigDecimal tasaRedescuento;
    protected String textoAdicional;
    protected Integer tipoPagare;
    protected String valorCapitalLetras;
    protected BigDecimal valorCapitalNumero;
    protected BigDecimal valorCuotaPesos;
    protected String valorCuotaPesosLetras;
    protected BigDecimal valorCuotaUVR;
    protected String valorCuotaUVRLetras;
    protected String valorDesembolsoUVRLetras;
    protected String valorInteresesLetras;
    protected BigDecimal valorInteresesNumero;
    protected BigDecimal valorPesosActual;
    protected BigDecimal valorPesosDesembolso;
    protected String valorPesosDesembolsoLetras;
    protected BigDecimal valorPesosDiligenciamiento;
    protected Boolean vis;

    /**
     * Obtiene el valor de la propiedad adquisicionVivienda.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdquisicionVivienda() {
        return adquisicionVivienda;
    }

    /**
     * Define el valor de la propiedad adquisicionVivienda.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdquisicionVivienda(Boolean value) {
        this.adquisicionVivienda = value;
    }

    /**
     * Obtiene el valor de la propiedad apoderadoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getApoderadoCuenta() {
        return apoderadoCuenta;
    }

    /**
     * Define el valor de la propiedad apoderadoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setApoderadoCuenta(Integer value) {
        this.apoderadoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad apoderadoNumId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApoderadoNumId() {
        return apoderadoNumId;
    }

    /**
     * Define el valor de la propiedad apoderadoNumId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApoderadoNumId(String value) {
        this.apoderadoNumId = value;
    }

    /**
     * Obtiene el valor de la propiedad apoderadoTipoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getApoderadoTipoId() {
        return apoderadoTipoId;
    }

    /**
     * Define el valor de la propiedad apoderadoTipoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setApoderadoTipoId(Integer value) {
        this.apoderadoTipoId = value;
    }

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
     * {@link ArchivoAdjuntoDTO }
     * 
     * 
     */
    public List<ArchivoAdjuntoDTO> getArchivosAdjuntos() {
        if (archivosAdjuntos == null) {
            archivosAdjuntos = new ArrayList<ArchivoAdjuntoDTO>();
        }
        return this.archivosAdjuntos;
    }

    /**
     * Obtiene el valor de la propiedad autorizaDebitoAutomatico.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutorizaDebitoAutomatico() {
        return autorizaDebitoAutomatico;
    }

    /**
     * Define el valor de la propiedad autorizaDebitoAutomatico.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutorizaDebitoAutomatico(Boolean value) {
        this.autorizaDebitoAutomatico = value;
    }

    /**
     * Obtiene el valor de la propiedad aval.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAval() {
        return aval;
    }

    /**
     * Define el valor de la propiedad aval.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAval(BigDecimal value) {
        this.aval = value;
    }

    /**
     * Obtiene el valor de la propiedad baseLiquidacionPlazo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseLiquidacionPlazo() {
        return baseLiquidacionPlazo;
    }

    /**
     * Define el valor de la propiedad baseLiquidacionPlazo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseLiquidacionPlazo(String value) {
        this.baseLiquidacionPlazo = value;
    }

    /**
     * Obtiene el valor de la propiedad baseLiquidacionTasa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseLiquidacionTasa() {
        return baseLiquidacionTasa;
    }

    /**
     * Define el valor de la propiedad baseLiquidacionTasa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseLiquidacionTasa(String value) {
        this.baseLiquidacionTasa = value;
    }

    /**
     * Obtiene el valor de la propiedad ciCEApartirDelMes.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCiCEApartirDelMes() {
        return ciCEApartirDelMes;
    }

    /**
     * Define el valor de la propiedad ciCEApartirDelMes.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCiCEApartirDelMes(XMLGregorianCalendar value) {
        this.ciCEApartirDelMes = value;
    }

    /**
     * Obtiene el valor de la propiedad ciCEPagaderaCada.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiCEPagaderaCada() {
        return ciCEPagaderaCada;
    }

    /**
     * Define el valor de la propiedad ciCEPagaderaCada.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiCEPagaderaCada(Integer value) {
        this.ciCEPagaderaCada = value;
    }

    /**
     * Obtiene el valor de la propiedad ciConCuotasExtras.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCiConCuotasExtras() {
        return ciConCuotasExtras;
    }

    /**
     * Define el valor de la propiedad ciConCuotasExtras.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCiConCuotasExtras(Boolean value) {
        this.ciConCuotasExtras = value;
    }

    /**
     * Obtiene el valor de la propiedad ciConPeriodoGracia.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCiConPeriodoGracia() {
        return ciConPeriodoGracia;
    }

    /**
     * Define el valor de la propiedad ciConPeriodoGracia.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCiConPeriodoGracia(Boolean value) {
        this.ciConPeriodoGracia = value;
    }

    /**
     * Obtiene el valor de la propiedad ciNumCuotasExtras.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiNumCuotasExtras() {
        return ciNumCuotasExtras;
    }

    /**
     * Define el valor de la propiedad ciNumCuotasExtras.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiNumCuotasExtras(Integer value) {
        this.ciNumCuotasExtras = value;
    }

    /**
     * Obtiene el valor de la propiedad ciValorCuotaExtra.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCiValorCuotaExtra() {
        return ciValorCuotaExtra;
    }

    /**
     * Define el valor de la propiedad ciValorCuotaExtra.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCiValorCuotaExtra(BigDecimal value) {
        this.ciValorCuotaExtra = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadCreacion() {
        return ciudadCreacion;
    }

    /**
     * Define el valor de la propiedad ciudadCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadCreacion(String value) {
        this.ciudadCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadDesembolso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadDesembolso() {
        return ciudadDesembolso;
    }

    /**
     * Define el valor de la propiedad ciudadDesembolso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadDesembolso(String value) {
        this.ciudadDesembolso = value;
    }

    /**
     * Obtiene el valor de la propiedad codOficina.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodOficina() {
        return codOficina;
    }

    /**
     * Define el valor de la propiedad codOficina.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodOficina(String value) {
        this.codOficina = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoGeoreferenciacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoGeoreferenciacion() {
        return codigoGeoreferenciacion;
    }

    /**
     * Define el valor de la propiedad codigoGeoreferenciacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoGeoreferenciacion(String value) {
        this.codigoGeoreferenciacion = value;
    }

    /**
     * Obtiene el valor de la propiedad construccionViviendaIndividual.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConstruccionViviendaIndividual() {
        return construccionViviendaIndividual;
    }

    /**
     * Define el valor de la propiedad construccionViviendaIndividual.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConstruccionViviendaIndividual(Boolean value) {
        this.construccionViviendaIndividual = value;
    }

    /**
     * Obtiene el valor de la propiedad creditoReembolsableEn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditoReembolsableEn() {
        return creditoReembolsableEn;
    }

    /**
     * Define el valor de la propiedad creditoReembolsableEn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditoReembolsableEn(String value) {
        this.creditoReembolsableEn = value;
    }

    /**
     * Obtiene el valor de la propiedad cuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Define el valor de la propiedad cuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuenta(String value) {
        this.cuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad deptoCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptoCreacion() {
        return deptoCreacion;
    }

    /**
     * Define el valor de la propiedad deptoCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptoCreacion(String value) {
        this.deptoCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad destinoOperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinoOperacion() {
        return destinoOperacion;
    }

    /**
     * Define el valor de la propiedad destinoOperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinoOperacion(String value) {
        this.destinoOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad diaPago.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDiaPago() {
        return diaPago;
    }

    /**
     * Define el valor de la propiedad diaPago.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDiaPago(Integer value) {
        this.diaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad dtfDessembolso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDtfDessembolso() {
        return dtfDessembolso;
    }

    /**
     * Define el valor de la propiedad dtfDessembolso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDtfDessembolso(BigDecimal value) {
        this.dtfDessembolso = value;
    }

    /**
     * Obtiene el valor de la propiedad dtfEA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtfEA() {
        return dtfEA;
    }

    /**
     * Define el valor de la propiedad dtfEA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtfEA(String value) {
        this.dtfEA = value;
    }

    /**
     * Obtiene el valor de la propiedad empresaOtorgante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpresaOtorgante() {
        return empresaOtorgante;
    }

    /**
     * Define el valor de la propiedad empresaOtorgante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpresaOtorgante(String value) {
        this.empresaOtorgante = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDesembolso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDesembolso() {
        return fechaDesembolso;
    }

    /**
     * Define el valor de la propiedad fechaDesembolso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDesembolso(XMLGregorianCalendar value) {
        this.fechaDesembolso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFirmaFisico.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFirmaFisico() {
        return fechaFirmaFisico;
    }

    /**
     * Define el valor de la propiedad fechaFirmaFisico.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFirmaFisico(XMLGregorianCalendar value) {
        this.fechaFirmaFisico = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaGrabacionPagare.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaGrabacionPagare() {
        return fechaGrabacionPagare;
    }

    /**
     * Define el valor de la propiedad fechaGrabacionPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaGrabacionPagare(XMLGregorianCalendar value) {
        this.fechaGrabacionPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPagoPrimerCuota.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPagoPrimerCuota() {
        return fechaPagoPrimerCuota;
    }

    /**
     * Define el valor de la propiedad fechaPagoPrimerCuota.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPagoPrimerCuota(XMLGregorianCalendar value) {
        this.fechaPagoPrimerCuota = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPagoPrimerCuotaCapital.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPagoPrimerCuotaCapital() {
        return fechaPagoPrimerCuotaCapital;
    }

    /**
     * Define el valor de la propiedad fechaPagoPrimerCuotaCapital.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPagoPrimerCuotaCapital(XMLGregorianCalendar value) {
        this.fechaPagoPrimerCuotaCapital = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPagoPrimerCuotaInteres.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPagoPrimerCuotaInteres() {
        return fechaPagoPrimerCuotaInteres;
    }

    /**
     * Define el valor de la propiedad fechaPagoPrimerCuotaInteres.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPagoPrimerCuotaInteres(XMLGregorianCalendar value) {
        this.fechaPagoPrimerCuotaInteres = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPagoPrimerCuotaMensual.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPagoPrimerCuotaMensual() {
        return fechaPagoPrimerCuotaMensual;
    }

    /**
     * Define el valor de la propiedad fechaPagoPrimerCuotaMensual.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPagoPrimerCuotaMensual(XMLGregorianCalendar value) {
        this.fechaPagoPrimerCuotaMensual = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPagoPrimerCuotaSemestral.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPagoPrimerCuotaSemestral() {
        return fechaPagoPrimerCuotaSemestral;
    }

    /**
     * Define el valor de la propiedad fechaPagoPrimerCuotaSemestral.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPagoPrimerCuotaSemestral(XMLGregorianCalendar value) {
        this.fechaPagoPrimerCuotaSemestral = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVencimientoFinanciero.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaVencimientoFinanciero() {
        return fechaVencimientoFinanciero;
    }

    /**
     * Define el valor de la propiedad fechaVencimientoFinanciero.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaVencimientoFinanciero(XMLGregorianCalendar value) {
        this.fechaVencimientoFinanciero = value;
    }

    /**
     * Obtiene el valor de la propiedad garantiaAdicional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGarantiaAdicional() {
        return garantiaAdicional;
    }

    /**
     * Define el valor de la propiedad garantiaAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGarantiaAdicional(String value) {
        this.garantiaAdicional = value;
    }

    /**
     * Obtiene el valor de la propiedad idClaseDefinicionDocumento.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdClaseDefinicionDocumento() {
        return idClaseDefinicionDocumento;
    }

    /**
     * Define el valor de la propiedad idClaseDefinicionDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdClaseDefinicionDocumento(Long value) {
        this.idClaseDefinicionDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumentoPagare.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDocumentoPagare() {
        return idDocumentoPagare;
    }

    /**
     * Define el valor de la propiedad idDocumentoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDocumentoPagare(Long value) {
        this.idDocumentoPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad idGestorDocumental.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdGestorDocumental() {
        return idGestorDocumental;
    }

    /**
     * Define el valor de la propiedad idGestorDocumental.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdGestorDocumental(String value) {
        this.idGestorDocumental = value;
    }

    /**
     * Obtiene el valor de la propiedad listaAmortizaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListaAmortizaciones() {
        return listaAmortizaciones;
    }

    /**
     * Define el valor de la propiedad listaAmortizaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListaAmortizaciones(String value) {
        this.listaAmortizaciones = value;
    }

    /**
     * Gets the value of the listaApoderadoRepresentantePagare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaApoderadoRepresentantePagare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaApoderadoRepresentantePagare().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultaGiradorServiceDTO }
     * 
     * 
     */
    public List<ConsultaGiradorServiceDTO> getListaApoderadoRepresentantePagare() {
        if (listaApoderadoRepresentantePagare == null) {
            listaApoderadoRepresentantePagare = new ArrayList<ConsultaGiradorServiceDTO>();
        }
        return this.listaApoderadoRepresentantePagare;
    }

    /**
     * Gets the value of the listaCodeudoresAvalistasPagare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCodeudoresAvalistasPagare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCodeudoresAvalistasPagare().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultaGiradorServiceDTO }
     * 
     * 
     */
    public List<ConsultaGiradorServiceDTO> getListaCodeudoresAvalistasPagare() {
        if (listaCodeudoresAvalistasPagare == null) {
            listaCodeudoresAvalistasPagare = new ArrayList<ConsultaGiradorServiceDTO>();
        }
        return this.listaCodeudoresAvalistasPagare;
    }

    /**
     * Obtiene el valor de la propiedad margenRedescuento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMargenRedescuento() {
        return margenRedescuento;
    }

    /**
     * Define el valor de la propiedad margenRedescuento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMargenRedescuento(BigDecimal value) {
        this.margenRedescuento = value;
    }

    /**
     * Obtiene el valor de la propiedad mejoramientoViviendaInterSoci.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMejoramientoViviendaInterSoci() {
        return mejoramientoViviendaInterSoci;
    }

    /**
     * Define el valor de la propiedad mejoramientoViviendaInterSoci.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMejoramientoViviendaInterSoci(Boolean value) {
        this.mejoramientoViviendaInterSoci = value;
    }

    /**
     * Gets the value of the mensajeRespuesta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mensajeRespuesta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMensajeRespuesta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMensajeRespuesta() {
        if (mensajeRespuesta == null) {
            mensajeRespuesta = new ArrayList<String>();
        }
        return this.mensajeRespuesta;
    }

    /**
     * Obtiene el valor de la propiedad modalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Define el valor de la propiedad modalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalidad(String value) {
        this.modalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad modalidadPagoCapital.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalidadPagoCapital() {
        return modalidadPagoCapital;
    }

    /**
     * Define el valor de la propiedad modalidadPagoCapital.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalidadPagoCapital(String value) {
        this.modalidadPagoCapital = value;
    }

    /**
     * Obtiene el valor de la propiedad modalidadPagosInteres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalidadPagosInteres() {
        return modalidadPagosInteres;
    }

    /**
     * Define el valor de la propiedad modalidadPagosInteres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalidadPagosInteres(String value) {
        this.modalidadPagosInteres = value;
    }

    /**
     * Obtiene el valor de la propiedad nitEmisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitEmisor() {
        return nitEmisor;
    }

    /**
     * Define el valor de la propiedad nitEmisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitEmisor(String value) {
        this.nitEmisor = value;
    }

    /**
     * Obtiene el valor de la propiedad noVis.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoVis() {
        return noVis;
    }

    /**
     * Define el valor de la propiedad noVis.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoVis(Boolean value) {
        this.noVis = value;
    }

    /**
     * Obtiene el valor de la propiedad numCredito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCredito() {
        return numCredito;
    }

    /**
     * Define el valor de la propiedad numCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCredito(String value) {
        this.numCredito = value;
    }

    /**
     * Obtiene el valor de la propiedad numCuotas.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCuotas() {
        return numCuotas;
    }

    /**
     * Define el valor de la propiedad numCuotas.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCuotas(Integer value) {
        this.numCuotas = value;
    }

    /**
     * Obtiene el valor de la propiedad numCuotasLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuotasLetras() {
        return numCuotasLetras;
    }

    /**
     * Define el valor de la propiedad numCuotasLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuotasLetras(String value) {
        this.numCuotasLetras = value;
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

    /**
     * Obtiene el valor de la propiedad numReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumReferencia() {
        return numReferencia;
    }

    /**
     * Define el valor de la propiedad numReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumReferencia(String value) {
        this.numReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad numUnidadesUVR.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumUnidadesUVR() {
        return numUnidadesUVR;
    }

    /**
     * Define el valor de la propiedad numUnidadesUVR.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumUnidadesUVR(BigDecimal value) {
        this.numUnidadesUVR = value;
    }

    /**
     * Obtiene el valor de la propiedad otorganteCuenta.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOtorganteCuenta() {
        return otorganteCuenta;
    }

    /**
     * Define el valor de la propiedad otorganteCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOtorganteCuenta(Integer value) {
        this.otorganteCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad otorganteNumId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtorganteNumId() {
        return otorganteNumId;
    }

    /**
     * Define el valor de la propiedad otorganteNumId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtorganteNumId(String value) {
        this.otorganteNumId = value;
    }

    /**
     * Obtiene el valor de la propiedad otorganteTipoId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOtorganteTipoId() {
        return otorganteTipoId;
    }

    /**
     * Define el valor de la propiedad otorganteTipoId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOtorganteTipoId(Integer value) {
        this.otorganteTipoId = value;
    }

    /**
     * Obtiene el valor de la propiedad otraModalidadPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtraModalidadPago() {
        return otraModalidadPago;
    }

    /**
     * Define el valor de la propiedad otraModalidadPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtraModalidadPago(String value) {
        this.otraModalidadPago = value;
    }

    /**
     * Obtiene el valor de la propiedad otroDestino.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOtroDestino() {
        return otroDestino;
    }

    /**
     * Define el valor de la propiedad otroDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOtroDestino(Boolean value) {
        this.otroDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtiene el valor de la propiedad paisCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisCreacion() {
        return paisCreacion;
    }

    /**
     * Define el valor de la propiedad paisCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisCreacion(String value) {
        this.paisCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad periodicidadGracia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodicidadGracia() {
        return periodicidadGracia;
    }

    /**
     * Define el valor de la propiedad periodicidadGracia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodicidadGracia(String value) {
        this.periodicidadGracia = value;
    }

    /**
     * Obtiene el valor de la propiedad periodicidadMuerto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodicidadMuerto() {
        return periodicidadMuerto;
    }

    /**
     * Define el valor de la propiedad periodicidadMuerto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodicidadMuerto(String value) {
        this.periodicidadMuerto = value;
    }

    /**
     * Obtiene el valor de la propiedad periodicidadPlazo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodicidadPlazo() {
        return periodicidadPlazo;
    }

    /**
     * Define el valor de la propiedad periodicidadPlazo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodicidadPlazo(String value) {
        this.periodicidadPlazo = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoGracia.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPeriodoGracia() {
        return periodoGracia;
    }

    /**
     * Define el valor de la propiedad periodoGracia.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPeriodoGracia(Boolean value) {
        this.periodoGracia = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoGraciaDe.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodoGraciaDe() {
        return periodoGraciaDe;
    }

    /**
     * Define el valor de la propiedad periodoGraciaDe.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodoGraciaDe(XMLGregorianCalendar value) {
        this.periodoGraciaDe = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoGraciaHasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodoGraciaHasta() {
        return periodoGraciaHasta;
    }

    /**
     * Define el valor de la propiedad periodoGraciaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodoGraciaHasta(XMLGregorianCalendar value) {
        this.periodoGraciaHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoGraciaLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoGraciaLetras() {
        return periodoGraciaLetras;
    }

    /**
     * Define el valor de la propiedad periodoGraciaLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoGraciaLetras(String value) {
        this.periodoGraciaLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoGraciaNumero.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodoGraciaNumero() {
        return periodoGraciaNumero;
    }

    /**
     * Define el valor de la propiedad periodoGraciaNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodoGraciaNumero(BigDecimal value) {
        this.periodoGraciaNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoMuerto.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPeriodoMuerto() {
        return periodoMuerto;
    }

    /**
     * Define el valor de la propiedad periodoMuerto.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPeriodoMuerto(Boolean value) {
        this.periodoMuerto = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoMuertoDe.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodoMuertoDe() {
        return periodoMuertoDe;
    }

    /**
     * Define el valor de la propiedad periodoMuertoDe.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodoMuertoDe(XMLGregorianCalendar value) {
        this.periodoMuertoDe = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoMuertoHasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriodoMuertoHasta() {
        return periodoMuertoHasta;
    }

    /**
     * Define el valor de la propiedad periodoMuertoHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriodoMuertoHasta(XMLGregorianCalendar value) {
        this.periodoMuertoHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoMuertoLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoMuertoLetras() {
        return periodoMuertoLetras;
    }

    /**
     * Define el valor de la propiedad periodoMuertoLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoMuertoLetras(String value) {
        this.periodoMuertoLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoMuertoNumero.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodoMuertoNumero() {
        return periodoMuertoNumero;
    }

    /**
     * Define el valor de la propiedad periodoMuertoNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodoMuertoNumero(BigDecimal value) {
        this.periodoMuertoNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad plazoCreditoDe.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlazoCreditoDe() {
        return plazoCreditoDe;
    }

    /**
     * Define el valor de la propiedad plazoCreditoDe.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlazoCreditoDe(XMLGregorianCalendar value) {
        this.plazoCreditoDe = value;
    }

    /**
     * Obtiene el valor de la propiedad plazoCreditoHasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlazoCreditoHasta() {
        return plazoCreditoHasta;
    }

    /**
     * Define el valor de la propiedad plazoCreditoHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlazoCreditoHasta(XMLGregorianCalendar value) {
        this.plazoCreditoHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad plazoLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazoLetras() {
        return plazoLetras;
    }

    /**
     * Define el valor de la propiedad plazoLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazoLetras(String value) {
        this.plazoLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad plazoNumero.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPlazoNumero() {
        return plazoNumero;
    }

    /**
     * Define el valor de la propiedad plazoNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPlazoNumero(BigDecimal value) {
        this.plazoNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentAmortizacionMensual.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorcentAmortizacionMensual() {
        return porcentAmortizacionMensual;
    }

    /**
     * Define el valor de la propiedad porcentAmortizacionMensual.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorcentAmortizacionMensual(BigDecimal value) {
        this.porcentAmortizacionMensual = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentAmortizacionSemestral.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorcentAmortizacionSemestral() {
        return porcentAmortizacionSemestral;
    }

    /**
     * Define el valor de la propiedad porcentAmortizacionSemestral.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorcentAmortizacionSemestral(BigDecimal value) {
        this.porcentAmortizacionSemestral = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeCobertura.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorcentajeCobertura() {
        return porcentajeCobertura;
    }

    /**
     * Define el valor de la propiedad porcentajeCobertura.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorcentajeCobertura(BigDecimal value) {
        this.porcentajeCobertura = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeComision.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPorcentajeComision() {
        return porcentajeComision;
    }

    /**
     * Define el valor de la propiedad porcentajeComision.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPorcentajeComision(BigDecimal value) {
        this.porcentajeComision = value;
    }

    /**
     * Obtiene el valor de la propiedad puntosPorcentualesRedescuento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPuntosPorcentualesRedescuento() {
        return puntosPorcentualesRedescuento;
    }

    /**
     * Define el valor de la propiedad puntosPorcentualesRedescuento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPuntosPorcentualesRedescuento(BigDecimal value) {
        this.puntosPorcentualesRedescuento = value;
    }

    /**
     * Obtiene el valor de la propiedad regional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegional() {
        return regional;
    }

    /**
     * Define el valor de la propiedad regional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegional(String value) {
        this.regional = value;
    }

    /**
     * Obtiene el valor de la propiedad seguroVida.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSeguroVida() {
        return seguroVida;
    }

    /**
     * Define el valor de la propiedad seguroVida.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSeguroVida(BigDecimal value) {
        this.seguroVida = value;
    }

    /**
     * Obtiene el valor de la propiedad spreed.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpreed() {
        return spreed;
    }

    /**
     * Define el valor de la propiedad spreed.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpreed(BigDecimal value) {
        this.spreed = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaInteres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaInteres() {
        return tasaInteres;
    }

    /**
     * Define el valor de la propiedad tasaInteres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaInteres(String value) {
        this.tasaInteres = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaInteresMora.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTasaInteresMora() {
        return tasaInteresMora;
    }

    /**
     * Define el valor de la propiedad tasaInteresMora.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTasaInteresMora(BigDecimal value) {
        this.tasaInteresMora = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaInteresMoraLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaInteresMoraLetras() {
        return tasaInteresMoraLetras;
    }

    /**
     * Define el valor de la propiedad tasaInteresMoraLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaInteresMoraLetras(String value) {
        this.tasaInteresMoraLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaInteresRenumEA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTasaInteresRenumEA() {
        return tasaInteresRenumEA;
    }

    /**
     * Define el valor de la propiedad tasaInteresRenumEA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTasaInteresRenumEA(BigDecimal value) {
        this.tasaInteresRenumEA = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaInteresRenumEALetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaInteresRenumEALetras() {
        return tasaInteresRenumEALetras;
    }

    /**
     * Define el valor de la propiedad tasaInteresRenumEALetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaInteresRenumEALetras(String value) {
        this.tasaInteresRenumEALetras = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaNominal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTasaNominal() {
        return tasaNominal;
    }

    /**
     * Define el valor de la propiedad tasaNominal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTasaNominal(BigDecimal value) {
        this.tasaNominal = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaNominalLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTasaNominalLetras() {
        return tasaNominalLetras;
    }

    /**
     * Define el valor de la propiedad tasaNominalLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTasaNominalLetras(String value) {
        this.tasaNominalLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad tasaRedescuento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTasaRedescuento() {
        return tasaRedescuento;
    }

    /**
     * Define el valor de la propiedad tasaRedescuento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTasaRedescuento(BigDecimal value) {
        this.tasaRedescuento = value;
    }

    /**
     * Obtiene el valor de la propiedad textoAdicional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoAdicional() {
        return textoAdicional;
    }

    /**
     * Define el valor de la propiedad textoAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoAdicional(String value) {
        this.textoAdicional = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPagare.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoPagare() {
        return tipoPagare;
    }

    /**
     * Define el valor de la propiedad tipoPagare.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoPagare(Integer value) {
        this.tipoPagare = value;
    }

    /**
     * Obtiene el valor de la propiedad valorCapitalLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorCapitalLetras() {
        return valorCapitalLetras;
    }

    /**
     * Define el valor de la propiedad valorCapitalLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorCapitalLetras(String value) {
        this.valorCapitalLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad valorCapitalNumero.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorCapitalNumero() {
        return valorCapitalNumero;
    }

    /**
     * Define el valor de la propiedad valorCapitalNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorCapitalNumero(BigDecimal value) {
        this.valorCapitalNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad valorCuotaPesos.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorCuotaPesos() {
        return valorCuotaPesos;
    }

    /**
     * Define el valor de la propiedad valorCuotaPesos.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorCuotaPesos(BigDecimal value) {
        this.valorCuotaPesos = value;
    }

    /**
     * Obtiene el valor de la propiedad valorCuotaPesosLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorCuotaPesosLetras() {
        return valorCuotaPesosLetras;
    }

    /**
     * Define el valor de la propiedad valorCuotaPesosLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorCuotaPesosLetras(String value) {
        this.valorCuotaPesosLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad valorCuotaUVR.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorCuotaUVR() {
        return valorCuotaUVR;
    }

    /**
     * Define el valor de la propiedad valorCuotaUVR.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorCuotaUVR(BigDecimal value) {
        this.valorCuotaUVR = value;
    }

    /**
     * Obtiene el valor de la propiedad valorCuotaUVRLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorCuotaUVRLetras() {
        return valorCuotaUVRLetras;
    }

    /**
     * Define el valor de la propiedad valorCuotaUVRLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorCuotaUVRLetras(String value) {
        this.valorCuotaUVRLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad valorDesembolsoUVRLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorDesembolsoUVRLetras() {
        return valorDesembolsoUVRLetras;
    }

    /**
     * Define el valor de la propiedad valorDesembolsoUVRLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorDesembolsoUVRLetras(String value) {
        this.valorDesembolsoUVRLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad valorInteresesLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorInteresesLetras() {
        return valorInteresesLetras;
    }

    /**
     * Define el valor de la propiedad valorInteresesLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorInteresesLetras(String value) {
        this.valorInteresesLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad valorInteresesNumero.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorInteresesNumero() {
        return valorInteresesNumero;
    }

    /**
     * Define el valor de la propiedad valorInteresesNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorInteresesNumero(BigDecimal value) {
        this.valorInteresesNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad valorPesosActual.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPesosActual() {
        return valorPesosActual;
    }

    /**
     * Define el valor de la propiedad valorPesosActual.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPesosActual(BigDecimal value) {
        this.valorPesosActual = value;
    }

    /**
     * Obtiene el valor de la propiedad valorPesosDesembolso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPesosDesembolso() {
        return valorPesosDesembolso;
    }

    /**
     * Define el valor de la propiedad valorPesosDesembolso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPesosDesembolso(BigDecimal value) {
        this.valorPesosDesembolso = value;
    }

    /**
     * Obtiene el valor de la propiedad valorPesosDesembolsoLetras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorPesosDesembolsoLetras() {
        return valorPesosDesembolsoLetras;
    }

    /**
     * Define el valor de la propiedad valorPesosDesembolsoLetras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorPesosDesembolsoLetras(String value) {
        this.valorPesosDesembolsoLetras = value;
    }

    /**
     * Obtiene el valor de la propiedad valorPesosDiligenciamiento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPesosDiligenciamiento() {
        return valorPesosDiligenciamiento;
    }

    /**
     * Define el valor de la propiedad valorPesosDiligenciamiento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPesosDiligenciamiento(BigDecimal value) {
        this.valorPesosDiligenciamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad vis.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVis() {
        return vis;
    }

    /**
     * Define el valor de la propiedad vis.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVis(Boolean value) {
        this.vis = value;
    }

}
