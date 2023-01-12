/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.TipoEstadoSolCreditoDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.TipoEstadoSolicitudCredito;
import com.ebssas.wsrestapicoopedac.response.ResponseTipoEstadoSolCredito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joseph
 */
public class TipoEstadoSolCreditoServiceBean implements TipoEstadoSolCreditoService {

    private final TipoEstadoSolCreditoDataAccessImp TipoEstadoSol = new TipoEstadoSolCreditoDataAccessImp();

    @Override
    public TipoEstadoSolicitudCredito findByID(long id) {
        return TipoEstadoSol.findByID(id);
    }

    @Override
    public List<ResponseTipoEstadoSolCredito> findAllTipoEstado() {
        List<ResponseTipoEstadoSolCredito> listResponseTipoEstadoSolCredito = new ArrayList<>();

        List<TipoEstadoSolicitudCredito> listTipoEst = TipoEstadoSol.findAllTipoEstado();

        if (listTipoEst != null && !listTipoEst.isEmpty()) {
            ResponseTipoEstadoSolCredito respuesta = new ResponseTipoEstadoSolCredito();
            for (TipoEstadoSolicitudCredito tp : listTipoEst) {
                if (tp.getICodigo() == 3 || tp.getICodigo() == 4 || tp.getICodigo() == 5 || tp.getICodigo() == 7 || tp.getICodigo() == 8) {
                    Long idCodigo = tp.getICodigo();
                    respuesta.setiCodigo(idCodigo.intValue());
                    respuesta.setcDescripcion(tp.getCDescripcion());
                    listResponseTipoEstadoSolCredito.add(respuesta);
                    respuesta = new ResponseTipoEstadoSolCredito();
                }
            }
        }
        return listResponseTipoEstadoSolCredito;
    }

//    @Override
//    public List<ResponseTipoEstadoSolCredito> findTipoEstadoByIdCurrentTipoSolCred(Long IdCurrentTipoSolCred) {
//        List<ResponseTipoEstadoSolCredito> listResponseTipoEstadoSolCredito = new ArrayList<>();
//
//        List<TipoEstadoSolicitudCredito> listTipoEst = TipoEstadoSol.findAllTipoEstado();
//
//        if (listTipoEst != null && !listTipoEst.isEmpty()) {
//            ResponseTipoEstadoSolCredito respuesta = new ResponseTipoEstadoSolCredito();
//            if (IdCurrentTipoSolCred != null) {
//                if (IdCurrentTipoSolCred == 2) {
//                    listTipoEst.removeIf(tp -> tp.getICodigo() == 1 || tp.getICodigo() == IdCurrentTipoSolCred || tp.getICodigo() == 3 || tp.getICodigo() == 4 || tp.getICodigo() == 5 || tp.getICodigo() == 6 || tp.getICodigo() == 8);
//                } else if (IdCurrentTipoSolCred == 3) {
//                    listTipoEst.removeAll(listTipoEst);
//                } else if (IdCurrentTipoSolCred == 4) {
//                    listTipoEst.removeIf(tp -> tp.getICodigo() == 1 || tp.getICodigo().equals(2) || tp.getICodigo().equals(8) || tp.getICodigo() == 6 || tp.getICodigo() == IdCurrentTipoSolCred);
//                } else if (IdCurrentTipoSolCred == 5) {
//                    listTipoEst.removeAll(listTipoEst);
//                } else if (IdCurrentTipoSolCred == 6) {
//                    listTipoEst.removeIf(tp -> tp.getICodigo() == 1 || tp.getICodigo() == 2 || tp.getICodigo() == 3 || tp.getICodigo() == 4 || tp.getICodigo() == 5 || tp.getICodigo() == IdCurrentTipoSolCred || tp.getICodigo() == 7);
//                } else if (IdCurrentTipoSolCred == 7) {
//                    listTipoEst.removeIf(tp -> tp.getICodigo() == 1 || tp.getICodigo() == 2 || tp.getICodigo() == 6 || tp.getICodigo() == 8 || tp.getICodigo() == IdCurrentTipoSolCred);
//                } else if (IdCurrentTipoSolCred == 8) {
//                    listTipoEst.removeAll(listTipoEst);
//                }
//                for (TipoEstadoSolicitudCredito tp : listTipoEst) {
//                    Long idCodigo = tp.getICodigo();
//                    respuesta.setiCodigo(idCodigo.intValue());
//                    respuesta.setcDescripcion(tp.getCDescripcion());
//                    listResponseTipoEstadoSolCredito.add(respuesta);
//                    respuesta = new ResponseTipoEstadoSolCredito();
//                }
//            }
//        }
//        return listResponseTipoEstadoSolCredito;
//    }
}
