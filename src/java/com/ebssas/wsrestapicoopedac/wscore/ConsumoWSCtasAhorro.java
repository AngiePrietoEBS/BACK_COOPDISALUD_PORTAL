package com.ebssas.wsrestapicoopedac.wscore;

import com.ebssas.wsrestapicoopedac.domain.CuentaAhorro;
import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import ws_cuentaahorros.RespuestaCreaCuentas;
import ws_cuentaahorros.RespuestaInfoCuentas;
import ws_cuentaahorros.WsCuentaAhorros;
import ws_cuentaahorros.WsCuentaAhorrosSoap;

/**
 * 
 * @author Andrés Sierra
 */
public class ConsumoWSCtasAhorro 
{
    private final String sURL_WS;

    public ConsumoWSCtasAhorro(String sURL_WS) {
        this.sURL_WS = sURL_WS;
    }
    
    /**
     * ESTE CONSUMO ME PERMITE CREAR CUENTAS DE AHORROS EN COOPEDAC PARA QUE CUANDO SE 
     * DESEMBOLSE UN CRÉDITO, SE SEPA A DONDE IRÁ EL DINERO LUEGO DE TODOS LOS PROCESOS
     */
    public ResponseCrearCtaAhorros wcCREARCUENTA_AHORROS(RequestCrearCtaAhorros req) {
        ResponseCrearCtaAhorros resultado = null;
        try {
            URL newEndpoint = new URL(this.sURL_WS);
            QName qname = new QName("ws_cuentaAhorros", "Ws_CuentaAhorros");

            WsCuentaAhorros service     = new WsCuentaAhorros(newEndpoint, qname);
            WsCuentaAhorrosSoap puerto  = service.getWsCuentaAhorrosSoap();

            RespuestaCreaCuentas wsRespuesta = puerto.creaCuenta(
                    req.getIdentificacion(), 
                    req.getBeneficiarios(), 
                    req.getCodLinea(), 
                    req.getCodOficina(), 
                    req.getModalidad(), 
                    req.getFechaApertura(), 
                    req.getTipoInteres(), 
                    req.getCodTipoTasa(), 
                    req.getTasaIntHistorica(), 
                    req.getDesviacion(), 
                    req.getCodTipoTasaHistorica(), 
                    req.getExentoRetefuente(), 
                    req.getBd(), 
                    req.getUsu(), 
                    req.getPsw());
            
            resultado = new ResponseCrearCtaAhorros(wsRespuesta.getBOk(), wsRespuesta.getSRespuesta(), wsRespuesta.getSNumCuentaCreado());
            
        } catch (Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-CA]: Hubo un error al invocar al WS para crear la cuenta de ahorros");
            System.err.println("\n");
            ex.printStackTrace();
        }
        return resultado;
    }
    
    
    
    
    
    
    /**
     * ESTE CONSUMO ME PERMITE LISTAR LAS CUENTAS DE AHORROS 
     * (DE IGUAL MANERA COMO ESTÁ EN EL WS DE ESTADO CUENTA)
     */
    public ResponseListadoCuentas wcLISTADOCUENTAS(String sIdent, String bd, String usu, String pass) {
        ResponseListadoCuentas resultado = new ResponseListadoCuentas();
        
         try {
            URL newEndpoint = new URL(this.sURL_WS);
            QName qname = new QName("ws_cuentaAhorros", "Ws_CuentaAhorros");

            WsCuentaAhorros service     = new WsCuentaAhorros(newEndpoint, qname);
            WsCuentaAhorrosSoap puerto  = service.getWsCuentaAhorrosSoap();

            RespuestaInfoCuentas wRespuesta = puerto.listadoCuentas(sIdent, bd, usu, pass);
            System.out.println(wRespuesta);
            List<CuentaAhorro> aux = new ArrayList();
            if(wRespuesta.getBOk().equals("1")) {
                resultado.setbOk(true);
                resultado.setsRespuesta(wRespuesta.getSRespuesta());
                wRespuesta.getInfoCuentas().getListadoCuentasAhorro().forEach((x)->{
                    CuentaAhorro c = new CuentaAhorro(
                            x.getNumeroCuenta(),
                            x.getLinea(),
                            x.getNombreLinea(),
                            x.getDestino(),
                            x.getSaldoTotal(),
                            x.getFechaApertura()
                    );
                    aux.add(c);
                });
                resultado.setListadoCuentasCliente(aux);
            }
            else {
                resultado.setbOk(false);
                resultado.setsRespuesta(wRespuesta.getSRespuesta());
                resultado.setListadoCuentasCliente(null);
            }
         }
         catch(Exception ex) {
            System.err.println("\n**********************************************");
            System.err.println("ERROR [BCWSCA-LC]: Hubo un error al invocar al WS para listar de ahorros");
            System.err.println("\n");
            ex.printStackTrace();
         }
        
        return resultado;
    }
    

}

