/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.DocumentoSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.DocumentoTransunionDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.DocumentoSolCred;
import com.ebssas.wsrestapicoopedac.domain.HistoriaSolCredito;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.dataaccess.HistoriaSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.domain.DocumentoTransunion;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.general.CrearEmailHTML;
import com.ebssas.wsrestapicoopedac.general.SendEmailSMTP;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.response.ResponseDocSolCred;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DocumentoSolCredServiceBean implements DocumentoSolCredService {
    
    private SolicitudCreditoServiceBean solicitudCreditoServiceBean = new SolicitudCreditoServiceBean();
    private ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private CrearEmailHTML emailHTML = new CrearEmailHTML();
    private SendEmailSMTP emailSMTP = new SendEmailSMTP();
    
    public DocumentoSolCred findDocumentoSolCredByTipoReq(Long idSolCred, Long idTipoReq) {
        return new DocumentoSolCredDataAccessImp().findDocumentoSolCrebByTipoReq(idSolCred, idTipoReq);
    }
    
    public DocumentoSolCred updateDocumentoSolCred(DocumentoSolCred documentoSolCred) {
        return new DocumentoSolCredDataAccessImp().updateDocumentoSolCred(documentoSolCred);
    }
    
    public DocumentoSolCred saveDocumentoSolCred(DocumentoSolCred documentoSolCred) {
        return new DocumentoSolCredDataAccessImp().saveDocumentoSolCred(documentoSolCred);
    }
    
    @Override
    public RespuestaGenerica saveDocSolCred(List<DocumentoSolCred> listDocs) {
        
        RespuestaGenerica generica = new RespuestaGenerica();
        Boolean actualizada = false;
        
        if (!listDocs.isEmpty()) {
            
            String iNumRadic = listDocs.get(0).getISolCredito().getINumRadic();
            SolicitudCredito credito = new SolicitudCreditoServiceBean().findSolCreditoByRadicado(iNumRadic);
            
            try {
                for (DocumentoSolCred docs : listDocs) {
                    DocumentoSolCred infoBuscada = this.findDocumentoSolCredByTipoReq(credito.getICodigo(), docs.getIRequisito().getICodigo());
                    if (infoBuscada != null) {
                        actualizada = true;
                        docs.setICodigo(infoBuscada.getICodigo());

                        DocumentoSolCred dsaw = this.updateDocumentoSolCred(docs);
                        if (dsaw.getICodigo() != null) {
                            generica.setbRta(Boolean.TRUE);
                            generica.setiCodigo(1);
                            generica.setsMsj("Información actualizada correctamente. Por favor continue con la solicitud de crédito.");
                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setiCodigo(0);
                            generica.setsMsj("Se ha presentado un incoveniente al actualizar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                        }
                    } else {
                        DocumentoSolCred dsaw = this.saveDocumentoSolCred(docs);
                        if (dsaw != null && dsaw.getICodigo() != null) {

                            //emailSolicitudCredRadicado
                            generica.setbRta(Boolean.TRUE);
                            generica.setiCodigo(1);
                            generica.setsMsj("Información registrada correctamente. Por favor continue con la solicitud de crédito.");
                        } else {
                            generica.setbRta(Boolean.FALSE);
                            generica.setiCodigo(0);
                            generica.setsMsj("Se ha presentado un incoveniente al registrar la información. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
                        }
                    }
                }
            }
            catch(IllegalStateException ex) {
                generica.setbRta(Boolean.FALSE);
                generica.setiCodigo(0);
                generica.setsMsj("Se ha presentado un inconveniente al registrar la información. Error 2-1");   // Si error JPA, verifique la info recibida contra la BD
            }

        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setiCodigo(0);
            generica.setsMsj("No se ha enviado el N° de radicado de la solicitud de crédito. Por favor vuelva a intentarlo, si el error persiste comuniquese con la entidad.");
        }
        
        return generica;
    }
    
    @Override
    public ResponseDocSolCred findDocumentoSolCredByIdSolCred(Long idSolCred
    ) {
        ResponseDocSolCred cred = new ResponseDocSolCred();
        
        List<DocumentoSolCred> listDocs = new DocumentoSolCredDataAccessImp().findDocumentoSolCredByIdSolCred(idSolCred);
        if (!listDocs.isEmpty()) {
            cred.setbRta(Boolean.TRUE);
            cred.setsMsj("Consulta exitosa");
            cred.setListDocs(listDocs);
        } else {
            cred.setbRta(Boolean.FALSE);
            cred.setsMsj("No se encontraron documentos de solicitud");
        }
        
        return cred;
    }
    
    public RespuestaGenerica saveDocumentoTransunion(DocumentoTransunion documentoTransunion) {
        
        RespuestaGenerica generica = new RespuestaGenerica();
        DocumentoTransunionDataAccessImp accessImp = new DocumentoTransunionDataAccessImp();
        
        if (documentoTransunion != null) {
            String iNumRadic = documentoTransunion.getISolCredito().getINumRadic();
            SolicitudCredito credito = new SolicitudCreditoServiceBean().findSolCreditoByRadicado(iNumRadic);
            if (credito.getICodigo() != null) {
                DocumentoTransunion dtB = new DocumentoTransunion();
                dtB = accessImp.findDocumentoTransunion(credito.getICodigo());
                if (dtB.getICodigo() != null) {
                    documentoTransunion.setICodigo(dtB.getICodigo());
                    DocumentoTransunion dtU = new DocumentoTransunion();
                    dtU = accessImp.updateDocumentoTransunion(documentoTransunion);
                    if (dtU.getICodigo() != null) {
                        generica.setbRta(Boolean.TRUE);
                        generica.setsMsj("Se ha actualizado correctamente el archivo.");
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Se ha presentado un inconveniente al cargar el archivo, por favor intente de nuevo.");
                    }
                } else {
                    
                    DocumentoTransunion dtS = new DocumentoTransunion();
                   
                    dtS = accessImp.saveDocumentoTransunion(documentoTransunion);
                    if (dtS.getICodigo() != null) {
                        generica.setbRta(Boolean.TRUE);
                        generica.setsMsj("Se ha guardado correctamente el archivo.");
                    } else {
                        generica.setbRta(Boolean.FALSE);
                        generica.setsMsj("Se ha presentado un inconveniente al cargar el archivo, por favor intente de nuevo.");
                    }
                }
                
            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("No se encontro solicitud de crédito con número de solicitud " + iNumRadic);
            }
            
        } else {
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("Se ha presentado un inconveniente al cargar el archivo, por favor intente de nuevo.");
        }
        
        return generica;
        
    }
    
    public DocumentoTransunion findDocumentoTU(Long idSolCred){
        return new DocumentoTransunionDataAccessImp().findDocumentoTransunion(idSolCred);
    }
    
}
