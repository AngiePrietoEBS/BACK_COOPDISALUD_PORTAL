/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.cifin.InformacionComercial;
import com.ebssas.wsrestapicoopedac.dataaccess.ConsultaCifinDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.ConsultaCifin;
import com.ebssas.wsrestapicoopedac.request.RequestCifin;
import com.ebssas.wsrestapicoopedac.response.ResponseCifin;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Administrador
 */
public class ConsultaCifinServiceImp implements ConsultaCifinService{
    
    private InformacionComercial infoComercial = new InformacionComercial();

    @Override
    public ResponseCifin consultarPuntajeScore(RequestCifin requestCifin) {
        ResponseCifin response = new ResponseCifin();
        try {
            String jsonConsulta = infoComercial.consultarInfoComercial(requestCifin);
            if (jsonConsulta != "") {
                response.setFlag(true);
                response.setsMsg("Consulta exitosa");
                response.setxData(jsonConsulta);
            } else {
                response.setFlag(false);
                response.setsMsg("Ha ocurrido un error al intentar consultar el puntaje");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setFlag(false);
            response.setsMsg("Ha ocurrido un error al intentar consultar el puntaje");
        }
        return response;
    }

    /**
     * Lo que esta en comentarios es por si en algún momento se pide validar la consulta con la BD antes 
     * de realizar una nueva
     * @param requestCifin
     * @return 
     */
    @Override
    public ResponseCifin validarConsultaScore(RequestCifin requestCifin) {
        ResponseCifin response = new ResponseCifin();
        try {
            ConsultaCifinDataAccessImp consultaCifinDataAccessImp = new ConsultaCifinDataAccessImp();
            List<ConsultaCifin> listaConsulta = consultaCifinDataAccessImp.findByTipoIdentAndIdent(requestCifin.getTipoIdentificacion(), requestCifin.getNumIdentificacion());
            if (listaConsulta == null || listaConsulta.isEmpty()) {
                response = this.consultarPuntajeScore(requestCifin);
                if (response.isFlag()) {
                    ConsultaCifin registroBD = new ConsultaCifin();
                    registroBD.setITipoIdent(Long.parseLong(requestCifin.getTipoIdentificacion()));
                    registroBD.setCIdent(requestCifin.getNumIdentificacion());
                    registroBD.setFFecConsulta(new Date());
                    registroBD.setCRespuesta(response.getxData());
                    consultaCifinDataAccessImp.saveConsumo(registroBD);
                    response.setPuntajeCifin(obtenerScoreDesdeJson(response.getxData()));
                    System.out.println(response.getxData());
                }
                return response;
           } else {
                ConsultaCifin consumoRealizado = listaConsulta.get(0);
                response.setFlag(true);
                response.setsMsg("Consulta encontrada correctamente");
                response.setPuntajeCifin(obtenerScoreDesdeJson(consumoRealizado.getCRespuesta()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setFlag(false);
            response.setsMsg("Ha ocurrido un error al intentar consultar el puntaje");
        }
        return response;
    }

    public String obtenerScoreDesdeJson(String json) {
        String rta = "";
        try {
            JSONObject raiz = new JSONObject(json);
            JSONObject jsonCifin = raiz.getJSONObject("CIFIN").getJSONObject("Tercero").getJSONObject("Score");
            rta = jsonCifin.getString("Puntaje");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rta;
    }

//    public static void main(String[] args) {
//        ConsultaCifinServiceImp con = new ConsultaCifinServiceImp();
//        RequestCifin re = new RequestCifin();
//        re.setNumIdentificacion("19196148");
//        re.setTipoIdentificacion("1");
//        ResponseCifin res = con.validarConsultaScore(re);
//        System.out.println(res.isFlag());
//        System.out.println(res.getsMsg());
//        System.out.println(res.getPuntajeCifin());
//    }

    
}
