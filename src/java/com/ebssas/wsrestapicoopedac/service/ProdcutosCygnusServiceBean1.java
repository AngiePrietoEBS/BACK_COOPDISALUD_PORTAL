package com.ebssas.wsrestapicoopedac.service;

import WSSimuladorCreditoCoopedac.RespuestaCupo;
import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCupoMaximo;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIService;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSCtasAhorro;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSProductoCygnus;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSProductoCygnus1;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSSimuladorCredito;
import java.util.List;
import wsproductoscygnus.RespuestaCreditos;


/**
 * @author Andrés Sierra
 */
public class ProdcutosCygnusServiceBean1
{
    
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sBDCore = parametroServiceBean.obtenerParametroPorNombre("DB_BD_CORE");
    private final String sUserCore = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_USERNAME_CORE");
    private final String sPassCore = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_PASSWORD_CORE");
    private final ConsumoWSProductoCygnus1 consumoWSProductoCygnus1;

        public ProdcutosCygnusServiceBean1() {
        this.consumoWSProductoCygnus1 = new ConsumoWSProductoCygnus1("http://129.158.242.142/WsProductosCygnus/WsProductosCygnus.asmx?wsdl");
    }

    
    /*public ProdcutosCygnusServiceBean() {
       
        // andysierra <future>
        // En futuros proyectos, usar un singleton para guardar esta info en un principio y no reconsultar:
        ParametroServiceBean parametros  = new ParametroServiceBean();
        this.params = parametros.findAllParams();
       
        this.pBd  = this.findParam(this.params, "DB_BD_CORE");
        this.pUsu = this.findParam(this.params, "DB_SERVER_USERNAME_CORE");
        this.pPsw = this.findParam(this.params, "DB_SERVER_PASSWORD_CORE");
    }*/


    
    
    
    
    
    
     /**
     * ESTE CONSUMO ME PERMITE CREAR CUENTAS DE AHORROS EN COOPEDAC PARA QUE CUANDO SE 
     * DESEMBOLSE UN CRÉDITO, SE SEPA A DONDE IRÁ EL DINERO LUEGO DE TODOS LOS PROCESOS
     */
   
     
    public RespuestaCreditos listadoCreditosradicado (String pwsIdentific, String Radic ) {
        
        RespuestaCreditos respuestaCreditos = new RespuestaCreditos();
            
            respuestaCreditos = this.consumoWSProductoCygnus1.listadoCreditosradicado(pwsIdentific,Radic, "coopedac", "sysadm", "E3C720DA4004");
            try {
                if (respuestaCreditos != null) {

                    // Armamos la respuesta:
                   /* responseCupoMaximo.setbRta(Boolean.TRUE);
                    responseCupoMaximo.setsCupoMaximo(util.valorPattern(respuestaCupo.getRSMaxMonto()));
                    responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
                    responseCupoMaximo.setsMsj("El plazo maximo asignado es de " + respuestaCupo.getRSMaxPlazo() + " meses. El cupo máximo asignado para su solictud es de $" + respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setsValorCuota(respuestaCupo.getRSValorCuota());*/
                } else {
                    /*responseCupoMaximo.setbRta(Boolean.FALSE);
                    responseCupoMaximo.setsMsj("El valor de la solicitud esta sujeto a verificaciÃ³n por parte de la entidad.");
                    responseCupoMaximo.setsCupoMaximo(respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
//		    responseCupoMaximo.setsTasaInteres(respuestaCupo.getRSTfijos());*/

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       
//        System.out.println("++++responseCupoMaximo"+responseCupoMaximo);
        return respuestaCreditos;
    }   

}
