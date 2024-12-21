package com.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimeSheetException extends Exception {
	public TimeSheetException(String message){
		super(message);
	}
}
