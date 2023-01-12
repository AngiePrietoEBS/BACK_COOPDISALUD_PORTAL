package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.Entidad;
import java.util.List;

public class ResponseEntidades 
{
    public boolean bRta;
    public String sMsj;
    public List<Entidad> entidades;

    public ResponseEntidades() {
    }

    public ResponseEntidades(boolean bRta, String sMsj, List<Entidad> entidades) {
        this.bRta = bRta;
        this.sMsj = sMsj;
        this.entidades = entidades;
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

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    @Override
    public String toString() {
        return "ResponseEntidades{" + "bRta=" + bRta + ", sMsj=" + sMsj + ", entidades=" + entidades + '}';
    }
}
