/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.HistoriaSolCredito;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class HistoriaSolCredDataAccessImp extends GenericRepositoryJPAImp<HistoriaSolCredito> implements HistoriaSolCredDataAccess {

    private EntityManager em = null;

    @Override
    public HistoriaSolCredito crear(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solicitudCredito) {
        HistoriaSolCredito hisSolAfiWebTemporal = new HistoriaSolCredito();
        hisSolAfiWebTemporal.setISolCredito(solicitudCredito);
        //hisSolAfiWebTemporal.setIEstadoSolicitud(tipoEstSolAfilWeb);
        hisSolAfiWebTemporal.setCObservacion("Se inicio el proceso de solicitud de crédito.");
        hisSolAfiWebTemporal.setFFecha(new Date());
        HistoriaSolCredito hisSolAfiWeb = create(hisSolAfiWebTemporal);
        return hisSolAfiWeb;
    }

    @Override
    public HistoriaSolCredito saveHistoriaSolicitudCredito(HistoriaSolCredito historiaSolicitudCredito) {
        return create(historiaSolicitudCredito);
    }

    @Override
    public HistoriaSolCredito findHistoriaSolCredById(Long id) {
        return find(id);
    }

    @Override
    public HistoriaSolCredito findHistoriaSolCredBySolCred(SolicitudCredito solicitudCredito) {
        HistoriaSolCredito histSolCred = new HistoriaSolCredito();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();

        try {
            em = connDBJPA.getEntityManager();
            Query consultDocument = em.createNativeQuery("SELECT   h.*\n"
                    + "    FROM historia_solicitud_credito h,\n"
                    + "         solicitud_credito sc,\n"
                    + "         tipo_estado_solicitud_credito tesc\n"
                    + "   WHERE h.i_solicitud_credito = sc.i_codigo\n"
                    + "     AND h.i_estado_solicitud = tesc.i_codigo\n"
                    + "     AND sc.i_estado_solicitud = tesc.i_codigo\n"
                    + "     AND h.i_estado_solicitud = sc.i_estado_solicitud\n"
                    + "     AND tesc.i_codigo = ? \n"
                    + "     AND sc.I_CODIGO = ? \n"
                    + "ORDER BY h.f_fecha_historia DESC", HistoriaSolCredito.class
            );

            consultDocument.setParameter(1, solicitudCredito.getIEstadoSolicitud().getICodigo());
            consultDocument.setParameter(2, solicitudCredito.getICodigo());

            List<HistoriaSolCredito> historiaSolCredList = consultDocument.getResultList();
            if (historiaSolCredList != null && !historiaSolCredList.isEmpty()) {
                for (HistoriaSolCredito hsc : historiaSolCredList) {
                    if (hsc.getISolCredito().equals(solicitudCredito)) {
                        histSolCred = hsc;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connDBJPA.closeEntityManager();
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
        return histSolCred;
    }

    @Override
    public HistoriaSolCredito update(TipoEstadoSolicitudCredito tipoEstSolAfilWeb, SolicitudCredito solicitudCredito, String mensaje) {
        HistoriaSolCredito hisSolAfiWebTemporal = new HistoriaSolCredito();
        hisSolAfiWebTemporal.setFFecha(new Date());
        hisSolAfiWebTemporal.setCObservacion(mensaje);
        //hisSolAfiWebTemporal.setIEstadoSolicitud(tipoEstSolAfilWeb);
        hisSolAfiWebTemporal.setISolCredito(solicitudCredito);
        HistoriaSolCredito hisSolAfiWeb = update(hisSolAfiWebTemporal);
        return hisSolAfiWeb;
    }

}
