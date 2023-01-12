/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.general;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Brayan F Silva R
 */
public class CrearEmailHTML {

    private final SimpleDateFormat parseFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final Utilidad util = new Utilidad();

    public CrearEmailHTML() {
    }
    
    public String cuerpoHTMLPagare(HashMap<String, String> hashMapData, String fecha) {
        String rta = "<body style=\"margin: 0em;\">\n"
                + "    <header style=\"height: 60px; background-color: #3E3D3C;\">\n"
                + "    <h2 style=\"text-align: center;\n"
                + "               margin-top: 2%;\n"
                + "               font-weight: 300;\n"
                + "               font-size: 40px;\n"
                + "               line-height: 60px;\">\n"
                + "    </h2>\n"
                + "    </header>\n"
                + "\n"
                + "<div style=\"margin-top: 5%;\"><div style=\"font-size: 20px;color: #3c86c6;\">Bogotá,<div style=\"font-size: 20px;float: right;\">" + fecha + "</div></div><div>"
                + "\n"
                + "    <h2 style=\"font-weight: 100;\n"
                + "    font-size: 27px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #3c86c6;\">Apreciad@ " + hashMapData.get("sNombres") + "</h2>\n"
                + "\n"
                + "<div style=\"font-size: 18px;color: #3E3D3C;\">"
                + " <strong> Se envian los pasos a seguir para la autenticación y firma electrónica en línea \n</strong>"
                + "\n"
                + "<br />"
                + "\n<a style=\"color: #3c86c6;\"> https://authdebug.bmicol.com.co/ </a>"
                + "\n"
                + "<ul>"
                + "<li> Ingresar a la opción  Proceso de Autenticación y firma electrónica en línea. </li> "
                + "<li> Seleccionar la opción  Finmeridian Voucher Pagaré. </li> "
                + "<li> Hacer clic en  Aceptar en la ventana de términos y condiciones. </li> "
                + "<li> Diligenciar Formulario de Autenticación </li> "
                + "</ul>"
                + "\n"
                + "<p> "
                + "<strong>Validación de Datos de Usuario:</strong>  (La información a diligenciar debe ser exactamente la del documento de identidad del firmante).\n"
                + "</p>"
                + "\n"
                + "<p>"
                + "<strong>Datos Créticos de Validación:</strong> Tipo de Documento, N° de Documento, Fecha de Expedición, Número de Celular, Primer Apellido.\n"
                + "</p>"
                + "\n"
                + "<p>"
                + "<strong>Datos Obligatorios:</strong> Tipo de Documento, N° de Documento, Fecha de Expedición, Número de Celular, Primer Nombre, Primer Apellido, Producto, Número de Póliza.\n"
                + "</p>"
                + "\n"
                + "<p>"
                + "Hacer clic en  <strong>Enviar Solicitud</strong> en la ventana emergente. "
                + "</p>"
                + "\n"
                + "<ol>"
                + "<li> <strong>Validación de número de Celular:</strong> <ul> <li> <strong> Número de Contacto: </strong> Seleccionar el mismo numero de Celular diligenciado en el formulario anterior. \n</li>"
                + "\n"
                + " <li> <strong> Método de Validación: </strong> Seleccionar Mensaje de Texto Para obtener el código en ambiente de pruebas. \n</li> "
                + "\n"
                + "<li> Hacer clic en <strong> Enviar Solicitud </strong> \n</li></ul> </li>\n"
                + "\n"
                + "<li> <strong>Validación de Código:</strong> <ul> <li> <strong> Código de Validación: </strong> Diligenciar el código mostrado. \n </li>"
                + "\n"
                + "<li> Hacer clic en <strong> Enviar Solicitud </strong> \n</li></ul> </li>\n"
                + "\n"
                + "<li> <strong>Firma de Documento:</strong> <ul> <li> Previsualización del documento Generado en PDF el cual será firmado electrónicamente. En el documento el usuario podrá validar los datos antes de realizar la firma electrónica. \n</li>"
                + "\n"
                + " <li> Hacer clic en <strong> Enviar Solicitud </strong> para Proceder a la Firma Electrónica. \n</li></ul> </li>\n "
                + "\n"
                + "<li> <strong>Confirmación de Firma de Documento:</strong> <ul> <li> Previsualización del documento Generado en PDF el cual será firmado electrónicamente. En el documento el usuario podrá validar los datos antes de realizar la firma electrónica. \n</li> </ul> </li>\n"
                + "\n"
                + "</ol>"
                + "</div>"
                + "</body>";

        return rta;
    }
    
    public String cuerpoHTMLCambioEstado(HashMap<String, String> hashMapData, String fecha) {
        String rta = "<body>\n"
                + "    <header style=\"height: 60px; background-color: #76c25c;\">\n"
                + "    <h2 style=\"text-align: center;\n"
                + "               margin-top: 2%;\n"
                + "               font-weight: 300;\n"
                + "               font-size: 40px;\n"
                + "               line-height: 60px;\">\n"
                + "    </h2>\n"
                + "    </header>\n"
                + "\n"
                + "<div style=\"margin-top: 5%;\"><div style=\"font-size: 20px;color: #3c86c6;\">Bogotá,<div style=\"font-size: 20px;float: right;\">" + fecha + "</div></div><div>"
                + "\n"
                + "    <h2 style=\"font-weight: 100;\n"
                + "    font-size: 27px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #3c86c6;\">Apreciad@ " + hashMapData.get("sNombres") + "</h2>\n"
                + "\n"
                + " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Nos permitimos informarle que su solicitud de cr�dito <br /> radicada con el N� " + hashMapData.get("sRadicado") + " fue: <br />\n</p>"
                + "<p style=\"font-weight: 100;\n"
                + "    font-size: 32px;\n"
                + "    line-height: 60px;\n"
                + "    text-align: center;\n"
                + "    color: #236EB6; font-weight: 300;\"><strong> " + hashMapData.get("sTipoSolicitud") + "</strong></p>"
                + "\n"
                + (!hashMapData.get("sObservacion").equals("") ?  " <p style=\"text-align: center;font-size: 25px;color: #202124;\"> Motivo:  " + hashMapData.get("sObservacion") + " </p>" : "")
                + "\n"
                + "</body>";
        return rta;
    }

    public String emailCodigoVerificacionRegUsu(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + ""
                    + "<div class=\"border\">\n"
                    + "      <table class=\"tableDetail\">\n"
                    + "      <tr>\n"
                    + "        <th class=\"subtitle\" colspan=\"2\"> C�DIGO DE VERIFICACI�N COOPEDAC</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th class=\"infoNotificacion\" colspan=\"2\">El siguiente c�digo de verificaci�n es generado para la solicitud de cr�dito en el portal transaccional de COOPEDAC.</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Fecha y Hora:</td>\n"
                    + "        <td class=\"colorGray\"> " + sFechaSystem + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\">C�digo de verificaci�n:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sCodigo") + "</td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "</div>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailRegistroNuevoUsuario(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + ""
                    + "<div class=\"border\">\n"
                    + "      <table class=\"tableDetail\">\n"
                    + "      <tr>\n"
                    + "        <th class=\"subtitle\" colspan=\"2\"> CONFIRMACIÓN REGISTRO ASOCIADO OFICINA VIRTUAL COOPERAGRO E.C</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th class=\"infoNotificacion\" colspan=\"2\">Se ha registrado de manera satisfactoria en el portal transaccional de COOPERAGRO. Con los siguientes datos.</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Fecha y Hora:</td>\n"
                    + "        <td class=\"colorGray\"> " + sFechaSystem + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Tipo y N° Documento:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sDescTipoDOI") + " - " + hashMapData.get("sNumDOI") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Nombres y Apellidos:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sNombreCompleto") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\">Clave:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sClave") + "</td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "</div>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailOlvidoClave(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + ""
                    + "<div class=\"border\">\n"
                    + "      <table class=\"tableDetail\">\n"
                    + "      <tr>\n"
                    + "        <th class=\"subtitle\" colspan=\"2\"> CAMBIO CLAVE OFICINA VIRTUAL COOPERAGRO E.C</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th class=\"infoNotificacion\" colspan=\"2\">Se ha realizado el proceso de restablecimiento de clave. Podra ingresar con los siguientes datos.</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Fecha y Hora:</td>\n"
                    + "        <td class=\"colorGray\"> " + sFechaSystem + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Tipo y N° Documento:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sDescTipoDOI") + " - " + hashMapData.get("sNumDOI") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Nombres y Apellidos:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sNombreCompleto") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\">Clave:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sClave") + "</td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "</div>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailExtractoAsociado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + ""
                    + "<div class=\"border\">\n"
                    + "      <table class=\"tableDetail\">\n"
                    + "      <tr>\n"
                    + "        <th class=\"subtitle\" colspan=\"2\"> GENERACIÓN DE EXTRACTO COOPERAGRO E.C</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th class=\"infoNotificacion\" colspan=\"2\">Se ha realizado el proceso de solicitud de extracto de acuerdo a la siguiente información.</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Fecha y Hora:</td>\n"
                    + "        <td class=\"colorGray\"> " + sFechaSystem + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Tipo y N° Documento:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sDescTipoDOI") + " - " + hashMapData.get("sNumDOI") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Nombres y Apellidos:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sNombreCompleto") + "</td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "</div>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredRadicado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml
                    + " <div class='conteiner'>\n"
                    + "				<div class='header'></div>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #3D6E3C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "					<p class='parrafoMediano'>\n"
                    + "						 Nos permitirmos informarle que su solicitud de cr�dito ha sido registrada con el N� " + hashMapData.get("sNumRadicSolCred") + ", con la siguiente informaci�n:\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "     <center>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Fecha y Hora:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + sFechaSystem + "</label>\n"
                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>L�nea de cr�dito:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sLineaCredito") + "</label>\n"
                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Monto de cr�dito:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + util.valorPattern(hashMapData.get("sMontoCredito")) + "</label>\n"
                    + "      </div>\n"
//                    + "      <div class='parrafoMediano'>\n"
//                    + "        <label class='lblSolCred'>Periodicidad de crédito:</label>\n"
//                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sDescPeriodicidad") + "</label>\n"
//                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Plazo:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sPlazo") + " cuotas</label>\n"
                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Valor de cuota:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + util.valorPattern(hashMapData.get("sValorCuota")) + "</label>\n"
                    + "      </div>\n"
//                    + "      <div class='parrafoMediano'>\n"
//                    + "        <label class='lblSolCred'>Solicitante:</label>\n"
//                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sNombreDeudor") + "</label>\n"
//                    + "      </div>\n"
                    + "    <br>\n"
                    + "    <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "          <button type=\"button\" class=\"btn text-white\" style=\"background-color: ##2ecc71\">RADICADA</button>\n"
                    + "			</div>\n"
                    + "		</div>"
                    + "    <br>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudServRadicado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + " <div class='conteiner'>\n"
                    + "				<div class='header'></div>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #3D6E3C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "					<p class='parrafoMediano'>\n"
                    + "						 Nos permitirmos informarle que su solicitud de servicio ha sido radica con el N° " + hashMapData.get("sNumRadicSolCred") + ", con la siguiente información:\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "     <center>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Fecha y Hora:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + sFechaSystem + "</label>\n"
                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Forma de pago:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sFormaPago") + "</label>\n"
                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Numero de personas a afiliar:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sNumPersonaAfiliar") + "</label>\n"
                    + "      </div>\n"
                    + "      <div class='parrafoMediano'>\n"
                    + "        <label class='lblSolCred'>Solicitante:</label>\n"
                    + "        <label class='lblInfoSolCred'>" + hashMapData.get("sNombreDeudor") + "</label>\n"
                    + "      </div>\n"
                    + "    <br>\n"
                    + "    <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "          <button type=\"button\" class=\"btn text-white\" style=\"background-color: ##2ecc71\">RADICADA</button>\n"
                    + "			</div>\n"
                    + "		</div>"
                    + "    <br>\n";;
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredAplazado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + " <div class='conteiner'>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<div class='header'></div>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #3D6E3C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "					<p class='parrafoMediano'>\n"
                    + "						 Nos permitirmos informarle que su solicitud de crédito ha sido radica con el N° " + hashMapData.get("sNumRadicSolCred") + ", fue:\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n"
                    + "    <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "          <button type=\"button\" class=\"Boton text-white\" style=\"background-color: #00d2d3\">Aplazada</button>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>"
                    + "    <br>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailRespuestaPQRSF(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + ""
                    + "<div class=\"border\">\n"
                    + "      <table class=\"tableDetail\">\n"
                    + "      <tr>\n"
                    + "        <th class=\"subtitle\" colspan=\"2\">RESPUESTA A SOLICITUD DE PQRSF COOPERAGRO E.C</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Fecha y Hora:</td>\n"
                    + "        <td class=\"colorGray\"> " + sFechaSystem + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Numero de radicado:</td>\n"
                    + "        <td class=\"colorGray\"> " + hashMapData.get("sNumRadicado") + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Mensaje de respuesta:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sMensaje") + "</td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "</div>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailRegistroPQRSF(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + ""
                    + "<div class=\"border\">\n"
                    + "      <table class=\"tableDetail\">\n"
                    + "      <tr>\n"
                    + "        <th class=\"subtitle\" colspan=\"2\"> SOLICITUD DE PQRSF COOPERAGRO E.C</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <th class=\"infoNotificacion\" colspan=\"2\">Se ha registrado satisfactoriamente el proceso de " + hashMapData.get("sTipoPQRSF") + " de acuerdo a la siguiente información.</th>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Fecha y Hora:</td>\n"
                    + "        <td class=\"colorGray\"> " + sFechaSystem + " </td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Tipo y N° Documento:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sDescTipoDOI") + " - " + hashMapData.get("sNumDOI") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Nombres y Apellidos:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sNombreCompleto") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Numero de Radicado:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sNumRadicado") + "</td>\n"
                    + "      </tr>\n"
                    + "      <tr>\n"
                    + "        <td class=\"labelMsj\"> Mensaje:</td>\n"
                    + "        <td class=\"colorGray\">" + hashMapData.get("sMensaje") + "</td>\n"
                    + "      </tr>\n"
                    + "    </table>\n"
                    + "</div>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredNegado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml
                    + " <div class='conteiner'>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<div class='header'></div>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #3D6E3C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "					<p class='parrafoMediano'>\n"
                    + "						 Nos permitirmos informarle que su solicitud de crédito ha sido radica con el N° " + hashMapData.get("sNumRadicSolCred") + ", fue:\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n"
                    + " <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "          <button type=\"button\" class=\"Boton text-white\" style=\"background-color: #00d2d3\">Negada</button>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredAprobado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml
                    + " <div class='conteiner'>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<div class='header'></div>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #76C25C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "                                  <p class='parrafoMediano'>\n"
                    + "						 El código de validación es el siguiente: " + hashMapData.get("sCodigo") + "\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n"
                    + "<div class='row'>\n"
                    + "     </div>\n"
                    + "    <br>\n"
                    + "    <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<div class='header'></div>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredAprobadoAceptado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + "     <div class=\"Contenedor\">\n"
                    + "          <div class=\"header\"></div>\n"
                    + "                    <div class=\"Cajatextos\">\n"
                    + "                      <div class=\"\">\n"
                    + "                        <div class=\"box top left\">\n"
                    + "                          <p class=\"texto\">\n"
                    + "                            Bogotá D.C\n"
                    + "                          </p>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"box top right\">\n"
                    + "                          <p class=\"texto \">\n"
                    + sFechaSystem + "\n"
                    + "                          </p>\n"
                    + "                        </div>\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "                    <div class=\"cajaTitulo\">\n"
                    + "                      <div class=\"col-lg-12 \">\n"
                    + "                        <h1 class=\"Titulo\">Apreciad@ asociad@</h1>\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "                    <div class=\"row contenedor mt-2\">\n"
                    + "                      <div class=\"col-lg-12\">\n"
                    + "                        <p class=\"parrafoMediano\">\n"
                    + "                          Nos permitirmos informarle que su solicitud de crédito \n"
                    + "                          N°" + hashMapData.get("sNumRadicSolCred") + " fue:\n"
                    + "                        </p>\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "                   \n"
                    + "                      <div class=\"CentroBoton\">\n"
                    + "                        <button class=\"Boton\">\n"
                    + "                          APROBADO-ACEPTADO\n"
                    + "                        </button>\n"
                    + "                      </div>\n"
                    + "\n"
                    + "                <div class=\"CentroBoton\">\n"
//                    + "                      <div class=\"felicidades\">\n"
//                    + "                          <img src=\"http://appswebpre.ebscreditodigital.com/FTP_COOPERAGRO/IMG/Felicidades.png\" alt=\"\" />\n"
//                    + "                      </div>\n"
                    + "                </div>"
                    + "                      <div class=\"Centro\">\n"
                    + "                        <p class=\"parrafoMediano\">Por favor comunicarse con la entidad</p>\n"
                    + "                      </div>\n"
                    + "                </div>\n"
                    + "    <br>\n";

        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredEstudio(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + " <div class='conteiner'>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<div class='header'></div>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #3D6E3C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "					<p class='parrafoMediano'>\n"
                    + "						 Nos permitirmos informarle que su solicitud de crédito con el N° " + hashMapData.get("sNumRadicSolCred") + ", fue:\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n"
                    + "    <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "          <button type=\"button\" class=\"Boton text-white\" style=\"background-color: #00d2d3\">En estudio</button>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>"
                    + "    <br>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCredDesembolsado(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();
        if (hashMapData != null && !hashMapData.isEmpty()) {
            Date dateSystem = new Date();
            String sFechaSystem = parseFormat.format(dateSystem);
            sHtml = sHtml + " <div class='conteiner'>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<div class='header'></div>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "					<h1 style='color: #3D6E3C;'>\n"
                    + "						Apreciad@ asociad@\n"
                    + "					</h1>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "		<br>\n"
                    + "		<div class='row'>\n"
                    + "			<div class='col-10 offset-1'>\n"
                    + "				<center>\n"
                    + "					<p class='parrafoMediano'>\n"
                    + "						 Nos permitirmos informarle que su solicitud de crédito con el N° " + hashMapData.get("sNumRadicSolCred") + ", fue:\n"
                    + "					</p>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>\n"
                    + "    <br>\n"
                    + "    <div class='row'>\n"
                    + "			<div class='col'>\n"
                    + "				<center>\n"
                    + "          <button type=\"button\" class=\"Boton text-white\" style=\"background-color: #00d2d3\">Desembolsado</button>\n"
                    + "				</center>\n"
                    + "			</div>\n"
                    + "		</div>"
                    + "    <br>\n";
        }
        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudAfiliacionWeb(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();

        Date dateSystem = new Date();
        String sFechaSystem = parseFormat.format(dateSystem);
        sHtml = sHtml
                + "<div class=\"conteiner\">\n"
                + "  <div class=\"header\"></div>\n"
                + "  <div class=\"row\">\n"
                + "    <div class=\"col\">\n"
                + "      <span style=\"margin-left: 3%; float: left\">Bogotá</span>\n"
                + "      <span style=\"margin-right: 3%; float: right\">" + sFechaSystem + "</span>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "  <br />\n"
                + "\n"
                + "  <div class=\"border\">\n"
                + "    <table class=\"tableDetail\" style=\"margin: 20px\">\n"
                + "      <tr>\n"
                + "        <th class=\"\" colspan=\"2\">\n"
                + "          <center>\n"
                + "            <h1 style=\"color: #3d6e3c\">Apreciad@ señor@</h1>\n"
                + "          </center>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <th class=\"infoNotificacion\" colspan=\"2\">\n"
                + "          <center>\n"
                + "            <p class=\"parrafoMediano\">\n"
                + "              Nos permitirmos informarle que su solicitud de afiliación fue\n"
                + "              " + hashMapData.get("tipo") + " con\n"
                + "            </p>\n"
                + "          </center>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <th colspan=\"3\">\n"
                + "          <div class=\"row\">\n"
                + "            <div class=\"col\">\n"
                + "              <div\n"
                + "                class=\"btn text-white\"\n"
                + "                style=\"\n"
                + "                  margin-left: auto;\n"
                + "                  margin-right: auto;\n"
                + "                  margin-top: 10px;\n"
                + "                  margin-bottom: 10px;\n"
                + "                  background-color: #edab05;\n"
                + "                  padding: 10px;\n"
                + "                  color: #fff;\n"
                + "                  border: none;\n"
                + "                  width: 100px;\n"
                + "                \"\n"
                + "              >\n"
                + "                Éxito\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          </div>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <td class=\"labelMsj\">Fecha y Hora de solicitud: </td>\n"
                + "        <td class=\"colorGray\">" + hashMapData.get("fechaSolicitud") + "</td>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <td class=\"labelMsj\">Número de radicado:</td>\n"
                + "        <td class=\"colorGray\">\n"
                + "          " + hashMapData.get("numRadic") + "\n"
                + "        </td>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <td class=\"labelMsj\">Estado:</td>\n"
                + "        <td class=\"colorGray\">\n"
                + "          " + hashMapData.get("estado") + "\n"
                + "        </td>\n"
                + "      </tr>\n"
                + "    </table>\n"
                + "  </div>\n"
                + "</div>";

        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudAfiliacionAdmin(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();

        Date dateSystem = new Date();
        String sFechaSystem = parseFormat.format(dateSystem);
        sHtml = sHtml
                + "<div class=\"conteiner\">\n"
                + "  <div class=\"header\"></div>\n"
                + "  <div class=\"row\">\n"
                + "    <div class=\"col\">\n"
                + "      <span style=\"margin-left: 3%; float: left\">Bogotá</span>\n"
                + "      <span style=\"margin-right: 3%; float: right\">" + sFechaSystem + "</span>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "  <br />\n"
                + "\n"
                + "  <div class=\"border\">\n"
                + "    <table class=\"tableDetail\" style=\"margin: 20px\">\n"
                + "      <tr>\n"
                + "        <th class=\"\" colspan=\"2\">\n"
                + "          <center>\n"
                + "            <h1 style=\"color: #3d6e3c\">Hola, " + hashMapData.get("nombreUsuario") + "</h1>\n"
                + "          </center>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <th class=\"infoNotificacion\" colspan=\"2\">\n"
                + "          <center>\n"
                + "            <p class=\"parrafoMediano\">\n"
                + "              Nos permitirmos informarle que se hizo una nueva solicitud de afiliación:\n"
                + "            </p>\n"
                + "          </center>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <th colspan=\"3\">\n"
                + "          <div class=\"row\">\n"
                + "            <div class=\"col\">\n"
                + "              <div\n"
                + "                class=\"btn text-white\"\n"
                + "                href=\"http://localhost:4200/#/home\" "
                + "                style=\"\n"
                + "                  margin-left: auto;\n"
                + "                  margin-right: auto;\n"
                + "                  margin-top: 10px;\n"
                + "                  margin-bottom: 10px;\n"
                + "                  background-color: #edab05;\n"
                + "                  padding: 10px;\n"
                + "                  color: #fff;\n"
                + "                  border: none;\n"
                + "                  width: 100px;\n"
                + "                \"\n"
                + "              >\n"
                + "                Ver\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          </div>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "    </table>\n"
                + "  </div>\n"
                + "</div>";

        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    public String emailSolicitudCreditoAdmin(HashMap<String, String> hashMapData) throws ParseException {
        String sHtml = null;
        sHtml = obtenerCabeceraHTML();

        Date dateSystem = new Date();
        String sFechaSystem = parseFormat.format(dateSystem);
        sHtml = sHtml
                + "<div class=\"conteiner\">\n"
                + "  <div class=\"header\"></div>\n"
                + "  <div class=\"row\">\n"
                + "    <div class=\"col\">\n"
                + "      <span style=\"margin-left: 3%; float: left\">Bogotá</span>\n"
                + "      <span style=\"margin-right: 3%; float: right\">" + sFechaSystem + "</span>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "  <br />\n"
                + "\n"
                + "  <div class=\"border\">\n"
                + "    <table class=\"tableDetail\" style=\"margin: 20px\">\n"
                + "      <tr>\n"
                + "        <th class=\"\" colspan=\"2\">\n"
                + "          <center>\n"
                + "            <h1 style=\"color: #3d6e3c\">Hola, " + hashMapData.get("nombreUsuario") + "</h1>\n"
                + "          </center>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <th class=\"infoNotificacion\" colspan=\"2\">\n"
                + "          <center>\n"
                + "            <p class=\"parrafoMediano\">\n"
                + "              Nos permitirmos informarle que se hizo una nueva solicitud de cr�dito:\n"
                + "            </p>\n"
                + "          </center>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "      <tr>\n"
                + "        <th colspan=\"3\">\n"
                + "          <div class=\"row\">\n"
                + "            <div class=\"col\">\n"
                + "              <div\n"
                + "                class=\"btn text-white\"\n"
                + "                href=\"http://localhost:4200/#/home\" "
                + "                style=\"\n"
                + "                  margin-left: auto;\n"
                + "                  margin-right: auto;\n"
                + "                  margin-top: 10px;\n"
                + "                  margin-bottom: 10px;\n"
                + "                  background-color: #edab05;\n"
                + "                  padding: 10px;\n"
                + "                  color: #fff;\n"
                + "                  border: none;\n"
                + "                  width: 100px;\n"
                + "                \"\n"
                + "              >\n"
                + "                Ver\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          </div>\n"
                + "        </th>\n"
                + "      </tr>\n"
                + "    </table>\n"
                + "  </div>\n"
                + "</div>";

        sHtml += obtenerFinalHTML();
        return sHtml;
    }

    private static String obtenerCabeceraHTML() {
        String sCabeceraHtml = null;
        sCabeceraHtml = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <meta charset=\"utf-8\" />\n"
                + "    <title>NOTIFICACIÓN COOPEDAC</title>\n"
                + "    <style>\n"
                + "      * {\n"
                + "        padding: 0;\n"
                + "        margin: 0;\n"
                + "        position: relative;\n"
                + "      }\n"
                + "\n"
                + "      .header {\n"
                + "        width: 100%;\n"
                + "        background-color: #76C25C;\n"
                + "        height: 50px;\n"
                + "        margin-bottom: 50px;\n"
                + "      }\n"
                + "\n"
                + "      .footer {\n"
                + "        margin: auto;\n"
                + "        margin-top: 100px;\n"
                + "        width: 100%;\n"
                + "        bottom: 0;\n"
                + "        height: auto;\n"
                + "      }\n"
                + "\n"
                + "      .header2 {\n"
                + "			width: 100%;\n"
                + "			background-color: #c23616;\n"
                + "			height: 50px;\n"
                + "			margin-bottom: ();\n"
                + "		}\n"
                + "\n"
                + "      img {\n"
                + "        max-width: 100%;\n"
                + "      }\n"
                + "\n"
                + "      .Contenedor {\n"
                + "        border: black solid;\n"
                + "        margin: auto;\n"
                + "        width: 80%;\n"
                + "\n"
                + "      }\n"
                + "\n"
                + "      .Cajatextos {\n"
                + "        margin: auto;\n"
                + "        width: 80%;\n"
                + "      }\n"
                + "\n"
                + "\n"
                + "      .cajaTitulo {\n"
                + "        margin: auto;\n"
                + "        margin-top: 150px;\n"
                + "      }\n"
                + "\n"
                + "\n"
                + "      .Centro {\n"
                + "        margin-left: auto;\n"
                + "        margin-right: auto;\n"
                + "        margin-bottom: 10px;\n"
                + "      }\n"
                + "\n"
                + "      .CentroBoton {\n"
                + "        margin-top: 20px;\n"
                + "        margin-left: auto;\n"
                + "        margin-right: auto;\n"
                + "        margin-bottom: 10px;\n"
                + "\n"
                + "      }\n"
                + "\n"
                + "      .parrafoMediano {\n"
                + "        text-align: center;\n"
                + "      }\n"
                + "\n"
                + "      @media screen and (max-width: 800px) {\n"
                + "        .footer {\n"
                + "          height: auto;\n"
                + "        }\n"
                + "      }\n"
                + "\n"
                + "      /* Estilos aplazado*/\n"
                + "\n"
                + "      .Boton:hover {\n"
                + "        color: #ffffff;\n"
                + "        border: 1px solid #efba24;\n"
                + "        box-sizing: border-box;\n"
                + "        background: #1059a9;\n"
                + "      }\n"
                + "\n"
                + "      .texto {\n"
                + "        font-family: Poppins;\n"
                + "        font-style: normal;\n"
                + "        font-weight: 300;\n"
                + "        font-size: 40px;\n"
                + "        line-height: 60px;\n"
                + "      }\n"
                + "\n"
                + "      .Titulo {\n"
                + "        margin: auto;\n"
                + "        text-align: center;\n"
                + "        font-family: Poppins;\n"
                + "        font-style: normal;\n"
                + "        font-weight: 500;\n"
                + "        font-size: 60px;\n"
                + "        line-height: 90px;\n"
                + "        letter-spacing: -0.015em;\n"
                + "        color: #1059a9;\n"
                + "      }\n"
                + "\n"
                + "\n"
                + "      .parrafoMediano {\n"
                + "        text-align: center;\n"
                + "        font-family: Poppins;\n"
                + "        font-style: normal;\n"
                + "        font-weight: normal;\n"
                + "        font-size: 35px;\n"
                + "        line-height: 40px;\n"
                + "        align-items: center;\n"
                + "        text-align: center;\n"
                + "        letter-spacing: -0.015em;\n"
                + "      }\n"
                + "\n"
                + "      .Boton {\n"
                + "\n"
                + "        margin-left: 50%;\n"
                + "        transform: translateX(-50%);\n"
                + "\n"
                + "        width: 380px;\n"
                + "        height: 91px;\n"
                + "        /*   left: 531px;\n"
                + "  top: 604px; */\n"
                + "        background-color: #efba24;\n"
                + "\n"
                + "        font-family: Poppins;\n"
                + "        font-style: normal;\n"
                + "        font-size: 40px;\n"
                + "        font-weight: 500;\n"
                + "        line-height: 60px;\n"
                + "        align-items: center;\n"
                + "        text-align: center;\n"
                + "        letter-spacing: -0.015em;\n"
                + "        color: #2559a9;\n"
                + "      }\n"
                + "\n"
                + "      .felicidades {\n"
                + "        margin-left: 60%;\n"
                + "        transform: translateX(-70%);\n"
                + "      }\n"
                + "\n"
                + "\n"
                + "      @media all and (max-width: 766px) {\n"
                + "        .texto {\n"
                + "          font-family: Poppins;\n"
                + "          font-style: normal;\n"
                + "          font-weight: 300;\n"
                + "          font-size: 20px;\n"
                + "          line-height: 60px;\n"
                + "        }\n"
                + "\n"
                + "        .Titulo {\n"
                + "          margin: auto;\n"
                + "          text-align: center;\n"
                + "          font-family: Poppins;\n"
                + "          font-style: normal;\n"
                + "          font-weight: 500;\n"
                + "          font-size: 30px;\n"
                + "          line-height: 90px;\n"
                + "          letter-spacing: -0.015em;\n"
                + "          color: #1059a9;\n"
                + "        }\n"
                + "\n"
                + "        .parrafo {\n"
                + "          font-family: Poppins;\n"
                + "          font-style: normal;\n"
                + "          font-weight: normal;\n"
                + "          font-size: 20px;\n"
                + "          line-height: 30px;\n"
                + "          align-items: center;\n"
                + "          text-align: center;\n"
                + "          letter-spacing: -0.015em;\n"
                + "        }\n"
                + "\n"
                + "        .parrafoMediano {\n"
                + "          text-align: center;\n"
                + "          font-family: Poppins;\n"
                + "          font-style: normal;\n"
                + "          font-weight: normal;\n"
                + "          font-size: 15px;\n"
                + "          line-height: 30px;\n"
                + "          letter-spacing: -0.015em;\n"
                + "        }\n"
                + "\n"
                + "        .Boton {\n"
                + "          margin-left: 50%;\n"
                + "          width: 140px;\n"
                + "          height: 45px;\n"
                + "          background-color: #efba24;\n"
                + "          font-family: Poppins;\n"
                + "          font-style: normal;\n"
                + "          font-size: 20px;\n"
                + "          font-weight: 250;\n"
                + "          line-height: 30px;\n"
                + "          align-items: center;\n"
                + "          text-align: center;\n"
                + "          letter-spacing: -0.015em;\n"
                + "          color: #2559a9;\n"
                + "        }\n"
                + "\n"
                + "        .Centro {\n"
                + "          margin-left: auto;\n"
                + "          margin-right: auto;\n"
                + "        }\n"
                + "      }\n"
                + "\n"
                + "      .lblInfoSolCred {\n"
                + "        position: static;\n"
                + "        left: 40.14%;\n"
                + "        right: 0%;\n"
                + "        top: 0%;\n"
                + "        bottom: 0%;\n"
                + "\n"
                + "        font-family: Open Sans;\n"
                + "        font-style: normal;\n"
                + "        font-weight: normal;\n"
                + "        font-size: 12px;\n"
                + "        line-height: 16px;\n"
                + "\n"
                + "        color: #000000;\n"
                + "\n"
                + "\n"
                + "        /* Inside Auto Layout */\n"
                + "\n"
                + "        flex: none;\n"
                + "        order: 1;\n"
                + "        align-self: center;\n"
                + "        margin: 12px 0px;\n"
                + "      }\n"
                + "\n"
                + "      .lblSolCred {\n"
                + "        position: static;\n"
                + "        left: 0%;\n"
                + "        right: 64.16%;\n"
                + "        top: 0%;\n"
                + "        bottom: 0%;\n"
                + "\n"
                + "        font-family: Open Sans;\n"
                + "        font-style: normal;\n"
                + "        font-weight: bold;\n"
                + "        font-size: 12px;\n"
                + "        line-height: 16px;\n"
                + "\n"
                + "        color: #000000;\n"
                + "\n"
                + "\n"
                + "        /* Inside Auto Layout */\n"
                + "\n"
                + "        flex: none;\n"
                + "        order: 0;\n"
                + "        align-self: center;\n"
                + "        margin: 12px 0px;\n"
                + "      }\n"
                + "\n"
                + "      /*div a los lados */\n"
                + "      .box {\n"
                + "        position: absolute;\n"
                + "        margin-top: 15px\n"
                + "      }\n"
                + "\n"
                + "      .box.top {\n"
                + "        top: 0;\n"
                + "      }\n"
                + "\n"
                + "      .box.right {\n"
                + "        right: 0;\n"
                + "      }\n"
                + "\n"
                + "      .box.left: {\n"
                + "        left: 0;\n"
                + "      }\n"
                + "\n"
                + "    </style>\n"
                + "  </head>\n"
                + " <body>\n";
        return sCabeceraHtml;
    }

    private static String obtenerFinalHTML() {
        String sFinalHtml;
        sFinalHtml = "<div class=\" footer\">\n"
                + "   </div>\n"
                + "</div>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        return sFinalHtml;
    }
    
    public String cuerpoHTML(HashMap<String, String> hashMapData) {
//        String rta = obtenerCabeceraHTML();
        String rta = "<body style=\"margin: 0em;\">\n"
                + "    <header style=\"height: 60px; background-color: #76c25c;\">\n"
                + "    </header>\n"
                + "\n"
                + "    <h2 style=\"text-align: center;margin-top: 2%; font-style: normal;\n"
                + "                font-weight: 300;\">\n"
                + "        <small>Bogot� - </small>\n"
                + "        <small>" + hashMapData.get("fecha") + "</small>\n"
                + "    </h2>\n"
                + "\n"
                + "    <h2 style=\"font-weight: 500;\n"
                + "    font-size: 30px;\n"
                + "    text-align: center;\n"
                + "    color: #76c25c;\">" + hashMapData.get("genero") + " " + hashMapData.get("nomUsuario") + "</h2>\n"
                + "\n"
                + "    <h3 style=\"text-align: center;margin-top: 2%; font-style: normal;\n"
                + "    font-weight: 300;\n"
                + "    font-size: 20px;\">\n"
                + "            " + hashMapData.get("mensaje") + "\n"
                + "    </h3>\n"
                + "\n"
                + "</body>";
//        rta+= obtenerFinalHTML();
        return rta;
    }

}
