/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;

import WSCygnusCoopedac.PersonasDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import WSCygnusCoopedac.WSCygnusCoreCoopedac;
import WSCygnusCoopedac.WSCygnusCoreCoopedacSoap;

/**
 *
 * @author Administrador
 */
public class ConsumoWSCygnus {
    
    private final String sURL_WS;

    public ConsumoWSCygnus(String sURL_WS) {
        this.sURL_WS = sURL_WS;
    }
    
    public List<PersonasDTO> wcCONSULTARPERSONAS(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        List<PersonasDTO> WSPersona = new ArrayList();
        try {

            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSCygnusCoreCoopedac");

            WSCygnusCoreCoopedac service = new WSCygnusCoreCoopedac(newEndpoint, qname);
            WSCygnusCoreCoopedacSoap cooperagroSoap = service.getWSCygnusCoreCoopedacSoap();
            WSPersona = cooperagroSoap.wsCONSULTARPERSONAS(xiCodigo, xiTipoIden, xcIdentificacion).getPersonasDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return WSPersona;
    }
    
}

