/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.domain;

import java.io.Serializable;

/**
 *
 * @author Juan Sebastian F
 */
public class DocumentoFinancier {    
    private String cDescripcion;
    private String cEntidadFin;
    private Long cNumcuenta;
    private Long iTipocuenta;
    private String iCodigo;
    private Long cDocumento;

    @Override
    public String toString() {
        return "DocumentoFinancier{" + "cDescripcion=" + cDescripcion + ", cEntidadFin=" + cEntidadFin + ", cNumcuenta=" + cNumcuenta + ", iTipocuenta=" + iTipocuenta + ", iCodigo=" + iCodigo + ", cDocumento=" + cDocumento + '}';
    }

    public DocumentoFinancier(String cDescripcion, String cEntidadFin, Long cNumcuenta, Long iTipocuenta, String iCodigo, Long cDocumento) {
        this.cDescripcion = cDescripcion;
        this.cEntidadFin = cEntidadFin;
        this.cNumcuenta = cNumcuenta;
        this.iTipocuenta = iTipocuenta;
        this.iCodigo = iCodigo;
        this.cDocumento = cDocumento;
    }

    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public String getcEntidadFin() {
        return cEntidadFin;
    }

    public void setcEntidadFin(String cEntidadFin) {
        this.cEntidadFin = cEntidadFin;
    }

    public Long getcNumcuenta() {
        return cNumcuenta;
    }

    public void setcNumcuenta(Long cNumcuenta) {
        this.cNumcuenta = cNumcuenta;
    }

    public Long getiTipocuenta() {
        return iTipocuenta;
    }

    public void setiTipocuenta(Long iTipocuenta) {
        this.iTipocuenta = iTipocuenta;
    }

    public String getiCodigo() {
        return iCodigo;
    }

    public void setiCodigo(String iCodigo) {
        this.iCodigo = iCodigo;
    }

    public Long getcDocumento() {
        return cDocumento;
    }

    public void setcDocumento(Long cDocumento) {
        this.cDocumento = cDocumento;
    }

    
    
}
