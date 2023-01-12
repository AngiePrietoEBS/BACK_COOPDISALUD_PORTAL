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
public class DatosBis {
    private List<String> nombre_ws;
    private List<String> country;
    private List<String> address;
    private List<String> city;
    private List<String> name;
    private String id;
    private List<String> title;
    private String _version_;

    public List<String> getNombre_ws() {
        return nombre_ws;
    }

    public void setNombre_ws(List<String> nombre_ws) {
        this.nombre_ws = nombre_ws;
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

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
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

    public String getVersion_() {
        return _version_;
    }

    public void setVersion_(String _version_) {
        this._version_ = _version_;
    }

    @Override
    public String toString() {
        return "DatosBis{" + "nombre_ws=" + nombre_ws + ", country=" + country + ", address=" + address + ", city=" + city + ", name=" + name + ", id=" + id + ", title=" + title + ", _version_=" + _version_ + '}';
    }
    
    
}
