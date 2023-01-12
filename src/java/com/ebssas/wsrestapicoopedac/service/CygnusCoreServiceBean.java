/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import WSCygnusCoopedac.PersonasDTO;
import com.ebssas.wsrestapicoopedac.request.RequestValidarPersona;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSCygnus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import com.ebssas.wsrestapicoopedac.seguridad.JwtTokenHelper;

/**
 *
 * @author Administrador
 */
public class CygnusCoreServiceBean implements CygnusCoreService {

    private final ParametroServiceBean parametroServiceBean = new ParametroServiceBean();
    private final String WS_CYGNUS = parametroServiceBean.obtenerParametroPorNombre("WS_CYGNUS");
    private final ConsumoWSCygnus wsCygnusCore = new ConsumoWSCygnus(WS_CYGNUS);

    //CAPA DE NEGOCIO
    private final JwtTokenHelper jwtTokenHelper = new JwtTokenHelper();


    @Override
    public List<PersonasDTO> wsConsultarPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        List<PersonasDTO> response = new ArrayList<>();
        try {
            System.out.println("--------------aqui es");
            System.out.println(xiCodigo +" "+ xiTipoIden + " "+ xcIdentificacion);
            response = wsCygnusCore.wcCONSULTARPERSONAS(xiCodigo, xiTipoIden, xcIdentificacion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public String getEmailPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sEmailPersona = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    sEmailPersona = personasDTO.getCEMail();
                    break;
                }
            }
        }
        return sEmailPersona;
    }

    @Override
    public String getTelPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sTelPersona = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    sTelPersona = personasDTO.getCTelefono();
                    break;
                }
            }
        }
        return sTelPersona;
    }

    @Override
    public String validarPersona(RequestValidarPersona rvp) {

        String rta = "";
        HashMap<String, Object> valToken = new HashMap<>();
        if (rvp.getTipoDocumento() != null && rvp.getDocumento() != null) {

            List<PersonasDTO> personaC = this.wsConsultarPersona("", rvp.getTipoDocumento(), rvp.getDocumento());
            String emailPersonaC = "";
            String celularPersonaC = "";
            if (personaC != null && !personaC.isEmpty()) {

                if (personaC.get(0).getCEstadoAct().equals("A")) {
                    for (PersonasDTO personasDTO : personaC) {
                        if (personasDTO.getCIdentificacion().equals(rvp.getDocumento())) {
                            emailPersonaC = personasDTO.getCEMail();
                            celularPersonaC = personasDTO.getCTelefono();
                            break;
                        }
                    }

                    if (emailPersonaC.contains("@") && celularPersonaC.length() == 10) {
                        valToken.put("bRta", true);
                        valToken.put("sMsj", "Persona registrada.");
                        valToken.put("mail", emailPersonaC);
                        valToken.put("celular", celularPersonaC);
                        rta = jwtTokenHelper.generateJwtTokenError(valToken);
                        JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                        rta = json.toString();
                    } else {
                        valToken.put("bRta", false);
                        valToken.put("sMsj", "La persona con número de identificación no cuenta con un medio de comunicación");
                        rta = jwtTokenHelper.generateJwtTokenError(valToken);
                        JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                        rta = json.toString();
                    }
                } else {
                    valToken.put("bRta", false);
                    valToken.put("sMsj", "La persona no cuenta con un estado Activo");
                    rta = jwtTokenHelper.generateJwtTokenError(valToken);
                    JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                    rta = json.toString();
                }

            } else {
                valToken.put("bRta", false);
                valToken.put("sMsj", "No se ha encontrado persona con identificación: " + rvp.getDocumento());
                rta = jwtTokenHelper.generateJwtTokenError(valToken);
                JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
                rta = json.toString();
            }

        } else {
            valToken.put("bRta", false);
            valToken.put("sMsj", "Todos los datos son necesarios para iniciar sesión");
            rta = jwtTokenHelper.generateJwtTokenError(valToken);
            JsonObject json = Json.createObjectBuilder().add("jwt", rta).build();
            rta = json.toString();
        }

        return rta;
    }

    @Override
    public Long getCodigoPersona(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        Long lCodigoPersona = null;
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    lCodigoPersona = Long.parseLong(personasDTO.getICodigo());
                    break;
                }
            }
        }
        return lCodigoPersona;
    }

    public String getNombre(String xiCodigo, String xiTipoIden, String xcIdentificacion) {
        String sNombresCompletos = "";
        List<PersonasDTO> consultaPersonaCore = this.wsConsultarPersona(xiCodigo, xiTipoIden, xcIdentificacion);
        if (consultaPersonaCore != null && !consultaPersonaCore.isEmpty()) {
            for (PersonasDTO personasDTO : consultaPersonaCore) {
                if (personasDTO.getCIdentificacion().equals(xcIdentificacion)) {
                    String sNombres = personasDTO.getCNombres() != null && !personasDTO.getCNombres().equals("") ? personasDTO.getCNombres() : "";
                    String sApellidos = personasDTO.getCApellidos() != null && !personasDTO.getCApellidos().equals("") ? personasDTO.getCApellidos() : "";
                    sNombresCompletos = sNombres + "-" + sApellidos;
                    break;
                }
            }
        }
        return sNombresCompletos;
    }

}
