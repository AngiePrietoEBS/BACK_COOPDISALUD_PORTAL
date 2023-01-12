/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.responseAML;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class ResponseConsultaAML {
    
    private String datetime;
    private String id_bitacora;
    private List<ResponseResult> results;
    private String elapsed_time;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(String id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public List<ResponseResult> getResults() {
        return results;
    }

    public void setResults(List<ResponseResult> results) {
        this.results = results;
    }

    public String getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(String elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    @Override
    public String toString() {
        return "ResponseConsultaAML{" + "datetime=" + datetime + ", id_bitacora=" + id_bitacora + ", results=" + results + ", elapsed_time=" + elapsed_time + '}';
    }
}
