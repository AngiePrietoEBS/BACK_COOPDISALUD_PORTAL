/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;

import WSAdminCoopedac.ResponseTiposIdent;
import WSAdminCoopedac.WSAdminCoopedac;
import WSAdminCoopedac.WSAdminCoopedacSoap;
import WSEstadoCuentaCoopedac.ArrayOfDato3DTO;
import WSEstadoCuentaCoopedac.ArrayOfDatoDTO;
import WSEstadoCuentaCoopedac.DatoDTO;
import WSEstadoCuentaCoopedac.DetalleCta;
import WSEstadoCuentaCoopedac.Movimiento;
import WSEstadoCuentaCoopedac.WSEstadoCuentaCygnus;
import WSEstadoCuentaCoopedac.WSEstadoCuentaCygnusSoap;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIService;
import java.net.URL;
import java.util.Date;
import javax.xml.namespace.QName;
import WSEstadoCuentaCoopedac.WSEstadoCuentaCygnus;
import WSEstadoCuentaCoopedac.WSEstadoCuentaCygnusSoap;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author EBS-USER
 */
public class ConsumoWSEstadoCuenta {
     private final String sURL_WS;

    public ConsumoWSEstadoCuenta(String sURL_WS) {
        this.sURL_WS = sURL_WS;
    }
     
//    public ResponseTiposIdent wsTiposIdentById(int codigo) {
//        
//        
//        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();
//        
//        try {
//            URL newEndpoint = new URL(sURL_WS);
//            QName qname = new QName("https://www.ebssas.com/", "WSEstadoCuentaCygnus");
//            
//            WSEstadoCuentaCygnus service = new WSEstadoCuentaCygnus(newEndpoint, qname);
//            WSEstadoCuentaCygnusSoap port = service.getWSEstadoCuentaCygnusSoap();
//            responseTiposIdent = port.wsCONSULTARESTADOCUENTAIIISERVICE(sURL_WS, sURL_WS);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return responseTiposIdent;
//    }
    
    public ResponseEstadoCuentaIService wcESTADOCUENTA (String ident, String tipoIdent, Integer producto){
        ResponseEstadoCuentaIService resultado = null;
        try {
            URL newEndpoint = new URL(this.sURL_WS);

            WSEstadoCuentaCygnus service     = new WSEstadoCuentaCygnus(newEndpoint);
            WSEstadoCuentaCygnusSoap puerto  = service.getWSEstadoCuentaCygnusSoap();

            ArrayOfDatoDTO wRespuesta = puerto.wsCONSULTARESTADOCUENTAISERVICE(tipoIdent, ident, producto.toString());
            System.out.println(wRespuesta); 
            resultado = new ResponseEstadoCuentaIService(producto, wRespuesta.getDatoDTO());
            /*if(!(wRespuesta.getDatoDTO().isEmpty())) {
                
                    wRespuesta.getDatoDTO().forEach((x)->{
                    ResponseEstadoCuentaIService c = new ResponseEstadoCuentaIService(
                            x.getLinea(),
                            x.getCupo(),
                            x.getFechapago(),
                            x.getValorpago(),
                            x.getRadicado(),
                            x.getTransaccion()
                    );
                    resultado.add(c);
                });
            }*/
         }
         catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para consultar estado de cuenta");
            System.err.println("\n");
            ex.printStackTrace();
         }
        return resultado;
    }
    
    public List<DatoDTO> wcESTADOCUENTAIDATOS (String ident, String tipoIdent, String producto) throws Exception {
        List<DatoDTO> resultado = new ArrayList();
        try {
            URL newEndpoint = new URL(this.sURL_WS);

            WSEstadoCuentaCygnus service     = new WSEstadoCuentaCygnus(newEndpoint);
            WSEstadoCuentaCygnusSoap puerto  = service.getWSEstadoCuentaCygnusSoap();

            resultado = puerto.wsCONSULTARESTADOCUENTAISERVICE(tipoIdent, ident, producto).getDatoDTO();
         }
         catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para consultar estado de cuenta");
            System.err.println("\n");
            ex.printStackTrace();
         }
        return resultado;
    } 
    
    public Movimiento wcESTADOCUENTA_2 (String radictado,  String tipoProd){
        Movimiento resultado = new Movimiento();
        try {
            URL newEndpoint = new URL(this.sURL_WS);

            WSEstadoCuentaCygnus service     = new WSEstadoCuentaCygnus(newEndpoint);
            WSEstadoCuentaCygnusSoap puerto  = service.getWSEstadoCuentaCygnusSoap();

            resultado = puerto.wsCONSULTARESTADOCUENTAIISERVICE(radictado, tipoProd);
            System.out.println(resultado); 
            //resultado = new ResponseEstadoCuentaIService(producto, wRespuesta.getDatoDTO());
            /*if(!(wRespuesta.getDatoDTO().isEmpty())) {
                
                    wRespuesta.getDatoDTO().forEach((x)->{
                    ResponseEstadoCuentaIService c = new ResponseEstadoCuentaIService(
                            x.getLinea(),
                            x.getCupo(),
                            x.getFechapago(),
                            x.getValorpago(),
                            x.getRadicado(),
                            x.getTransaccion()
                    );
                    resultado.add(c);
                });
            }*/
         }
         catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para consultar estado de cuenta");
            System.err.println("\n");
            ex.printStackTrace();
         }
        return resultado;
    }
    
    public DetalleCta wcOBTENERDETALLECUENTA (String radicado,  String tipoProd){
        DetalleCta resultado = new DetalleCta();
        try {
            URL newEndpoint = new URL(this.sURL_WS);

            WSEstadoCuentaCygnus service     = new WSEstadoCuentaCygnus(newEndpoint);
            WSEstadoCuentaCygnusSoap puerto  = service.getWSEstadoCuentaCygnusSoap();

            resultado = puerto.wsOBTENERDETALLECUENTA(radicado, tipoProd);
            System.out.println(resultado); 
            //resultado = new ResponseEstadoCuentaIService(producto, wRespuesta.getDatoDTO());
            /*if(!(wRespuesta.getDatoDTO().isEmpty())) {
                
                    wRespuesta.getDatoDTO().forEach((x)->{
                    ResponseEstadoCuentaIService c = new ResponseEstadoCuentaIService(
                            x.getLinea(),
                            x.getCupo(),
                            x.getFechapago(),
                            x.getValorpago(),
                            x.getRadicado(),
                            x.getTransaccion()
                    );
                    resultado.add(c);
                });
            }*/
         }
         catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para consultar estado de cuenta");
            System.err.println("\n");
            ex.printStackTrace();
         }
        return resultado;
    }
    
    public ArrayOfDato3DTO wcCONSULTAREXTRACTO (String tipoIdent, String ident,  String producto){
        ArrayOfDato3DTO resultado = new ArrayOfDato3DTO();
        try {
            URL newEndpoint = new URL(this.sURL_WS);

            WSEstadoCuentaCygnus service     = new WSEstadoCuentaCygnus(newEndpoint);
            WSEstadoCuentaCygnusSoap puerto  = service.getWSEstadoCuentaCygnusSoap();

            resultado = puerto.wsCONSULTAREXTRACTO(tipoIdent, ident, producto);
            System.out.println(resultado); 
            //resultado = new ResponseEstadoCuentaIService(producto, wRespuesta.getDatoDTO());
            /*if(!(wRespuesta.getDatoDTO().isEmpty())) {
                
                    wRespuesta.getDatoDTO().forEach((x)->{
                    ResponseEstadoCuentaIService c = new ResponseEstadoCuentaIService(
                            x.getLinea(),
                            x.getCupo(),
                            x.getFechapago(),
                            x.getValorpago(),
                            x.getRadicado(),
                            x.getTransaccion()
                    );
                    resultado.add(c);
                });
            }*/
         }
         catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para consultar estado de cuenta");
            System.err.println("\n");
            ex.printStackTrace();
         }
        return resultado;
    }
}
