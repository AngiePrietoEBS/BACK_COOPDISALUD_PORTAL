/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;


import WSAdminCoopedac.ResponseActividadEconomica;
import WSAdminCoopedac.ResponseTipoEstadoCivil;
import WSAdminCoopedac.ResponseCargo;
import WSAdminCoopedac.ResponseLineaCredito;
import WSAdminCoopedac.ResponseTiposIdent;
import WSAdminCoopedac.ResponseTipoContrato;
import WSAdminCoopedac.ResponseCiudad;
import WSAdminCoopedac.ResponseEntidad;
import WSAdminCoopedac.ResponseNivelesEstudio;
import WSAdminCoopedac.WSAdminCoopedac;
import WSAdminCoopedac.WSAdminCoopedacSoap;
import WSAdminCoopedac.ResponsePeriodo;
import WSAdminCoopedac.ResponseProfesion;
import com.ebssas.wsrestapicoopedac.domain.Entidad;
import com.ebssas.wsrestapicoopedac.response.ResponseEntidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
/**
 *
 * @author user
 */
public class ConsumoWSAdministracion {
    
    private final String sURL_WS;
    
    public ConsumoWSAdministracion(String xUrlWsWsdl) {
        this.sURL_WS = xUrlWsWsdl;
    }
    
    public ResponseTiposIdent wsTIPOSIDENTIFICACIONI() {
        ResponseTiposIdent response = new ResponseTiposIdent();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            response = port.wsTIPOSIDENTIFICACIONI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return response;
    }
    
    public ResponseTiposIdent wsTiposIdentById(int codigo) {
        
        ResponseTiposIdent responseTiposIdent = new ResponseTiposIdent();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseTiposIdent = port.wsTIPOSIDENTIFICACIONII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposIdent;
    }
    
    public ResponseLineaCredito wsLineaCredito() {
        ResponseLineaCredito responseLineaCredito = new ResponseLineaCredito();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            System.out.println("newEndpoint"+newEndpoint);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            System.out.println("qname"+qname);
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseLineaCredito = port.wsLINEASCREDITO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseLineaCredito;
    }
    
    public ResponseLineaCredito wsLineaCreditoById(String codLinea) {
        ResponseLineaCredito responseLineaCredito = new ResponseLineaCredito();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseLineaCredito = port.wsLINEACREDITOBYCOD(codLinea);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseLineaCredito;
    }
    
    public ResponsePeriodo wsPeriodos() {
        
        ResponsePeriodo responsePeriodo = new ResponsePeriodo();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responsePeriodo = port.wsPERIODO();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responsePeriodo;
    }
    
    public ResponsePeriodo wsPeriodosById(String id) {
        
        ResponsePeriodo responsePeriodo = new ResponsePeriodo();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responsePeriodo = port.wsPERIODOBYID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responsePeriodo;
    }
    
    public ResponseNivelesEstudio wsTIPOSNIVESTUDIOI() {
        ResponseNivelesEstudio response = new ResponseNivelesEstudio();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            response = port.wsTIPOSNIVESTUDIOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return response;
    }
    
    public ResponseNivelesEstudio wsTIPOSNIVESTUDIOII(int codigo) {
        
        ResponseNivelesEstudio responseTiposIdent = new ResponseNivelesEstudio();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseTiposIdent = port.wsTIPOSNIVESTUDIOII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposIdent;
    }
    
    public ResponseTipoContrato wsTIPOCONTRATOI() {
        ResponseTipoContrato response = new ResponseTipoContrato();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            response = port.wsTIPOCONTRATOI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return response;
    }
    
    public ResponseTipoContrato wsTIPOCONTRATOII(int codigo) {
        
        ResponseTipoContrato responseTiposContrado = new ResponseTipoContrato();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseTiposContrado = port.wsTIPOCONTRATOII(codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTiposContrado;
    }
    
    public ResponseCiudad wsCiudad() {
        
        ResponseCiudad response = new ResponseCiudad();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            response = port.wsCIUDADI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    public ResponseCiudad wsCiudadByParam(String xiCodigo, String nombre, String nivel, String xi_ind_nal, String xi_ind_internal, String xi_ubicacion) {
        
        ResponseCiudad response = new ResponseCiudad();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            response = port.wsCIUDADII(xiCodigo, nombre, nivel, xi_ind_nal, xi_ind_internal, xi_ubicacion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
    public ResponseEntidades wsEntidades() {
        ResponseEntidades resultado = new ResponseEntidades();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            ResponseEntidad r = port.wsENTIDADESI();
            resultado.bRta = r.isBRta();
            resultado.sMsj = r.getSMsjConsulta();
            
            // si agregan a este endpoint la posibilidad de consultar tambien
            // los códigos de entidad, corregir aquí y en el dto
            List<Entidad> l = new ArrayList<Entidad>();
            r.getLstEntidadBanco().getEntidadDTO().forEach(x->{
                Entidad e = new Entidad();
                e.descripcion = x.getSDesc();
                l.add(e);
            });
            resultado.setEntidades(l);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return resultado;
    }
    
    public ResponseCargo wsCargos() {
        ResponseCargo responseCargos = new ResponseCargo();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            System.out.println("newEndpoint"+newEndpoint);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            System.out.println("qname"+qname);
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseCargos = port.wsCARGOSI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseCargos;
    }
    
    public ResponseTipoEstadoCivil wsTiposEstadoCivil() {
        ResponseTipoEstadoCivil responseTipoEstadoCivil = new ResponseTipoEstadoCivil();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            System.out.println("newEndpoint"+newEndpoint);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            System.out.println("qname"+qname);
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseTipoEstadoCivil = port.wsTIPOESTADOCIVILI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseTipoEstadoCivil;
    }
    
    public ResponseProfesion wsProfesion() {
        ResponseProfesion responseProfesion = new ResponseProfesion();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            System.out.println("newEndpoint"+newEndpoint);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            System.out.println("qname"+qname);
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseProfesion = port.wsPROFESIONESI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseProfesion;
    }
    
    public ResponseActividadEconomica wsActividadEconomica() {
        ResponseActividadEconomica responseActividadEconomica = new ResponseActividadEconomica();
        
        try {
            URL newEndpoint = new URL(sURL_WS);
            System.out.println("newEndpoint"+newEndpoint);
            QName qname = new QName("https://www.ebssas.com/", "WSAdminCoopedac");
            System.out.println("qname"+qname);
            WSAdminCoopedac service = new WSAdminCoopedac(newEndpoint, qname);
            WSAdminCoopedacSoap port = service.getWSAdminCoopedacSoap();
            responseActividadEconomica = port.wsTIPOSACTECONOMICAI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseActividadEconomica;
    }
}
