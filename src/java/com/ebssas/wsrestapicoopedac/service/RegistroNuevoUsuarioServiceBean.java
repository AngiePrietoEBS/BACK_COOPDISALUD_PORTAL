/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.RegistroNuevoUsuarioDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;

/**
 *
 * @author Administrador
 */
public class RegistroNuevoUsuarioServiceBean implements RegistroNuevoUsuarioService {

    private final RegistroNuevoUsuarioDataAccessImp nuevoUsuarioDataAccessImp = new RegistroNuevoUsuarioDataAccessImp();

    @Override
    public RespuestaGenerica realizarRegistroNuevoUsuario(Persona persona, String sClave, String sLlaveSeg, int iTipoPerfil, int iTipoCanal) {
        return nuevoUsuarioDataAccessImp.realizarRegistroNuevoUsuario(persona, sClave, sLlaveSeg, iTipoPerfil, iTipoCanal);
    }

}
