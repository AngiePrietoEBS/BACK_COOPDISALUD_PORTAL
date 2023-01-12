/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Administrador
 */
public class GenerarPDFServiceBean {

    public static final Font FONT_NORMAL = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
    public static final Font BLACK_BOLD = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
    public static final Font ITALIC = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC, new BaseColor(141, 141, 141));
    public static final Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, new BaseColor(84, 136, 90));
    public static final Font font_BOLD = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(84, 136, 90));
    public static final Font FONT_BOLD = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, new BaseColor(41, 108, 48));
    public static final String RUTA_RETEFUENTE = "D:\\cooperagro\\Retencion\\";

    public void item(Document document, String linea, String saldo) throws DocumentException {
        PdfPTable table;
        PdfPCell cellL;
        PdfPCell cellR;
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
        table = new PdfPTable(5);
        cellL = new PdfPCell(new Phrase(linea.toUpperCase(), font));
        cellL.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellL.setColspan(4);
        cellL.setBorder(Rectangle.NO_BORDER);

        cellR = new PdfPCell(new Phrase("$ " + saldo, font));

        cellR.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellR.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellL);
        table.addCell(cellR);
        table.setSpacingBefore(5);
        table.setWidthPercentage(100);
        document.add(table);
    }

    public void itemBackgroud(Document document, String linea, String saldo) throws DocumentException {

        PdfPTable table;
        PdfPCell cellL;
        PdfPCell cellR;
        Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
        table = new PdfPTable(5);
        cellL = new PdfPCell(new Phrase(linea.toUpperCase(), font2));
        cellL.setBackgroundColor(new BaseColor(84, 136, 90));
        cellL.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellL.setColspan(4);
        cellL.setPaddingTop(5);
        cellL.setPaddingLeft(8);
        cellL.setPaddingBottom(8);
        cellL.setBorder(Rectangle.NO_BORDER);

        cellR = new PdfPCell(new Phrase("$ " + saldo, font2));
        cellR.setBackgroundColor(new BaseColor(84, 136, 90));
        cellR.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellR.setBorder(Rectangle.NO_BORDER);
        cellR.setPaddingTop(5);
        cellR.setPaddingRight(8);
        cellR.setPaddingBottom(8);
        table.addCell(cellL);
        table.addCell(cellR);
        table.setSpacingBefore(5);
        table.setWidthPercentage(100);
        document.add(table);
    }
}
