/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.request;

import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.domain.BeneficiarioAperturaCta;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class RequestAperturaCuentaSolCred {

    private AperturaCuentaSolCred aperturaCuentaSolCred;
    private List<BeneficiarioAperturaCta> listBeneficiarios;

    public AperturaCuentaSolCred getAperturaCuentaSolCred() {
        return aperturaCuentaSolCred;
    }

    public void setAperturaCuentaSolCred(AperturaCuentaSolCred aperturaCuentaSolCred) {
        this.aperturaCuentaSolCred = aperturaCuentaSolCred;
    }

    public List<BeneficiarioAperturaCta> getListBeneficiarios() {
        return listBeneficiarios;
    }

    public void setListBeneficiarios(List<BeneficiarioAperturaCta> listBeneficiarios) {
        this.listBeneficiarios = listBeneficiarios;
    }

}
