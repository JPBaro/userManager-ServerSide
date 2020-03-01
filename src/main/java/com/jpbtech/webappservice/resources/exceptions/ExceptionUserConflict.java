package com.jpbtech.webappservice.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceptionUserConflict extends ExceptionInDataBase {

	
	private static final long serialVersionUID = 1L;
	public ExceptionUserConflict(Date timestamp, String exceptionDescription,String fieldDetail) {
		super(timestamp, exceptionDescription, fieldDetail);
		
	}
	
	

}
