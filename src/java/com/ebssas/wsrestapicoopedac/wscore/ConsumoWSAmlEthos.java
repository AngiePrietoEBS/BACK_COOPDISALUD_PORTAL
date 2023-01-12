/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.wscore;

import wsamlcoopedac.DataPortType;
import wsamlcoopedac.Data_Impl;
import com.co.ebs.coopechance.respuestasGenericas.AmlResponseDTO;
import com.ebssas.wsrestapicoopedac.responseAML.ResponseConsultaAML;
import com.ebssas.wsrestapicoopedac.service.GenerarPDFServiceImp;
//import com.co.ebs.financiar.response.DTO.AmlResponseDTO;
import com.google.gson.Gson;

/**
 *
 * @author Administrador
 */
public class ConsumoWSAmlEthos {
Gson g = new Gson();
    public ResponseConsultaAML consultaListasSoap(String nombre, String identificacion, String tipoConsulta) {
        String rta = "";
        ResponseConsultaAML consultaAML = null;
        try {
            String data = "\"people\";a:1:{i:0;a:2:{s:4:\"name\";s:" + nombre.length() + ":\"" + nombre + "\";s:6:\"doc_id\";s:" + identificacion.length() + ":\"" + identificacion + "\";}}";
            
            Data_Impl dataImpAML = new Data_Impl();
            DataPortType portAML = dataImpAML.getDataPort();
//            Gson g = new Gson();
            rta = portAML.consulltaListas(
                    data, 
                    "TJqJ5m6oriK1qCVDfqvR3LlN37XgFCVs", 
                    "900.165.442-5", 
                    "2");
            
            // andysierra log
            System.out.println("\n**********************************************");
            System.out.println("TEMP JSON AML");
            System.out.println(rta);
            System.out.println("\n");
            
            consultaAML = g.fromJson(rta, ResponseConsultaAML.class);

            //new GenerarPDFServiceImp().crearPDF(consultaAML);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(g.toJson(consultaAML));
        return consultaAML;
    }
    
//    public static void main(String[] args) {
//        ConsumoWSAmlEthos consumoWSAmlEthos = new ConsumoWSAmlEthos();
//        consumoWSAmlEthos.consultaListasSoap("Juan Pablo Valencia Quintero", "1022426702", "2");
//        consumoWSAmlEthos.generarPDF("1022426702", "Juan Pablo Valencia Quintero");
//    }
    
    public AmlResponseDTO generarPDF(String cIdentificacion,String cNombre){
        AmlResponseDTO amlRta =null;
        try {
            Data_Impl dataImpAML = new Data_Impl();
            DataPortType portAML =dataImpAML.getDataPort();
            Gson g= new Gson();
            String rta = portAML.generarPDF(
                    cIdentificacion,
                    cNombre, 
                    "TJqJ5m6oriK1qCVDfqvR3LlN37XgFCVs", 
                    "900.165.442-5",
                    "TRUE",
                    "FTP_COOPEDAC");
            amlRta = g.fromJson(rta, AmlResponseDTO.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return amlRta;
    }
}
