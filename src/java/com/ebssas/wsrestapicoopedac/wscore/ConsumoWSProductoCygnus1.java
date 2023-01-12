/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;

import WSSimuladorCreditoCoopedac.RespuestaAtr;
import WSSimuladorCreditoCoopedac.RespuestaCrea;
import WSSimuladorCreditoCoopedac.RespuestaCupo;
import WSSimuladorCreditoCoopedac.RespuestaPermite;
import WSSimuladorCreditoCoopedac.RespuestaValorDeuda;
import WSSimuladorCreditoCoopedac.WSSimuladorCreditoCoopedac;
import WSSimuladorCreditoCoopedac.WSSimuladorCreditoCoopedacSoap;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import java.net.URL;
import javax.xml.namespace.QName;
import com.ebssas.wsrestapicoopedac.service.ParametroServiceBean;
import wsproductoscygnus.RespuestaCreditos;
import wsproductoscygnus.WsProductosCygnus;
import wsproductoscygnus.WsProductosCygnusSoap;

/**
 *
 * @author Administrador
 */
public class ConsumoWSProductoCygnus1 {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String URL = parametroServiceBean.obtenerParametroPorNombre("");
    private final String sURL_WS;

    public ConsumoWSProductoCygnus1(String sURL_WS) {
        this.sURL_WS = sURL_WS;
    }

    public RespuestaCreditos listadoCreditosradicado(String pwsIdentific, String Radic, String pwsBd, String pwsUsu, String pwsPsw) {

        RespuestaCreditos respuestaCreditos = new RespuestaCreditos();
        
        try {
            URL newEndpoint = new URL("http://129.158.242.142/WsProductosCygnus/WsProductosCygnus.asmx?wsdl");
            QName qname = new QName("WsProductosCygnus", "WsProductosCygnus");
            WsProductosCygnus wsProductosCygnus = new WsProductosCygnus(newEndpoint, qname);
            WsProductosCygnusSoap wsProductosCygnusSoap = wsProductosCygnus.getWsProductosCygnusSoap();

            respuestaCreditos = wsProductosCygnusSoap.listadoCreditosradicado(pwsIdentific,Radic, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuestaCreditos;
    }

}
