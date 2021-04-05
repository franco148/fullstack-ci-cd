package com.fral.fullstackcicd.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    /**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
        super(msg);
    }
}
