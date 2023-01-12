/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package com.ebssas.wsrestapicoopedac.wsrestapi;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 ** @author Brayan F Silva R
 */
@javax.ws.rs.ApplicationPath("APIRest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.ebssas.wsrestapicoopedac.seguridad.CrossOriginFilterPinc.class);
        resources.add(com.ebssas.wsrestapicoopedac.seguridad.RestSecurityFilter.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSClientCygnus.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSCuentasCygnus.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSParametros.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSRestAdminCore.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSRestAuth.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSRestLogin.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSRestPagos.class);
        resources.add(com.ebssas.wsrestapicoopedac.wsrestapi.WSRestSolicitudCredito.class);

    }

}
