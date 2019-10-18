package com.cp.microservices.api.exception;

public enum ApiError {

 	// Project Errors
	ERROR_1001("1001", "Project not found");
	
	private String errorCode;
	private String errorMessage;
	
	ApiError(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
