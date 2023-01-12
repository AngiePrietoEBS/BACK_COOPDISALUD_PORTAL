package com.ebssas.wsrestapicoopedac.service;

import WSEstadoCuentaCoopedac.ArrayOfDato3DTO;
import WSEstadoCuentaCoopedac.DatoDTO;
import WSEstadoCuentaCoopedac.DetalleCta;
import WSEstadoCuentaCoopedac.Movimiento;
import WSSimuladorCreditoCoopedac.RespuestaValorDeuda;
import com.ebssas.wsrestapicoopedac.domain.Parametros;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCrearCtaAhorros;
import com.ebssas.wsrestapicoopedac.response.ResponseCreditoConCuota;
import com.ebssas.wsrestapicoopedac.response.ResponseDetalleCuenta;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIGeneric;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIIGeneric;
import com.ebssas.wsrestapicoopedac.response.ResponseEstadoCuentaIService;
import com.ebssas.wsrestapicoopedac.response.ResponseExtracto;
import com.ebssas.wsrestapicoopedac.response.ResponseListadoCuentas;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSCtasAhorro;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSCygnus;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSEstadoCuenta;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Andrés Sierra
 */
public class EstadoCuentaServiceBean extends Utilidad implements EstadoCuentaService {

    private List<Parametros> params;
    Parametros pBd;
    Parametros pUsu;
    Parametros pPsw;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String WSCLIENTE_ESTADO_CUENTA = parametroServiceBean.obtenerParametroPorNombre("WSCLIENTE_ESTADO_CUENTA");
    private final ConsumoWSEstadoCuenta wsEstadoCuenta = new ConsumoWSEstadoCuenta(WSCLIENTE_ESTADO_CUENTA);
    private final SimuladorCreditoServiceBean simuladorCreditoServiceBean = new SimuladorCreditoServiceBean();

    public EstadoCuentaServiceBean() {

        // andysierra <future>
        // En futuros proyectos, usar un singleton para guardar esta info en un principio y no reconsultar:
        ParametroServiceBean parametros = new ParametroServiceBean();
        this.params = parametros.findAllParams();

        this.pBd = this.findParam(this.params, "DB_BD_CORE");
        this.pUsu = this.findParam(this.params, "DB_SERVER_USERNAME_CORE");
        this.pPsw = this.findParam(this.params, "DB_SERVER_PASSWORD_CORE");
    }

    public ResponseEstadoCuentaIGeneric getEstadoCtaI(String ident, String tipoIdent) {
        ResponseEstadoCuentaIGeneric resultado = new ResponseEstadoCuentaIGeneric();
        List<ResponseEstadoCuentaIService> aux = new ArrayList<>();
        String isIndev = this.getValueConfigurePropByKey("INDEV");

        /*ConsumoWSEstadoCuenta wsEstadoCuenta = new ConsumoWSEstadoCuenta(
            new ParametroServiceBean().obtenerParametroPorNombre(isIndev.equals("1") ? "WS_CTASAHORRO_INDEV" : "WS_CTASAHORRO")
        );*/
        try {
            //ConsumoWSEstadoCuenta wsEstadoCuenta = new ConsumoWSEstadoCuenta("http://129.213.113.194/WSEstadoCuentaCoopedac/WSClientEstadoCuenta.asmx?wsdl");
            resultado.setbRta(true);
            resultado.setsMsj("");
            for (int i = 1; i <= 8; i++) {
                aux.add(wsEstadoCuenta.wcESTADOCUENTA(ident, tipoIdent, i));
            }
            resultado.setProductos(aux);

        } catch (Exception e) {
            resultado.setbRta(false);
            resultado.setsMsj("Se ha producido un error al consultar los registros");
            resultado.setProductos(null);
        }

        return resultado;
    }
    
    public List<DatoDTO> wsConsultarEstadoCuentaI(String tipoIdent, String identificacion, String producto) throws Exception {
        try {
            return wsEstadoCuenta.wcESTADOCUENTAIDATOS(identificacion, tipoIdent, producto);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public ResponseEstadoCuentaIIGeneric getEstadoCtaII(String radicado, String tipoProd) {
        ResponseEstadoCuentaIIGeneric resultado = new ResponseEstadoCuentaIIGeneric();
        Movimiento aux = new Movimiento();
        String isIndev = this.getValueConfigurePropByKey("INDEV");

        /*ConsumoWSEstadoCuenta wsEstadoCuenta = new ConsumoWSEstadoCuenta(
            new ParametroServiceBean().obtenerParametroPorNombre(isIndev.equals("1") ? "WS_CTASAHORRO_INDEV" : "WS_CTASAHORRO")
        );*/
        try {
            resultado.setbRta(true);
            resultado.setsMsj("");
            aux = wsEstadoCuenta.wcESTADOCUENTA_2(radicado, tipoProd);
            resultado.setProductos(aux);

        } catch (Exception e) {
            resultado.setbRta(false);
            resultado.setsMsj("Se ha producido un error al consultar los registros");
            resultado.setProductos(null);
        }

        return resultado;
    }
    
    public ResponseDetalleCuenta getDetalleCta(String radicado, String tipoProd) {
        ResponseDetalleCuenta resultado = new ResponseDetalleCuenta();
        DetalleCta aux = new DetalleCta();
        String isInDev = this.getValueConfigurePropByKey("INDEV");
        
        try {
            resultado.setbRta(true);
            resultado.setsMsj("");
            aux = wsEstadoCuenta.wcOBTENERDETALLECUENTA(radicado, tipoProd);
            resultado.setDetalleCta(aux);
            
        } catch (Exception e) {
            resultado.setbRta(false);
            resultado.setsMsj("Se ha producido un error al consultar los registros");
            resultado.setDetalleCta(null);
        }
        
        return resultado;
    }
    
    public ResponseExtracto getExtracto(String tipoIdent, String ident,  String producto) {
        ResponseExtracto resultado = new ResponseExtracto();
        ArrayOfDato3DTO aux = new ArrayOfDato3DTO();
        String isInDev = this.getValueConfigurePropByKey("INDEV");
        
        try {
            resultado.setbRta(true);
            resultado.setsMsj("");
            aux = wsEstadoCuenta.wcCONSULTAREXTRACTO(tipoIdent, ident, producto);
            resultado.setArrayOfDato3DTO(aux);
        } catch (Exception e) {
            resultado.setbRta(false);
            resultado.setsMsj("Se ha producido un error al consultar los registros");
            resultado.setArrayOfDato3DTO(null);
        }
        
        return resultado;
    }
    
    public List<DatoDTO> getCreditosCalculoPrimeraCuota(String tipoIdent, String identificacion, String tipoProducto) {
        List<DatoDTO> lstCreditos = new ArrayList<>();
        Date dateSystem = new Date();
        String sValorCuotaPago = "0";
        
        try {
            BigDecimal bdValorCuotaFinal = new BigDecimal(BigInteger.ZERO);
            List<DatoDTO> lstCreditosTemp = this.wsConsultarEstadoCuentaI(tipoIdent, identificacion, tipoProducto);
            
            if (lstCreditosTemp != null && !lstCreditosTemp.isEmpty()) {
                String sFechaSystem = this.dateFormat.format(dateSystem);
                BigDecimal bdValorCuotaTemp = new BigDecimal(BigInteger.ZERO);
                for (DatoDTO lstCredito : lstCreditosTemp) {
                    if (lstCredito.getRadicado() != null && !lstCredito.getRadicado().equals("")) {
                        DetalleCta detalleCtaCredito = this.getDetalleCta(lstCredito.getRadicado(), tipoProducto).getDetalleCta();
                        if (detalleCtaCredito != null && detalleCtaCredito.isBRtaConsulta()) {
                            if (detalleCtaCredito.getICuotaPag() == 0) {
                                sValorCuotaPago = this.simuladorCreditoServiceBean.getValorPrimeraCuota(identificacion, String.valueOf(detalleCtaCredito.getINumRadic()), String.valueOf(detalleCtaCredito.getICodDesti()), "1");
                                lstCredito.setValorpago(sValorCuotaPago);
                            } else {
                                RespuestaValorDeuda respuestaValorPago = this.simuladorCreditoServiceBean.consultaCuotaCreditoFecha(identificacion, String.valueOf(detalleCtaCredito.getINumRadic()), String.valueOf(detalleCtaCredito.getICodDesti()), sFechaSystem);
                                if (respuestaValorPago != null && respuestaValorPago.getMensaje() != null && !respuestaValorPago.getMensaje().isEmpty()) {
                                    if (respuestaValorPago.getMensaje().equals("SUCCESS")) {
                                        if (respuestaValorPago.getResultado() != null && !respuestaValorPago.getResultado().isEmpty() && !respuestaValorPago.getResultado().equals("0.00")) {
                                            String sValorCuota = respuestaValorPago.getResultado();
                                            bdValorCuotaTemp = new BigDecimal(sValorCuota);
                                            bdValorCuotaTemp = bdValorCuotaTemp.setScale(2, RoundingMode.HALF_UP);
                                            bdValorCuotaFinal = bdValorCuotaFinal.add(bdValorCuotaTemp);
                                            bdValorCuotaFinal = bdValorCuotaFinal.setScale(2, RoundingMode.HALF_UP);
                                            lstCredito.setValorpago(bdValorCuotaFinal.toString());
                                            bdValorCuotaFinal = new BigDecimal(BigInteger.ZERO);
                                        } else {
                                            lstCredito.setValorpago(detalleCtaCredito.getSValorCuota());
                                        }
                                    } else {
                                        lstCredito.setValorpago(detalleCtaCredito.getSValorCuota());
                                    }

                                } else {
                                    lstCredito.setValorpago(detalleCtaCredito.getSValorCuota());
                                }
                            }
                        }
                    }
                    lstCreditos.add(lstCredito);
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            lstCreditos = new ArrayList<>();
        }
        return lstCreditos;
    }
    
    public ResponseCreditoConCuota getCreditoConCuota(String tipoIdentificacion, String identificacion, String tipoProducto) {
        ResponseCreditoConCuota resultado = new ResponseCreditoConCuota();
        List<DatoDTO> aux;
        try {
            resultado.setbRta(true);
            resultado.setsMsj("");
            aux = this.getCreditosCalculoPrimeraCuota(tipoIdentificacion, identificacion, tipoProducto);
            resultado.setListDatoDTO(aux);
        } catch (Exception ex) {
            resultado.setbRta(false);
            resultado.setsMsj("Se ha producido un error al consultar los registros");
            resultado.setListDatoDTO(null);
        }
        return resultado;
    }

}
