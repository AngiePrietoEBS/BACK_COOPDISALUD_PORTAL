/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.request.RequestDatosPersonales;
import com.ebssas.wsrestapicoopedac.response.ResponseDatosPersonales;
import com.ebssas.wsrestapicoopedac.response.ResponseDatosPersonalesSolCred;

/**
 *
 * @author Administrador
 */
public interface DatosPersonalesSolCredService {

    ResponseDatosPersonalesSolCred obtenerDatosPersonalesCore(Long codPersona);

    ResponseDatosPersonalesSolCred obtenerDatosPersonalesSolCred(Long codPersona, Long idSolCred);

    DatosPersonales findDatosPersonalesByPersona(Long idPersona);

    DatosPersonales saveDatosPersonales(DatosPersonales datosPersonales);

    DatosPersonales updateDatosPersonales(DatosPersonales datosPersonales);

}
