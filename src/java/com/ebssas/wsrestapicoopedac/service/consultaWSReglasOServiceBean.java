/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;
import WSReglasOtorgamientoCoopedac.RespuestaPermite;
import com.ebssas.wsrestapicoopedac.dataaccess.ParametroDataAccessImp;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSReglasOtorgamiento;

/**
 *
 * @author Juan Sebastian F
 */
public class consultaWSReglasOServiceBean {
    
    String usuarioBdCore= new ParametroDataAccessImp().getValorParametroByNombre("DB_SERVER_USERNAME_CORE");
    String nombreBdCore= new ParametroDataAccessImp().getValorParametroByNombre("DB_BD_CORE");
    String passwordBdCore= new ParametroDataAccessImp().getValorParametroByNombre("DB_SERVER_PASSWORD_CORE");
    
    public RespuestaPermite consultaReglasO (String xiIden, String xcCodCred){
        
        RespuestaPermite WSPersona = new RespuestaPermite();
        String bd  = nombreBdCore;
        String usu = usuarioBdCore;
        String psw = passwordBdCore;
        ConsumoWSReglasOtorgamiento Ro=new ConsumoWSReglasOtorgamiento();
        WSPersona    = Ro.wcREGLASOTORGAMIENTO(xiIden, xcCodCred, bd, usu, psw);
        return WSPersona;
    }
    
}
