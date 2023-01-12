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
public class ResponseResult {

    private String item_no;
    private String nombre;
    private String doc_id;
    private boolean block;
    private List<DatosSdn> datos_sdn;
    private List<DatosBan> datos_ban;
    private List<DatosBis> datos_bis;
    private List<DatosEul> datos_eul;
    private List<DatosHmt> datos_hmt;
    private List<DatosPro> datos_pro;
    private List<DatosAmlNews> datos_amlnews;
    private List<DatosTsti> datos_tsti;

    public String getItem_no() {
        return item_no;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public boolean isBlocked() {
        return block;
    }

    public void setBlocked(boolean bloc) {
        this.block = bloc;
    }

    public List<DatosSdn> getDatos_sdn() {
        return datos_sdn;
    }

    public void setDatos_sdn(List<DatosSdn> datos_sdn) {
        this.datos_sdn = datos_sdn;
    }

    public List<DatosBan> getDatos_ban() {
        return datos_ban;
    }

    public void setDatos_ban(List<DatosBan> datos_ban) {
        this.datos_ban = datos_ban;
    }

    public List<DatosBis> getDatos_bis() {
        return datos_bis;
    }

    public void setDatos_bis(List<DatosBis> datos_bis) {
        this.datos_bis = datos_bis;
    }

    public List<DatosEul> getDatos_eul() {
        return datos_eul;
    }

    public void setDatos_eul(List<DatosEul> datos_eul) {
        this.datos_eul = datos_eul;
    }

    public List<DatosHmt> getDatos_hmt() {
        return datos_hmt;
    }

    public void setDatos_hmt(List<DatosHmt> datos_hmt) {
        this.datos_hmt = datos_hmt;
    }

    public List<DatosPro> getDatos_pro() {
        return datos_pro;
    }

    public void setDatos_pro(List<DatosPro> datos_pro) {
        this.datos_pro = datos_pro;
    }

    public List<DatosAmlNews> getDatos_amlnews() {
        return datos_amlnews;
    }

    public void setDatos_amlnews(List<DatosAmlNews> datos_amlnews) {
        this.datos_amlnews = datos_amlnews;
    }

    public List<DatosTsti> getDatos_tsti() {
        return datos_tsti;
    }

    public void setDatos_tsti(List<DatosTsti> datos_tsti) {
        this.datos_tsti = datos_tsti;
    }

    @Override
    public String toString() {
        return "ResponseResult{" + "item_no=" + item_no + ", nombre=" + nombre + ", doc_id=" + doc_id + ", block=" + block + ", datos_sdn=" + datos_sdn + ", datos_ban=" + datos_ban + ", datos_bis=" + datos_bis + ", datos_eul=" + datos_eul + ", datos_hmt=" + datos_hmt + ", datos_pro=" + datos_pro + ", datos_amlnews=" + datos_amlnews + ", datos_tsti=" + datos_tsti + '}';
    }
}
