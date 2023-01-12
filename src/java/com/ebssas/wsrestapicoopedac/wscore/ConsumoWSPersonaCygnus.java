/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;

import WSPersonasCygnus.RespuestaCrea;
import WSPersonasCygnus.RespuestaMenus;
import WSPersonasCygnus.WSPersonasCygnus;
import WSPersonasCygnus.WSPersonasCygnusSoap;
import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.request.RequestPersonaBasica;
import com.ebssas.wsrestapicoopedac.service.ParametroServiceBean;
import java.net.URL;
import java.util.Date;
import javax.xml.namespace.QName;

/**
 *
 * @author andre
 */
public class ConsumoWSPersonaCygnus {
    
    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String DB_BD_CORE = parametroServiceBean.obtenerParametroPorNombre("DB_BD_CORE");
    private final String DB_SERVER_USERNAME_CORE = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_USERNAME_CORE");
    private final String DB_SERVER_PASSWORD_CORE = parametroServiceBean.obtenerParametroPorNombre("DB_SERVER_PASSWORD_CORE");

    private final Utilidad util = new Utilidad();
    private final String sURL_WS;

    public ConsumoWSPersonaCygnus(String xUrlWsWsdl) {
        this.sURL_WS = xUrlWsWsdl;
    }

//    public String wsCREAPERSONABASICA(RequestPersonaBasica personaBasica) {
//
//        String tipoPer = personaBasica.getCTipoPersona();
//        String cIdentificacion = personaBasica.getCIdentificacion();
//        String cTipoIden = personaBasica.getCTipoIdentificacion();
//        String fFechaNacimiento = personaBasica.getFNacimiento() != null ? util.dateToStringFormatFechaMesDiaAnio(personaBasica.getFNacimiento()) : "";
//        String cNombres = personaBasica.getCNnombre();
//        String cApellidos = personaBasica.getCApellido();
//        String cDireccion = personaBasica.getCDireccion();
//        String cCodigoCiudadNac = personaBasica.getCCodigoCiudadNacimiento();
//        String cTelefono = personaBasica.getCTelefono();
//        String cEmail = personaBasica.getCCorreoElectronico();
//        String response = "";
//        try {
//            URL newEndpoint = new URL(sURL_WS);
//            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint);
//            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
//            //response = port.wcCREARPERSONABASICO("0", tipoPer, cIdentificacion, cTipoIden, fFechaNacimiento, cNombres, cApellidos, cDireccion, "", cTelefono, cEmail, DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
//            response = port.wcCREARPERSONABASICO("0", "", cIdentificacion, cTipoIden, "", cNombres, cApellidos, "", "", cTelefono, cEmail, DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
//        } catch (Exception ex) {
//            response = "Ocurrio un error en el proceso";
//            ex.printStackTrace();
//        }
//        return response;
//    }

    public String wsCREAPERSONACOMPLETA(RequestPersonaBasica personaBasica) {
        String tipoPer = personaBasica.getCTipoPersona();
        String cIdentificacion = personaBasica.getCIdentificacion();
        String cTipoIden = personaBasica.getCTipoIdentificacion();
        String cTipoCli = personaBasica.getCTipoCli();
        String cCodExpCiudad = personaBasica.getCCodExpCiudad();
        String cCodNacCiudad = personaBasica.getCCodigoCiudadNacimiento();
        String fExpDocumento = util.dateToStringFormatFechaMesDiaAnio(personaBasica.getFExpDocumento());
        String cNatResAux = personaBasica.getCNatResAux(); //1 si es residente
        String fInicioRes = util.dateToStringFormatFechaMesDiaAnio(personaBasica.getFInicioRes()); //Fecha de inicio de residencia desde. Forma de Fecha mm-dd-yyyy
        String cSexo = personaBasica.getCSexo();
        String cTesoro = personaBasica.getCTesoro();
        String cEstadoCivil = personaBasica.getCEstadoCivil();
        String cNumPersonasCargo = personaBasica.getCNumPersonasCargo();
        String cNatCla = ""; //Clave cygnus
        String cNatClaint = ""; //Clave Cygnus intenert.
        String cNatNroAct = ""; //Numero acto de creaciï¿½n
        String cCodOfi = personaBasica.getCCodOfi();
        String cNacionalidad = personaBasica.getCNacionalidad();
        String cNacionalidad2 = personaBasica.getCNacionalidad2();
        String cNumHijos = personaBasica.getCNumHijos();
        String cNatApellido1 = personaBasica.getCNatApellido1();
        String cNatApellido2 = personaBasica.getCNatApellido2();
        String cEstrato = personaBasica.getCEstrato();
        String cMujerCabFamilia = personaBasica.getCMujerCabFamilia();
        String cOperacionExt = personaBasica.getCOperacionExt(); //Valor registrado en Financiar 0-false
        String cCodResCiudad = personaBasica.getCCodResCiudad();
        String cEstadoAct = personaBasica.getCEstadoAct();
        String cVinculacionLab = personaBasica.getCVinculacionLab();
        String cAsesorCom = personaBasica.getCAsesorCom();
        String cSalario = personaBasica.getCSalario();
        String cNivelEstudio = personaBasica.getCNivelEstudio();
        String cProfesion = personaBasica.getCProfesion();
        String cCargo = personaBasica.getCCargo();
        String cTipoCont = personaBasica.getCTipoCont();
        String cModeloScoring = personaBasica.getCModeloScoring();
        String fFechaNacimiento = util.dateToStringFormatFechaMesDiaAnio(personaBasica.getFNacimiento());
        String cNombres = personaBasica.getCNnombre();
        String cApellidos = personaBasica.getCApellido();
        String cDireccion = personaBasica.getCDireccion();
        String cTelefono = personaBasica.getCTelefono();
        String cEmail = personaBasica.getCCorreoElectronico();
        String cRut = cIdentificacion;
        String response = "";
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("WSPersonasCygnus", "WSPersonasCygnus");
            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint, qname);
            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
            response = port.wcCREARPERSONAS(
                    "0",
                    tipoPer,
                    cIdentificacion, //NatCodaso
                    cIdentificacion,
                    cTipoCli, // pDfnNatTipcli
                    cTipoIden,
                    cCodExpCiudad,//cCodExpCiudad,
                    fExpDocumento,
                    cNombres,
                    cApellidos,
                    cCodNacCiudad,//cCodNacCiudad,
                    fFechaNacimiento, //fecha nacimiento
                    cNatResAux, //pCbsNatResAux,
                    fInicioRes, //pWDFecres,
                    cSexo,
                    cTesoro, //pSTesoro,
                    cEstadoCivil, //Estado civil **
                    cNumPersonasCargo,
                    cNatCla, //Natcla
                    cNatClaint, // NatClaInt
                    cNatNroAct, // Nroact
                    cRut, // NatRut
                    cCodOfi, // codOf
                    cNacionalidad, //Nacionalidad
                    cNacionalidad2, //Nacionalidad2
                    cNumHijos, //NroHijos
                    cNatApellido1, //Apellido1
                    cNatApellido2, // Apellido2
                    cEstrato, //cEstrato
                    cMujerCabFamilia, // pCbNatMujerFam
                    cOperacionExt, // pCbOperacionExt,
                    cEstadoAct, // pEstadoAct,
                    cDireccion, //dir
                    cCodResCiudad, // pWNCiudad,
                    cTelefono, //telefono
                    cEmail, //email
                    cVinculacionLab, //cVinculacionLab
                    cAsesorCom, //cAsesorCom
                    cSalario, //cSalario
                    cNivelEstudio, //cNivelEstudio
                    cProfesion, //cProfesion
                    cCargo, //cCargo,
                    cTipoCont, //cTipoCont
                    cModeloScoring, //cModeloScoring                    
                    DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public RespuestaCrea wsCREAROLPERSONA(String codPersona, String numRol, Date fechaInicio) {
        RespuestaCrea respuestaCrea = new RespuestaCrea();
        String cFechaInicio = util.dateToStringFormatFechaMesDiaAnio(fechaInicio);
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("WSPersonasCygnus", "WSPersonasCygnus");
            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint, qname);
            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
            respuestaCrea = port.wcCREARROLPERSONAS(codPersona, numRol, cFechaInicio, DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuestaCrea;
    }

//    public RespuestaGenerica wsCREAPARENTESCO(RequestParentesco parentesco) {
//        RespuestaGenerica respuesta = new RespuestaGenerica();
//        String codigoPersona = parentesco.getcCodigoPersona();
//        String codigoFamilia = parentesco.getcCodigoFamiliar();
//        String tipoParentesco = parentesco.getcParentesco();
//
//        String response = "";
//        try {
//            URL newEndpoint = new URL(sURL_WS);
//            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint);
//            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
//            response = port.wcCREARPARENTESCO(codigoPersona, codigoFamilia, tipoParentesco, DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
//            respuesta.setbRta(Boolean.TRUE);
//            respuesta.setsMsj(response);
//        } catch (Exception ex) {
//            respuesta.setbRta(Boolean.FALSE);
//            respuesta.setsMsj("Ocurrio un error en el proceso");
//            ex.printStackTrace();
//        }
//        return respuesta;
//    }

    public RespuestaMenus wsCONSULTATIPOVIVIENDA() {
        RespuestaMenus respuestaMenus = new RespuestaMenus();
        try {
            URL newEndpoint = new URL("http://150.136.154.156/WSPersonasCygnus/WSPersonasCygnus.asmx?WSDL");
            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint);
            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
            respuestaMenus = port.consultaTiposVivienda();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuestaMenus;
    }

//    public String wsCREARREFERENCIA(ReferenciaSolCredito referenciaItem, Long idPersonaSygnus) {
//        String respuesta = "";
//        try {
//            URL newEndpoint = new URL("http://150.136.154.156/WSPersonasCygnus/WSPersonasCygnus.asmx?WSDL");
//            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint);
//            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
//            String referencia = referenciaItem.getITipoReferencia().getCDescripcion();
//            String fecha = util.dateToStringFormatFechaMesDiaAnio(referenciaItem.getFFechaRegistro());
//            String parentesco = referenciaItem.getCParentesco() == null ? "X" : referenciaItem.getCParentesco();
//            String nombreApellido = referenciaItem.getCNombres() + " " + referenciaItem.getCApellidos();
//            String idcygnus = referenciaItem.getICodCygnus() == null ? "" : referenciaItem.getICodCygnus().toString();
//            String observacion = referenciaItem.getCObservaciones() == null ? "X" : referenciaItem.getCObservaciones();
//            String celular = referenciaItem.getCNumCelular() == null ? "0" : referenciaItem.getCNumCelular();
//            String telefono = referenciaItem.getCTelefono() == null ? "0" : referenciaItem.getCTelefono();
//            respuesta = port.wcCREARREFERENCIAS(
//                    "",
//                    fecha,
//                    idPersonaSygnus.toString(),
//                    referencia.substring(0, 1),//refencia
//                    nombreApellido,
//                    "vacio",
//                    celular,
//                    "",
//                    parentesco,
//                    telefono,
//                    observacion,
//                    DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            respuesta = "";
//        }
//        return respuesta;
//    }

    /**
     * Método que permite guardar Informacion del Solicitante.
     *
     * @return
     */
//    public Resultado wsALMACENASOLICITANTE(String psIdentificacion, String sActividad, String sEmpresa, String sFecIngreso, String sContrato, String sCargo, String sDirEmpresa, String sCiudadEmpresa, String sIngresoPrincipal, String sGastosObligaciones, String sOtrosIngresos, String sTotalActivos, String sTotalIngresomes, String sTotalPasivo, String sRenta, String sDeclaranteRenta, String sVivienda, String sPrendasVivienda, String sVehiculo, String sPrendasVehiculo, String sOtrosBienes, String sDescripcion, String sBarrio) {
//        Resultado resultado = new Resultado();
//        try {
//            URL newEndpoint = new URL("http://150.136.154.156/WSPersonasCygnus/WSPersonasCygnus.asmx?WSDL");
//            WSPersonasCygnus service = new WSPersonasCygnus(newEndpoint);
//            WSPersonasCygnusSoap port = service.getWSPersonasCygnusSoap();
//            resultado = port.wcALMACENARACTSOLICITANTE(
//                    psIdentificacion, //"13072110", 
//                    sActividad, //"1",
//                    sEmpresa, //"XXXX", 
//                    sFecIngreso, //"11-11-2011", 
//                    sContrato, //"1", 
//                    sCargo, // "1", 
//                    sDirEmpresa, //"CALLE25", 
//                    sCiudadEmpresa,//"52001",
//                    sIngresoPrincipal,//"100000",
//                    sGastosObligaciones, //"0", 
//                    sOtrosIngresos, // "0", 
//                    sTotalActivos,//"0",
//                    sTotalIngresomes,//"100000",
//                    sTotalPasivo,//"0",
//                    sRenta,//"0",
//                    sDeclaranteRenta, //"0",                   
//                    sVivienda,//"3",
//                    sPrendasVivienda, //"0", 
//                    sVehiculo, //"2", 
//                    sPrendasVehiculo, //"XXX", 
//                    sOtrosBienes, //"NO",
//                    sDescripcion, //Descripicion
//                    sBarrio, //"XXXDXXCX",
//                    DB_BD_CORE, DB_SERVER_USERNAME_CORE, DB_SERVER_PASSWORD_CORE);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return resultado;
//    }
//    
}
