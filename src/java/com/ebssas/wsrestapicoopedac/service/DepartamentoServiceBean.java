/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.DepartamentoDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Departamento;
import java.util.List;

/**
 *
 * @author Braya
 */
public class DepartamentoServiceBean {
    
    public Departamento saveDepartamento(Departamento departamento) {
        Departamento tc = new DepartamentoDataAccessImp().saveDepartamento(departamento);
        return tc;
    }
    
    public Departamento updateDepartamento(Departamento departamento) {
        Departamento tc = new DepartamentoDataAccessImp().updateDepartamento(departamento);
        return tc;
    }
    
    public Departamento findDepartamentoById(Long id) {
        Departamento tc = new DepartamentoDataAccessImp().findDepartamentoById(id);
        return tc;
    }
    
    public List<Departamento> findAllDepartamento() {
        List<Departamento> listDepartamento = new DepartamentoDataAccessImp().findAllDepartamento();
        return listDepartamento;
    }
    
    public void deleteDepartamento(Departamento departamento) {
        new DepartamentoDataAccessImp().deleteDepartamento(departamento);
    }
    
}
