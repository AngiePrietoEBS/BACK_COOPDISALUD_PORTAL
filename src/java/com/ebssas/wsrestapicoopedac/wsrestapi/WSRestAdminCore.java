/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wsrestapi;

import WSAdminCoopedac.ResponseActividadEconomica;
import WSAdminCoopedac.ResponseProfesion;
import WSAdminCoopedac.ResponseNivelesEstudio;
import WSAdminCoopedac.ResponseTipoEstadoCivil;
import WSAdminCoopedac.ResponseCargo;
import WSAdminCoopedac.ResponseCiudad;
import WSAdminCoopedac.ResponseLineaCredito;
import WSAdminCoopedac.ResponsePeriodo;
import WSAdminCoopedac.ResponseTipoContrato;
import WSAdminCoopedac.ResponseTiposIdent;
import com.ebssas.wsrestapicoopedac.response.ResponseEntidades;
import com.ebssas.wsrestapicoopedac.service.AdminCoreServiceBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrador
 */
@Path("/WSAdminCore/")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestAdminCore {

    @POST
    @Path("tiposIden")
    public ResponseTiposIdent getTipoIdent() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposIdentHabilitados();
    }
    
    @POST
    @Path("tiposContrato")
    public ResponseTipoContrato getTipoContrato() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposContrato();
    }
    
    @POST
    @Path("tiposCiudad")
    public ResponseCiudad getTipoCiudad() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsCiudad();
    }

    @POST
    @Path("lineasCreditoHab")
    public ResponseLineaCredito getLineasCreditoHab() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsLineaCredito();
    }

    @POST
    @Path("periodos")
//    @Secured
    public ResponsePeriodo getPeriodos() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.obtenerPeriodicidadHabilitadasSolCred();
    }

    @POST
    @Path("entidades")
//    @Secured
    public ResponseEntidades getEntidades() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsEntidades();
    }
    
    @POST
    @Path("cargos")
//    @Secured
    public ResponseCargo getCargos() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsCargos();
    }
    
    @POST
    @Path("tiposEstadoCivil")
//    @Secured
    public ResponseTipoEstadoCivil getEstadoCivil() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTipoEstadoCivil();
    }
    
    @POST
    @Path("tiposNivelEstudio")
//    @Secured
    public ResponseNivelesEstudio getTipoNivelEstudio() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsTiposNivEstudio();
    }
    
    @POST
    @Path("profesiones")
//    @Secured
    public ResponseProfesion getProfesiones() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsProfesiones();
    }
    
    @POST
    @Path("actividadEconomica")
//    @Secured
    public ResponseActividadEconomica getActividadEconomica() {
        AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
        return adminCoreServiceBean.wsActividadEconomica();
    }
}
