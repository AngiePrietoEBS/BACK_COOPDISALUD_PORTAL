package com.ebssas.wsrestapicoopedac.response;

import WSEstadoCuentaCoopedac.DatoDTO;
import java.util.List;

public class ResponseCreditoConCuota {
    
    protected boolean bRta;
    protected String sMsj;
    protected List<DatoDTO> listDatoDTO;

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

    public List<DatoDTO> getListDatoDTO() {
        return listDatoDTO;
    }

    public void setListDatoDTO(List<DatoDTO> listDatoDTO) {
        this.listDatoDTO = listDatoDTO;
    }
    
    
    
}
