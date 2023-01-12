/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

/**
 *
 * @author Camilo
 */
public class ResponsePSEFunctionality {
    
    protected boolean bRta;
    protected String sMsj;
    protected String functionality;

    public ResponsePSEFunctionality() {}

    public ResponsePSEFunctionality(boolean bRta, String sMsj, String functionality) {
        this.bRta = bRta;
        this.sMsj = sMsj;
        this.functionality = functionality;
    }

    public boolean isbRta() {
        return bRta;
    }

    public void setbRta(boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }
    
    
    
}
