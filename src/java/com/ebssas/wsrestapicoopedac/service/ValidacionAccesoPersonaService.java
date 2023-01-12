/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.request.RequestValidCodigo;
import com.ebssas.wsrestapicoopedac.domain.ValidacionAccesoPersona;

/**
 *
 * @author Administrador
 */
public interface ValidacionAccesoPersonaService {
    
    RespuestaGenerica generarCodigo(String email, String celular);
    
    RespuestaGenerica validarCodigo(RequestValidCodigo requestValidCodigo);
    
    void inactivarTokens(String email, String celular);
    
    ValidacionAccesoPersona findById(String email, String celular);
}
