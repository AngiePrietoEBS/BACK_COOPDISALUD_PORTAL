/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.RequisitoSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.RequisitosSolCred;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class RequisitoSolCredServiceBean implements RequisitoSolCredService {

    @Override
    public List<RequisitosSolCred> findByTipoReqAndTipoCred(Long idTipoReq, Long idTipoCred) {
        return new RequisitoSolCredDataAccessImp().findByTipoReqAndTipoCred(idTipoReq, idTipoCred);
    }

}
