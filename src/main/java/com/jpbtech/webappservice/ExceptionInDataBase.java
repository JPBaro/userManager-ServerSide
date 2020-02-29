package com.jpbtech.webappservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value= HttpStatus.CONFLICT)
public class ExceptionInDataBase extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String exceptionDescription;
	private Object fieldDetail;
	
	public ExceptionInDataBase(String exceptionDescription, String fieldDetail) {
		
		super(exceptionDescription+"- oh NOOO ! - "+fieldDetail);
		this.exceptionDescription = exceptionDescription;
		this.fieldDetail = fieldDetail;
	}
	
	public String getExceptionDetail() {
		return exceptionDescription;
		}
	
	public Object getFieldValue() {
		return fieldDetail;
		}
	
	

}