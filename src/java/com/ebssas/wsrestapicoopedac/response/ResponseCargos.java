/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.Cargo;
import java.util.List;

/**
 *
 * @author andre
 */
public class ResponseCargos {
    public boolean bRta;
    public String sMsj;
    public List<Cargo> cargos;
    
    public ResponseCargos(){
    }
    
    public ResponseCargos(boolean bRta, String sMsj, List<Cargo> cargos){
        this.bRta = bRta;
        this.sMsj = sMsj;
        this.cargos = cargos;
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

    public List<Cargo> getEntidades() {
        return cargos;
    }

    public void setEntidades(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    @Override
    public String toString() {
        return "ResponseCargos{" + "bRta=" + bRta + ", sMsj=" + sMsj + ", entidades=" + cargos + '}';
    }
}
