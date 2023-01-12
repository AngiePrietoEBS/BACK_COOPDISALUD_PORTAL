/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ValidacionAccesoPersona;

/**
 *
 * @author Administrador
 */
public interface ValidacionAccesoPersonaDataAccess {

    ValidacionAccesoPersona save(ValidacionAccesoPersona identSolCred);
    
    void inactivarTokens(Long id);
    
    ValidacionAccesoPersona findByIdSolCred(Long id);
}
