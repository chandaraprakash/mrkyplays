package com.cp.microservices.api.common;

public class ApiUtil {
	
	public static Status createErrorInfo(String errorMessage, String errorCode, ErrorType errorType) {
		Status status = new Status();
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		errorInfo.setErrorType(errorType);
		
		status.setStatusMessage("API_ERROR");
		status.getErrorInfo().add(errorInfo);
		
		return status;
	}
}
