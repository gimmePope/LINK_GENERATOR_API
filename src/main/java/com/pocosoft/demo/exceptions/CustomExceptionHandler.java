package com.pocosoft.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Component
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public final ResponseEntity<Object> handleCompanyNotFoundException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		       return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleCustomerNotFoundException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		       return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvoiceNotFoundException.class)
	public final ResponseEntity<Object> handleInvoiceNotFoundException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		       return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		       return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
