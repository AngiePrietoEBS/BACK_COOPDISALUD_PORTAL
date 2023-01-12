/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.*;
import com.ebssas.wsrestapicoopedac.domain.CodeudoresPagareDeceval;
import java.util.List;

/**
 *
 * @author Braya
 */
public class CodeudorPagareDecevalServiceBean   {

        
    
    public CodeudoresPagareDeceval saveCodeudoresPagareDeceval(CodeudoresPagareDeceval codeudoresPagareDeceval) {
        CodeudoresPagareDeceval tc = new CodeudorPagareDecevalDataAccessImp().saveCodeudoresPagareDeceval(codeudoresPagareDeceval);
        return tc;
    }

    
    public CodeudoresPagareDeceval updateCodeudoresPagareDeceval(CodeudoresPagareDeceval codeudoresPagareDeceval) {
        CodeudoresPagareDeceval tc =  new CodeudorPagareDecevalDataAccessImp().updateCodeudoresPagareDeceval(codeudoresPagareDeceval);
        return tc;
    }

    
    public CodeudoresPagareDeceval findCodeudoresPagareDecevalById(Long id) {
        CodeudoresPagareDeceval tc =  new CodeudorPagareDecevalDataAccessImp().findCodeudoresPagareDecevalById(id);
        return tc; 
    }

    
    public List<CodeudoresPagareDeceval> findAllCodeudoresPagareDeceval() {
        List<CodeudoresPagareDeceval> listCodeudoresPagareDeceval =  new CodeudorPagareDecevalDataAccessImp().findAllCodeudoresPagareDeceval();
        return listCodeudoresPagareDeceval;
    }

    
    public void deleteCodeudoresPagareDeceval(CodeudoresPagareDeceval codeudoresPagareDeceval) {
         new CodeudorPagareDecevalDataAccessImp().deleteCodeudoresPagareDeceval(codeudoresPagareDeceval);
    }

}
