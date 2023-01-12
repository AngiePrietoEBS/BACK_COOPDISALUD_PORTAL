/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.InformacionDesembolsoDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;

/**
 *
 * @author Administrador
 */
public class InformacionDesembolsoServiceBean implements InformacionDesembolsoService {

    @Override
    public InformacionDesembolso saveInformacionDesembolso(InformacionDesembolso informacionDesembolso) {
        return new InformacionDesembolsoDataAccessImp().saveInformacionDesembolso(informacionDesembolso);
    }

    @Override
    public InformacionDesembolso updateInformacionDesembolso(InformacionDesembolso informacionDesembolso) {
        return new InformacionDesembolsoDataAccessImp().updateInformacionDesembolso(informacionDesembolso);
    }

    @Override
    public InformacionDesembolso findInformacionDesembolsoBySolCred(Long idsolCred) {
        return new InformacionDesembolsoDataAccessImp().findInformacionDesembolsoBySolCred(idsolCred);
    }

}
