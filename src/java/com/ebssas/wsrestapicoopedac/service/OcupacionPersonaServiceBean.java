/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.OcupacionPersonaDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;

/**
 *
 * @author Administrador
 */
public class OcupacionPersonaServiceBean implements OcupacionPersonaService {

    @Override
    public OcupacionPersona findOcupacionPersonaByPersona(Long id) {
        return new OcupacionPersonaDataAccessImp().findOcupacionPersonaByIdPersona(id);
    }

    @Override
    public OcupacionPersona saveOcupacionPersona(OcupacionPersona ocupacionPersona) {
        return new OcupacionPersonaDataAccessImp().saveOcupacionPersona(ocupacionPersona);
    }

    @Override
    public OcupacionPersona updateOcupacionPersona(OcupacionPersona ocupacionPersona) {
        return new OcupacionPersonaDataAccessImp().updateOcupacionPersona(ocupacionPersona);
    }

}
