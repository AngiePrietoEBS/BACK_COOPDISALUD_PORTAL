/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.sms;

/**
 *
 * @author Usuario
 */
public class ResponseSendSMSV3 {

    private String status;
    private String account;
    private String sms;
    private String execution_time;
    private String privaip;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(String execution_time) {
        this.execution_time = execution_time;
    }

    public String getPrivaip() {
        return privaip;
    }

    public void setPrivaip(String privaip) {
        this.privaip = privaip;
    }

}
