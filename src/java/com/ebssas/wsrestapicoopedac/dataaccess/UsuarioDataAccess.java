package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Usuario;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Brayan F Silva R
 */
public interface UsuarioDataAccess {

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuario(Usuario usuario);

    Usuario findUsuarioById(Long id);

    Usuario findUserByPersonaIdent(int iTipoIdent, String sIdent);
    
    Usuario findUserBysIdent(int iTipoIdent, String sIdent);

    Usuario validaOlvidoClaveForUser(int xiTipoIdent, String xsIdent, int xiTipoPerfil, Long iTipoCanal);
    
    List<Usuario> listUsuarios();
    
    List<Usuario> listarTodosUsuarios();

}
