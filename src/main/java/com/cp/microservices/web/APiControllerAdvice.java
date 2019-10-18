package com.cp.microservices.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cp.microservices.api.common.ApiUtil;
import com.cp.microservices.api.common.ErrorType;
import com.cp.microservices.api.common.Status;
import com.cp.microservices.api.exception.ProjectNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class APiControllerAdvice {
	
	@ExceptionHandler(ProjectNotFoundException.class)
	ResponseEntity<Status> projectNotFoundException(HttpServletRequest req, ProjectNotFoundException e) {
		return error(req, ApiUtil.createErrorInfo(e.getErrorMessage(), e.getErrorCode(), ErrorType.APP_ERROR), HttpStatus.BAD_REQUEST);
	}
	
	private <E extends Status> ResponseEntity<E> error(HttpServletRequest req, E e, HttpStatus httpStatus) {
		HttpHeaders headers = new HttpHeaders();
		String contentType = req.getHeader("Content-Type");
		if (contentType != null && contentType.contentEquals("application/xml")) {
			headers.setContentType(MediaType.APPLICATION_XML);
		} else {
			headers.setContentType(MediaType.APPLICATION_JSON);
		}
		return new ResponseEntity<>(e, headers, httpStatus);
	}

}
