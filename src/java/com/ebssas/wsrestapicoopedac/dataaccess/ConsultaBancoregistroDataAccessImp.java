/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DocumentoFinanciero;
import com.ebssas.wsrestapicoopedac.domain.DocumentoFirma;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Juan Sebastian F
 */
public class ConsultaBancoregistroDataAccessImp {
    private EntityManager em = null;
    RespuestaGenerica respuesta = new RespuestaGenerica();
    DocumentoFinanciero docf = new DocumentoFinanciero();
    
    public DocumentoFinanciero consultarBanco(int documentoF) {
                
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("select * from documento_financiero "
                    + "where c_documento ='?'", DocumentoFinanciero.class);

            consultDocument.setParameter(1, documentoF);
            
            List<DocumentoFinanciero> docf = consultDocument.getResultList();
            em.getTransaction().begin();
            consultDocument.executeUpdate();
            em.getTransaction().commit();
            
        } catch (Exception e) {
            docf.setICodigo("1");
            docf.setCDescripcion("El Usuario no Fue Identificado");          
            
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return docf;
    }
}
