/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.dataaccess.PersonaDataAccessImp;
import com.ebssas.wsrestapicoopedac.domain.Ciudad;
import com.ebssas.wsrestapicoopedac.domain.DatosPersonales;
import com.ebssas.wsrestapicoopedac.domain.Departamento;
import com.ebssas.wsrestapicoopedac.domain.InformacionDesembolso;
import com.ebssas.wsrestapicoopedac.domain.OcupacionPersona;
import com.ebssas.wsrestapicoopedac.domain.OperacionFinanciera;
import com.ebssas.wsrestapicoopedac.domain.Persona;
import com.ebssas.wsrestapicoopedac.domain.PersonaCygnus;
import com.ebssas.wsrestapicoopedac.domain.SolicitudCredito;
import com.ebssas.wsrestapicoopedac.request.RequestDatosPersona;
import com.ebssas.wsrestapicoopedac.request.RequestPersonaBasica;
import com.ebssas.wsrestapicoopedac.response.RespuestaCreaPersona;
import com.ebssas.wsrestapicoopedac.response.RespuestaGenerica;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSCygnus;
import com.ebssas.wsrestapicoopedac.wscore.ConsumoWSPersonaCygnus;
import java.util.ArrayList;


import java.io.StringReader;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oracle.sql.DATE;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
/**
 *
 * @author Administrador
 */
public class PersonaServiceBean implements PersonaService {

    private PersonaDataAccessImp personaDataAccessImp = new PersonaDataAccessImp();
    private DatosPersonalesSolCredServiceBean datosPersonalesSolCredServiceBean = new DatosPersonalesSolCredServiceBean();
    private OcupacionPersonaServiceBean ocupacionPersonaServiceBean = new OcupacionPersonaServiceBean();
    private OperacionFinancieraServiceBean operacionFinancieraServiceBean = new OperacionFinancieraServiceBean();
    private InformacionDesembolsoServiceBean informacionDesembolsoServiceBean = new InformacionDesembolsoServiceBean();
    private final ConsumoWSPersonaCygnus consumoWSPersonaCygnus;
    
    public PersonaServiceBean() {
        //this.consumoWSPersonaCygnus = new ConsumoWSPersonaCygnus("http://150.136.154.156/WSPersonasCygnus/WSPersonasCygnus.asmx?WSDL");
        this.consumoWSPersonaCygnus = new ConsumoWSPersonaCygnus("http://129.158.242.142/WSPersonasCygnus_coopedac/WsPersonasCygnus.asmx?WSDL");
        //this.consumoWSCygnus = new ConsumoWSCygnus("http://150.136.154.156/WSCygnusYamaha/WSClientCygnus.asmx?WSDL");
    }
    
    @Override
    public Persona personaWebFindByCIdentificacion(int xiTipoIden, String C_IDENTIFICACION) {

        Persona personaWeb = personaDataAccessImp.personaWebFindByCIdentificacion(xiTipoIden, C_IDENTIFICACION);

        return personaWeb;
    }

    @Override
    public Persona personaWebFindByCIdentificacionAndPerfil(int iPerfil, int xiTipoIden, String C_IDENTIFICACION) {

        Persona personaWeb = personaDataAccessImp.personaWebFindByCIdentificacionAndPerfil(iPerfil, xiTipoIden, C_IDENTIFICACION);

        return personaWeb;
    }

    @Override
    public Persona personaWebFindByID(Long xiCodPersona) {
        Persona personaWeb = personaDataAccessImp.personaWebFindByID(xiCodPersona);
        return personaWeb;
    }

    public RespuestaGenerica saveDatosPersona(RequestDatosPersona datosPersona) {
        RespuestaGenerica respuestaGenerica = new RespuestaGenerica();

        try {
            if (datosPersona.getDatosPersonales() != null && datosPersona.getOcupacionPersona() != null && datosPersona.getOperacionFinanciera() != null && datosPersona.getsNumRadicSolCred() != null) {
                SolicitudCredito sc = new SolicitudCreditoServiceBean().findSolCreditoByRadicado(datosPersona.getsNumRadicSolCred());

                if (sc.getICodigo() != null) {
                    ArrayList<Boolean> resultados = new ArrayList<>();

                    DatosPersonales buscarDP = this.datosPersonalesSolCredServiceBean.findDatosPersonalesByPersona(sc.getIPersona().getICodigo());
                    if (buscarDP.getICodigo() != null) {
                        datosPersona.getDatosPersonales().setICodigo(buscarDP.getICodigo());
                        DatosPersonales datosPersonalesU = this.datosPersonalesSolCredServiceBean.updateDatosPersonales(datosPersona.getDatosPersonales());
                        if (datosPersonalesU != null) {
                            resultados.add(Boolean.TRUE);
                        } else {
                            resultados.add(Boolean.FALSE);
                        }
                    } else {
                        DatosPersonales datosPersonalesSave = new DatosPersonalesSolCredServiceBean().saveDatosPersonales(datosPersona.getDatosPersonales());
                        if (datosPersonalesSave != null) {
                            resultados.add(Boolean.TRUE);
                        } else {
                            resultados.add(Boolean.FALSE);
                        }
                    }
                    OcupacionPersona buscarOP = this.ocupacionPersonaServiceBean.findOcupacionPersonaByPersona(sc.getIPersona().getICodigo());
                    if (buscarOP.getICodigo() != null) {
                        datosPersona.getOcupacionPersona().setICodigo(buscarOP.getICodigo());
                        OcupacionPersona ocupacionPersonaU = this.ocupacionPersonaServiceBean.updateOcupacionPersona(buscarOP);
                        if (ocupacionPersonaU != null) {
                            resultados.add(Boolean.TRUE);
                        } else {
                            resultados.add(Boolean.FALSE);
                        }
                    } else {
                        OcupacionPersona ocupacionPersonaSave = new OcupacionPersonaServiceBean().saveOcupacionPersona(datosPersona.getOcupacionPersona());
                        if (ocupacionPersonaSave != null) {
                            resultados.add(Boolean.TRUE);
                        } else {
                            resultados.add(Boolean.FALSE);
                        }
                    }
                    OperacionFinanciera buscarOF = this.operacionFinancieraServiceBean.findOperacionFinancieraByPersona(sc.getIPersona().getICodigo());
                    if (buscarOF.getICodigo() != null) {
                        datosPersona.getOperacionFinanciera().setICodigo(buscarOF.getICodigo());
                        OperacionFinanciera operacionFinancieraU = this.operacionFinancieraServiceBean.updateOperacionFinanciera(datosPersona.getOperacionFinanciera());
                        if (operacionFinancieraU != null) {
                            resultados.add(Boolean.TRUE);
                        } else {
                            resultados.add(Boolean.FALSE);
                        }
                    } else {
                        OperacionFinanciera operacionFinancieraSave = new OperacionFinancieraServiceBean().saveOperacionFinanciera(datosPersona.getOperacionFinanciera());
                        if (operacionFinancieraSave != null) {
                            resultados.add(Boolean.TRUE);
                        } else {
                            resultados.add(Boolean.FALSE);
                        }
                    }

//                    if (datosPersona.getsInformacionDesembolso().equalsIgnoreCase("S")) {
//                        InformacionDesembolso buscarID = this.informacionDesembolsoServiceBean.findInformacionDesembolsoBySolCred(sc.getICodigo());
//                        if (buscarID.getICodigo() != null) {
//                            datosPersona.getInformacionDesembolso().setICodigo(buscarID.getICodigo());
//                            InformacionDesembolso informacionDesembolsoU = this.informacionDesembolsoServiceBean.updateInformacionDesembolso(datosPersona.getInformacionDesembolso());
//                            if (informacionDesembolsoU.getICodigo() != null) {
//                                resultados.add(Boolean.TRUE);
//                            } else {
//                                resultados.add(Boolean.FALSE);
//                            }
//
//                        } else {
//                            datosPersona.getInformacionDesembolso().setISolCredito(datosPersona.getSolicitudCredito());
//                            InformacionDesembolso informacionDesembolsoSave = this.informacionDesembolsoServiceBean.saveInformacionDesembolso(datosPersona.getInformacionDesembolso());
//                            if (informacionDesembolsoSave.getICodigo() != null) {
//                                resultados.add(Boolean.TRUE);
//                            } else {
//                                resultados.add(Boolean.FALSE);
//                            }
//                        }
//                    }

                    if (!resultados.contains(Boolean.FALSE)) {
                        respuestaGenerica.setbRta(Boolean.TRUE);
                        respuestaGenerica.setiCodigo(1);
                        respuestaGenerica.setsMsj("Se actualizaron los datos exitosamente, puede continuar con la solicitud.");
                    } else {
                        respuestaGenerica.setbRta(Boolean.FALSE);
                        respuestaGenerica.setiCodigo(1);
                        respuestaGenerica.setsMsj("Se presento un problema al actualizar los datos, por favor intente de nuevo. Si el problema persiste comuniquese con la entidad.");
                    }
                } else {
                    respuestaGenerica.setbRta(Boolean.FALSE);
                    respuestaGenerica.setsMsj("No se encontró solicitud de crédito con el numero de solicitud " + datosPersona.getsNumRadicSolCred());
                }
            } else {
                respuestaGenerica.setbRta(Boolean.FALSE);
                respuestaGenerica.setsMsj("Todos los campos son obligatorios.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuestaGenerica.setbRta(Boolean.FALSE);
            respuestaGenerica.setiCodigo(1);
            respuestaGenerica.setsMsj("Se presento un problema al actualizar los datos, por favor intente de nuevo. Si el problema persiste comunoquese con la entidad..");
        }

        return respuestaGenerica;
    }

    public RespuestaCreaPersona guardarPersonaCompleta(RequestDatosPersona datosPersona) {
        RequestPersonaBasica personaBasica = new RequestPersonaBasica();
        PersonaCygnus personaCygnus = new PersonaCygnus();
        RespuestaGenerica respuestaGenerica = new RespuestaGenerica();
        RespuestaCreaPersona respuestaCreaPersona = new RespuestaCreaPersona();
//        SolicitudCreditoServiceBean solicitudCreditoServiceBean = new SolicitudCreditoServiceBean();

        //Departamento departamento = solicitudCreditoServiceBean.mapearDepartamento(datosPersona.getDatosPersonales().getCDepartamentoExp());
        Ciudad ciudad = new Ciudad();
//        if (departamento != null) {
//            ciudad = solicitudCreditoServiceBean.mapearCiudad(datosPersona.getDatosPersonales().getCCiudadExp(), departamento.getICodigo());
//            System.out.println("Depratmaento: " + departamento.getCDepartamento());
//            System.out.println("Depratmaento: " + ciudad.getCCiudad());
//            datosPersona.getDatosPersonales().setICiudadExp(ciudad);
//            datosPersona.getDatosPersonales().setIDepartamentoExp(departamento);
//            if (ciudad.getICodigo() == null) {
//                DepartamentoDataAccessImp departamentoDataAccessImp = new DepartamentoDataAccessImp();
//                Departamento departamentoPorDefecto = new Departamento();
//                //SE AGREGA DEPARTAMENTO POR DEFECTO AL NO SER MAPEADO DENTRO DEL LISTADO DE LA BD WLO
//                departamentoPorDefecto = departamentoDataAccessImp.findDepartamentoById(Long.valueOf(100000));
//                //SE AGREGA CIUDAD POR DEFECTO AL NO SER MAPEADO DENTRO DEL LISTADO DE LA BD WLO
//                CiudadDataAccessImp ciudadDataAccessImp = new CiudadDataAccessImp();
//                Ciudad ciudadPorDefecto = new Ciudad();
//                ciudadPorDefecto = ciudadDataAccessImp.findCiudadById(Long.valueOf(100000));
//                datosPersona.getDatosPersonales().setICiudadExp(ciudadPorDefecto);
//                datosPersona.getDatosPersonales().setIDepartamentoExp(departamentoPorDefecto);
//            }
//        } else {
//            DepartamentoDataAccessImp departamentoDataAccessImp = new DepartamentoDataAccessImp();
//            Departamento departamentoPorDefecto = new Departamento();
//            //SE AGREGA DEPARTAMENTO POR DEFECTO AL NO SER MAPEADO DENTRO DEL LISTADO DE LA BD WLO
//            departamentoPorDefecto = departamentoDataAccessImp.findDepartamentoById(Long.valueOf(100000));
//            //SE AGREGA CIUDAD POR DEFECTO AL NO SER MAPEADO DENTRO DEL LISTADO DE LA BD WLO
//            CiudadDataAccessImp ciudadDataAccessImp = new CiudadDataAccessImp();
//            Ciudad ciudadPorDefecto = new Ciudad();
//            ciudadPorDefecto = ciudadDataAccessImp.findCiudadById(Long.valueOf(100000));
//            datosPersona.getDatosPersonales().setICiudadExp(ciudadPorDefecto);
//            datosPersona.getDatosPersonales().setIDepartamentoExp(departamentoPorDefecto);
//        }
        personaBasica.setCTipoPersona("N");
        personaBasica.setCIdentificacion(datosPersona.getPersona().getCIdentificacion());
        personaBasica.setCTipoIdentificacion(datosPersona.getPersona().getITipoIdent().toString());
        
//        personaBasica.setFNacimiento(datosPersona.getDatosPersonales().getFNacimiento()); //andres toca crear campo en db
        personaBasica.setFNacimiento(new Date()); //andres toca crear campo en db
        
        personaBasica.setCNnombre(datosPersona.getPersona().getCNombres());
        personaBasica.setCApellido(datosPersona.getPersona().getCApellidos());
        personaBasica.setCDireccion(datosPersona.getDatosPersonales().getCDireccionResidencia());
        personaBasica.setCTelefono(datosPersona.getDatosPersonales().getCNumCelular());
        personaBasica.setCCorreoElectronico(datosPersona.getDatosPersonales().getCEmail());
//        personaBasica.setCTipoCli(datosPersona.getOcupacionPersona().getITipoCliente().getICodigo().toString()); andres
        personaBasica.setCCodExpCiudad(datosPersona.getDatosPersonales().getICiudadResidencia().toString());
        personaBasica.setCCodExpCiudad(ciudad.getICodigo() == null ? datosPersona.getDatosPersonales().getICiudadResidencia().toString() : ciudad.getICodigo().toString());
        personaBasica.setCCodigoCiudadNacimiento(datosPersona.getDatosPersonales().getICiudadResidencia().toString());
//        personaBasica.setFExpDocumento(datosPersona.getDatosPersonales().getFNacimiento());
        personaBasica.setFExpDocumento(new Date());//andres modificar
        personaBasica.setCNatResAux("");
//        personaBasica.setFInicioRes(datosPersona.getDatosPersonales().getFNacimiento());
        personaBasica.setFInicioRes(new Date());//andres modificar
        personaBasica.setCSexo("F");//agregar a uno de los objetos de la lista que llama
        personaBasica.setCTesoro("");
        personaBasica.setCEstadoCivil(datosPersona.getDatosPersonales().getCEstadoCivil().toString());
        personaBasica.setCNumPersonasCargo(datosPersona.getDatosPersonales().getNPersonasCargo().toString());
        personaBasica.setCCodOfi("");
        personaBasica.setCNacionalidad("57");
        personaBasica.setCNacionalidad2("");
        personaBasica.setCNumHijos("");
        personaBasica.setCNatApellido1(datosPersona.getPersona().getCApellidos());
        personaBasica.setCNatApellido2("");
        personaBasica.setCEstrato(datosPersona.getDatosPersonales().getIEstrato().toString());
        personaBasica.setCMujerCabFamilia("");
        personaBasica.setCOperacionExt("");
        personaBasica.setCCodResCiudad(datosPersona.getDatosPersonales().getICiudadResidencia().toString());
        personaBasica.setCEstadoAct("A");
        personaBasica.setCVinculacionLab("");
        personaBasica.setCAsesorCom(datosPersona.getCIdentificacionVendedor());
        personaBasica.setCSalario("");
        personaBasica.setCNivelEstudio(datosPersona.getDatosPersonales().getINivelEstudio().toString());
        personaBasica.setCProfesion(datosPersona.getOcupacionPersona().getITipoOcupacion().toString());
        personaBasica.setCCargo("");
        personaBasica.setCTipoCont(datosPersona.getOcupacionPersona().getITipoContrato().toString() == "0" || datosPersona.getOcupacionPersona().getITipoContrato().toString().equals("") ? "" : datosPersona.getOcupacionPersona().getITipoContrato().toString()); //Andres tipo de contrato
        personaBasica.setCModeloScoring("");
        personaBasica.setCRut("");
//        String iTipoCliente = datosPersona.getOcupacionPersona().getITipoCliente().toString; andres 
//        String rol = "0";
//        switch (iTipoCliente) {
//            case "13":
//                rol = "2";
//                break;
//            case "14":
//                rol = "4";
//                break;
//            case "15":
//                rol = "3";
//                break;
//            case "17":
//                rol = "7";
//                break;
//            default:
//                rol = "2";
//        }

        try {
            String respuesta = this.consumoWSPersonaCygnus.wsCREAPERSONACOMPLETA(personaBasica);
            Document doc = convertStringToXMLDocument(respuesta);
            String resultado = doc.getElementsByTagName("Resultado").item(0).getTextContent();
            String mensaje = doc.getElementsByTagName("MensajeError").item(0).getTextContent();
            String codigo = doc.getElementsByTagName("CodigoCygnus").item(0).getTextContent();
            personaCygnus.setCodigoCygnus(codigo);
            personaCygnus.setMensajeError(mensaje);
            personaCygnus.setResultado(resultado);
            respuestaGenerica.setiCodigo(1);
            respuestaGenerica.setbRta(Boolean.TRUE);
            respuestaGenerica.setsMsj("Registro realizado con Éxito en CYGNUS y YAMAHA.");
            String mensajeRespuesta = personaCygnus.getMensajeError();
            if (mensajeRespuesta.substring(0, 1).equals("1")) {
                //Permite crear el rol en CYGNUS 
//                if (datosPersona.getOcupacionPersona().getIAntiguedad().equals(1)) {
//                    rol = "7";
//                }
//                RespuestaGenerica respuestaCrearRolPersona = this.guardarRolPersona(codigo, rol);
//                if (respuestaCrearRolPersona.getbRta()) {
//                    //permite crear la persona en bd yamaha    
//                    datosPersona.getPersona().setNCodigoCygnus(codigo);
//                    RespuestaGenerica respuestaCrearDatosPersona = this.guardarDatosPersona(datosPersona);
//                    if (respuestaCrearDatosPersona.getbRta()) {
//                        respuestaCreaPersona.setbRta(respuestaCrearDatosPersona.getbRta());
//                        respuestaCreaPersona.setiCodigo(respuestaCrearDatosPersona.getiCodigo());
//                        respuestaCreaPersona.setsMsj(respuestaCrearDatosPersona.getsMsj());
//                        respuestaCreaPersona.setNCodigoCygnus(codigo);
//                        return respuestaCreaPersona;
//                    } else {
//                        respuestaCreaPersona.setiCodigo(0);
//                        respuestaCreaPersona.setNCodigoCygnus("0");
//                        respuestaCreaPersona.setsMsj("Se ha presentado un error al guardar la Persona en BD.");
//                        respuestaCreaPersona.setbRta(Boolean.FALSE);
//                    }
//
//                } else {
//                    respuestaCreaPersona.setiCodigo(0);
//                    respuestaCreaPersona.setNCodigoCygnus("0");
//                    respuestaCreaPersona.setsMsj("Se ha presentado un error al registrar el Rol de la Persona");
//                    respuestaCreaPersona.setbRta(Boolean.FALSE);
//                }

            } else {
                respuestaCreaPersona.setiCodigo(0);
                respuestaCreaPersona.setNCodigoCygnus("0");
                respuestaCreaPersona.setsMsj("Se ha presentado un error al guardar la Persona en WS");
                respuestaCreaPersona.setbRta(Boolean.FALSE);
            }
        } catch (Exception e) {
            respuestaCreaPersona.setiCodigo(0);
            respuestaCreaPersona.setNCodigoCygnus("0");
            respuestaCreaPersona.setsMsj("Se ha presentado un error al guardar la Persona en la BD.");
            respuestaCreaPersona.setbRta(Boolean.FALSE);
            e.printStackTrace();
        }
//        solicitudCreditoServiceBean = null;
        return respuestaCreaPersona;
    }
    
    private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
