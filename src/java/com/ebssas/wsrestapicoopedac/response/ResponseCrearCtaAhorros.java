package com.ebssas.wsrestapicoopedac.response;

public class ResponseCrearCtaAhorros 
{
    protected String bOk;
    protected String sRespuesta;
    protected String sNumCuentaCreado;
    
    public ResponseCrearCtaAhorros(){}

    public ResponseCrearCtaAhorros(String bOk, String sRespuesta, String sNumCuentaCreado) {
        this.bOk = bOk;
        this.sRespuesta = sRespuesta;
        this.sNumCuentaCreado = sNumCuentaCreado;
    }
    
    public String getbOk() {
        return bOk;
    }

    public void setbOk(String bOk) {
        this.bOk = bOk;
    }

    public String getsRespuesta() {
        return sRespuesta;
    }

    public void setsRespuesta(String sRespuesta) {
        this.sRespuesta = sRespuesta;
    }

    public String getsNumCuentaCreado() {
        return sNumCuentaCreado;
    }

    public void setsNumCuentaCreado(String sNumCuentaCreado) {
        this.sNumCuentaCreado = sNumCuentaCreado;
    }

    @Override
    public String toString() {
        return "ResponseCrearCtaAhorros{" + "bOk=" + bOk + ", sRespuesta=" + sRespuesta + ", sNumCuentaCreado=" + sNumCuentaCreado + '}';
    }
}
