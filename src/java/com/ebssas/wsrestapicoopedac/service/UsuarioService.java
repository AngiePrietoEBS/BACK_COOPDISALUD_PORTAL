/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;

import com.ebssas.wsrestapicoopedac.domain.Usuario;


/**
 *
 * @author Brayan F Silva R
 */
public interface UsuarioService {

    Usuario findUsuarioById(Long id);

}
