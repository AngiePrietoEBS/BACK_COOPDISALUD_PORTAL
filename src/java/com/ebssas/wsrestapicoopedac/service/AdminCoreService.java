/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSAdminCoopedac.ResponseActividadEconomica;
import WSAdminCoopedac.ResponseCargo;
import WSAdminCoopedac.ResponseCiudad;
import WSAdminCoopedac.ResponseLineaCredito;
import WSAdminCoopedac.ResponseNivelesEstudio;
import WSAdminCoopedac.ResponsePeriodo;
import WSAdminCoopedac.ResponseProfesion;
import WSAdminCoopedac.ResponseTipoContrato;
import WSAdminCoopedac.ResponseTipoEstadoCivil;
import WSAdminCoopedac.ResponseTiposIdent;
import com.ebssas.wsrestapicoopedac.response.ResponseEntidades;

/**
 *
 * @author Administrador
 */
public interface AdminCoreService {

    ResponseTiposIdent wsTiposIdentHabilitados();

    ResponseLineaCredito wsLineaCredito();

    ResponsePeriodo obtenerPeriodicidadHabilitadasSolCred();

    String getDescPeriodo(String lcodigo);

    ResponsePeriodo findPeriodoById(String codigo);

    ResponsePeriodo wsPeriodos();

    ResponseEntidades wsEntidades();
    
    ResponseNivelesEstudio wsTiposNivEstudio();

    ResponseNivelesEstudio wsTiposNivEstudioById(int codigo);

    ResponseTipoContrato wsTiposContrato();

    ResponseTipoContrato wsTiposContratoById(int codigo);

    ResponseTipoEstadoCivil wsTipoEstadoCivil();

    ResponseTipoEstadoCivil wsTipoEstadoCivilByID(String codigo);

    ResponseCiudad wsCiudad();

    ResponseCiudad wsCiudadByParam(String xiCodigo, String nombre, String nivel, String xi_ind_nal, String xi_ind_internal, String xi_ubicacion);

    ResponseProfesion wsProfesiones();

    ResponseCargo wsCargos();
    
    ResponseActividadEconomica wsActividadEconomica();

}
