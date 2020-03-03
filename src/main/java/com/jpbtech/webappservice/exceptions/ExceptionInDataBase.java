package com.jpbtech.webappservice.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceptionInDataBase extends Exception {

	
	private static final long serialVersionUID = 1L;
	private String fieldDetail;
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
