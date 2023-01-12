package com.ebssas.wsrestapicoopedac.response;

import WSEstadoCuentaCoopedac.ArrayOfDato3DTO;
public class ResponseExtracto {
    
    protected boolean bRta;
    protected String sMsj;
    protected ArrayOfDato3DTO arrayOfDato3DTO;
    
    public ResponseExtracto() {}
    
    public ResponseExtracto(boolean bRta, String sMsj, ArrayOfDato3DTO arrayOfDato3DTO) {
        this.bRta = bRta;
        this.sMsj = sMsj;
        this.arrayOfDato3DTO = arrayOfDato3DTO;
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
    
    public ArrayOfDato3DTO getArrayOfDato3DTO() {
        return arrayOfDato3DTO;
    }

    public void setArrayOfDato3DTO(ArrayOfDato3DTO arrayOfDato3DTO) {
        this.arrayOfDato3DTO = arrayOfDato3DTO;
    }
}
