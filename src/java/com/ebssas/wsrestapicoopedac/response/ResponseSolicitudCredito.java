/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import java.util.List;

/**
 *
 * @author juan_
 */
public class ResponseSolicitudCredito {
    
    private boolean flag;
    private String sMsg;
    private List<SolicitudCredito> listaSolicitud;

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

    public List<SolicitudCredito> getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(List<SolicitudCredito> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }
    
    
}
