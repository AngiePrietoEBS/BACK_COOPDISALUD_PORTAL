package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;

/**
 * @author Andrés Sierra
 */
public interface CuentasAhorroService
{
    ResponseCrearCtaAhorros crearCuentaAhorrosCoopedac(RequestCrearCtaAhorros input);
    ResponseListadoCuentas getCuentaAhorrosByIdent(String sIdent);
}