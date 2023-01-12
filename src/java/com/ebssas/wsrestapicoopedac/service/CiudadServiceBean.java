/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.CiudadDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Ciudad;
import java.util.List;

/**
 *
 * @author Braya
 */
public class CiudadServiceBean  {

       
    
    public Ciudad saveCiudad(Ciudad ciudad) {
        Ciudad tc = new CiudadDataAccessImp().saveCiudad(ciudad);
        return tc;
    }

    
    public Ciudad updateCiudad(Ciudad ciudad) {
        Ciudad tc = new CiudadDataAccessImp().updateCiudad(ciudad);
        return tc;
    }

    
    public Ciudad findCiudadById(Long id) {
        Ciudad tc = new CiudadDataAccessImp().findCiudadById(id);
        return tc;
    }

    
    public List<Ciudad> findAllCiudad() {
        List<Ciudad> listCiudad = new CiudadDataAccessImp().findAllCiudad();
        return listCiudad;
    }

    
    public void deleteCiudad(Ciudad ciudad) {
        new CiudadDataAccessImp().deleteCiudad(ciudad);
    }

}
