/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;
import com.ebssas.wsrestapicoopedac.request.RequestValidarPersona;

import java.util.List;
import WSCygnusCoopedac.PersonasDTO;

/**
 *
 * @author Administrador
 */
public interface CygnusCoreService {

    List<PersonasDTO> wsConsultarPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    String getEmailPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);

    String getTelPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);
    
    String validarPersona(RequestValidarPersona requestValidarPersona);

    Long getCodigoPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion);
}
