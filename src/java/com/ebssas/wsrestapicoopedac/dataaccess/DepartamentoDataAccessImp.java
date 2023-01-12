/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.Departamento;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class DepartamentoDataAccessImp extends GenericRepositoryJPAImp<Departamento>  {

    private EntityManager em = null;
    
    
    public Departamento saveDepartamento(Departamento departamento) {
        Departamento tc = create(departamento);
        return tc;
    }

    
    public Departamento updateDepartamento(Departamento departamento) {
        Departamento tc = update(departamento);
        return tc;
    }

    
    public Departamento findDepartamentoById(Long id) {
        Departamento tc = find(id);
        return tc;
    }

    
    public List<Departamento> findAllDepartamento() {
        List<Departamento> listDepartamento = findAll();
        return listDepartamento;
    }

    
    public void deleteDepartamento(Departamento departamento) {
        delete(departamento);
    }

}
