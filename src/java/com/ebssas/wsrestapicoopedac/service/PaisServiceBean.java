/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.PaisDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Pais;
import java.util.List;

/**
 *
 * @author Braya
 */
public class PaisServiceBean {
    
    public Pais savePais(Pais pais) {
        Pais tc = new PaisDataAccessImp().savePais(pais);
        return tc;
    }
    
    public Pais updatePais(Pais pais) {
        Pais tc = new PaisDataAccessImp().updatePais(pais);
        return tc;
    }
    
    public Pais findPaisById(Long id) {
        Pais tc = new PaisDataAccessImp().findPaisById(id);
        return tc;
    }
    
    public List<Pais> findAllPais() {
        List<Pais> listPais = new PaisDataAccessImp().findAllPais();
        return listPais;
    }
    
    public void deletePais(Pais pais) {
        new PaisDataAccessImp().deletePais(pais);
    }
    
}
