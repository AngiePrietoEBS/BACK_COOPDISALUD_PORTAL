/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.DocumentoSolCred;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ResponseDocSolCred {

    private Boolean bRta;
    private String sMsj;
    private List<DocumentoSolCred> listDocs;

    public Boolean getbRta() {
        return bRta;
    }

    public void setbRta(Boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public List<DocumentoSolCred> getListDocs() {
        return listDocs;
    }

    public void setListDocs(List<DocumentoSolCred> listDocs) {
        this.listDocs = listDocs;
    }

}
