/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.SolicitudCreditoDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestPSEFunctionality;
import com.ebssas.wsrestapicoopedac.response.ResponsePSEFunctionality;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSPagoPSE;
import java.util.List;

/**
 *
 * @author Camilo
 */
public class PagoPSEServiceBean implements PagoPSEService {
    
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String WS_PAGO_PSE = parametroServiceBean.obtenerParametroPorNombre("WS_PSE");
    private final ConsumoWSPagoPSE wsPagoPSECore = new ConsumoWSPagoPSE(WS_PAGO_PSE);
    private final Utilidad util = new Utilidad();

    public PagoPSEServiceBean() {
        
    }
    
    public ResponsePSEFunctionality wsPSEFunctionality(RequestPSEFunctionality requestPSEFunctionality) {
        ResponsePSEFunctionality resultado = new ResponsePSEFunctionality();
        String aux = "";
        try {
            aux = wsPagoPSECore.wcPSEFunctionality(requestPSEFunctionality);
            resultado.setbRta(true);
            resultado.setsMsj("");
            resultado.setFunctionality(aux);
        }
        catch(Exception e) {
            resultado.setbRta(false);
            resultado.setsMsj("Se ha producido un error al consultar los registros");
            resultado.setFunctionality(null);
        }
        
        return resultado;
    }
    
}
