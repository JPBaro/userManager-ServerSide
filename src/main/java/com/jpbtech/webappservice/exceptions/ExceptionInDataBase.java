package com.jpbtech.webappservice.exceptions;

import java.util.ArrayList;
import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceptionInDataBase extends Exception {

	
	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private ArrayList<String> details;
	
	public ExceptionInDataBase(String fieldDetail) {
				
		super();
		this.details.add(fieldDetail);
		this.details.add( timestamp.toString() );
	}
	
	public ArrayList<String> getAlldetails() {
				
		return details;
								
		}

	
	

}
