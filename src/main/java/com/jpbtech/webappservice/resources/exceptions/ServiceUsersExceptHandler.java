package com.jpbtech.webappservice.resources.exceptions;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ServiceUsersExceptHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ErrorResponse> handleConstraintViolation(
                                            ConstraintViolationException ex,
                                            WebRequest request)
    {
        List<String> details = ex.getConstraintViolations()
                                    .parallelStream()
                                    .map(e -> e.getMessage())
                                    .collect(Collectors.toList());
 
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
	//@ExceptionHandler(ExceptionInDataBase.class)
    //public final ResponseEntity<ErrorResponse> handleDBExceptionViolation(
    	//					ExceptionInDataBase ex, WebRequest request)
   // {
		 //List<String> details = new ArrayList<>();
		 //details.add(ex.)
			
			
		//};
 
        //ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT, details);
        
        //return new ResponseEntity<>(error, HttpStatus.CONFLICT);
   // }
	
//	  @ExceptionHandler(ExceptionUserConflict.class) public final
//	  ResponseEntity<ErrorDetails> ExceptionUserConflict(ExceptionUserConflict
//	  ex, WebRequest request) { ErrorDetails errorDetails = new
//	  ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//	  return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT); }

}	 

