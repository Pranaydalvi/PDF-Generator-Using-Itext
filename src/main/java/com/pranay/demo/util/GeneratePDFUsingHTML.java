package com.pranay.demo.util;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class GeneratePDFUsingHTML {

	    public static void main(String[] args) throws IOException {

	        HtmlConverter.convertToPdf(new File("src/main/resources/templates/purchase.html"),
	                new File("output/purchase-html.pdf"));
	    }
	}