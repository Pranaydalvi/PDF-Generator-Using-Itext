package com.pranay.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.pranay.demo.entity.Purchase;
import com.pranay.demo.util.PurchaseHelper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/purchases")
public class PDFController {

    @Autowired
    ServletContext servletContext;

    private final TemplateEngine templateEngine;

    public PDFController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @RequestMapping(path = "/")
    public String getPurchasePage(Model model) {
        Purchase purchase = PurchaseHelper.getPurchase();
        model.addAttribute("purchaseEntry", purchase);
        return "purchase";
    }

    @RequestMapping(path = "/pdf")
    public ResponseEntity<?> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Purchase purchase = PurchaseHelper.getPurchase();

        WebContext context = new WebContext(request, response, servletContext);
        context.setVariable("purchaseEntry", purchase);
        String purchaseHtml = templateEngine.process("purchase", context);

        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri("http://localhost:8088");
        HtmlConverter.convertToPdf(purchaseHtml, target, converterProperties);

        byte[] bytes = target.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=purchase.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);
    }
}