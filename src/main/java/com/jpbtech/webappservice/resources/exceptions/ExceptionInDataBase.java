package com.jpbtech.webappservice.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceptionInDataBase extends Exception {

	
	private static final long serialVersionUID = 1L;
	private String exceptionDescription;
	private String fieldDetail;
	private Date timestamp;
	
	public ExceptionInDataBase(Date timestamp, String exceptionDescription, String fieldDetail) {
				
		super();
		this.timestamp = timestamp;
		this.exceptionDescription = exceptionDescription;
		this.fieldDetail = fieldDetail;
	}
	
	public String getExceptionDetail() {
		return exceptionDescription;
		}
	
	public String getFieldValue() {
		return fieldDetail;
		}

	public Date getTimestamp() {
		return timestamp;
	}
	
	

}
