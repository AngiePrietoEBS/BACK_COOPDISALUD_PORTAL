/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DocumentoTransunion;

/**
 *
 * @author Administrador
 */
public interface DocumentoTransunionDataAccess {
 
    DocumentoTransunion saveDocumentoTransunion(DocumentoTransunion documentoTransunion);
    
    DocumentoTransunion updateDocumentoTransunion(DocumentoTransunion documentoTransunion);
    
    DocumentoTransunion findDocumentoTransunion(Long idsolCredito);
    
}
