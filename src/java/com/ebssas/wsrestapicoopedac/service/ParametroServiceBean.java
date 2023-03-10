/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.ParametroDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.ParametrosDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.response.ResponseParametros;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan F Silva R
 */
public class ParametroServiceBean implements ParametroService {

    private final ParametroDataAccessImp parametroDataAccessImp = new ParametroDataAccessImp();

    @Override
    public String obtenerParametroPorNombre(String sNombreParam) {
        String sValorParametro = parametroDataAccessImp.getValorParametroByNombre(sNombreParam);
        return sValorParametro;
    }

    @Override
    public ResponseParametros parametrosClave() {
        ResponseParametros response = new ResponseParametros();
        String alfanum = this.obtenerParametroPorNombre("PASSWORD_ALPHANUMERICO");
        String canMin = this.obtenerParametroPorNombre("MIN_PRIMER_PASSWORD");
        String canMax = this.obtenerParametroPorNombre("MAX_PRIMER_PASSWORD");
        if (alfanum!=null && canMax!=null && canMin!=null) {
            response.setAlfanumerico(alfanum);
            response.setCanMinDig(canMin);
            response.setCantMaxDig(canMax);
            response.setFlag(true);
            response.setsMsg("Consulta correcta");
        }
        else{
            response.setFlag(false);
            response.setsMsg("No se pudo realizar la consulta");
        }
        return response;
    }

    public List<Parametros> findAllParams() {
        return new ParametrosDataAccessImp().findAll();
    }
}
