package com.convertPdfToWordService;

import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

import io.micronaut.http.multipart.CompletedFileUpload;
import jakarta.inject.Singleton;

import org.apache.poi.xwpf.extractor.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.*;
@Singleton
public class PDFConverter implements ServiceInterface {

    public static void main(String[] args) throws Exception {

        // Load the PDF file
        PDDocument document = PDDocument.load(new File("C:\\Users\\DELL\\Desktop\\IR DOC\\all documents for OCR\\Sample Documents\\Analyst Data\\Biocon\\Axis Capital\\Q1FY22 Result Note.pdf"));
    
        // Create a new Word document
        XWPFDocument doc = new XWPFDocument();

        // Extract the text from the PDF
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);

        // Create a new paragraph in the Word document and add the text
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);

        // Save the Word document
        String home = System.getProperty("user.home");
        FileOutputStream fos = new FileOutputStream(home + "/Downloads/"+"file.doc");
        doc.write(fos);
        fos.close();

        // Close the PDF document
        document.close();
        System.out.println("File converted from pdf to Doc Successfully......................................");
    }

	@Override
	public String PdftoDoc(CompletedFileUpload file) throws IOException {
		  // Load the PDF file
		String filename=file.getFilename();
		byte[] filedata=file.getBytes();
        PDDocument document = PDDocument.load(filedata);
    
        // Create a new Word document
        XWPFDocument doc = new XWPFDocument();

        // Extract the text from the PDF
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);

        // Create a new paragraph in the Word document and add the text
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);

        // Save the Word document
        String home = System.getProperty("user.home");
        FileOutputStream fos = new FileOutputStream(home + "/Downloads/"+filename+".doc");
        doc.write(fos);
        fos.close();

        // Close the PDF document
        document.close();
        System.out.println("File converted from pdf to Doc Successfully......................................");
    
		return "File converted from pdf to Doc Successfully......................................";
	}
}
