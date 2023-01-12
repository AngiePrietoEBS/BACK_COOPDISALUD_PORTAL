package com.ebssas.wsrestapicoopedac.wsrestapi;

import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCreditoConCuota;
import com.ebssas.wsrestapicoopedac.response.ResponseDetalleCuenta;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIGeneric;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIIGeneric;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIService;
import com.ebssas.wsrestapicoopedac.response.ResponseExtracto;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;
import com.ebssas.wsrestapicoopedac.service.CuentasAhorroServiceBean;
import com.ebssas.wsrestapicoopedac.service.EstadoCuentaServiceBean;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;

@Path("WSCuentasCygnus/")
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
public class WSCuentasCygnus 
{

    @Context
    private UriInfo context;

    
    public WSCuentasCygnus() {
    }
    
    @POST
    @Path("crearCuentaAhorros")
    public ResponseCrearCtaAhorros crearCuentaAhorros(RequestCrearCtaAhorros req) {
        return new CuentasAhorroServiceBean().crearCuentaAhorrosCoopedac(req);
    }

    
    @POST
    @Path("getCuentaAhorrosByIdent")
    public ResponseListadoCuentas getCuentaAhorrosByIdent(@QueryParam("sIdent") String sIdent) {
        return new CuentasAhorroServiceBean().getCuentaAhorrosByIdent(sIdent);
    }
    
    @POST
    @Path("getEstadoCtaI")
    public ResponseEstadoCuentaIGeneric getEstadoCtaI(@QueryParam("tipoIdent") String tipoIdent, @QueryParam("ident") String ident) {
        return new EstadoCuentaServiceBean().getEstadoCtaI(ident, tipoIdent);
    }
                                
    @POST
    @Path("getEstadoCtaII")
    public ResponseEstadoCuentaIIGeneric getEstadoCtaII(@QueryParam("radicado") String radicado, @QueryParam("tipoProd") String tipoProd) {
        return new EstadoCuentaServiceBean().getEstadoCtaII(radicado, tipoProd);
    }
    
    @POST
    @Path("getDetalleCta")
    public ResponseDetalleCuenta getDetalleCta(@QueryParam("radicado") String radicado, @QueryParam("tipoProd") String tipoProd) {
        return new EstadoCuentaServiceBean().getDetalleCta(radicado, tipoProd);
    }
    
    @POST
    @Path("getExtracto")
    public ResponseExtracto getExtracto(@QueryParam("tipoIdent") String tipoIdent, @QueryParam("ident") String ident, @QueryParam("producto") String producto) {
        return new EstadoCuentaServiceBean().getExtracto(tipoIdent, ident, producto);
    }
    
    @POST
    @Path("getCreditoConCuota")
    public ResponseCreditoConCuota getCreditoConCuota(@QueryParam("tipoIdent") String tipoIdent, @QueryParam("ident") String ident, @QueryParam("producto") String producto) {
        return new EstadoCuentaServiceBean().getCreditoConCuota(tipoIdent, ident, producto);
    }
    
}
