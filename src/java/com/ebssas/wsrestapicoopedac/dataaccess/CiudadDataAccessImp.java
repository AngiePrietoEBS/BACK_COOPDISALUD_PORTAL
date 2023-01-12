/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Ciudad;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class CiudadDataAccessImp extends GenericRepositoryJPAImp<Ciudad>  {

    private EntityManager em = null;
    
    
    public Ciudad saveCiudad(Ciudad ciudad) {
        Ciudad tc = create(ciudad);
        return tc;
    }

    
    public Ciudad updateCiudad(Ciudad ciudad) {
        Ciudad tc = update(ciudad);
        return tc;
    }

    
    public Ciudad findCiudadById(Long id) {
        Ciudad tc = find(id);
        return tc;
    }

    
    public List<Ciudad> findAllCiudad() {
        List<Ciudad> listCiudad = findAll();
        return listCiudad;
    }

    
    public void deleteCiudad(Ciudad ciudad) {
        delete(ciudad);
    }

}
