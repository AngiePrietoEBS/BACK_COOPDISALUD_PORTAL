/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.Persona;

/**
 *
 * @author Administrador
 */
public interface PersonaService {

    Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION);

    Persona personaWebFindByCIdentificacionAndPerfil(int iPerfil, int xiTipoIden, String C_IDENTIFICACION);

    Persona personaWebFindByID(Long xiCodPersona);
}
