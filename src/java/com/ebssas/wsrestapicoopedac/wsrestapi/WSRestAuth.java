package com.ebssas.wsrestapicoopedac.wsrestapi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestAuthAPI;
import com.ebssas.wsrestapicoopedac.response.ResponseAuthAPI;
import com.ebssas.wsrestapicoopedac.seguridad.JwtTokenHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Brayan F Silva R
 */
@Path("APIAuth")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestAuth {

    @Context
    private UriInfo context;
    private Utilidad util;
    private JwtTokenHelper jwtTokenHelper;

    /**
     * Creates a new instance of WSRestAuth
     */
    public WSRestAuth() {
        this.util = new Utilidad();
        this.jwtTokenHelper = new JwtTokenHelper();
    }

    @POST
    public ResponseAuthAPI WSAuthenticate(RequestAuthAPI requestAuth) {
        ResponseAuthAPI responseAuth = new ResponseAuthAPI();
        try {
            String user = "123456789";
            String pass = "123456789";
            String sUserDecode = "", sPassDecode = "";
            if (requestAuth != null) {
                if (requestAuth.getsUser() != null && !requestAuth.getsUser().equals("") && requestAuth.getsPass() != null && !requestAuth.getsPass().equals("")) {
                    sUserDecode = util.decodeBase64(requestAuth.getsUser());
                    sPassDecode = util.decodeBase64(requestAuth.getsPass());
                    if (sUserDecode.equals(user) && sPassDecode.equals(pass)) {
                        String token = jwtTokenHelper.issueTokenAuth();
                        responseAuth.setbRta(Boolean.TRUE);
                        responseAuth.setsToken(token);
                        responseAuth.setsMsg("Se ha generado el token correctamente");
                    } else {
                        responseAuth.setbRta(Boolean.FALSE);
                        responseAuth.setsMsg("Datos incorrectos!");
                    }
                } else {
                    responseAuth.setbRta(Boolean.FALSE);
                    responseAuth.setsMsg("Sin datos para validar.");
                }
            } else {
                responseAuth.setbRta(Boolean.FALSE);
                responseAuth.setsMsg("Sin datos para validar.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseAuth.setbRta(Boolean.FALSE);
            responseAuth.setsMsg("Se ha presentado un inconveniente al generar el token.");
        }
        return responseAuth;
    }
}
