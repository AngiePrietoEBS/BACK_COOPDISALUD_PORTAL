package com.ebssas.wsrestapicoopedac.request;

public class RequestCrearCtaAhorros 
{
    protected String identificacion;
    protected String beneficiarios;
    protected String codLinea;
    protected String codOficina;
    protected String modalidad;
    protected String fechaApertura;
    protected String tipoInteres;
    protected String codTipoTasa;
    protected String tasaIntHistorica;
    protected String desviacion;
    protected String codTipoTasaHistorica;
    protected String exentoRetefuente;
    protected String bd;
    protected String usu;
    protected String psw;
    
    public RequestCrearCtaAhorros(){}

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(String beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public String getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(String codLinea) {
        this.codLinea = codLinea;
    }

    public String getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(String codOficina) {
        this.codOficina = codOficina;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(String tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public String getCodTipoTasa() {
        return codTipoTasa;
    }

    public void setCodTipoTasa(String codTipoTasa) {
        this.codTipoTasa = codTipoTasa;
    }

    public String getTasaIntHistorica() {
        return tasaIntHistorica;
    }

    public void setTasaIntHistorica(String tasaIntHistorica) {
        this.tasaIntHistorica = tasaIntHistorica;
    }

    public String getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(String desviacion) {
        this.desviacion = desviacion;
    }

    public String getCodTipoTasaHistorica() {
        return codTipoTasaHistorica;
    }

    public void setCodTipoTasaHistorica(String codTipoTasaHistorica) {
        this.codTipoTasaHistorica = codTipoTasaHistorica;
    }

    public String getExentoRetefuente() {
        return exentoRetefuente;
    }

    public void setExentoRetefuente(String exentoRetefuente) {
        this.exentoRetefuente = exentoRetefuente;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "RequestCrearCtaAhorros{" + "identificacion=" + identificacion + ", beneficiarios=" + beneficiarios + ", codLinea=" + codLinea + ", codOficina=" + codOficina + ", modalidad=" + modalidad + ", fechaApertura=" + fechaApertura + ", tipoInteres=" + tipoInteres + ", codTipoTasa=" + codTipoTasa + ", tasaIntHistorica=" + tasaIntHistorica + ", desviacion=" + desviacion + ", codTipoTasaHistorica=" + codTipoTasaHistorica + ", exentoRetefuente=" + exentoRetefuente + ", bd=" + bd + ", usu=" + usu + ", psw=" + psw + '}';
    }
}
