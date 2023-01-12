/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.sms;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class RequestSMSMasivo {

    private List<RequestSMSM> bulk;

    public List<RequestSMSM> getBulk() {
        return bulk;
    }

    public void setBulk(List<RequestSMSM> bulk) {
        this.bulk = bulk;
    }

}
