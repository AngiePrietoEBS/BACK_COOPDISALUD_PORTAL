/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;

/**
 *
 * @author Administrador
 */
public interface OcupacionPersonaDataAccess {
    
    OcupacionPersona saveOcupacionPersona(OcupacionPersona ocupacionPersona);
    
    OcupacionPersona updateOcupacionPersona(OcupacionPersona ocupacionPersona);
    
    OcupacionPersona findOcupacionPersonaByIdPersona(Long id);
    
}
