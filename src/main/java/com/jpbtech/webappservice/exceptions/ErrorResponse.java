package com.jpbtech.webappservice.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse
{
    private HttpStatus status;
    private String message;
    private List<String> details;


	public ErrorResponse(HttpStatus status, List<String> details) {
        super();
        this.status = status;
        this.details = details;
    }
 
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public List<String> getDetails() {
        return details;
    }
 
    public void setDetails(List<String> details) {
        this.details = details;
    }
}