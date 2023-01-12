/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.OperacionFinancieraDataAccess;
import com.ebssas.wsrestapicoopedac.dataaccess.OperacionFinancieraDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.response.ResponseCaptacionPago;

/**
 *
 * @author EBS-USER
 */
public class CaptacionPagoServiceBean {

    public ResponseCaptacionPago CalculoTotal(Long Codigo) {

        OperacionFinancieraDataAccessImp op = new OperacionFinancieraDataAccessImp();

        OperacionFinanciera Suma = op.findOperacionFinancieraByIdPersona(Codigo);
        Long Operador1=Suma.getNDescuentosLaborales();

        return null;
    }

}
