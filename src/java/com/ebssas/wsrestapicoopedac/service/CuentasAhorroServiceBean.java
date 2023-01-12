package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIService;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSCtasAhorro;
import java.util.List;

/**
 * @author Andrés Sierra
 */
public class CuentasAhorroServiceBean extends Utilidad implements CuentasAhorroService
{
    private List<Parametros> params;
    Parametros pBd; 
    Parametros pUsu;
    Parametros pPsw;
    
    public CuentasAhorroServiceBean() {
       
        // andysierra <future>
        // En futuros proyectos, usar un singleton para guardar esta info en un principio y no reconsultar:
        ParametroServiceBean parametros  = new ParametroServiceBean();
        this.params = parametros.findAllParams();
       
        this.pBd  = this.findParam(this.params, "DB_BD_CORE");
        this.pUsu = this.findParam(this.params, "DB_SERVER_USERNAME_CORE");
        this.pPsw = this.findParam(this.params, "DB_SERVER_PASSWORD_CORE");
    }

    
    
    
    
    
    
     /**
     * ESTE CONSUMO ME PERMITE CREAR CUENTAS DE AHORROS EN COOPEDAC PARA QUE CUANDO SE 
     * DESEMBOLSE UN CRÉDITO, SE SEPA A DONDE IRÁ EL DINERO LUEGO DE TODOS LOS PROCESOS
     */
    @Override
    public ResponseCrearCtaAhorros crearCuentaAhorrosCoopedac(RequestCrearCtaAhorros req) {
        ResponseCrearCtaAhorros resultado  = new ResponseCrearCtaAhorros();
        String isIndev = this.getValueConfigurePropByKey("INDEV");
        
        if(this.pBd==null || this.pUsu==null || this.pPsw==null) {
            resultado.setbOk("0");
            resultado.setsRespuesta("ERROR [BCASB-CCAC-1]: Algun parametro de la BDWEB ha dado null");
            return resultado;
        }
        
        req.setBd(pBd.getCValor());
        req.setUsu(pUsu.getCValor());
        req.setPsw(pPsw.getCValor());
        
        ConsumoWSCtasAhorro wsCtasAhorro = new ConsumoWSCtasAhorro(
            new ParametroServiceBean().obtenerParametroPorNombre(isIndev.equals("1") ? "WS_CTASAHORRO_INDEV" : "WS_CTASAHORRO")
        );
        req.setFechaApertura(this.curdate());  // fecha actual del servidor

        resultado = wsCtasAhorro.wcCREARCUENTA_AHORROS(req);
        
        if(resultado == null) {
            resultado.setbOk("false");
            resultado.setsRespuesta("ERROR [BCASB-CCAC-2]: La consulta al WS ha fallado!");
        }
        return resultado;
    }

    
    
    
    
    
    /**
     * ESTE CONSUMO ME PERMITE LISTAR LAS CUENTAS DE AHORROS 
     * (DE IGUAL MANERA COMO ESTÁ EN EL WS DE ESTADO CUENTA)
     */
    @Override
    public ResponseListadoCuentas getCuentaAhorrosByIdent(String sIdent) {
        ResponseListadoCuentas resultado = new ResponseListadoCuentas();
        String isIndev = this.getValueConfigurePropByKey("INDEV");
        
        if(this.pBd==null || this.pUsu==null || this.pPsw==null) {
            resultado.setbOk(false);
            resultado.setsRespuesta("ERROR [BCASB-LC-1]: Algun parametro de la BDWEB ha dado null");
            return resultado;
        }
        
        ConsumoWSCtasAhorro wsCtasAhorro = new ConsumoWSCtasAhorro(
            new ParametroServiceBean().obtenerParametroPorNombre(isIndev.equals("1") ? "WS_CTASAHORRO_INDEV" : "WS_CTASAHORRO")
        );
        
        return wsCtasAhorro.wcLISTADOCUENTAS(sIdent, this.pBd.getCValor(), this.pUsu.getCValor(), this.pPsw.getCValor());
    }
    
    
    
}
