/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.request.RequestCifin;
import com.ebssas.wsrestapicoopedac.response.ResponseCifin;

/**
 *
 * @author Administrador
 */
public interface ConsultaCifinService {
    
    ResponseCifin consultarPuntajeScore(RequestCifin requestCifin);
    
    ResponseCifin validarConsultaScore(RequestCifin requestCifin);
}
