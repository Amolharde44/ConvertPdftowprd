package com.convertPdfToWordService;

import java.io.IOException;

import io.micronaut.http.multipart.CompletedFileUpload;

public interface ServiceInterface {
	
public	String PdftoDoc(CompletedFileUpload file) throws IOException;

}
