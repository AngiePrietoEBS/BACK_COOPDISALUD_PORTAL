package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.CuentaAhorro;
import java.util.Date;
import java.util.List;
import WSEstadoCuentaCoopedac.ArrayOfDatoDTO;
import WSEstadoCuentaCoopedac.DatoDTO;
import WSEstadoCuentaCoopedac.Movimiento;
public class ResponseEstadoCuentaIIGeneric 
{
    protected boolean bRta;
    protected String sMsj;
    protected Movimiento productos;
    
    public ResponseEstadoCuentaIIGeneric() {}
    
    public ResponseEstadoCuentaIIGeneric(boolean bRta, String sMsj, Movimiento productos) {
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

    public Movimiento getProductos() {
        return productos;
    }

    public void setProductos(Movimiento productos) {
        this.productos = productos;
    }
    
    
    
    
}
