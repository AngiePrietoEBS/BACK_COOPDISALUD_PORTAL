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

/**
 *
 * @author Administrador
 */
public class ConsumoWSSimuladorCredito {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String URL = parametroServiceBean.obtenerParametroPorNombre("WS_SIM_CREDITO");
    private final String sURL_WS;

    public ConsumoWSSimuladorCredito(String sURL_WS) {
        this.sURL_WS = sURL_WS;
    }

    public RespuestaCupo calculoCupos(String pwsIdentific, String pwsFormPeriodic, String pwsCodCredi, String pwsFormPlazo, String pwsBd, String pwsUsu, String pwsPsw) {
//        System.out.println("datossss-"+pwsIdentific);
//        System.out.println(""+pwsFormPeriodic);
//        System.out.println(""+pwsCodCredi);
//        System.out.println(""+pwsFormPlazo);
//        System.out.println(""+pwsFormPlazo);
//        System.out.println(""+pwsBd);
//        System.out.println(""+pwsUsu);
//        System.out.println(""+pwsPsw);
        RespuestaCupo respuestaCupo = new RespuestaCupo();
        try {
            URL newEndpoint = new URL(URL);
            QName qname = new QName("WSSimuladorCreditoCoopedac", "WSSimuladorCreditoCoopedac");
            WSSimuladorCreditoCoopedac wSClientSimuladorCredito = new WSSimuladorCreditoCoopedac(newEndpoint, qname);
            WSSimuladorCreditoCoopedacSoap clientSimuladorCreditoSoap = wSClientSimuladorCredito.getWSSimuladorCreditoCoopedacSoap();
            pwsFormPeriodic ="Mensual";
            pwsFormPlazo ="Mensual";
            respuestaCupo = clientSimuladorCreditoSoap.calculoCupos(pwsIdentific, pwsFormPeriodic, pwsCodCredi, pwsFormPlazo, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuestaCupo;
    }

    public RespuestaAtr liqSimuladorCreditoAtr(
            String pwsMonto, 
            String pwsNroCuotas, 
            String pwsFechaSol, 
            String pwsValRecog, 
            String pwsCodCredi, 
            String pwsFormPlazo, 
            String pwsIdentific, 
            String pwsFormPeriodic, 
            String pwsValTf1, 
            String pwsFecTf1, 
            String pwsValTf2, 
            String pwsFecTf2, 
            String pwsValTf3, 
            String pwsFecTf3, 
            String pwsFormaPago,
            String pwsBd, 
            String pwsUsu, 
            String pwsPsw) {
        //Respuesta rtaSimCredito = new Respuesta();
        
        RespuestaAtr rtaSimCreditoAtr = new RespuestaAtr();
        try {
            URL newEndpoint = new URL(URL);
            QName qname = new QName("WSSimuladorCreditoCoopedac", "WSSimuladorCreditoCoopedac");
            WSSimuladorCreditoCoopedac wSClientSimuladorCredito = new WSSimuladorCreditoCoopedac(newEndpoint, qname);
            WSSimuladorCreditoCoopedacSoap clientSimuladorCreditoSoap = wSClientSimuladorCredito.getWSSimuladorCreditoCoopedacSoap();
            rtaSimCreditoAtr = clientSimuladorCreditoSoap.liqSimuladorCredito(pwsMonto, pwsNroCuotas, pwsFechaSol, pwsValRecog, pwsCodCredi, pwsFormPlazo, pwsIdentific, pwsFormPeriodic, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, pwsFormaPago, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtaSimCreditoAtr;
    }
    
    public RespuestaCrea creaCredito(String pwsMonto, String pwsNroCuotas, String pwsFechaSol, String pwsValRecog, String pwsCodCredi, String pwsFormPlazo, String pwsIdentific, String pwsFormPeriodic, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3, String pwsNumSolicitud, String pwsEstadoCredito, String pwsEstadoSolicitud, String pwsDescripcion, String pwsCuentaInternaDesem, String pwsFormaPago, String pwsBd, String pwsUsu, String pwsPsw) {
        
        Utilidad util = new Utilidad();
        String newFecha = util.calcularFechaLinaCredito(pwsFechaSol, Integer.parseInt(pwsCodCredi));
        pwsFechaSol = newFecha;
        RespuestaCrea response = new RespuestaCrea();
        try {
            URL newEndpoint = new URL(URL);
            QName qname = new QName("WSSimuladorCreditoCoopedac", "WSSimuladorCreditoCoopedac");
            WSSimuladorCreditoCoopedac service = new WSSimuladorCreditoCoopedac(newEndpoint, qname);
            WSSimuladorCreditoCoopedacSoap port = service.getWSSimuladorCreditoCoopedacSoap();
//            System.out.println("+++++++"+pwsMonto + " " + pwsNroCuotas + " " + pwsFechaSol + " " + pwsValRecog + " " + pwsCodCredi + " " + "plazo" +pwsFormPlazo + " " + pwsIdentific + " " + pwsFormPeriodic + " " + pwsValTf1 + " " + pwsFecTf1 + " " + pwsValTf2 + " " + pwsFecTf2 + " " + pwsValTf3 + " " + pwsFecTf3 + " " + pwsNumSolicitud + " " + pwsEstadoCredito + " " + pwsEstadoSolicitud + " " + pwsDescripcion + " " + pwsCuentaInternaDesem + " " + pwsFormaPago + " " + pwsBd + " " + pwsUsu + " " + pwsPsw);
            response = port.creaCredito(pwsMonto, pwsNroCuotas, pwsFechaSol, pwsValRecog, pwsCodCredi, pwsFormPlazo, pwsIdentific, pwsFormPeriodic, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, pwsNumSolicitud, pwsEstadoCredito,  pwsEstadoSolicitud, pwsDescripcion, pwsCuentaInternaDesem, pwsFormaPago, pwsBd, pwsUsu, pwsPsw);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public RespuestaPermite permiteCredito(String pwsIdentific, String pwsCodCredi, String pwsBd, String pwsUsu, String pwsPsw){
        RespuestaPermite permite = new RespuestaPermite();
        
        try {
            URL newEndpoint = new URL(URL);
            QName qname = new QName("WSSimuladorCreditoCoopedac", "WSSimuladorCreditoCoopedac");
            WSSimuladorCreditoCoopedac service = new WSSimuladorCreditoCoopedac(newEndpoint, qname);
            WSSimuladorCreditoCoopedacSoap port = service.getWSSimuladorCreditoCoopedacSoap();
            permite = port.permiteCredito(pwsIdentific, pwsCodCredi, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return permite;
    }
    
    public RespuestaValorDeuda wsConsultaCuotaCreditoFecha(String psIdentificacion, String pwsNumRadic, String pwsCodDesti, String pwsFechaPag, String pwsBd, String pwsUsu, String pwsPsw){
        RespuestaValorDeuda respuestaValorDeuda = new RespuestaValorDeuda();
        
        try {
            URL newEndpoint = new URL(URL);
            QName qname = new QName("WSSimuladorCreditoCoopedac", "WSSimuladorCreditoCoopedac");
            WSSimuladorCreditoCoopedac service = new WSSimuladorCreditoCoopedac(newEndpoint, qname);
            WSSimuladorCreditoCoopedacSoap port = service.getWSSimuladorCreditoCoopedacSoap();
            respuestaValorDeuda = port.deudaFecha(psIdentificacion, pwsCodDesti, pwsCodDesti, pwsFechaPag, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return respuestaValorDeuda;
    }
    
    public RespuestaValorDeuda wsConsultaPrimeraCuotaCredito(String psIdentificacion, String psNumRadic, String psCodDesti, String psNumCuotas, String pwsBd, String pwsUsu, String pwsPsw) {
        RespuestaValorDeuda respuestaDeuda = new RespuestaValorDeuda();
        try {
            URL newEndpoint = new URL(URL);
            QName qname = new QName("WSSimuladorCreditoCoopedac", "WSSimuladorCreditoCoopedac");

            WSSimuladorCreditoCoopedac service = new WSSimuladorCreditoCoopedac(newEndpoint, qname);
            WSSimuladorCreditoCoopedacSoap port = service.getWSSimuladorCreditoCoopedacSoap();
            respuestaDeuda = port.deudaCuotas(psIdentificacion, psNumRadic, psCodDesti, psNumCuotas, pwsBd, pwsUsu, pwsPsw);
        } catch (Exception e) {
            e.printStackTrace();
            respuestaDeuda = null;
        }
        return respuestaDeuda;
    }
}
