package com.cp.microservices.api.common;

public enum ErrorType {

	SYSTEM_ERROR, APP_ERROR, USER_ERROR;

	ErrorType() {
	}

	public String value() {
		return this.name();
	}

	public static ErrorType fromValue(String v) {
		return valueOf(v);
	}

}
