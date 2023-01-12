    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

/**
 *
 * @author Juan Sebastian F
 */
public class Entidad {
    public String descripcion;

    public Entidad() {}
    
    public Entidad(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Entidad{" + "descripcion=" + descripcion + '}';
    }
}
