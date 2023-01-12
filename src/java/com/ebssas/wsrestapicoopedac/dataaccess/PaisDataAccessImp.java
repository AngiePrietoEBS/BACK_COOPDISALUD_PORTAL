/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Pais;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class PaisDataAccessImp extends GenericRepositoryJPAImp<Pais>  {

    private EntityManager em = null;
    
    
    public Pais savePais(Pais pais) {
        Pais tc = create(pais);
        return tc;
    }

    
    public Pais updatePais(Pais pais) {
        Pais tc = update(pais);
        return tc;
    }

    
    public Pais findPaisById(Long id) {
        Pais tc = find(id);
        return tc;
    }

    
    public List<Pais> findAllPais() {
        List<Pais> listPais = findAll();
        return listPais;
    }

    
    public void deletePais(Pais pais) {
        delete(pais);
    }

}
