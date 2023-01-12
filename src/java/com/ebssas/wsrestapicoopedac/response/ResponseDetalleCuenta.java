package com.ebssas.wsrestapicoopedac.response;

import WSEstadoCuentaCoopedac.DetalleCta;
public class ResponseDetalleCuenta {
    
    protected boolean bRta;
    protected String sMsj;
    protected DetalleCta detalleCta;
    
    public ResponseDetalleCuenta() {}
    
    public ResponseDetalleCuenta(boolean bRta, String sMsj, DetalleCta detalleCta) {
        this.bRta = bRta;
        this.sMsj = sMsj;
        this.detalleCta = detalleCta;
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
    
    public DetalleCta getDetalleCta() {
        return detalleCta;
    }

    public void setDetalleCta(DetalleCta detalleCta) {
        this.detalleCta = detalleCta;
    }
    
}
