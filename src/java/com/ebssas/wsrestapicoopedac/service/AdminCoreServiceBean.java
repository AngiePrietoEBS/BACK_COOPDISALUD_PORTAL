/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSAdminCoopedac.ArrayOfLineaCreditoDTO;
import WSAdminCoopedac.ArrayOfPeriodoDTO;
import WSAdminCoopedac.ArrayOfTipoIdentificacionDTO;
import WSAdminCoopedac.LineaCreditoDTO;
import WSAdminCoopedac.PeriodoDTO;
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
import WSAdminCoopedac.TipoIdentificacionDTO;
import com.ebssas.wsrestapicoopedac.response.ResponseEntidades;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSAdministracion;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class AdminCoreServiceBean implements AdminCoreService {
    
    private final ConsumoWSAdministracion wsAdminCore;
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String WS_ADMIN = parametroServiceBean.obtenerParametroPorNombre("WS_ADMIN");
    
    public AdminCoreServiceBean() {
        this.wsAdminCore = new ConsumoWSAdministracion(WS_ADMIN);
    }
    
    @Override
    public ResponseTiposIdent wsTiposIdentHabilitados() {
        ResponseTiposIdent tiposIdentHabilitadas = new ResponseTiposIdent();
        ArrayOfTipoIdentificacionDTO arrayOfTipoIdentificacionDTO = new ArrayOfTipoIdentificacionDTO();
        try {
            String sTiposIdentHabParam = parametroServiceBean.obtenerParametroPorNombre("TIPOS_IDEN_HABILES");
            if (sTiposIdentHabParam != null && !sTiposIdentHabParam.equals("")) {
                String sSplitTiposIdentHab[] = sTiposIdentHabParam.split(",");
                if (sSplitTiposIdentHab != null && sSplitTiposIdentHab.length > 0) {
                    for (int i = 0; i < sSplitTiposIdentHab.length; i++) {
                        String sCodTipoIden = sSplitTiposIdentHab[i];
                        ResponseTiposIdent responseTiposIdent = this.wsTiposIdentByID(Integer.parseInt(sCodTipoIden));
                        if (responseTiposIdent != null && responseTiposIdent.isBRta()) {
                            List<TipoIdentificacionDTO> lstTipoIdent = responseTiposIdent.getLstTiposIdent().getTipoIdentificacionDTO();
                            if (lstTipoIdent != null && !lstTipoIdent.isEmpty()) {
                                for (TipoIdentificacionDTO tipoIdentificacionDTO : lstTipoIdent) {
                                    if (String.valueOf(tipoIdentificacionDTO.getICodigo()).equals(sCodTipoIden)) {
                                        arrayOfTipoIdentificacionDTO.getTipoIdentificacionDTO().add(tipoIdentificacionDTO);
                                    }
                                }
                            }
                        }
                    }
                    if (arrayOfTipoIdentificacionDTO.getTipoIdentificacionDTO().isEmpty()) {
                        tiposIdentHabilitadas.setBRta(false);
                        tiposIdentHabilitadas.setSMsjConsulta("Los tipos de identidad no fueron cargados correctamente.");
                        tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
                    } else {
                        tiposIdentHabilitadas.setBRta(true);
                        tiposIdentHabilitadas.setSMsjConsulta("Los datos de identidad fueron cargadas correctamente.");
                        tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            tiposIdentHabilitadas.setBRta(false);
            tiposIdentHabilitadas.setSMsjConsulta("Los tipos de identidad no fueron cargados correctamente.");
            tiposIdentHabilitadas.setLstTiposIdent(arrayOfTipoIdentificacionDTO);
        }
        
        return tiposIdentHabilitadas;
    }
    
    public ResponseTiposIdent wsTiposIdentByID(int codigo) {
        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();
        try {
            responseTiposIdent = wsAdminCore.wsTiposIdentById(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposIdent;
    }
    
    @Override
    public ResponseLineaCredito wsLineaCredito() {
        ParametroServiceBean paramDao = new ParametroServiceBean();
        ResponseLineaCredito responseLinea = wsAdminCore.wsLineaCredito();
        ResponseLineaCredito lineasCreditoHabiles = new ResponseLineaCredito();
        if (responseLinea != null && responseLinea.isBRta()) {
            String sPeriodicidadHabParam = paramDao.obtenerParametroPorNombre("LINEA_CREDITO_HABILITADA");
            if (sPeriodicidadHabParam != null && !sPeriodicidadHabParam.equals("")) {
                String sSplitPerHab[] = sPeriodicidadHabParam.split(",");
                if (sSplitPerHab != null && sSplitPerHab.length > 0) {
                    ArrayOfLineaCreditoDTO arrayOfPeriodoDTO = new ArrayOfLineaCreditoDTO();
                    for (int i = 0; i < sSplitPerHab.length; i++) {
//                        LineaCreditoDTO lineasCreditoDto = null;
                        List<LineaCreditoDTO> lineasCreditoDto = responseLinea.getListLineaCredito().getLineaCreditoDTO();
                        for (LineaCreditoDTO lineaCreditoDTO : lineasCreditoDto) {
                            if (String.valueOf(lineaCreditoDTO.getICodigo()).equals(sSplitPerHab[i])) {
                                arrayOfPeriodoDTO.getLineaCreditoDTO().add(lineaCreditoDTO);
                            }
                        }
                        
                    }
                    lineasCreditoHabiles.setBRta(true);
                    lineasCreditoHabiles.setSMsj("Los datos de las lineas de crédito fueron cargadas correctamente.");
                    lineasCreditoHabiles.setListLineaCredito(arrayOfPeriodoDTO);
                }
            }
        }
        return lineasCreditoHabiles;
    }
    
    public ResponseLineaCredito wsLineaCreditoByID(String codigo) {
        ResponseLineaCredito responseLineaCredito = new ResponseLineaCredito();
        try {
            responseLineaCredito = wsAdminCore.wsLineaCreditoById(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseLineaCredito;
    }
    
    
    @Override
    public ResponseEntidades wsEntidades() {
        ResponseEntidades resultado = new ResponseEntidades();
        
        try {
            resultado = wsAdminCore.wsEntidades();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return resultado;
    }
    
    @Override
    public ResponsePeriodo obtenerPeriodicidadHabilitadasSolCred() {
        ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
        ResponsePeriodo responsePeriodo = wsAdminCore.wsPeriodos();
        ResponsePeriodo periodicidadHabilitadas = new ResponsePeriodo();
        if (responsePeriodo != null && responsePeriodo.isBRta()) {
            String sPeriodicidadHabParam = parametroServiceBean.obtenerParametroPorNombre("PERIODICIDAD_HAB_SOL_CRED");
            if (sPeriodicidadHabParam != null && !sPeriodicidadHabParam.equals("")) {
                String sSplitPerHab[] = sPeriodicidadHabParam.split(",");
                if (sSplitPerHab != null && sSplitPerHab.length > 0) {
                    ArrayOfPeriodoDTO arrayOfPeriodoDTO = new ArrayOfPeriodoDTO();
                    for (int i = 0; i < sSplitPerHab.length; i++) {
                        PeriodoDTO periodoDTO = null;
                        periodoDTO = responsePeriodo.getListPerido().getPeriodoDTO().get(i);
                        if (String.valueOf(periodoDTO.getICodigo()).equals(sSplitPerHab[i])) {
                            arrayOfPeriodoDTO.getPeriodoDTO().add(periodoDTO);
                            periodoDTO = new PeriodoDTO();
                        }
                    }
                    periodicidadHabilitadas.setBRta(true);
                    periodicidadHabilitadas.setSMsj("Los datos de la periodicidad fueron cargadas correctamente.");
                    periodicidadHabilitadas.setListPerido(arrayOfPeriodoDTO);
                }
            }
        }
        return periodicidadHabilitadas;
    }
    
    @Override
    public ResponsePeriodo wsPeriodos() {
        return wsAdminCore.wsPeriodos();
    }
    
    @Override
    public ResponsePeriodo findPeriodoById(String codigo) {
        ResponsePeriodo periodo = new ResponsePeriodo();
        try {
            periodo = wsAdminCore.wsPeriodosById(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return periodo;
    }
    
    @Override
    public String getDescPeriodo(String lcodigo) {
        String sDescPeriodo = "";
        ResponsePeriodo responsePeriodo = this.findPeriodoById(lcodigo);
        if (responsePeriodo != null && responsePeriodo.isBRta()) {
            sDescPeriodo = responsePeriodo.getListPerido().getPeriodoDTO().get(0).getSDescripcion();
        }
        return sDescPeriodo;
    }
    
    @Override
    public ResponseNivelesEstudio wsTiposNivEstudio() {
        ResponseNivelesEstudio response = new ResponseNivelesEstudio();
        try {
            response = wsAdminCore.wsTIPOSNIVESTUDIOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseNivelesEstudio wsTiposNivEstudioById(int codigo) {
        ResponseNivelesEstudio response = new ResponseNivelesEstudio();
        try {
            response = wsAdminCore.wsTIPOSNIVESTUDIOII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseTipoEstadoCivil wsTipoEstadoCivil() {
        ResponseTipoEstadoCivil response = new ResponseTipoEstadoCivil();
        try {
            response = wsAdminCore.wsTiposEstadoCivil();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseTipoEstadoCivil wsTipoEstadoCivilByID(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResponseCiudad wsCiudad() {
        ResponseCiudad response = new ResponseCiudad();
        try {
            response = wsAdminCore.wsCiudad();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public ResponseCiudad wsCiudadByParam(String xiCodigo, String nombre, String nivel, String xi_ind_nal, String xi_ind_internal, String xi_ubicacion) {
        ResponseCiudad response = new ResponseCiudad();
        try {
            response = wsAdminCore.wsCiudadByParam(xiCodigo, nombre, nivel, xi_ind_nal, xi_ind_internal, xi_ubicacion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseProfesion wsProfesiones() {
        ResponseProfesion response = new ResponseProfesion();
        try {
            response = wsAdminCore.wsProfesion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseCargo wsCargos() {
        ResponseCargo response = new ResponseCargo();
        try {
            response = wsAdminCore.wsCargos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseTipoContrato wsTiposContrato() {
        ResponseTipoContrato response = new ResponseTipoContrato();
        try {
            response = wsAdminCore.wsTIPOCONTRATOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseTipoContrato wsTiposContratoById(int i) {
        ResponseTipoContrato response = new ResponseTipoContrato();
        try {
            response = wsAdminCore.wsTIPOCONTRATOII(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    @Override
    public ResponseActividadEconomica wsActividadEconomica() {
        ResponseActividadEconomica response = new ResponseActividadEconomica();
        try {
            response = wsAdminCore.wsActividadEconomica();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
}
