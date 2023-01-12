/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.ProcesoValidacionAccesoPers;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ProcesoValidacionAccesoPersDataAcces {
 
    ProcesoValidacionAccesoPers save(ProcesoValidacionAccesoPers procesoValidacionAccesoPers);
    
    List<ProcesoValidacionAccesoPers> findProcesoByEmailAndCelular(String email, String celular);
}
