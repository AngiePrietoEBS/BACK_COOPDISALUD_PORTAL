/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

/**
 *
 * @author andre
 */
public class Cargo {
    
    public Integer iCodigo;
    public String sDescripcion;

    public Cargo() {}
    
    public Cargo(Integer iCodigo, String sDescripcion) {
        this.iCodigo = iCodigo;
        this.sDescripcion = sDescripcion;
    }

    public Integer getCodigo() {
        return iCodigo;
    }

    public void setCodigo(Integer codigo) {
        this.iCodigo = codigo;
    }
    
    public String getDescripcion() {
        return sDescripcion;
    }

    public void setDescripcion(String descripcion) {
        this.sDescripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cargo{" + "iCodigo=" + iCodigo + ", sDescripcion=" + sDescripcion + '}';
    }
    
}
