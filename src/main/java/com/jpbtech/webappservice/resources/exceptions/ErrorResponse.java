package com.jpbtech.webappservice.resources.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse
{
    private HttpStatus status;

	public ErrorResponse(HttpStatus status, List<String> details) {
        super();
        this.status = status;
        this.details = details;
    }
  
    private String message;
    private List<String> details;
 
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