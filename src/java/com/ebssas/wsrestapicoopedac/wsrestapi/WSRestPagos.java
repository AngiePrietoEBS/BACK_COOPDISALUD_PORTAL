/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wsrestapi;

import com.ebssas.wsrestapicoopedac.request.RequestPSEFunctionality;
import com.ebssas.wsrestapicoopedac.request.RequestPagoPSE;
import com.ebssas.wsrestapicoopedac.response.ResponsePSEFunctionality;
import com.ebssas.wsrestapicoopedac.service.PagoPSEServiceBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Camilo
 */
@Path("WSPagos/")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSRestPagos {

    public WSRestPagos() {
    }
    
    @POST
    @Path("pagoPSE")
    public ResponsePSEFunctionality pagoPSE(RequestPSEFunctionality requestPSEFunctionality) {
        return (new PagoPSEServiceBean()).wsPSEFunctionality(requestPSEFunctionality);
    }
    
}
