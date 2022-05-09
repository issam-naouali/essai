package com.esprit.essaii.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class RessourceDuplicated extends Exception {
	
	public RessourceDuplicated(String message) {
		super(message);
	}

}
