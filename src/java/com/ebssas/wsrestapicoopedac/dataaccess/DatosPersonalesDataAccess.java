/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;

/**
 *
 * @author Administrador
 */
public interface DatosPersonalesDataAccess {
    
    DatosPersonales saveDatosPersonale(DatosPersonales datosPersonales);
    
    DatosPersonales updateDatosPersonales(DatosPersonales datosPersonales);
    
    DatosPersonales findDatosPersonalesByIdPersona(Long id);
    
    
    
}
