package com.convertPdfToWordController;

import java.io.IOException;

import com.convertPdfToWordService.ServiceInterface;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;
import jakarta.inject.Inject;

@Controller
public class ptwController {
	
@Inject
ServiceInterface serviceinerface;

@Post(uri="/upload",consumes=MediaType.MULTIPART_FORM_DATA , produces = MediaType.TEXT_PLAIN)
public String covertpdf(@PathVariable("file")  CompletedFileUpload file) throws IOException
{
	return this.serviceinerface.PdftoDoc(file);
}
}