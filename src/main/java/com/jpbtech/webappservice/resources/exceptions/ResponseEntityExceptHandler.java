package com.jpbtech.webappservice.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseEntityExceptHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ExceptionUserConflict.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ExceptionUserConflict ex,
							WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
								request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ExceptionInDataBase.class)
	public final ResponseEntity<ExceptionInDataBase> handleAllExceptions(Exception ex,
							WebRequest request) {
		ExceptionInDataBase exceptionResponse = new ExceptionInDataBase(new Date(), ex.getMessage(),
								request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public class ErrorDetails {

		private Date timestamp;
		private String errorDescription;
		private String errorDetails;

		public ErrorDetails(Date timestamp, String errorDescription, String errorDetails) {
			super();
			this.timestamp = timestamp;
			this.errorDescription = errorDescription;
			this.errorDetails = errorDetails;
		}

	}
}
