/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSAdminCoopedac.CiudadDTO;
import com.ebssas.wsrestapicoopedac.dataaccess.AperturaCuentaSolCredDataAccessImp;
import com.ebssas.wsrestapicoopedac.dataaccess.BeneficiarioAperturaCtaDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.AperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.domain.BeneficiarioAperturaCta;
import com.ebssas.wsrestapicoopedac.domain.CondicionCuenta;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.request.RequestAperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.response.ResponseAperturaCuentaSolCred;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class AperturaCuentaSolCredServiceBean implements AperturaCuentaSolCredService {

//    public RespuestaGenerica guardarApertura(RequestAperturaCuentaSolCred racsc) {
//        RespuestaGenerica generica = new RespuestaGenerica();
//
//        if (racsc.getAperturaCuentaSolCred() != null) {
//            AperturaCuentaSolCred acsc = this.actualizarAperturaCuenta(racsc.getAperturaCuentaSolCred());
//            if (generica.getbRta()) {
//                if (!racsc.getListBeneficiarios().isEmpty()) {
//                    for (BeneficiarioAperturaCta beneficiario : racsc.getListBeneficiarios()) {
//                        //BeneficiarioAperturaCta buscarBenef = new BeneficiarioAperturaCtaDataAccessImp().findBeneficiarioCtaByIdCuenta(acsc.getICodigo(), beneficiario.get);
//                    }
//                }
//            }
//
//        }
//
//        return generica;
//    }

    @Override
    public AperturaCuentaSolCred saveAperturaCuentaSolCred(AperturaCuentaSolCred aperturaCuentaSolCred) {
        return new AperturaCuentaSolCredDataAccessImp().saveAperturaCuenta(aperturaCuentaSolCred);
    }

    @Override
    public AperturaCuentaSolCred updateAperturaCuentaSolCred(AperturaCuentaSolCred aperturaCuentaSolCred) {
        return new AperturaCuentaSolCredDataAccessImp().updateAperturaCuenta(aperturaCuentaSolCred);
    }

    @Override
    public AperturaCuentaSolCred findAperturaCuentaBySolCred(Long id) {
        return new AperturaCuentaSolCredDataAccessImp().findAperturaCuentaByIdSolCred(id);
    }

    @Override
    public ResponseAperturaCuentaSolCred findAperturaCuentaBySolCredR(Long id) {

        ResponseAperturaCuentaSolCred racsc = new ResponseAperturaCuentaSolCred();
        try {

            AperturaCuentaSolCred aperturaCuentaSolCred = new AperturaCuentaSolCredDataAccessImp().findAperturaCuentaByIdSolCred(id);
            if (aperturaCuentaSolCred.getICodigo() != null) {
                AdminCoreServiceBean coreServiceBean = new AdminCoreServiceBean();
                CiudadDTO ciudadDTO = coreServiceBean.wsCiudadByParam(aperturaCuentaSolCred.getICodigo().toString(), "", "", "", "", "").getListCiudades().getCiudadDTO().get(0);
                racsc.setCiudad(ciudadDTO);
                racsc.setICodigo(aperturaCuentaSolCred.getICodigo());
                racsc.setITipoIdent(aperturaCuentaSolCred.getITipoIdent());
                racsc.setCApellidos(aperturaCuentaSolCred.getCApellidos());
                racsc.setCNombres(aperturaCuentaSolCred.getCNombres());
                racsc.setCTelefono(aperturaCuentaSolCred.getCTelefono());
                racsc.setCDireccion(aperturaCuentaSolCred.getCDireccion());
                racsc.setFFechaExpedicion(aperturaCuentaSolCred.getFFechaExpedicion());
                racsc.setfFechaNacimiento(aperturaCuentaSolCred.getfFechaNacimiento());
                racsc.setCTelefono(aperturaCuentaSolCred.getCTelefono());
                racsc.setCTipoCuenta(aperturaCuentaSolCred.getCTipoCuenta());
                racsc.setITipoCondicion(aperturaCuentaSolCred.getITipoCondicion());
                racsc.setBeneficiarioAperturaCtaList(aperturaCuentaSolCred.getBeneficiarioAperturaCtaList());
                racsc.setISolCredito(aperturaCuentaSolCred.getISolCredito());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return racsc;
    }

    public RespuestaGenerica actualizarAperturaCuenta(AperturaCuentaSolCred acsc) {
        RespuestaGenerica generica = new RespuestaGenerica();

        BeneficiarioAperturaCtaDataAccessImp accessImp = new BeneficiarioAperturaCtaDataAccessImp();
        AperturaCuentaSolCred aperturaCuentaSolCred = new AperturaCuentaSolCred();

        try {
            if (acsc != null) {
                System.out.println("ascs " + acsc.toString());
                System.out.println("Benefs " + acsc.getBeneficiarioAperturaCtaList().size());
                for(BeneficiarioAperturaCta benef: acsc.getBeneficiarioAperturaCtaList()){
                    System.out.println("Nombre " + benef.getCNombres());
                    System.out.println("Nombre " + benef.getCIdentificacion());
                    System.out.println("Nombre " + benef.getCApellidos());
                    System.out.println("Nombre " + benef.getCTelefono());
                    System.out.println("Nombre " + benef.getNPorcentaje());
                    System.out.println("Nombre " + benef.getICiudad());
                }
                
                SolicitudCredito sc = new SolicitudCreditoServiceBean().findSolCreditoByRadicado(acsc.getISolCredito().getINumRadic());
                if (sc != null) {
                    AperturaCuentaSolCred buscarCuenta = this.findAperturaCuentaBySolCred(sc.getICodigo());
                    if (buscarCuenta.getICodigo() != null) {
                        acsc.setfFechaNacimiento(new Date());
                        acsc.setFFechaExpedicion(new Date());
                        acsc.setITipoCondicion(new CondicionCuenta(Long.parseLong("1")));
                        acsc.setICodigo(buscarCuenta.getICodigo());
                        AperturaCuentaSolCred cuentaSolCredU = this.updateAperturaCuentaSolCred(acsc);
                        if (cuentaSolCredU != null) {
                            aperturaCuentaSolCred = cuentaSolCredU;

                            List<BeneficiarioAperturaCta> listFind = accessImp.findAllBeneficiariosByCta(aperturaCuentaSolCred.getICodigo());

                            // Actualizar actuales beneficiarios
                            for (BeneficiarioAperturaCta beneficiarioAperturaCta : acsc.getBeneficiarioAperturaCtaList()) {
                                BeneficiarioAperturaCta buscarBenef = accessImp.findBeneficiarioCtaByIdCuenta(aperturaCuentaSolCred.getICodigo(), beneficiarioAperturaCta.getCIdentificacion());
                                if (buscarBenef.getICodigo() != null) {
                                    beneficiarioAperturaCta.setICodigo(buscarBenef.getICodigo());
                                    accessImp.update(beneficiarioAperturaCta);
                                }
                            }

                            //Insertar nuevos beneficiarios
                            for (BeneficiarioAperturaCta beneficiarioAperturaCta : acsc.getBeneficiarioAperturaCtaList()) {
                                if (!listFind.contains(beneficiarioAperturaCta)) {
                                    accessImp.saveBeneficiarioCuenta(beneficiarioAperturaCta);
                                }
                            }

                            //Elimiar beneficiarios
                            for (BeneficiarioAperturaCta beneficiarioAperturaCta : listFind) {
                                if (!acsc.getBeneficiarioAperturaCtaList().contains(beneficiarioAperturaCta)) {
                                    accessImp.delete(beneficiarioAperturaCta);
                                }
                            }

                            generica.setbRta(Boolean.TRUE);
                            generica.setsMsj("Se actualizo la información correctamente.");
                        }

                    } else {
                        acsc.setfFechaNacimiento(new Date());
                        acsc.setITipoCondicion(new CondicionCuenta(Long.parseLong("1")));
                        AperturaCuentaSolCred cuentaSolCredSave = this.saveAperturaCuentaSolCred(acsc);
                        if (cuentaSolCredSave != null) {
                            aperturaCuentaSolCred = cuentaSolCredSave;

                            if (acsc.getBeneficiarioAperturaCtaList() != null && !acsc.getBeneficiarioAperturaCtaList().isEmpty()) {
                                for (BeneficiarioAperturaCta beneficiarioAperturaCta : acsc.getBeneficiarioAperturaCtaList()) {
                                    accessImp.saveBeneficiarioCuenta(beneficiarioAperturaCta);
                                }
                            }
                            generica.setbRta(Boolean.TRUE);
                            generica.setsMsj("Se guardo la información correctamente.");

                        }
                    }
                } else {
                    generica.setbRta(Boolean.FALSE);
                    generica.setsMsj("No se encontro solicitud con el número de registro " + acsc.getISolCredito().getINumRadic() + ".");
                }

            } else {
                generica.setbRta(Boolean.FALSE);
                generica.setsMsj("La informacion debe estar completa.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            generica.setbRta(Boolean.FALSE);
            generica.setsMsj("Se ha prensentado un problema por favor intente de nuevo.");
        }
        return generica;

    }
}
