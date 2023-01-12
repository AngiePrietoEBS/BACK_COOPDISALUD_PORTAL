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
public class DatosTsti {
    private List<String> lista;
    private List<String> categoria;
    private List<String> nombre_apellido;
    private String id;
    private List<String> pais;
    private List<String> detalle;
    private List<String> nombre_relacion_lista;
    private List<String> id_relacion_lista;
    private String _version_;
    private String estado;
    private String estado1;
    private String estado2;
    private String estado3;
    private String relacionado;

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    public List<String> getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(List<String> nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPais() {
        return pais;
    }

    public void setPais(List<String> pais) {
        this.pais = pais;
    }

    public List<String> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<String> detalle) {
        this.detalle = detalle;
    }

    public List<String> getNombre_relacion_lista() {
        return nombre_relacion_lista;
    }

    public void setNombre_relacion_lista(List<String> nombre_relacion_lista) {
        this.nombre_relacion_lista = nombre_relacion_lista;
    }

    public List<String> getId_relacion_lista() {
        return id_relacion_lista;
    }

    public void setId_relacion_lista(List<String> id_relacion_lista) {
        this.id_relacion_lista = id_relacion_lista;
    }

    public String getVersion_() {
        return _version_;
    }

    public void setVersion_(String _version_) {
        this._version_ = _version_;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado1() {
        return estado1;
    }

    public void setEstado1(String estado1) {
        this.estado1 = estado1;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getEstado3() {
        return estado3;
    }

    public void setEstado3(String estado3) {
        this.estado3 = estado3;
    }

    public String getRelacionado() {
        return relacionado;
    }

    public void setRelacionado(String relacionado) {
        this.relacionado = relacionado;
    }

    @Override
    public String toString() {
        return "DatosTsti{" + "lista=" + lista + ", categoria=" + categoria + ", nombre_apellido=" + nombre_apellido + ", id=" + id + ", pais=" + pais + ", detalle=" + detalle + ", nombre_relacion_lista=" + nombre_relacion_lista + ", id_relacion_lista=" + id_relacion_lista + ", _version_=" + _version_ + ", estado=" + estado + ", estado1=" + estado1 + ", estado2=" + estado2 + ", estado3=" + estado3 + ", relacionado=" + relacionado + '}';
    }
    
    
}
