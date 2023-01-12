/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSAdminCoopedac.TipoContratoDTO;
import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.DatosPersonalesDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;
import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.response.ResponseDatosPersonales;
import com.ebssas.wsrestapicoopedac.response.ResponseDatosPersonalesSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseOcupacionPersona;
import com.ebssas.wsrestapicoopedac.responseAML.AmlResponseDTO;
import com.ebssas.wsrestapicoopedac.wsaml.WSamlEthos;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DatosPersonalesSolCredServiceBean implements DatosPersonalesSolCredService {

    private final AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();

    @Override
    public ResponseDatosPersonalesSolCred obtenerDatosPersonalesCore(Long codPersona) {

        ResponseDatosPersonalesSolCred cred = new ResponseDatosPersonalesSolCred();
        ResponseOcupacionPersona ocupacionPersona = new ResponseOcupacionPersona();
        OperacionFinanciera operacionFinanciera = new OperacionFinanciera();

        ResponseDatosPersonales datosPersonales = new ResponseDatosPersonales();
        CygnusCoreServiceBean coreServiceBean = new CygnusCoreServiceBean();
        List<PersonasDTO> personaCore = coreServiceBean.wsConsultarPersona(String.valueOf(codPersona), "", "");
        if (personaCore.size() > 0) {
            PersonasDTO personaC = personaCore.get(0);
            datosPersonales.setCNumCelular(personaC.getCTelefono());
            datosPersonales.setCEmail(personaC.getCEMail());

            TipoContratoDTO contratoDTO = this.adminCoreServiceBean.wsTiposContratoById(Integer.parseInt(personaC.getITipoCont())).getListTipoContr().getTipoContratoDTO().get(0);
            ocupacionPersona.setITipoContrato(contratoDTO);
            List<PersonasDTO> empresaDTO = coreServiceBean.wsConsultarPersona(personaC.getICodEmp(), "", "");
            if (!empresaDTO.isEmpty()) {
                ocupacionPersona.setCEmpresa(empresaDTO.get(0).getCRazonSoc());
            }
            operacionFinanciera.setNSalario(Long.parseLong(personaC.getNSalario()));

            cred.setDatosPersonales(datosPersonales);
            cred.setOcupacionPersona(ocupacionPersona);
            cred.setOperacionFinanciera(operacionFinanciera);

            cred.setbRTa(Boolean.TRUE);
            cred.setsMjs("Consulta exitosa.");
        } else {
            cred.setbRTa(Boolean.FALSE);
            cred.setsMjs("No se encontro registros");
        }

        return cred;
    }

    @Override
    public ResponseDatosPersonalesSolCred obtenerDatosPersonalesSolCred(Long codPersona, Long idSolCred) {
        ResponseDatosPersonalesSolCred datosPersonalesSolCred = new ResponseDatosPersonalesSolCred();

        ResponseDatosPersonales datosPersonales     = new ResponseDatosPersonales();
        ResponseOcupacionPersona ocupacionPersona   = new ResponseOcupacionPersona();
        OperacionFinanciera operacionFinanciera     = new OperacionFinanciera();
        InformacionDesembolso informacionDesembolso = new InformacionDesembolso();
        AperturaCuentaSolCred aperturaCuentaSolCred = new AperturaCuentaSolCred();

        CygnusCoreServiceBean coreServiceBean = new CygnusCoreServiceBean();

        try {
            List<PersonasDTO> personaCore = coreServiceBean.wsConsultarPersona(String.valueOf(codPersona), "", "");

            DatosPersonales datosPersonalesBD = this.findDatosPersonalesByPersona(codPersona);
            
            if (datosPersonalesBD.getICodigo() != null) {
                
                /**
                 * ANDYSIERRA: PENDIENTE POR CORREGIR A NIVEL DE WS:
                 * Se necesita consultar estos DTO's desde un WS ya que su info se encuentra en CYGNUS
                 * [MODIFICAR ADMINISTRACION CYGNUS]
                 */
                datosPersonales.setIDepartamentoResidencia  (null);    // * 
                datosPersonales.setICiudadResidencia        (null);         // usar WS Administracion andysierra <future>
                datosPersonales.setIEstrato                 (null);                 // *
                datosPersonales.setCEstadoCivil             (null);             // usar WS Administracion andysierra <future>
                datosPersonales.setINivelEstudio            (null);            // usar WS Administracion andysierra <future>
                
                datosPersonales.setICodigo              (datosPersonalesBD.getICodigo());
                datosPersonales.setCDireccionResidencia (datosPersonalesBD.getCDireccionResidencia());
                datosPersonales.setITipoVivienda        (datosPersonalesBD.getITipoVivienda());
                datosPersonales.setNPersonasCargo       (datosPersonalesBD.getNPersonasCargo());
                datosPersonales.setCCabezaHogar         (datosPersonalesBD.getCCabezaHogar());
                datosPersonales.setCTelefonoFijo        (datosPersonalesBD.getCTelefonoFijo());
                datosPersonales.setCNumCelular          (datosPersonalesBD.getCNumCelular());
                datosPersonales.setCFacebook            (datosPersonalesBD.getCFacebook());
                datosPersonales.setCLinkedin            (datosPersonalesBD.getCLinkedin());
                datosPersonales.setCEmail               (datosPersonalesBD.getCEmail());
                datosPersonales.setIPersona             (datosPersonalesBD.getIPersona());
            } else {
                if (!personaCore.isEmpty()) {
                    datosPersonales.setCNumCelular(personaCore.get(0).getCTelefono());
                    datosPersonales.setCEmail(personaCore.get(0).getCEMail());
                    datosPersonales.setIPersona(new Persona(Long.parseLong(personaCore.get(0).getICodigo())));
                    datosPersonales.setICodigo              (Long.parseLong(personaCore.get(0).getICodigo()));
                    datosPersonales.setCDireccionResidencia (personaCore.get(0).getCDireccion());
                    datosPersonales.setITipoVivienda        (null);
                    datosPersonales.setNPersonasCargo       (null);
                    datosPersonales.setCCabezaHogar         (null);
                    datosPersonales.setCTelefonoFijo        (personaCore.get(0).getCTelefono());
                    datosPersonales.setCEmail               (personaCore.get(0).getCEMail());
                }
            }

            OcupacionPersona ocupacionPersonaDB = new OcupacionPersonaServiceBean().findOcupacionPersonaByPersona(codPersona);
            if (ocupacionPersonaDB.getICodigo() != null) {
                ocupacionPersona.setCEmpresa(ocupacionPersonaDB.getCEmpresa());
                BigInteger tipoContrato = ocupacionPersonaDB.getITipoContrato();
                if(tipoContrato != null) {
                    TipoContratoDTO contratoDTO 
                        = this.adminCoreServiceBean.wsTiposContratoById(ocupacionPersonaDB.getITipoContrato().intValue())
                                .getListTipoContr().getTipoContratoDTO().get(0);
                    ocupacionPersona.setITipoContrato(contratoDTO);
                    ocupacionPersona.setIPersona(ocupacionPersonaDB.getIPersona());
                }
            } else {
                if (!personaCore.isEmpty()) {
                    TipoContratoDTO contratoDTO = this.adminCoreServiceBean.wsTiposContratoById(Integer.parseInt(personaCore.get(0).getITipoCont())).getListTipoContr().getTipoContratoDTO().get(0);
                    ocupacionPersona.setITipoContrato(contratoDTO);
                    ocupacionPersona.setIPersona(new Persona(Long.parseLong(personaCore.get(0).getICodigo())));
                    List<PersonasDTO> empresaDTO = coreServiceBean.wsConsultarPersona(personaCore.get(0).getICodEmp(), "", "");
                    if (!empresaDTO.isEmpty()) {
                        ocupacionPersona.setCEmpresa(empresaDTO.get(0).getCRazonSoc());
                    }
                }
            }

            operacionFinanciera = new OperacionFinancieraServiceBean().findOperacionFinancieraByPersona(codPersona);
            if (operacionFinanciera.getICodigo() == null) {
                if (!personaCore.isEmpty()) {
                    operacionFinanciera = new OperacionFinanciera();
                    if (!personaCore.get(0).getNSalario().equals("")) {
                        if (personaCore.get(0).getNSalario().contains(".")) {
                            String salario = personaCore.get(0).getNSalario().split("\\.")[0];
                            operacionFinanciera.setNSalario(Long.parseLong(salario));
                        } else {
                            operacionFinanciera.setNSalario(Long.parseLong(personaCore.get(0).getNSalario()));
                        }
                    }
                   
                    operacionFinanciera.setIPersona(new Persona(Long.parseLong(personaCore.get(0).getICodigo())));
                }
            }

            informacionDesembolso = new InformacionDesembolsoServiceBean().findInformacionDesembolsoBySolCred(idSolCred);
            if (informacionDesembolso.getICodigo() != null) {
                datosPersonalesSolCred.setInformacionDesembolso(informacionDesembolso);
            }
            
            aperturaCuentaSolCred = new AperturaCuentaSolCredServiceBean().findAperturaCuentaBySolCred(idSolCred);
            if(aperturaCuentaSolCred.getICodigo() != null){
                datosPersonalesSolCred.setAperturaCuentaSolCred(aperturaCuentaSolCred);
            }

            if (datosPersonales.getIPersona() != null && ocupacionPersona.getIPersona() != null && operacionFinanciera.getIPersona() != null) {
                datosPersonalesSolCred.setDatosPersonales(datosPersonales);
                datosPersonalesSolCred.setOcupacionPersona(ocupacionPersona);
                datosPersonalesSolCred.setOperacionFinanciera(operacionFinanciera);

                datosPersonalesSolCred.setbRTa(Boolean.TRUE);
                datosPersonalesSolCred.setsMjs("Consulta exitosa");
            } else {
                datosPersonalesSolCred.setbRTa(Boolean.FALSE);
                datosPersonalesSolCred.setsMjs("No se pudo recuperar la informacion del asociado, por favor intente de nuevo.");
            }

        } catch (Exception e) {
            datosPersonalesSolCred.setbRTa(Boolean.FALSE);
            datosPersonalesSolCred.setsMjs("No se pudo recuperar la informacion del asociado, por favor intente de nuevo.");
            e.printStackTrace();
        }

        return datosPersonalesSolCred;
    }

    @Override
    public DatosPersonales saveDatosPersonales(DatosPersonales datosPersonales) {
        return new DatosPersonalesDataAccessImp().saveDatosPersonale(datosPersonales);
    }

    @Override
    public DatosPersonales updateDatosPersonales(DatosPersonales datosPersonales) {
        return new DatosPersonalesDataAccessImp().updateDatosPersonales(datosPersonales);
    }

    @Override
    public DatosPersonales findDatosPersonalesByPersona(Long id) {
        return new DatosPersonalesDataAccessImp().findDatosPersonalesByIdPersona(id);
    }

}
