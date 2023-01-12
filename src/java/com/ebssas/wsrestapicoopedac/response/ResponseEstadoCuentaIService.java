package com.ebssas.wsrestapicoopedac.response;

import com.ebssas.wsrestapicoopedac.domain.CuentaAhorro;
import java.util.Date;
import java.util.List;
import WSEstadoCuentaCoopedac.ArrayOfDatoDTO;
import WSEstadoCuentaCoopedac.DatoDTO;
public class ResponseEstadoCuentaIService 
{
    protected Integer tipoProducto;
   
    protected List<DatoDTO> producto;
    
    public ResponseEstadoCuentaIService() {}
    
    public ResponseEstadoCuentaIService(Integer tipoProducto, List<DatoDTO> producto) {
        this.tipoProducto = tipoProducto;
        this.producto = producto;        
    }
    
     public Integer getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Integer tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<DatoDTO> getProducto() {
        return producto;
    }

    public void setProducto(List<DatoDTO> producto) {
        this.producto = producto;
    }
    
    
    
}
