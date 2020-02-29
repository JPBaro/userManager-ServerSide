package com.jpbtech.webappservice.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {

	/**
	 * @ResponseStatus (value= HttpStatus.NOT_FOUND) public class ItemNotFound
	 *                 extends RuntimeException
	 * 
	 *                 ----Pending to check why i have to include
	 *                 serilVersionUID to avoid warning JP
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionDescription;
	private Object fieldDetail;

	public ItemNotFoundException(String exceptionDescription,String fieldDetail) {

		super(exceptionDescription + "- !!Oh my Godness :-) ! - "
				+ fieldDetail);
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