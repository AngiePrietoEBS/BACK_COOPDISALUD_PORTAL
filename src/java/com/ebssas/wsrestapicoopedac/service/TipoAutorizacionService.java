/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.TipoAutorizacionSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseTiposAutorizacionesSolCred;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface TipoAutorizacionService {

    ResponseTiposAutorizacionesSolCred findAllTipoAutorizacion();
}
