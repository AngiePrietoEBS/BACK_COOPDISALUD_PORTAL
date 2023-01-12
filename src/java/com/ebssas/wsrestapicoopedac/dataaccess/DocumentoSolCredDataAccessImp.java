/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DocumentoSolCred;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class DocumentoSolCredDataAccessImp extends GenericRepositoryJPAImp<DocumentoSolCred> implements DocumentoSolCredDataAccess {

    private EntityManager em = null;

    @Override
    public DocumentoSolCred saveDocumentoSolCred(DocumentoSolCred documentoSolCred) {
        return create(documentoSolCred);
    }

    @Override
    public DocumentoSolCred updateDocumentoSolCred(DocumentoSolCred documentoSolCred) {
        return update(documentoSolCred);
    }

    @Override
    public List<DocumentoSolCred> findDocumentoSolCredByIdSolCred(Long IdSolCred) {

        List<DocumentoSolCred> listDocs = new VirtualFlow.ArrayLinkedList<>();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        String sentencia = "SELECT * FROM DOCUMENTO_SOL_CRED WHERE I_SOL_CREDITO = ?";

        try {
            this.em = connDBJPA.getEntityManager();
            Query query = this.em.createNativeQuery(sentencia, DocumentoSolCred.class);
            query.setParameter(1, IdSolCred);

            listDocs = query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (this.em != null) {
                if (this.em.isOpen()) {
                    this.em.close();
                }
            }
        }

        return listDocs;
    }

    public DocumentoSolCred findDocumentoSolCrebByTipoReq(Long idSolCred, Long idTipoRequ) {
        DocumentoSolCred documentoSolAfilWeb = null;
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT * FROM DOCUMENTO_SOL_CRED WHERE I_REQUISITO = ? AND I_SOL_CREDITO = ? ";
            Query query = em.createNativeQuery(sql, DocumentoSolCred.class);
            query.setParameter(1, idTipoRequ);
            query.setParameter(2, idSolCred);
            List<DocumentoSolCred> listDocs = query.getResultList();
            if (listDocs != null && !listDocs.isEmpty()) {
                if (listDocs.size() > 0) {
                    documentoSolAfilWeb = listDocs.get(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            documentoSolAfilWeb = null;
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return documentoSolAfilWeb;
    }

}
