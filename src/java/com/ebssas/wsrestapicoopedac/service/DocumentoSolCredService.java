/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.DocumentoSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseDocSolCred;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface DocumentoSolCredService {

    RespuestaGenerica saveDocSolCred(List<DocumentoSolCred> listDocs);

    ResponseDocSolCred findDocumentoSolCredByIdSolCred(Long idSolCred);
}
