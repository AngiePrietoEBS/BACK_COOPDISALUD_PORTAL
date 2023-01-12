package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.CuentaAhorro;
import java.util.Date;
import java.util.List;
import WSEstadoCuentaCoopedac.ArrayOfDatoDTO;
import WSEstadoCuentaCoopedac.DatoDTO;
public class ResponseEstadoCuentaIGeneric 
{
    protected boolean bRta;
    protected String sMsj;
    protected List<ResponseEstadoCuentaIService> productos;
    
    public ResponseEstadoCuentaIGeneric() {}
    
    public ResponseEstadoCuentaIGeneric(boolean bRta, String sMsj, List<ResponseEstadoCuentaIService> productos) {
        this.bRta = bRta;
        this.sMsj = sMsj;
        this.productos = productos;
    }

    public boolean isbRta() {
        return bRta;
    }

    public void setbRta(boolean bRta) {
        this.bRta = bRta;
    }

    public String getsMsj() {
        return sMsj;
    }

    public void setsMsj(String sMsj) {
        this.sMsj = sMsj;
    }

    public List<ResponseEstadoCuentaIService> getProductos() {
        return productos;
    }

    public void setProductos(List<ResponseEstadoCuentaIService> productos) {
        this.productos = productos;
    }
    
    
    
    
}
