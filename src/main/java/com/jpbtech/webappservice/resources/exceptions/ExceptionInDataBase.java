package com.jpbtech.webappservice.resources.exceptions;

import java.util.Date;


public class ExceptionInDataBase extends RuntimeException{

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
