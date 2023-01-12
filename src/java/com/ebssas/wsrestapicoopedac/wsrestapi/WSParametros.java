package com.ebssas.wsrestapicoopedac.wsrestapi;

import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.service.ParametroServiceBean;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("WSParams/")
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
public class WSParametros 
{
    @Context
    public UriInfo context;
    
    public WSParametros() {}
    
    @POST
    @Path("getAllParams")
    public List<Parametros> findAllParams() {
        return new ParametroServiceBean().findAllParams();
    }
    
    
}
