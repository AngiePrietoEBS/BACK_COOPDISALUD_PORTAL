/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;


import WSReglasOtorgamientoCoopedac.RespuestaPermite;
import WSReglasOtorgamientoCoopedac.WSReglasOtorgamientoCoopedac;
import WSReglasOtorgamientoCoopedac.WSReglasOtorgamientoCoopedacSoap;
import com.ebssas.wsrestapicoopedac.service.ParametroServiceBean;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 *
 * @author Juan Sebastian F
 */
public class ConsumoWSReglasOtorgamiento {
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
//    private final String sURL_WS="http://10.10.30.35/WSReglasOtorgamientoCoopedac/WSReglasOtorgamientoCoopedac.asmx?WSDL";
    private final String sURL_WS=parametroServiceBean.obtenerParametroPorNombre("WSREGLAS_OTORGAMIENTO");;
    
    public RespuestaPermite wcREGLASOTORGAMIENTO(String xiIden, String xcCodCred, String xcBd,String xcUsu,String xPsw) {
        RespuestaPermite WSPersona = new RespuestaPermite();
        try {

            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("WSReglasOtorgamientoCoopedac", "WSReglasOtorgamientoCoopedac");

            WSReglasOtorgamientoCoopedac service = new WSReglasOtorgamientoCoopedac(newEndpoint, qname);
            WSReglasOtorgamientoCoopedacSoap coopedacSoap = service.getWSReglasOtorgamientoCoopedacSoap();
            WSPersona = coopedacSoap.validaReglas(xiIden, xcCodCred, xcBd,xcUsu,xPsw);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return WSPersona;
    }
    
//    public static void main(String[] args) {
//        ConsumoWSReglasOtorgamiento f=new ConsumoWSReglasOtorgamiento();
//        RespuestaPermite a=f.wcREGLASOTORGAMIENTO("43502371", "900", "coopedac", "system", "ethos");
//        System.out.println("Respuesta :"+a.getRSRespuesta());
//    }
}
