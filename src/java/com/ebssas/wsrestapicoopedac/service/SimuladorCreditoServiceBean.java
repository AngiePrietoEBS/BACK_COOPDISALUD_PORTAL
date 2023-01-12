/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;


import WSSimuladorCreditoCoopedac.LiquidacionAtr;
import WSSimuladorCreditoCoopedac.RespuestaAtr;
import WSSimuladorCreditoCoopedac.RespuestaCrea;
import WSSimuladorCreditoCoopedac.RespuestaCupo;
import WSSimuladorCreditoCoopedac.RespuestaValorDeuda;
import WSSimuladorCreditoCoopedac.WSSimuladorCreditoCoopedac;
import com.ebssas.wsrestapicoopedac.dataaccess.BancoRegistroDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.DocumentoFinanciero;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.request.RequestValidarLinea;
import com.ebssas.wsrestapicoopedac.response.ResponseCupoMaximo;
import com.ebssas.wsrestapicoopedac.response.ResponseSimuladorCredito;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSSimuladorCredito;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class SimuladorCreditoServiceBean implements SimuladorCreditoService {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String sBDCore = parametroServiceBean.obtenerParametroPorNombre("DB_BD_CORE");
    private final String sUserCore = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_USERNAME_CORE");
    private final String sPassCore = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_PASSWORD_CORE");
    private final WSSimuladorCreditoCoopedac wsSimuladorCredito = new WSSimuladorCreditoCoopedac();
    private final String WS_SIMULADOR = parametroServiceBean.obtenerParametroPorNombre("WS_SIM_CREDITO");
    private final ConsumoWSSimuladorCredito consumoWSSimuladorCredito;
    private AdminCoreServiceBean adminCoreServiceBean = new AdminCoreServiceBean();
    Utilidad util = new Utilidad();

    public SimuladorCreditoServiceBean() {
        this.consumoWSSimuladorCredito = new ConsumoWSSimuladorCredito(WS_SIMULADOR);
    }

    @Override
    public ResponseCupoMaximo calcularCupoMaximo(String pwsIdentific, String pwsCodCredi, String pwsFormPeriodic) {
        ResponseCupoMaximo responseCupoMaximo = new ResponseCupoMaximo();
        if (pwsCodCredi != null && !pwsCodCredi.equals("")) {
            String descPeriodicidad = this.adminCoreServiceBean.getDescPeriodo(pwsFormPeriodic);
            RespuestaCupo respuestaCupo = this.consumoWSSimuladorCredito.calculoCupos(pwsIdentific, pwsFormPeriodic, pwsCodCredi, pwsFormPeriodic, sBDCore, sUserCore, sPassCore);
            try {
                if (respuestaCupo != null && respuestaCupo.getRSMaxMonto() != null && !respuestaCupo.getRSMaxMonto().equals("")) {

                    // Armamos la respuesta:
                    responseCupoMaximo.setbRta(Boolean.TRUE);
                    responseCupoMaximo.setsCupoMaximo(util.valorPattern(respuestaCupo.getRSMaxMonto()));
                    responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
                    responseCupoMaximo.setsMsj("El plazo maximo asignado es de " + respuestaCupo.getRSMaxPlazo() + " meses. El cupo máximo asignado para su solictud es de $" + respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setsValorCuota(respuestaCupo.getRSValorCuota());
                } else {
                    responseCupoMaximo.setbRta(Boolean.FALSE);
                    responseCupoMaximo.setsMsj("El valor de la solicitud esta sujeto a verificaciÃ³n por parte de la entidad.");
                    responseCupoMaximo.setsCupoMaximo(respuestaCupo.getRSMaxMonto());
                    responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
//		    responseCupoMaximo.setsTasaInteres(respuestaCupo.getRSTfijos());

                }
            } catch (Exception e) {
                e.printStackTrace();
                responseCupoMaximo.setbRta(Boolean.FALSE);
                responseCupoMaximo.setsMsj("No se ha podido obtener el cupo mÃ¡ximo, por favor intente de nuevo.");
                responseCupoMaximo.setsCupoMaximo(respuestaCupo.getRSMaxMonto());
                responseCupoMaximo.setsPlazoMaximo(respuestaCupo.getRSMaxPlazo());
//		responseCupoMaximo.setsTasaInteres(respuestaCupo.getRSTfijos());
            }
        } else {
        }
//        System.out.println("++++responseCupoMaximo"+responseCupoMaximo);
        return responseCupoMaximo;
    }

    @Override
    public ResponseSimuladorCredito simuladorValorCuota(String pwsMonto, String pwsNroCuotas, String pwsValRecog, String pwsCodCredi, String pwsIdentific, String pwsFormPeriodic, String pwsValTf1, String pwsFecTf1, String pwsValTf2, String pwsFecTf2, String pwsValTf3, String pwsFecTf3, String pwsFormaPago) {
        ResponseSimuladorCredito responseSimuladorCredito = new ResponseSimuladorCredito();

        String sFechaActual = util.dateToStringFormatFechaMesDiaAnio(new Date());
//        System.out.println("sFechaSol" + sFechaActual);
//        System.out.println("numero de linea" + pwsCodCredi);

        int nuevaLinea = Integer.parseInt(pwsCodCredi);
//------------------Validacion de fecha actual-------------------------

        Utilidad util = new Utilidad();
        
        String newFecha = util.calcularFechaLinaCredito(sFechaActual, nuevaLinea);
        
        
        String sFechaSol = newFecha;
//        String[] partsFecha = sFechaSol.split("/");
//        System.out.println("fecha para enviar-->"+sFechaSol);

//------------------Validacion de fecha actual-------------------------
        String descPeriodicidad = this.adminCoreServiceBean.getDescPeriodo(pwsFormPeriodic);
        RespuestaAtr respuesta = this.consumoWSSimuladorCredito.liqSimuladorCreditoAtr(pwsMonto, pwsNroCuotas, sFechaSol, pwsValRecog, pwsCodCredi, pwsFormPeriodic, pwsIdentific, pwsFormPeriodic, pwsValTf1, pwsFecTf1, pwsValTf2, pwsFecTf2, pwsValTf3, pwsFecTf3, pwsFormaPago, sBDCore, sUserCore, sPassCore);
        if (respuesta.getRValCuota() != null && !respuesta.getRValCuota().equals("")) {
            responseSimuladorCredito.setbRta(Boolean.TRUE);
            responseSimuladorCredito.setsMsj("Se ha realizado correctamente la simulación del valor de la cuota.");
            String sValorCuotaAsoc = respuesta.getRValCuota();
            if (sValorCuotaAsoc != null && !sValorCuotaAsoc.equals("")) {
                if (sValorCuotaAsoc.contains(",")) {
                    sValorCuotaAsoc = sValorCuotaAsoc.replace(",", ".");
                }
            }
            if (respuesta.getRSTasa() != null && respuesta.getRSTasa() != "") {
                responseSimuladorCredito.setsTasa(respuesta.getRSTasa());

            }

            String sValorTasa = respuesta.getRSTasa();

            if (sValorTasa != null && sValorTasa != "") {
                if (sValorTasa.contains(",")) {
                    sValorTasa = sValorTasa.replace(",", ".");
                }

            }
            Double dValorTasa = new Double(sValorTasa);
            BigDecimal bdValorTasa = new BigDecimal(dValorTasa);
            bdValorTasa = bdValorTasa.setScale(4, RoundingMode.FLOOR);
            responseSimuladorCredito.setsTasa(String.valueOf(bdValorTasa));

            Double dValorCuota = new Double(sValorCuotaAsoc);
            BigDecimal bdValorCuota = new BigDecimal(dValorCuota);
            bdValorCuota = bdValorCuota.setScale(4, RoundingMode.HALF_EVEN);
            responseSimuladorCredito.setBdValorCuota(bdValorCuota);

            for (LiquidacionAtr liquidacion : respuesta.getRLiquidacion().getLiquidacionAtr()) {
                liquidacion.setNCapital(liquidacion.getNCapital().replaceAll(",00", ""));
                liquidacion.setNSalIni(liquidacion.getNSalIni().replaceAll(",00", ""));
                liquidacion.setNSalFin(liquidacion.getNSalFin().replaceAll(",00", ""));
                liquidacion.setNTotal(liquidacion.getNTotal().replaceAll(",00", ""));
                liquidacion.setNIntTf(liquidacion.getNIntTf().replaceAll(",00", ""));
                liquidacion.setNInt1(liquidacion.getNInt1().replaceAll(",00", ""));
                liquidacion.setNInt2(liquidacion.getNInt2().replaceAll(",00", ""));
                liquidacion.setNInt3(liquidacion.getNInt3().replaceAll(",00", ""));

            }

//            respuesta.getRLiquidacion().getLiquidacionAtr().forEach(liquidacion -> {
//                liquidacion.setNCapital(liquidacion.getNCapital().replaceAll(",00", ""));
//                liquidacion.setNSalIni(liquidacion.getNSalIni().replaceAll(",00", ""));
//                liquidacion.setNSalFin(liquidacion.getNSalFin().replaceAll(",00", ""));
//                liquidacion.setNTotal(liquidacion.getNTotal().replaceAll(",00", ""));
//                liquidacion.setNIntTf(liquidacion.getNIntTf().replaceAll(",00", ""));
//                liquidacion.setNInt1(liquidacion.getNInt1().replaceAll(",00", ""));
//                liquidacion.setNInt2(liquidacion.getNInt2().replaceAll(",00", ""));
//                liquidacion.setNInt3(liquidacion.getNInt3().replaceAll(",00", ""));
//            });
            responseSimuladorCredito.setrLiquidacion(respuesta.getRLiquidacion());
        } else {
            responseSimuladorCredito.setbRta(Boolean.FALSE);
            responseSimuladorCredito.setsMsj("No se ha obtenido ningun valor para la cuota. Intente cambiando los valores de periodicidad, plazo y valor de la solicitud.");
            Double dValorCuota = new Double(0.00);
            BigDecimal bdValorCuota = new BigDecimal(dValorCuota);
            bdValorCuota = bdValorCuota.setScale(4, RoundingMode.HALF_EVEN);
            responseSimuladorCredito.setBdValorCuota(bdValorCuota);
            if (respuesta.getRSTasa() != null && respuesta.getRSTasa() != "") {
                responseSimuladorCredito.setsTasa(respuesta.getRSTasa());
            }
        }
        return responseSimuladorCredito;
    }

    public RespuestaCrea crearCreditoCygnus(SolicitudCredito solicitudCredito, String estadoCredito) {
        RespuestaCrea response = new RespuestaCrea();
        String periodicidad = "";
        // 900 productividad Bimensual
        // 504 especial Semestrsl
        // Cambiar esto cuando llegue la otra linea
        if (solicitudCredito.getITipoCredito().getICodigo() == 504) {
            periodicidad = "Semestral";
        } else {
            periodicidad = "Bimensual";
        }
        BancoRegistroDataAccessImp documentoFinanciero = new BancoRegistroDataAccessImp();
        long identificacion = Long.parseLong(solicitudCredito.getIPersona().getCIdentificacion());
        DocumentoFinanciero cuentaRegistrada = documentoFinanciero.consultarBanco(identificacion, solicitudCredito.getINumRadic());
        String cuentaInternaDesembolso = "";
//        System.out.println("solicitudCredito.getIEstadoSolicitud().getICodigo()--->"+solicitudCredito.getIEstadoSolicitud().getICodigo());
//        System.out.println("--->"+cuentaRegistrada.getCNumcuenta().toString());
//        System.out.println("cuentaRegistrada.getCEntidadFin()--->"+cuentaRegistrada.getCEntidadFin());
        if (cuentaRegistrada.getCEntidadFin().equalsIgnoreCase("COPEDAC")) {
//            System.out.println("if 194");
            if (solicitudCredito.getIEstadoSolicitud().getICodigo() == 6) {
                cuentaInternaDesembolso = cuentaRegistrada.getCNumcuenta().toString();
            }
        }
        try {
//            System.out.println("cuenta desembolso" + cuentaInternaDesembolso);
//            String nomPlazo = this.adminCoreServiceBean.getDescPeriodo(solicitudCredito.getIPlazo().toString());
            String estadoSolicitudCredito = Character.toString(solicitudCredito.getIEstadoSolicitud().getCDescripcion().charAt(0));
            response = this.consumoWSSimuladorCredito.creaCredito(
                    solicitudCredito.getNMontoSolicitado().toString(),
                    solicitudCredito.getIPlazo().toString(),
                    util.dateToStringFormatFechaMesDiaAnio(solicitudCredito.getFFechaSolicitud()),
                    "0", //Val_recog                    
                    solicitudCredito.getITipoCredito().getICodigo().toString(),
                    periodicidad,
                    solicitudCredito.getIPersona().getCIdentificacion(),
                    periodicidad,
                    "0", "", "0", "", "0", "",
                    solicitudCredito.getINumRadic(),
                    estadoCredito,
                    estadoSolicitudCredito,
                    "", //Descripcion
                    cuentaInternaDesembolso, //
                    "NOMINA", //
                    sBDCore,
                    sUserCore,
                    sPassCore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public boolean permiteCredito(String cIdentificacion, String cCodLinea) {

        boolean permite = false;

        if (cCodLinea != null && cIdentificacion != null) {
            // 1 permite el crédito 0 No permite
            permite
                    = this.consumoWSSimuladorCredito.permiteCredito(
                            cIdentificacion,
                            cCodLinea,
                            sBDCore,
                            sBDCore,
                            sBDCore).getRSRespuesta().equals("1");
        }
        return permite;
    }
    
    public String getValorPrimeraCuota(String psIdentificacion, String psNumRadic, String psCodDesti, String psNumCuotas) {
        String sValPrimeraCuota = "0";
        BigDecimal bdValorCuotaFinal = new BigDecimal(BigInteger.ZERO);

        RespuestaValorDeuda respuestaValorDeuda = this.consumoWSSimuladorCredito.wsConsultaPrimeraCuotaCredito(psIdentificacion, psNumRadic, psCodDesti, psNumCuotas, sBDCore, sUserCore, sPassCore);
        if (respuestaValorDeuda != null && respuestaValorDeuda.getMensaje().equals("")) {
            BigDecimal bdValorCuotaTemp = new BigDecimal(BigInteger.ZERO);
                    String sNValorCuota = respuestaValorDeuda.getResultado();
                    bdValorCuotaTemp = new BigDecimal(sNValorCuota);
                    bdValorCuotaTemp = bdValorCuotaTemp.setScale(2, RoundingMode.HALF_UP);
                    bdValorCuotaFinal = bdValorCuotaFinal.add(bdValorCuotaTemp);
                    bdValorCuotaFinal = bdValorCuotaFinal.setScale(2, RoundingMode.HALF_UP);
            sValPrimeraCuota = bdValorCuotaFinal.toString();
        } else {
            sValPrimeraCuota = "0";
        }
        return sValPrimeraCuota;
    }
    
    public RespuestaValorDeuda consultaCuotaCreditoFecha(String psIdentificacion, String pwsNumRadic, String pwsCodDesti, String pwsFechaPag) {
        RespuestaValorDeuda respuestaValorDeuda;
        respuestaValorDeuda = this.consumoWSSimuladorCredito.wsConsultaCuotaCreditoFecha(psIdentificacion, pwsNumRadic, pwsCodDesti, pwsFechaPag, sBDCore, sUserCore, sPassCore);
        return respuestaValorDeuda;
    }
       

    public static void main(String[] args) {

        String sFechaSol = "04/02/2022";
        int pwsCodCredi = 504;

        Utilidad util = new Utilidad();

        String nuevaFecha = util.calcularFechaLinaCredito(sFechaSol, pwsCodCredi);

//        System.out.println("Fecha nueva -->"+nuevaFecha);
    }

}
