package com.pranay.demo.util;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class GeneratePDF {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("purchase_report.pdf",
                new WriterProperties().addUAXmpMetadata().setPdfVersion(PdfVersion.PDF_1_7)));
        Document document = new Document(pdfDoc, PageSize.A4.rotate());
        pdfDoc.getCatalog().setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));
        pdfDoc.getCatalog().setLang(new PdfString("en-IN"));
        pdfDoc.getDocumentInfo().setTitle("Purchase Report");

        Paragraph p = new Paragraph();
        p.setFontSize(18);
        p.add("Purchase Report");

        Image img = new Image(ImageDataFactory.create("logo.jpg"));
        img.getAccessibilityProperties().setAlternateDescription("Company Logo");
        p.add(img);

        document.add(p);

        Table table = new Table(4);
        table.setWidth(UnitValue.createPercentValue(100));
        table.addHeaderCell("Product");
        table.addHeaderCell("Quantity");
        table.addHeaderCell("Unit Price");
        table.addHeaderCell("Total");
        table.addCell("Laptop");
        table.addCell("1");
        table.addCell("1200.00");
        table.addCell("1200.00");
        table.addCell("Mouse");
        table.addCell("2");
        table.addCell("25.00");
        table.addCell("50.00");

        document.add(table);
        document.close();
    }
}