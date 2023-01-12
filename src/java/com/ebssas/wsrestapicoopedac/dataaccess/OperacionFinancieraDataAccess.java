/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;

/**
 *
 * @author Administrador
 */
public interface OperacionFinancieraDataAccess {

    OperacionFinanciera saveOperacionFinanciera(OperacionFinanciera operacionFinanciera);

    OperacionFinanciera updateOperacionFinanciera(OperacionFinanciera operacionFinanciera);

    OperacionFinanciera findOperacionFinancieraByIdPersona(Long id);

}
