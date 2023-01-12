/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.HistoriaSolCredito;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;

/**
 *
 * @author Administrador
 */
public interface HistoriaSolCredDataAccess {

    HistoriaSolCredito crear(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb);

    HistoriaSolCredito saveHistoriaSolicitudCredito(HistoriaSolCredito historiaSolicitudCredito);

    HistoriaSolCredito findHistoriaSolCredById(Long id);

    HistoriaSolCredito findHistoriaSolCredBySolCred(SolicitudCredito solicitudCredito);

    HistoriaSolCredito update(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solAfilWeb, String mensaje);

}
