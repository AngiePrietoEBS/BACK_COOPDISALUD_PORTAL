/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;

/**
 *
 * @author Administrador
 */
public interface OcupacionPersonaService {

    OcupacionPersona findOcupacionPersonaByPersona(Long id);

    OcupacionPersona saveOcupacionPersona(OcupacionPersona ocupacionPersona);

    OcupacionPersona updateOcupacionPersona(OcupacionPersona ocupacionPersona);

}
