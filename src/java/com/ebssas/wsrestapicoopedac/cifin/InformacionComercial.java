/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.cifin;

import com.ebssas.wsrestapicoopedac.cifin.dto.ParametrosConsultaDTO;
import com.ebssas.wsrestapicoopedac.cifin.service.InformacionComercialSoapBindingStub;
import com.ebssas.wsrestapicoopedac.cifin.service.InformacionComercialWSServiceLocator;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestCifin;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author Braya
 */
public class InformacionComercial {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    private Utilidad util;

    public InformacionComercial() {
        this.util = new Utilidad();
    }

    public String consultarInfoComercial(RequestCifin requestCifin) {
        String response = "";
        try {
            InformacionComercialWSServiceLocator locator = new InformacionComercialWSServiceLocator("https://cifinpruebas.asobancaria.com/InformacionComercialWS/services/InformacionComercial?wsdl");
            InformacionComercialSoapBindingStub stub = (InformacionComercialSoapBindingStub) locator.getInformacionComercial();
            //Parámetros a enviar en el WS
            ParametrosConsultaDTO parametros = new ParametrosConsultaDTO();
            parametros.setCodigoInformacion("5702");
            parametros.setMotivoConsulta("35");
            parametros.setNumeroIdentificacion(requestCifin.getNumIdentificacion()); //70041053
            parametros.setTipoIdentificacion(requestCifin.getTipoIdentificacion()); //1
//            parametros.setNumeroIdentificacion("70041053"); //70041053
//            parametros.setTipoIdentificacion("1"); //1
            //Credenciales WS

            stub.setUsername(util.getValueConfigurePropByKey("USER_CIFIN"));
            stub.setPassword(util.getValueConfigurePropByKey("PASS_CIFIN"));

            String respXml = stub.consultaXml(parametros);
            //Convertir respuesta a json
            JSONObject xmlJsonObject = XML.toJSONObject(respXml, true);
            response = xmlJsonObject.toString(PRETTY_PRINT_INDENT_FACTOR);

        } catch (ServiceException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return response;
    }

//    public static void main(String[] args) {
//        InformacionComercial comercial = new InformacionComercial();        
//    }
}
