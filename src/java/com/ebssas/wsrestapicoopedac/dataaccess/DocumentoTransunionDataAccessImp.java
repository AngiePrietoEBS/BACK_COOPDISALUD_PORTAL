/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DocumentoTransunion;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class DocumentoTransunionDataAccessImp extends GenericRepositoryJPAImp<DocumentoTransunion> implements DocumentoTransunionDataAccess {

    private EntityManager em = null;

    @Override
    public DocumentoTransunion saveDocumentoTransunion(DocumentoTransunion documentoTransunion) {
        return create(documentoTransunion);
    }

    @Override
    public DocumentoTransunion updateDocumentoTransunion(DocumentoTransunion documentoTransunion) {
        return update(documentoTransunion);
    }

    @Override
    public DocumentoTransunion findDocumentoTransunion(Long idsolCredito) {
        DocumentoTransunion documentoTransunion = new DocumentoTransunion();

        try {
            ConnectionDBJPA connectionDBJPA = new ConnectionDBJPA();
            this.em = connectionDBJPA.getEntityManager();
            String sentencia = "SELECT * FROM DOCUMENTO_TRANSUNION WHERE I_SOL_CREDITO = ?";
            Query query = this.em.createNativeQuery(sentencia, DocumentoTransunion.class);
            query.setParameter(1, idsolCredito);

            List<DocumentoTransunion> list = query.getResultList();
            if (!list.isEmpty()) {
                documentoTransunion = list.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return documentoTransunion;
    }

}
