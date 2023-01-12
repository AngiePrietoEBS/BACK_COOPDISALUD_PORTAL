/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wsrestapi;

import com.ebssas.wsrestapicoopedac.request.RequestLogin;
import com.ebssas.wsrestapicoopedac.request.RequestPrueba;
import com.ebssas.wsrestapicoopedac.seguridad.Secured;
import com.ebssas.wsrestapicoopedac.service.AccesoServiceBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author user
 */
@Path("Login")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestLogin {

    @Context
    private UriInfo context;

    public WSRestLogin() {
    }

    @POST
    @Path("/LoginPersona")
    public String loginUsuarioEmpleado(RequestLogin loginEmpleado) {
        return new AccesoServiceBean().validarLogin(loginEmpleado);
    }
}
