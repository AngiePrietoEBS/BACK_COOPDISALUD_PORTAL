package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.CuentaAhorro;
import java.util.List;

public class ResponseListadoCuentas 
{
    protected boolean bOk;
    protected String sRespuesta;
    protected List<CuentaAhorro> listadoCuentasCliente;
    
    public ResponseListadoCuentas() {}
    public ResponseListadoCuentas(boolean bOk, String sRespuesta, List<CuentaAhorro> listadoCuentasCliente) {
        this.bOk = bOk;
        this.sRespuesta = sRespuesta;
        this.listadoCuentasCliente = listadoCuentasCliente;
    }

    public boolean getbOk() {
        return bOk;
    }

    public void setbOk(boolean bOk) {
        this.bOk = bOk;
    }

    public String getsRespuesta() {
        return sRespuesta;
    }

    public void setsRespuesta(String sRespuesta) {
        this.sRespuesta = sRespuesta;
    }

    public List<CuentaAhorro> getListadoCuentasCliente() {
        return listadoCuentasCliente;
    }

    public void setListadoCuentasCliente(List<CuentaAhorro> listadoCuentasCliente) {
        this.listadoCuentasCliente = listadoCuentasCliente;
    }

    @Override
    public String toString() {
        return "ResponseListadoCuentas{" + "bOk=" + bOk + ", sRespuesta=" + sRespuesta + ", listadoCuentasCliente=" + listadoCuentasCliente + '}';
    }
}
