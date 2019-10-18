package com.cp.microservices.api.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorInfo {
	private static final Long serialVersionUID = 1L;
	ErrorType errorType;
	String errorCode;
	String errorMessage;
	
	public ErrorInfo() {}	
	
}
