/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DocumentoSolCred;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface DocumentoSolCredDataAccess {
    
    DocumentoSolCred saveDocumentoSolCred(DocumentoSolCred documentoSolCred);
    
    DocumentoSolCred updateDocumentoSolCred(DocumentoSolCred documentoSolCred);
    
    List<DocumentoSolCred> findDocumentoSolCredByIdSolCred(Long IdSolCred);
    
}
