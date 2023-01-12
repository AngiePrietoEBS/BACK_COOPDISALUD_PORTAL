/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.domain.TipoAutorizacionSolCred;
import com.ebssas.wsrestapicoopedac.dataaccess.TipoAutorizacionSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.response.ResponseTiposAutorizacionesSolCred;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class TipoAutorizacionServiceBean implements TipoAutorizacionService {

    
    
    
    @Override
    public ResponseTiposAutorizacionesSolCred findAllTipoAutorizacion() {
        ResponseTiposAutorizacionesSolCred tiposAutorizacionesSolCred = new ResponseTiposAutorizacionesSolCred();

        List<TipoAutorizacionSolCred> list = new TipoAutorizacionSolCredDataAccessImp().findAllTipoAutorizacion();
        if (!list.isEmpty()) {

            tiposAutorizacionesSolCred.setListTipoAutorizacion(list);
            tiposAutorizacionesSolCred.setbRta(Boolean.TRUE);
            tiposAutorizacionesSolCred.setsMsj("Consulta exitosa");
        } else {
            tiposAutorizacionesSolCred.setbRta(Boolean.FALSE);
            tiposAutorizacionesSolCred.setsMsj("No se pudo cargar las autorizaciones");
        }

        return tiposAutorizacionesSolCred;
    }

    
    
    
    public ResponseTiposAutorizacionesSolCred findAllTipoAutorizacion(String codigoPersona) {
        ResponseTiposAutorizacionesSolCred tiposAutorizacionesSolCred = new ResponseTiposAutorizacionesSolCred();

        try {
            if (!"".equals(codigoPersona)) {
                List<TipoAutorizacionSolCred> list = new TipoAutorizacionSolCredDataAccessImp().findAllTipoAutorizacion();
                if (!list.isEmpty()) {

                    PersonasDTO personaDTO = new CygnusCoreServiceBean().wsConsultarPersona(codigoPersona, "", "").get(0);

                    String nombre = personaDTO.getCNombres() + " " + personaDTO.getCApellidos();
                    //String tipoIdentificacion = new AdminCoreServiceBean().wsTiposIdentByID(Integer.parseInt(personaDTO.getITipoIden())).getLstTiposIdent().getTipoIdentificacionDTO().get(0).getSDescripcion();
                    //String ciudadExpedicion = new AdminCoreServiceBean().wsCiudadByParam("", "", "", "", "", "").getListCiudades().getCiudadDTO().get(0).getCNombre();

                    for (TipoAutorizacionSolCred auto : list) {
                        auto.setCDescripcion(auto.getCDescripcion().replace("\"nombre\"", nombre));
                        auto.setCDescripcion(auto.getCDescripcion().replace("\"tipoDocumento\"", "CEDULA DE CIUDADANIA"));
                        auto.setCDescripcion(auto.getCDescripcion().replace("\"identificacion\"", personaDTO.getCIdentificacion()));
                        auto.setCDescripcion(auto.getCDescripcion().replace("\"ciudadExpedicion\"", "Bogotá D.C."));
                    }

                    tiposAutorizacionesSolCred.setListTipoAutorizacion(list);
                    tiposAutorizacionesSolCred.setbRta(Boolean.TRUE);
                    tiposAutorizacionesSolCred.setsMsj("Consulta exitosa");
                } else {
                    tiposAutorizacionesSolCred.setbRta(Boolean.FALSE);
                    tiposAutorizacionesSolCred.setsMsj("No se pudo cargar las autorizaciones");
                }
            } else {
                tiposAutorizacionesSolCred.setbRta(Boolean.FALSE);
                tiposAutorizacionesSolCred.setsMsj("No se pudo cargar las autorizaciones.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            tiposAutorizacionesSolCred.setbRta(Boolean.FALSE);
            tiposAutorizacionesSolCred.setsMsj("Se ha presentado un inconveniente al cargar las autorizaciones.");
        }

        return tiposAutorizacionesSolCred;
    }
}
