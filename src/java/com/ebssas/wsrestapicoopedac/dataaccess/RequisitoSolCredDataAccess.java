/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.RequisitosSolCred;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface RequisitoSolCredDataAccess {
    
    RequisitosSolCred findById(Long id);
    
    List<RequisitosSolCred> findByTipoRequisito(Long id);
    
    List<RequisitosSolCred> findByTipoCredito(Long id);
    
    List<RequisitosSolCred> findByTipoReqAndTipoCred(Long idTipoReq, Long idTipoCred);
}
