/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;

/**
 *
 * @author Administrador
 */
public interface InformacionDesembolsoService {

    InformacionDesembolso saveInformacionDesembolso(InformacionDesembolso informacionDesembolso);

    InformacionDesembolso updateInformacionDesembolso(InformacionDesembolso informacionDesembolso);

    InformacionDesembolso findInformacionDesembolsoBySolCred(Long idsolCred);

}
