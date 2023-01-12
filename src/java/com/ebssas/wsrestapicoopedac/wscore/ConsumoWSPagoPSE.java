/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;

import com.ebssas.wsrestapicoopedac.request.RequestPSEFunctionality;
import java.net.URL;
import javax.xml.namespace.QName;
import webservice.WebServicePSE;
import webservice.WebServicePSE_Service;

/**
 *
 * @author Camilo
 */
public class ConsumoWSPagoPSE {
    
    private final String sURL_WS;

    public ConsumoWSPagoPSE(String sURL_WS) {
        this.sURL_WS = sURL_WS;
    }
    
    public String wcPSEFunctionality (RequestPSEFunctionality requestPSEFunctionality) {
        String resultado = "";
        try {
            URL newEndpoint = new URL(this.sURL_WS);            
            QName qname = new QName("http://WebService/", "WebServicePSE");
            
            WebServicePSE_Service service = new WebServicePSE_Service(newEndpoint, qname);
            WebServicePSE puerto = service.getWebServicePSEPort();
            resultado = puerto.pseFunctionality(
                    requestPSEFunctionality.getPseTotalPago(),
                    requestPSEFunctionality.getPseTipoIdCliente(),
                    requestPSEFunctionality.getPseIdCliente(),
                    requestPSEFunctionality.getPseCodigoCliente(),
                    requestPSEFunctionality.getPseNombreCliente(),
                    requestPSEFunctionality.getPseApellidoCliente(),
                    requestPSEFunctionality.getPseTelefonoCliente(),
                    requestPSEFunctionality.getPseEmailCliente(),
                    requestPSEFunctionality.getIpCliente(),
                    requestPSEFunctionality.getCredito());
            // resultado = new PSEFunctionalityResponse().setReturn().getReturn();
        } 
        catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para pago PSE");
            System.err.println("\n");
            ex.printStackTrace();
        }
        
        return resultado;
    }
    
    
    
}
