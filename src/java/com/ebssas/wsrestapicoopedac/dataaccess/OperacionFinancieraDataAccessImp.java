/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.dataaccess;

import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.general.ConnectionDBJPA;
import com.ebssas.wsrestapicoopedac.general.GenericRepositoryJPAImp;
import com.ebssas.wsrestapicoopedac.response.ResponseCaptacionPago;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class OperacionFinancieraDataAccessImp extends GenericRepositoryJPAImp<OperacionFinanciera> implements OperacionFinancieraDataAccess {
    
    private EntityManager em = null;
    
    @Override
    public OperacionFinanciera saveOperacionFinanciera(OperacionFinanciera operacionFinanciera) {
        return create(operacionFinanciera);
    }
    
    @Override
    public OperacionFinanciera updateOperacionFinanciera(OperacionFinanciera operacionFinanciera) {
        return update(operacionFinanciera);
    }
    
//    @Override
//    public ResponseCaptacionPago findOperacionFinancieraByIdPersona(Long id) {
//        OperacionFinanciera operacionFinanciera = new OperacionFinanciera();
//        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();
//        Long Salario, OtrosIn, CotrosIn, TActivos, TPasivos, GaLaborales, GaFamiliares, DesLaborares, GasFinancierosCifin, GasFinancieros, Operadorador1, Operador2;
//        ResponseCaptacionPago respuesta = new ResponseCaptacionPago();
//        try {
//            this.em = connDBJPA.getEntityManager();
//            String sentencia = "SELECT * FROM OPERACION_FINANCIERA WHERE I_PERSONA = ?";
//            Query query = em.createNativeQuery(sentencia, OperacionFinanciera.class);
//            query.setParameter(1, id);
//            
//            List<OperacionFinanciera> listO = query.getResultList();
//            
//            if (listO != null && !listO.isEmpty()) {
//                for (OperacionFinanciera op : listO) {
//                    if (op.getIPersona().getICodigo().equals(id)) {
////                        operacionFinanciera = op;
//                        Long Monto = op.getNGastosFamiliares();
//                        Salario = op.getNSalario();
//                        Operadorador1 = Salario + Monto;
//                        respuesta.setsMsj("TRUE");
//                        respuesta.setCedula(id);
//                        respuesta.setValor(Operadorador1);
//                    }
//                    
//                }
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (em != null) {
//                if (em.isOpen()) {
//                    em.close();
//                }
//            }
//        }
//        
//        return respuesta;
//    }
    @Override
    public OperacionFinanciera findOperacionFinancieraByIdPersona(Long id) {
        OperacionFinanciera operacionFinanciera = new OperacionFinanciera();
        ConnectionDBJPA connDBJPA = new ConnectionDBJPA();

        try {
            this.em = connDBJPA.getEntityManager();
            String sentencia = "SELECT * FROM OPERACION_FINANCIERA WHERE I_PERSONA = ?";
            Query query = em.createNativeQuery(sentencia, OperacionFinanciera.class);
            query.setParameter(1, id);

            List<OperacionFinanciera> listO = query.getResultList();

            if (listO != null && !listO.isEmpty()) {
                for (OperacionFinanciera op : listO) {
                    if (op.getIPersona().getICodigo().equals(id)) {
                        operacionFinanciera = op;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }

        return operacionFinanciera;
    }
}
