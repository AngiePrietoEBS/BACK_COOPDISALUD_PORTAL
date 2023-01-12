/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.BeneficiarioAperturaCta;

/**
 *
 * @author Administrador
 */
public interface BeneficiarioAperturaCtaDataAccess {

    BeneficiarioAperturaCta saveBeneficiarioCuenta(BeneficiarioAperturaCta beneficiarioAperturaCta);

    BeneficiarioAperturaCta updateBeneficiarioCuenta(BeneficiarioAperturaCta beneficiarioAperturaCta);

    BeneficiarioAperturaCta findBeneficiarioCtaByIdCuenta(Long idAperturaCta);
}
