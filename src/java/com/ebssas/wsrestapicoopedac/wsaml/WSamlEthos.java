package com.ebssas.wsrestapicoopedac.wsaml;

import wsamlcoopedac.DataPortType;
import wsamlcoopedac.Data_Impl;
import com.ebssas.wsrestapicoopedac.responseAML.AmlResponseDTO;
import com.google.gson.Gson;

public class WSamlEthos {

    public AmlResponseDTO generarPDF(String cIdentificacion, String cNombre, String cToken, String cNit) {
        AmlResponseDTO amlRta = null;
        String rta = "";
        try {
            Data_Impl dataImpAML = new Data_Impl();
            DataPortType portAML = dataImpAML.getDataPort();
            Gson g = new Gson();
            //"people";a:1:{i:0;a:2:{s:4:"name";s:18:"MARTA OFELIA VELEZ";s:6:"doc_id";s:8:"21265232";}}
            String serializable = "\"people\";a:1:{i:0;a:2:{s:4:\"name\";s:" + cNombre.length() + ":\"" + cNombre + "\";s:6:\"doc_id\";s:" + cIdentificacion.length() + ":\"" + cIdentificacion + "\";}}";
            String consulta = portAML.consulltaListas(serializable, cToken, cNit, "0");
            
            if (!consulta.contains("ERROR")) {
                rta = portAML.generarPDF(cIdentificacion, cNombre, cToken, cNit, "FALSE","FTP_COOPEDAC");
                amlRta = g.fromJson(rta, AmlResponseDTO.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return amlRta;
    }

//    public static void main(String[] args) {
//        WSamlEthos ws = new WSamlEthos();
//        AmlResponseDTO a = ws.generarPDF("3323620", "OSCAR JAVIER PINILLA TOVAR", "4QhrcBCwgLFx13tDGFwS7fhZr6S23I7v", "900.165.442-5");
//        if (a!=null) {
//            System.out.println("Buenas");
//        }
//    }
}
