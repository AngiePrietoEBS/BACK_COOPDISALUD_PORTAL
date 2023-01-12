/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;

/**
 *
 * @author Administrador
 */
public interface RegistroNuevoUsuarioService {

    RespuestaGenerica realizarRegistroNuevoUsuario(Persona persona, String sClave, String sLlaveSeg, int iTipoPerfil, int iTipoCanal);
}
