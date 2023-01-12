/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.responseAML;

import java.util.List;

/**
 *
 * @author EBS_OPER_17
 */
public class DatosSdn {
    private List<String> nombre_ws;
    private List<String> sdn_name;
    private List<String> remarks2;
    private String id;
    private List<String> title;
    private List<String> remarks;
    private List<String> country;
    private List<String> address;
    private List<String> alt_name;
    private String _version_;

    public List<String> getNombre_ws() {
        return nombre_ws;
    }

    public void setNombre_ws(List<String> nombre_ws) {
        this.nombre_ws = nombre_ws;
    }

    public List<String> getSdn_name() {
        return sdn_name;
    }

    public void setSdn_name(List<String> sdn_name) {
        this.sdn_name = sdn_name;
    }

    public List<String> getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(List<String> remarks2) {
        this.remarks2 = remarks2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<String> getAlt_name() {
        return alt_name;
    }

    public void setAlt_name(List<String> alt_name) {
        this.alt_name = alt_name;
    }

    public String getVersion_() {
        return _version_;
    }

    public void setVersion_(String _version_) {
        this._version_ = _version_;
    }

    @Override
    public String toString() {
        return "DatosSdn{" + "nombre_ws=" + nombre_ws + ", sdn_name=" + sdn_name + ", remarks2=" + remarks2 + ", id=" + id + ", title=" + title + ", remarks=" + remarks + ", country=" + country + ", address=" + address + ", alt_name=" + alt_name + ", _version_=" + _version_ + '}';
    }
    
    
}
