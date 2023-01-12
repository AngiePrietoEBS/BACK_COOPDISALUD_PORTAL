package com.ebssas.wsrestapicoopedac.deceval.service.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;



/**
 * Esta clase representa el manejador de passwords cuando se realizan procesos
 * de UsernameToken. El usuario y contraseña debe ser las credenciales asignadas 
 * que se validarán contra el Servidor de aplicaciones
 */
public class PasswordCallback implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {

        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        System.out.println("Identificador: "+ pc.getIdentifier());
        if(pc.getIdentifier()!=null){
        	pc.setPassword(null);
        	if(pc.getIdentifier().equals(PropertiesLoader.loadProperty("co.com.integracion.wssecurity.keystore.user"))){
        		pc.setPassword(PropertiesLoader.loadProperty("co.com.integracion.wssecurity.keystore.password"));
        	}else{
        		pc.setPassword(PropertiesLoader.loadProperty("co.com.integracion.token.password"));
        	}
        }      
        
    }

}
