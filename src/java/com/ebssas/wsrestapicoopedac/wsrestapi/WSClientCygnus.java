package com.ebssas.wsrestapicoopedac.wsrestapi;

import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.service.CygnusCoreServiceBean;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Andrés Sierra
 */
@Path("WSClientCygnus/")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSClientCygnus {

    @Context
    private UriInfo context;

    public WSClientCygnus() {

    }
    
    @POST
    @Path("consultarPersonaCygnus")
    public PersonasDTO consultarPersonaCygnus(@QueryParam("iTipoIdent") String iTipoIdent, @QueryParam("sIdent") String sIdent) {
        return (new CygnusCoreServiceBean()).wsConsultarPersona("", iTipoIdent, sIdent).get(0);
    }
}