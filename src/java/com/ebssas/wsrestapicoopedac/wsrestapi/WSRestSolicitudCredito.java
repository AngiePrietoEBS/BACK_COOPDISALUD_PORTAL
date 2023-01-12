
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wsrestapi;

import WSReglasOtorgamientoCoopedac.RespuestaPermite;
import WSSimuladorCreditoCoopedac.RespuestaCrea;
import com.co.ebs.coopechance.respuestasGenericas.AmlResponseDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.BancoRegistroDataAccessImp;
import com.ebssas.wsrestapicoopedac.deceval.sdl.services.ConsultaPagareServiceDTO;
import com.ebssas.wsrestapicoopedac.deceval.sdl.services.CrearGiradorDaneServiceDTO;
import com.ebssas.wsrestapicoopedac.deceval.sdl.services.DocumentoPagareServiceDTO;
import com.ebssas.wsrestapicoopedac.deceval.sdl.services.RespuestaConsultarPagaresDTO;
import com.ebssas.wsrestapicoopedac.deceval.sdl.services.RespuestaCrearGiradorDaneServiceDTO;
import com.ebssas.wsrestapicoopedac.deceval.sdl.services.RespuestaDocumentoPagareServiceDTO;
import com.ebssas.wsrestapicoopedac.deceval.service.client.SDLServiceClient;
import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.domain.AutorizacionSolCredito;
import com.ebssas.wsrestapicoopedac.domain.Comunicacion;
import com.ebssas.wsrestapicoopedac.domain.DocumentoFinanciero;
import com.ebssas.wsrestapicoopedac.domain.DocumentoSolCred;
import com.ebssas.wsrestapicoopedac.domain.DocumentoTransunion;
import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;
import com.ebssas.wsrestapicoopedac.domain.RequisitosSolCred;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoAutorizacionSolCred;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.request.RequestCambiarEstadoSolCred;
import com.ebssas.wsrestapicoopedac.request.RequestConsultaAML;
import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.request.RequestCupoMaxSolCred;
import com.ebssas.wsrestapicoopedac.request.RequestDatosPersona;
import com.ebssas.wsrestapicoopedac.request.RequestDatosPersonales;
import com.ebssas.wsrestapicoopedac.request.RequestRequsitosSolCred;
import com.ebssas.wsrestapicoopedac.request.RequestSimuladorCredito;
import com.ebssas.wsrestapicoopedac.request.RequestValIdent;
import com.ebssas.wsrestapicoopedac.request.RequestValidCodigo;
import com.ebssas.wsrestapicoopedac.request.RequestValidarLinea;
import com.ebssas.wsrestapicoopedac.request.RequestValidarPersona;
import com.ebssas.wsrestapicoopedac.response.ResponseAperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseCaptacionPago;
import com.ebssas.wsrestapicoopedac.response.ResponseComunicacion;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCupoMaximo;
import com.ebssas.wsrestapicoopedac.response.ResponseDatosPersonalesSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseDocSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;
import com.ebssas.wsrestapicoopedac.response.ResponseNuevaSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSimuladorCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseSolicitudDiligenciada;
import com.ebssas.wsrestapicoopedac.response.ResponseTiposAutorizacionesSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseValidarLineaCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseValidarSolCred;
import com.ebssas.wsrestapicoopedac.response.RespuestaCreaPersona;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.responseAML.ResponseConsultaAML;
import com.ebssas.wsrestapicoopedac.service.AperturaCuentaSolCredServiceBean;
import com.ebssas.wsrestapicoopedac.service.AutorizacionSolCreditoServiceBean;
import com.ebssas.wsrestapicoopedac.service.CaptacionPagoServiceBean;
import com.ebssas.wsrestapicoopedac.service.ComunicacionServiceBean;
import com.ebssas.wsrestapicoopedac.service.CuentasAhorroServiceBean;
import com.ebssas.wsrestapicoopedac.service.CygnusCoreServiceBean;
import com.ebssas.wsrestapicoopedac.service.DatosPersonalesSolCredServiceBean;
import com.ebssas.wsrestapicoopedac.service.DocumentoSolCredServiceBean;
import com.ebssas.wsrestapicoopedac.service.InformacionDesembolsoServiceBean;
import com.ebssas.wsrestapicoopedac.service.PersonaServiceBean;
import com.ebssas.wsrestapicoopedac.service.ProdcutosCygnusServiceBean;
import com.ebssas.wsrestapicoopedac.service.ProdcutosCygnusServiceBean1;
import com.ebssas.wsrestapicoopedac.service.RequisitoSolCredServiceBean;
import com.ebssas.wsrestapicoopedac.service.SimuladorCreditoServiceBean;
import com.ebssas.wsrestapicoopedac.service.SolicitudCreditoServiceBean;
import com.ebssas.wsrestapicoopedac.service.Solicitud_Correo_ServiceBean;
import com.ebssas.wsrestapicoopedac.service.TipoAutorizacionServiceBean;
import com.ebssas.wsrestapicoopedac.service.ValidacionAccesoPersonaServiceBean;
import com.ebssas.wsrestapicoopedac.service.consultaWSReglasOServiceBean;
import com.ebssas.wsrestapicoopedac.wsaml.WSamlEthos;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSAmlEthos;
import com.google.gson.Gson;
//import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSAmlEthos;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import ws_cuentaahorros.CreaCuenta;
import ws_cuentaahorros.RespuestaCreaCuentas;
import wsproductoscygnus.RespuestaCodeudor;
import wsproductoscygnus.RespuestaCreditos;

/**
 *
 * @author Andrés Sierra
 */
@Path("WSSolCredito/")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestSolicitudCredito {

    @Context
    private UriInfo context;

    public WSRestSolicitudCredito() {

    }

    @POST
   //@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("buscarTodasSolCredito")
    public ResponseSolicitudCredito buscarTodasSolCredito() {
        return new SolicitudCreditoServiceBean().buscarTodasSolCredito();
    }

    @POST
    @Path("/buscarSolCred")
    public ResponseSolCredito buscarSolCredito(@QueryParam("iNumRadic") String iNumRadic) {
        return new SolicitudCreditoServiceBean().findSolCreditoByRadicado2(iNumRadic);
    }
    
    @POST
    @Path("/buscarSolCredbyPersona")
    public ResponseSolicitudCredito buscarSolCredbyPersona(@QueryParam("xCodPersona") Long xCodPersona) {
        return new SolicitudCreditoServiceBean().buscarSolCredbyPersona(xCodPersona);
    }

    @Path("validarPersona")
    @POST
    public String validarPersonaCore(RequestValidarPersona requestValidarPersona) {
        return new CygnusCoreServiceBean().validarPersona(requestValidarPersona);
    }

    @Path("generarCodigoVal")
    @POST
    public RespuestaGenerica generarCodigoVal(RequestValIdent requestValIdent) {
        return new ValidacionAccesoPersonaServiceBean().generarCodigo(requestValIdent.getCorreo(), requestValIdent.getCelular());
    }

    @Path("validarCodigoVal")
    @POST
    public RespuestaGenerica validarCodigoVal(RequestValidCodigo requestValidCodigo) {
        return new ValidacionAccesoPersonaServiceBean().validarCodigo(requestValidCodigo);
    }

    @POST
    @Path("calcularCuposMaximos")
    public ResponseCupoMaximo obtenerValoresMaximos(RequestCupoMaxSolCred rcmsc) {
        System.out.println("rcmsc"+rcmsc);
        System.out.println("rcmsc.getsPeriodicidad()"+rcmsc.getsPeriodicidad());
        return new SimuladorCreditoServiceBean().calcularCupoMaximo(rcmsc.getsIdentificacion(), rcmsc.getsCodCredito(), rcmsc.getsPeriodicidad());
    }

    @POST
    @Path("simuladorCreditoAtr")
    public ResponseSimuladorCredito SimuladorCreditoAtr(RequestSimuladorCredito rsc) {
        return new SimuladorCreditoServiceBean().simuladorValorCuota(rsc.getsMonto(), rsc.getsNroCuota(), "0", rsc.getsCodCredito(), rsc.getsIdentificacion(), rsc.getXsFormaPeriodicidad(), "0", "0", "0", "0", "0", "0","NOMINA");
    }

    @POST
    @Path("obtenerDatosPersonales")
    public ResponseDatosPersonalesSolCred obtenerDatosPersonales(RequestDatosPersonales datosPersonales) {
        return new DatosPersonalesSolCredServiceBean().obtenerDatosPersonalesSolCred(
                datosPersonales.getCodPersona(),
                datosPersonales.getIdSolCred()
        );
    }

    @POST
    @Path("guardarDatosPersonales")
    public RespuestaGenerica guardarDatosPersonales(RequestDatosPersona datosPersona) {
        RespuestaGenerica resultado = new PersonaServiceBean().saveDatosPersona(datosPersona);
        return resultado;
    }

    @POST
    @Path("guardarAperturaCuenta")
    public RespuestaGenerica guardarAperturaCuenta(AperturaCuentaSolCred acsc) {
        return new AperturaCuentaSolCredServiceBean().actualizarAperturaCuenta(acsc);
    }

    @POST
    @Path("obtenerAperturaCuenta")
    public ResponseAperturaCuentaSolCred obtenerAperturaCuenta(@QueryParam("idSolCred") Long idSolCred) {
        return new AperturaCuentaSolCredServiceBean().findAperturaCuentaBySolCredR(idSolCred);
    }

    @POST
    @Path("validarSolCred")
    public ResponseValidarSolCred validarSolCred(@QueryParam("codPersona") Long codPersona) {
        return new SolicitudCreditoServiceBean().validarSolicitudCredito(codPersona);
    }

    @POST
    @Path("saveSolCred")
    public ResponseNuevaSolicitudCredito saveSolCred(SolicitudCredito solicitudCredito) {
        return new SolicitudCreditoServiceBean().saveSolicitudCredito(solicitudCredito);
    }

    @POST
    @Path("saveDocumentosSolCred")
    public RespuestaGenerica saveDocumentosSolCred(List<DocumentoSolCred> documentoSolCreds) {
        return new DocumentoSolCredServiceBean().saveDocSolCred(documentoSolCreds);
    }

    @POST
    @Path("obtenerRequisitos")
    public List<RequisitosSolCred> obtenerRequisitos(RequestRequsitosSolCred requsitosSolCred) {
        return new RequisitoSolCredServiceBean().findByTipoReqAndTipoCred(requsitosSolCred.getIdTipoReq(), requsitosSolCred.getIdTipoCred());
    }

    @POST
    @Path("obtenerDocumentosSolCred")
    public ResponseDocSolCred obtenerDocumentosSolCred(@QueryParam("idSolCredito") Long idSolCred) {
        return new DocumentoSolCredServiceBean().findDocumentoSolCredByIdSolCred(idSolCred);
    }

    @POST
    @Path("obtenerTiposAutorizacionesNomina")
    public ResponseTiposAutorizacionesSolCred obtenerTiposAutorizaciones() {
        return new TipoAutorizacionServiceBean().findAllTipoAutorizacion();
    }

    @POST
    @Path("obtenerTiposAutorizaciones")
    public ResponseTiposAutorizacionesSolCred obtenerTiposAutorizaciones(@QueryParam("codPersona") String CodigoPersona) {
        return new TipoAutorizacionServiceBean().findAllTipoAutorizacion(CodigoPersona);
    }

    @POST
    @Path("saveAutorizaciones")
    public RespuestaGenerica saveAutorizaciones(List<AutorizacionSolCredito> autorizacionSolCredito) {
        return new AutorizacionSolCreditoServiceBean().saveAutorizacion(autorizacionSolCredito);
    }

    @POST
    @Path("obtenerInformacionDesembolso")
    public InformacionDesembolso obtenerInformacionDesembolso(Long idSolCred) {
        return new InformacionDesembolsoServiceBean().findInformacionDesembolsoBySolCred(idSolCred);
    }

    @POST
    @Path("cambiarEstadoSolicitud")
    public RespuestaGenerica cambiarEstadoSolicitud(RequestCambiarEstadoSolCred cambiarEstadoSolCred) {
        return new SolicitudCreditoServiceBean().cambiarEstado(cambiarEstadoSolCred.getlCodSolCredito(), cambiarEstadoSolCred.getlCodEstado(), cambiarEstadoSolCred.getlCodUsuario(), cambiarEstadoSolCred.getsObservacion(), cambiarEstadoSolCred.getcNumRadic(), cambiarEstadoSolCred.getcPagareCygnus(), cambiarEstadoSolCred.getcPagareDeceval());
    }

    @POST
    @Path("validarSolicitud")
    public ResponseSolicitudDiligenciada validarSolicitud(@QueryParam("idPersona") Long idPersona) {
        return new SolicitudCreditoServiceBean().findSolCreditoDiligenciada(idPersona);
    }

    @POST
    @Path("validarLineaCredito")
    public RespuestaGenerica validarLineaCredito(RequestValidarLinea requestValidarLinea) {
        return new SolicitudCreditoServiceBean().findSolCreditoByLineaByPersona(requestValidarLinea);
        
    }

    @POST
    @Path("saveDocumentoTU")
    public RespuestaGenerica saveDocumentoTransunion(DocumentoTransunion documentoTransunion) {
        return new DocumentoSolCredServiceBean().saveDocumentoTransunion(documentoTransunion);
    }

    @POST
    @Path("obtenerDocumentoTU")
    public DocumentoTransunion obtenerDocumentoTransunion(@QueryParam("idSolCredito") Long idSolCred) {
        return new DocumentoSolCredServiceBean().findDocumentoTU(idSolCred);
    }

    @POST
    @Path("guardarComunicacion")
    public ResponseComunicacion guardarComunicacion(Comunicacion c) {
        System.out.println(c.getCMensaje());
        return new ComunicacionServiceBean().saveComunicacion(c);
    }

    @POST
    @Path("obtenerComunicados")
    public List<Comunicacion> obtenerComunicaciones(@QueryParam("idSolCred") Long id) {
        return new ComunicacionServiceBean().findAllComunicacionesSolCred(id);
    }

    @POST
    @Path("obtenerTotCaptacionPago")
    public ResponseCaptacionPago obtenerTotCaptacionPago(@QueryParam("Cedula") Long Cedula) {
        return new CaptacionPagoServiceBean().CalculoTotal(Cedula);
    }

    @POST
    @Path("consultarAML")
    public ResponseConsultaAML consultarAML(RequestConsultaAML consultaAML) {
        return new ConsumoWSAmlEthos().consultaListasSoap(consultaAML.getsNombre(), consultaAML.getsIdentificacion(), "2");
    }

    @POST
    @Path("amlGenerarPDF")
    public AmlResponseDTO amlGenerarPDF(RequestConsultaAML consultaAML) {
        return new ConsumoWSAmlEthos().generarPDF(consultaAML.getsIdentificacion(), consultaAML.getsNombre());
    }

    @POST
    @Path("emailDiligenciado")
    public RespuestaGenerica emailDiligenciado(@QueryParam("iCodigo") Long iCodigo,
            @QueryParam("Radicado") Long Radicado,
            @QueryParam("LCredito") String LCredito) {
        return new Solicitud_Correo_ServiceBean().Diligenciado(iCodigo, Radicado, LCredito);
    }

    @POST
    @Path("emailAprobado")
    public RespuestaGenerica emailAprobado(@QueryParam("iCodigo") Long iCodigo,
            @QueryParam("Radicado") Long Radicado,
            @QueryParam("LCredito") String LCredito,
            @QueryParam("Valor") Long Valor) {

        return new Solicitud_Correo_ServiceBean().Aprobado(iCodigo, Radicado, LCredito, Valor);
    }

    @POST
    @Path("emailDesembolsado")
    public RespuestaGenerica emailDesembolsado(@QueryParam("iCodigo") Long iCodigo,
            @QueryParam("Radicado") Long Radicado,
            @QueryParam("cValor") String cValor,
            @QueryParam("cEntidad") String cEntidad,
            @QueryParam("cCuenta") String cCuenta,
            @QueryParam("LCredito") String LCredito)
            throws Exception {
        return new Solicitud_Correo_ServiceBean().Desembolsado(iCodigo, Radicado, LCredito, cEntidad, cCuenta, cValor);
    }

    @POST
    @Path("crearCuentaAhorros")
    public ResponseCrearCtaAhorros crearCuentaAhorros(RequestCrearCtaAhorros req) {
        return new CuentasAhorroServiceBean().crearCuentaAhorrosCoopedac(req);
    }
    
    @POST
    @Path("cuentaAhorros")
    public ResponseListadoCuentas cuentaAhorrosbyIdent(@QueryParam("xNumIdent") String ident) {
        return new CuentasAhorroServiceBean().getCuentaAhorrosByIdent(ident);
    }

//    @POST
//    @Path("listadoCuentas")
//    public ResponseListadoCuentas listadoCuentas(@QueryParam("sIdent") String sIdent) {
//        return new CuentasAhorroServiceBean().listadoCuentas(sIdent);
//    }
    @POST
    @Path("creargirardor")
    public RespuestaCrearGiradorDaneServiceDTO creargirardor(CrearGiradorDaneServiceDTO crearGiradorDane) {
        return new SDLServiceClient().crearGirador(crearGiradorDane);
    }

    @POST
    @Path("consultaPagares") //
    public RespuestaConsultarPagaresDTO consultaPagares(ConsultaPagareServiceDTO consultaPagaresDTO) {
        return new SDLServiceClient().consultaPagares(consultaPagaresDTO);
    }

    @POST
    @Path("crearPagare")
    public RespuestaDocumentoPagareServiceDTO crearPagare(DocumentoPagareServiceDTO documentoPagareServiceDTO) {
        return new SDLServiceClient().crearPagare(documentoPagareServiceDTO);
    }

    @POST
    @Path("registrarBanco")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public RespuestaGenerica registrarBanco(DocumentoFinanciero infoBancaria) {
        return new BancoRegistroDataAccessImp().insertarBanco(infoBancaria);
    }

        @POST
        @Path("crearCreditoCygnus")
        public RespuestaCrea crearCreditoCygnus(SolicitudCredito solicitudCredito,  @QueryParam("sEstadoCredito") String estadoCredito) {       
//        public String crearCreditoCygnus(SolicitudCredito solicitudCredito,  @QueryParam("sEstadoCredito") String estadoCredito) {       
//            System.out.println("estadoCredito"+estadoCredito);
//            System.out.println(solicitudCredito.toString());
            return new SimuladorCreditoServiceBean().crearCreditoCygnus(solicitudCredito, estadoCredito);
        }

    @POST
    @Path("consultaSolicitudDesembolso")
    public DocumentoFinanciero consultaSolicitudDesembolso(@QueryParam("iCedula") Long iCedula, @QueryParam("iNumRadicado") String iNumRadicado) {
        return new BancoRegistroDataAccessImp().consultarBanco(iCedula, iNumRadicado);
    }

//    @POST
//    @Path("reglasOtorgamiento")
//    public DocumentoFinanciero reglasOtorgamiento() {
//        return new ConsultaBancoregistroDataAccessImp().consultarBanco(sIdent);
//    }
    @POST
    @Path("consultaWSReglasO")
    public RespuestaPermite consultaWSReglasO(@QueryParam("xiIden") String xiIden, @QueryParam("xcCodCred") String xcCodCred) {
        return new consultaWSReglasOServiceBean().consultaReglasO(xiIden, xcCodCred);
    }

    /**
     * Método que permite actualizar en la tabla SOLICITUD_CREDITO el campo C_BASE64 con el pagaré.
     * @param solicitudCredito
     * @return un objeto RespuestaGenerica.
     */
    
    @POST
    @Path("saveDocumentoPagare")
    public RespuestaGenerica saveDocumentoPagare(SolicitudCredito solicitudCredito ) {
        return new SolicitudCreditoServiceBean().saveDocumentoPagare(solicitudCredito);
    }
    
    @POST
    @Path("guardarPersonaCygnus")
    public RespuestaCreaPersona guardarPersonaCygnus(RequestDatosPersona datosPersona) {
        return new PersonaServiceBean().guardarPersonaCompleta(datosPersona);
    }
    
    @POST
    @Path("consultaDeudorCodeudor")
    public RespuestaCodeudor consultaDeudorCodeudor(@QueryParam("xiIden") String xiIden) {
        return new ProdcutosCygnusServiceBean().deudor_codeudor(xiIden);
    }
    
    @POST
    @Path("consultaListaCreditos")
    public RespuestaCreditos consultaListaCreditos(@QueryParam("xiIdenn") String xiIdenn, @QueryParam("xcCodCred") String xcCodCred) {
        return new ProdcutosCygnusServiceBean1().listadoCreditosradicado(xiIdenn, xcCodCred);
    }
}
