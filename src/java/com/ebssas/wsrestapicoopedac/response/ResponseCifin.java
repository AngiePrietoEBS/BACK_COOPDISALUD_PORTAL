/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

/**
 *
 * @author Administrador
 */
public class ResponseCifin {
    
    private boolean flag;
    private String sMsg;
    private String xData;
    private String puntajeCifin;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getsMsg() {
        return sMsg;
    }

    public void setsMsg(String sMsg) {
        this.sMsg = sMsg;
    }

    public String getxData() {
        return xData;
    }

    public void setxData(String xData) {
        this.xData = xData;
    }
    
    

    public String getPuntajeCifin() {
        return puntajeCifin;
    }

    public void setPuntajeCifin(String puntajeCifin) {
        this.puntajeCifin = puntajeCifin;
    }
}
