package com.cp.microservices.api.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Status implements Serializable {
	private static final Long serialVersionUID = 1L;
	
	String statusMessage;
	List<ErrorInfo> errorInfo;
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<ErrorInfo> getErrorInfo() {
		if (this.errorInfo == null) {
			this.errorInfo = new ArrayList<>();
		}
		return this.errorInfo;
	}
}
