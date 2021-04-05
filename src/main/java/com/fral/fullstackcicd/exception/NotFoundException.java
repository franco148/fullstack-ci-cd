package com.fral.fullstackcicd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    /**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -1296058072185823946L;

	public NotFoundException(String msg) {
        super(msg);
    }
}
