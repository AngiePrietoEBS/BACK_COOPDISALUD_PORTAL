package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Acceso;
import com.ebssas.wsrestapicoopedac.domain.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Brian Cardenas
 */
public interface AccesoDataAccess {

    Acceso saveAcceso(Acceso acceso);

    Acceso updateAcceso(Acceso acceso);

    Acceso findAccesoById(Long id);
    
    Acceso findAccesoByIdUser(Usuario usuario);

    void deleteAcceso(Acceso acceso);

    Acceso findAccesoByIUsuarioAndiTransaccion(Long idUser, int iTransaccion);

    String getLlaveSeguridadAcceso(int tipoIdent, String sIdentificacion, String sTipoTransaccion, int iTipoPerfil, int iTipoCanal);

    Usuario validarPrimeraClave(int tipoIdent, String sIdentificacion, String sClaveEncriptada, int iTipoPerfil, int iTipoCanal);
}
