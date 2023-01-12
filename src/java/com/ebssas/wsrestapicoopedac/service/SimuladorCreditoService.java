/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.response.ResponseCupoMaximo;
import com.ebssas.wsrestapicoopedac.response.ResponseSimuladorCredito;

/**
 *
 * @author Administrador
 */
public interface SimuladorCreditoService {

    ResponseCupoMaximo calcularCupoMaximo(String pwsIdentific, String pwsCodCredi, String pwsFormPeriodic);

    ResponseSimuladorCredito simuladorValorCuota(String pwsMonto, String pwsNroCuotas, String pwsValRecog, String pwsCodCredi, String pwsIdentific, String pwsFormPeriodic, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3, String pwsFormaPago);
}
