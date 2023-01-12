/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.OperacionFinancieraDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;

/**
 *
 * @author Administrador
 */
public class OperacionFinancieraServiceBean implements OperacionFinancieraService {

    @Override
    public OperacionFinanciera findOperacionFinancieraByPersona(Long id) {
        return new OperacionFinancieraDataAccessImp().findOperacionFinancieraByIdPersona(id);
    }

    @Override
    public OperacionFinanciera saveOperacionFinanciera(OperacionFinanciera ocupacionPersona) {
        return new OperacionFinancieraDataAccessImp().saveOperacionFinanciera(ocupacionPersona);
    }

    @Override
    public OperacionFinanciera updateOperacionFinanciera(OperacionFinanciera ocupacionPersona) {
        return new OperacionFinancieraDataAccessImp().updateOperacionFinanciera(ocupacionPersona);
    }

}
