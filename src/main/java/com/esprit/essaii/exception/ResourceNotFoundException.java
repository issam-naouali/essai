package com.esprit.essaii.exception;


import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//la statut(not found) de la requete qui va etre retourné
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);
    }
}
