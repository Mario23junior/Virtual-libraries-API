package com.api.library.Handlererro;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.api.library.exceptions.ReturnErroFindNotFound;
import com.api.library.modelErroResponse.modelErroReturn;

@RestControllerAdvice
public class ErroHandlerCustom {
    
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ReturnErroFindNotFound.class)
	public modelErroReturn returnErroCustom(ReturnErroFindNotFound ex, WebRequest request) {
		modelErroReturn error = new modelErroReturn(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
				return error;	
	}
	
	  @ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public modelErroReturn globalExceptionHandler(Exception ex, WebRequest request) {
		modelErroReturn message = new modelErroReturn(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return message;
	  }
}
