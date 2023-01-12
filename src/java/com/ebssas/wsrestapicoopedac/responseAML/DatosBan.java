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
public class DatosBan {
    private List<String> country;
    private List<String> grounds;
    private List<String> address;
    private List<String> ini;
    private List<String> name;
    private List<String> fin;
    private String id;
    private String _version_;

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<String> grounds) {
        this.grounds = grounds;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<String> getIni() {
        return ini;
    }

    public void setIni(List<String> ini) {
        this.ini = ini;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getFin() {
        return fin;
    }

    public void setFin(List<String> fin) {
        this.fin = fin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion_() {
        return _version_;
    }

    public void setVersion_(String _version_) {
        this._version_ = _version_;
    }

    @Override
    public String toString() {
        return "DatosBan{" + "country=" + country + ", grounds=" + grounds + ", address=" + address + ", ini=" + ini + ", name=" + name + ", fin=" + fin + ", id=" + id + ", _version_=" + _version_ + '}';
    }
    
    
}
