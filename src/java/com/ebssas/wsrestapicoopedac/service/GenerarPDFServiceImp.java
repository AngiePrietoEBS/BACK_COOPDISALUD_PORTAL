/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.ebssas.wsrestapicoopedac.general.Utilidad;
import com.ebssas.wsrestapicoopedac.responseAML.DatosSdn;
import com.ebssas.wsrestapicoopedac.responseAML.ResponseConsultaAML;
import com.ebssas.wsrestapicoopedac.responseAML.ResponseResult;
import com.ebssas.wsrestapicoopedac.responseAML.DatosBan;
import com.ebssas.wsrestapicoopedac.responseAML.DatosBis;
import com.ebssas.wsrestapicoopedac.responseAML.DatosEul;
import com.ebssas.wsrestapicoopedac.responseAML.DatosHmt;
import com.ebssas.wsrestapicoopedac.responseAML.DatosPro;
import com.ebssas.wsrestapicoopedac.responseAML.DatosTsti;

import java.util.Date;
import java.util.List;
/*import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import be.quodlibet.boxable.*;*/
import java.awt.Color;

/**
 *
 * @author Jonathan
 */
public class GenerarPDFServiceImp {

    /*private BaseTable table;
    private PDDocument document;
    public static final String RUTA = "D:\\coopedac\\Listas\\";

    public String crearPDF(ResponseConsultaAML responseAML) {
        try {
            document = new PDDocument();
            for (ResponseResult resultado : responseAML.getResults()) {
                PDPage page = new PDPage(PDRectangle.A6);
                document.addPage(page);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);
                headerPDF(contentStream, page, responseAML.getId_bitacora());
                nombresPDF(contentStream, page, resultado.getNombre(), resultado.getDoc_id(), seEncuentraEnLista(resultado));

                //Crear tabla
                float margin = 10;
                float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
                float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
                boolean drawContent = true;
                float yStart = page.getMediaBox().getHeight() - (11 * margin);;

                table = new BaseTable(yStart, yStartNewPage, 0, tableWidth, margin, document, page, true, drawContent);

                listaSDN(page, resultado.getDatos_sdn());
                listaBAN(page, resultado.getDatos_ban());
                listaBIS(page, resultado.getDatos_bis());
                listaEUL(page, resultado.getDatos_eul());
                listaHMT(page, resultado.getDatos_hmt());
                listaPRO(page, resultado.getDatos_pro());
                listaTSTI(page, resultado.getDatos_tsti());

                table.draw();
                contentStream.close();
            }
            document.save(RUTA + "pdfTemp.pdf");
            return "pdfTemp.pdf";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void headerPDF(PDPageContentStream contentStream, PDPage page, String codConsulta) {
        try {
            PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
            PDFont fontTexto = PDType1Font.HELVETICA;

            contentStream.beginText();
            contentStream.setFont(fontTexto, 5);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() - 80, page.getMediaBox().getHeight() - 35);
            contentStream.showText("Código consulta " + codConsulta);
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTitulo, 6);
            contentStream.newLineAtOffset(10, page.getMediaBox().getHeight() - 45);
            contentStream.showText("Fecha:");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTexto, 6);
            contentStream.newLineAtOffset(40, page.getMediaBox().getHeight() - 45);
            contentStream.showText(new Utilidad().dateToStringFormatFechaHora(new Date()));
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTitulo, 6);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() - 125, page.getMediaBox().getHeight() - 45);
            contentStream.showText("CONSULTA ANTI MONEY LAUNDERING");
            contentStream.endText();

            contentStream.drawLine(10, page.getMediaBox().getHeight() - 47, page.getMediaBox().getWidth() - 10, page.getMediaBox().getHeight() - 47);

            float titleWidth = fontTitulo.getStringWidth("RESUMEN DE COINCIDENCIAS") / 1000 * 7;
            float titleHeight = fontTitulo.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * 7;
            float startX = (page.getMediaBox().getWidth() - titleWidth) / 2;
            float startY = page.getMediaBox().getHeight() - titleHeight - 50;
            contentStream.beginText();
            contentStream.setFont(fontTitulo, 7);
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText("RESUMEN DE COINCIDENCIAS");
            contentStream.endText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void nombresPDF(PDPageContentStream contentStream, PDPage page, String nombres, String identificacion, String coincidenciaLista) {
        try {
            PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
            PDFont fontTexto = PDType1Font.HELVETICA;
            float fontSize = 5;
            contentStream.beginText();
            contentStream.setFont(fontTitulo, fontSize);
            contentStream.newLineAtOffset(30, page.getMediaBox().getHeight() - 80);
            contentStream.showText("NOMBRES:");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTexto, fontSize);
            contentStream.newLineAtOffset(60, page.getMediaBox().getHeight() - 80);
            contentStream.showText(nombres.toUpperCase());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTitulo, fontSize);
            contentStream.newLineAtOffset(30, page.getMediaBox().getHeight() - 87);
            contentStream.showText("IDENTIFICACIÓN:");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTexto, fontSize);
            contentStream.newLineAtOffset(75, page.getMediaBox().getHeight() - 87);
            contentStream.showText(identificacion.toUpperCase());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTitulo, fontSize);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() - 120, page.getMediaBox().getHeight() - 80);
            contentStream.showText("Coincidencia en Listas Restrictivas:");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontTexto, fontSize);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() - 30, page.getMediaBox().getHeight() - 80);
            contentStream.showText(coincidenciaLista);
            contentStream.endText();

//            contentStream.beginText();
//            contentStream.setFont(fontTitulo, fontSize);
//            contentStream.newLineAtOffset(page.getMediaBox().getWidth() - 120, page.getMediaBox().getHeight() - 87);
//            contentStream.showText("Coincidencia en Listas PEPS:");
//            contentStream.endText();
//
//            contentStream.beginText();
//            contentStream.setFont(fontTexto, fontSize);
//            contentStream.newLineAtOffset(page.getMediaBox().getWidth() - 40, page.getMediaBox().getHeight() - 87);
//            contentStream.showText(coincidenciaPep);
//            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(fontTitulo, 6);
            contentStream.newLineAtOffset(25, page.getMediaBox().getHeight() - 100);
            contentStream.showText("LISTAS RESTRICTIVAS");
            contentStream.endText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaSDN(PDPage page, List<DatosSdn> lista) {
        try {
            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "SDN - Oficina de control de activos estadounidenses (OFAC)");
                float divisionCeldas = 16f;
                float cantColumnas = 4;

                //Encabezado tabla consultas
                Row< PDPage> factHeaderrow = table.createRow(1f);
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Nombres");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Observaciones");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Dirección");

                for (DatosSdn data : lista) {
                    String nombres = data.getSdn_name() != null && !data.getSdn_name().isEmpty() ? data.getSdn_name().get(0) : "N/A";
                    String observaciones = data.getRemarks() != null && !data.getRemarks().isEmpty() ? data.getRemarks().get(0) : "N/A";
                    String pais = data.getCountry() != null && !data.getCountry().isEmpty() ? data.getCountry().get(0) : "N/A";
                    String direccion = data.getAddress() != null && !data.getAddress().isEmpty() ? data.getAddress().get(0) : "N/A";

                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, nombres);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, observaciones);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, direccion);
                }

            } else {
                agregarHeaderTablaListaNoExistente(page, "SDN - Oficina de control de activos estadounidenses (OFAC)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaBAN(PDPage page, List<DatosBan> lista) {
        try {

            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "BAN - LISTADO DEL BANCO MUNDIAL DE EMPRESAS E INDIVIDUOS NO ELEGIBLES");
                float divisionCeldas = 25f;
                float cantColumnas = 5;

                //Encabezado tabla consultas
                Row< PDPage> factHeaderrow = table.createRow(12f);
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Nombres");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Grounds (Jardines)");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Dirección");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Inicio - Fin");

                for (DatosBan data : lista) {
                    String nombres = data.getName() != null && !data.getName().isEmpty() ? data.getName().get(0) : "N/A";
                    String grounds = data.getGrounds() != null && !data.getGrounds().isEmpty() ? data.getGrounds().get(0) : "N/A";
                    String pais = data.getCountry() != null && !data.getCountry().isEmpty() ? data.getCountry().get(0) : "N/A";
                    String direccion = data.getAddress() != null && !data.getAddress().isEmpty() ? data.getAddress().get(0) : "N/A";
                    String ini = data.getIni() != null && !data.getIni().isEmpty() ? data.getIni().get(0) : "N/A";
                    String fin = data.getFin() != null && !data.getFin().isEmpty() ? data.getFin().get(0) : "N/A";

                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, nombres);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, grounds);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, direccion);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, ini + " - " + fin);
                }

            } else {
                agregarHeaderTablaListaNoExistente(page, "BAN - LISTADO DEL BANCO MUNDIAL DE EMPRESAS E INDIVIDUOS NO ELEGIBLES");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaBIS(PDPage page, List<DatosBis> lista) {
        try {

            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "BIS - LISTA DE OFICINA DE INDUSTRIA Y SEGURIDAD");
                float divisionCeldas = 25f;
                float cantColumnas = 5;

                //Encabezado tabla consultas
                Row< PDPage> factHeaderrow = table.createRow(12f);
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Titulo");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Nombres");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Ciudad");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Dirección");

                for (DatosBis data : lista) {
                    String titulo = data.getTitle() != null && !data.getTitle().isEmpty() ? data.getTitle().get(0) : "N/A";
                    String pais = data.getCountry() != null && !data.getCountry().isEmpty() ? data.getCountry().get(0) : "N/A";
                    String nombres = data.getName() != null && !data.getName().isEmpty() ? data.getName().get(0) : "N/A";
                    String ciudad = data.getCity() != null && !data.getCity().isEmpty() ? data.getCity().get(0) : "N/A";
                    String direccion = data.getAddress() != null && !data.getAddress().isEmpty() ? data.getAddress().get(0) : "N/A";

                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, titulo);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, nombres);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, ciudad);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, direccion);
                }
            } else {
                agregarHeaderTablaListaNoExistente(page, "BIS - LISTA DE OFICINA DE INDUSTRIA Y SEGURIDAD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaEUL(PDPage page, List<DatosEul> lista) {
        try {

            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "EUL - LISTA DE LA UNIÓN EUROPEA");
                float divisionCeldas = 25f;
                float cantColumnas = 5;

                //Encabezado tabla consultas
                Row< PDPage> factHeaderrow = table.createRow(12f);
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Titulo");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Nombres");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Ciudad");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Dirección");

                for (DatosEul data : lista) {
//                    String titulo = data.getTitle() != null && !data.getTitle().isEmpty() ? data.getTitle().get(0) : "N/A";
//                    String pais = data.getCountry() != null && !data.getCountry().isEmpty() ? data.getCountry().get(0) : "N/A";
//                    String nombres = data.getName() != null && !data.getName().isEmpty() ? data.getName().get(0) : "N/A";
//                    String ciudad = data.getCity() != null && !data.getCity().isEmpty() ? data.getCity().get(0) : "N/A";
//                    String direccion = data.getAddress() != null && !data.getAddress().isEmpty() ? data.getAddress().get(0) : "N/A";
//
//                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, titulo);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, nombres);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, ciudad);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, direccion);
                }
            } else {
                agregarHeaderTablaListaNoExistente(page, "EUL - LISTA DE LA UNIÓN EUROPEA");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaHMT(PDPage page, List<DatosHmt> lista) {
        try {

            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "HTM - DEPARTAMENTO GUBERNAMENTAL DEL REINO UNIDO");
                float divisionCeldas = 16f;
                float cantColumnas = 4;

                //Encabezado tabla consultas
                Row< PDPage> factHeaderrow = table.createRow(12f);
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Titulo");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Tipo de grupo");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Otra información");

                for (DatosHmt data : lista) {
                    String titulo = data.getTitle() != null && !data.getTitle().isEmpty() ? data.getTitle().get(0) : "N/A";
                    String pais = data.getCountry() != null && !data.getCountry().isEmpty() ? data.getCountry().get(0) : "N/A";
                    String grupo = data.getGroup_type() != null && !data.getGroup_type().isEmpty() ? data.getGroup_type().get(0) : "N/A";
                    String otraInfo = data.getOther_information() != null && !data.getOther_information().isEmpty() ? data.getOther_information().get(0) : "N/A";

                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, titulo);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, grupo);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, otraInfo);
                }
            } else {
                agregarHeaderTablaListaNoExistente(page, "HTM - DEPARTAMENTO GUBERNAMENTAL DEL REINO UNIDO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaPRO(PDPage page, List<DatosPro> lista) {
        try {

            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "PRO - PROCURADURÍA GENERAL DE LA NACIÓN");
                float divisionCeldas = 16f;
                float cantColumnas = 4;

                //Encabezado tabla consultas
//                Row< PDPage> factHeaderrow = table.createRow(12f);
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Titulo");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Tipo de grupo");
//                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Otra información");
                for (DatosPro data : lista) {
//                    String titulo = data.getTitle() != null && !data.getTitle().isEmpty() ? data.getTitle().get(0) : "N/A";
//                    String pais = data.getCountry() != null && !data.getCountry().isEmpty() ? data.getCountry().get(0) : "N/A";
//                    String grupo = data.getGroup_type() != null && !data.getGroup_type().isEmpty() ? data.getGroup_type().get(0) : "N/A";
//                    String otraInfo = data.getOther_information() != null && !data.getOther_information().isEmpty() ? data.getOther_information().get(0) : "N/A";
//
//                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, titulo);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, grupo);
//                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, otraInfo);
                }
            } else {
                agregarHeaderTablaListaNoExistente(page, "PRO - PROCURADURÍA GENERAL DE LA NACIÓN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaTSTI(PDPage page, List<DatosTsti> lista) {
        try {

            if (lista != null && !lista.isEmpty()) {
                agregarHeaderTablaListaExistente(page, "CONGLOMERADO DE LISTAS");
                float divisionCeldas = 16f;
                float cantColumnas = 4;

                //Encabezado tabla consultas
                Row< PDPage> factHeaderrow = table.createRow(12f);
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Nombres");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Lista");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "País");
                agregarCampoHeaderBodyTabla(page, factHeaderrow, divisionCeldas, cantColumnas, "Detalle");
                for (DatosTsti data : lista) {
                    String nombres = data.getNombre_apellido() != null && !data.getNombre_apellido().isEmpty() ? data.getNombre_apellido().get(0) : "N/A";
                    String listaT = data.getNombre_relacion_lista() != null && !data.getNombre_relacion_lista().isEmpty() ? data.getNombre_relacion_lista().get(0) : "N/A";
                    String pais = data.getPais() != null && !data.getPais().isEmpty() ? data.getPais().get(0) : "N/A";
                    String detalle = data.getDetalle() != null && !data.getDetalle().isEmpty() ? data.getDetalle().get(0) : "N/A";

                    Row< PDPage> factHeaderrowTemp = table.createRow(1f);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, nombres);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, listaT);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, pais);
                    agregarCampoBodyTabla(page, factHeaderrowTemp, divisionCeldas, cantColumnas, detalle);
                }
            } else {
                agregarHeaderTablaListaNoExistente(page, "CONGLOMERADO DE LISTAS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarHeaderTablaListaNoExistente(PDPage page, String lista) {
        try {
            PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
            float fontSizeTabla = 4;
            Color colorHeaderTabla = new Color(226, 37, 32);

            Row< PDPage> factHeaderrow = table.createRow(12f);
            Cell<PDPage> cell = factHeaderrow.createCell((100 / 3f) * 2, lista);
            cell.setFont(fontTitulo);
            cell.setFontSize(fontSizeTabla);
            cell.setFillColor(colorHeaderTabla);
            cell.setTextColor(Color.white);

            cell = factHeaderrow.createCell((100 / 3f), "NO SE ENCONTRÓ COINCIDENCIAS");
            cell.setFont(fontTitulo);
            cell.setFontSize(fontSizeTabla);
            cell.setFillColor(colorHeaderTabla);
            cell.setTextColor(Color.white);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void agregarHeaderTablaListaExistente(PDPage page, String lista) {
        try {
            PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
            float fontSizeTabla = 4;
            Color colorHeaderTabla = new Color(226, 37, 32);

            Row< PDPage> factHeaderrow = table.createRow(12f);
            Cell<PDPage> cell = factHeaderrow.createCell(100, lista);
            cell.setFont(fontTitulo);
            cell.setFontSize(fontSizeTabla);
            cell.setFillColor(colorHeaderTabla);
            cell.setTextColor(Color.white);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarCampoHeaderBodyTabla(PDPage page, Row<PDPage> factHeaderrow, float divisionCeldas, float cantColumnas, String texto) {
        try {
            PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
            Color colorHeaderTabla = new Color(230, 138, 123);
            float fontSizeTabla = 4;
            Cell<PDPage> cell = factHeaderrow.createCell((100 / divisionCeldas) * cantColumnas, texto);
            cell.setFont(fontTitulo);
            cell.setFontSize(fontSizeTabla);
            cell.setFillColor(colorHeaderTabla);
            cell.setTextColor(Color.white);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarCampoBodyTabla(PDPage page, Row<PDPage> factHeaderrow, float divisionCeldas, float cantColumnas, String texto) {
        try {
            PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
            Color colorBodyTabla = new Color(221, 216, 204);
            float fontSizeTabla = 4;
            Cell<PDPage> cell = factHeaderrow.createCell((100 / divisionCeldas) * cantColumnas, texto);
            cell.setFont(fontTitulo);
            cell.setFontSize(fontSizeTabla);
            cell.setFillColor(colorBodyTabla);
            cell.setTextColor(Color.BLACK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String seEncuentraEnLista(ResponseResult response) {
        if (response.getDatos_sdn() != null && !response.getDatos_sdn().isEmpty()) {
            return "SI";
        }
        if (response.getDatos_ban() != null && !response.getDatos_ban().isEmpty()) {
            return "SI";
        }
        if (response.getDatos_bis() != null && !response.getDatos_bis().isEmpty()) {
            return "SI";
        }
        if (response.getDatos_eul() != null && !response.getDatos_eul().isEmpty()) {
            return "SI";
        }
        if (response.getDatos_hmt() != null && !response.getDatos_hmt().isEmpty()) {
            return "SI";
        }
        if (response.getDatos_pro() != null && !response.getDatos_pro().isEmpty()) {
            return "SI";
        }
        return "NO";
    }

     */
}
