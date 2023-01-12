/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ConsultaCifin;
import com.ebssas.wsrestapicoopedac.domain.DocumentoFinancier;
import com.ebssas.wsrestapicoopedac.domain.DocumentoFinanciero;
import com.ebssas.wsrestapicoopedac.domain.DocumentoFirma;
import com.ebssas.wsrestapicoopedac.domain.Usuario;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Juan Sebastian F
 */
public class BancoRegistroDataAccessImp {

    private EntityManager em = null;
    RespuestaGenerica respuesta = new RespuestaGenerica();

    public RespuestaGenerica insertarBanco(DocumentoFinanciero documentoF) {

        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("insert into documento_Financiero  \n"
                    + " (C_BASE64, C_DESCRIPCION, C_ENTIDAD_FIN, C_NUMCUENTA, I_TIPOCUENTA, I_CODIGO, C_DOCUMENTO, I_NUM_RADICADO) \n"
                    + " values (?,?,?,?,?,SEC_BANCO.NEXTVAL,?, ?)");
            
            consultDocument.setParameter(1, documentoF.getCBase64());
            consultDocument.setParameter(2, documentoF.getCDescripcion());
            consultDocument.setParameter(3, documentoF.getCEntidadFin());
            consultDocument.setParameter(4, documentoF.getCNumcuenta());
            consultDocument.setParameter(5, documentoF.getITipocuenta());
            consultDocument.setParameter(6, documentoF.getCDocumento());
            consultDocument.setParameter(7, documentoF.getINumRadicado());
            consultDocument.setParameter(8, "");

            em.getTransaction().begin();
            consultDocument.executeUpdate();
            em.getTransaction().commit();

            respuesta.setbRta(Boolean.TRUE);
            respuesta.setiCodigo(1);
            respuesta.setsMsj("Se ha registrado la cuenta de manera exitosa.");
        } catch (Exception e) {
            respuesta.setbRta(Boolean.FALSE);
            respuesta.setiCodigo(1);
            respuesta.setsMsj("Se ha generado una inconsistencia");
            throw new RuntimeException(e.getMessage());

        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return respuesta;
    }

    /**
     * Método que permite consultar en la tabla Documento_Financiero un registro en base a su numero de documento y numero radicado
     * @param iDocumento
     * @param iNumRadicado
     * @return un objeto de tipo DocumentoFinanciero.
     */
    
    public static void main(String[] args) {
        BancoRegistroDataAccessImp bancoRegistroDataAccessImp = new BancoRegistroDataAccessImp();
        DocumentoFinanciero res = bancoRegistroDataAccessImp.consultarBanco(Long.parseLong("51733677"), "20211201566");
        System.out.print(res.getCNumcuenta().toString());
    }
    
    public DocumentoFinanciero consultarBanco(long iDocumento, String iNumRadicado) {
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
        DocumentoFinanciero documentoFinanciero = new DocumentoFinanciero();
        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT df.* FROM documento_Financiero df where df.C_DOCUMENTO=? AND df.I_NUM_RADICADO=?", DocumentoFinanciero.class);
            consultDocument.setParameter(1, iDocumento);
            consultDocument.setParameter(2, iNumRadicado);
            List<DocumentoFinanciero> listRequest = consultDocument.getResultList();
            if (listRequest != null && !listRequest.isEmpty()) {
                documentoFinanciero = listRequest.get(0);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return documentoFinanciero;
    }
}
