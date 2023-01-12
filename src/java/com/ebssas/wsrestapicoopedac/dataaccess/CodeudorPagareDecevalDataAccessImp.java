/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.CodeudoresPagareDeceval;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Braya
 */
public class CodeudorPagareDecevalDataAccessImp extends GenericRepositoryJPAImp<CodeudoresPagareDeceval>  {

    private EntityManager em = null;
    
    
    public CodeudoresPagareDeceval saveCodeudoresPagareDeceval(CodeudoresPagareDeceval codeudoresPagareDeceval) {
        CodeudoresPagareDeceval tc = create(codeudoresPagareDeceval);
        return tc;
    }

    
    public CodeudoresPagareDeceval updateCodeudoresPagareDeceval(CodeudoresPagareDeceval codeudoresPagareDeceval) {
        CodeudoresPagareDeceval tc = update(codeudoresPagareDeceval);
        return tc;
    }

    
    public CodeudoresPagareDeceval findCodeudoresPagareDecevalById(Long id) {
        CodeudoresPagareDeceval tc = find(id);
        return tc; 
    }

    
    public List<CodeudoresPagareDeceval> findAllCodeudoresPagareDeceval() {
        List<CodeudoresPagareDeceval> listCodeudoresPagareDeceval = findAll();
        return listCodeudoresPagareDeceval;
    }

    
    public void deleteCodeudoresPagareDeceval(CodeudoresPagareDeceval codeudoresPagareDeceval) {
        delete(codeudoresPagareDeceval);
    }

}
