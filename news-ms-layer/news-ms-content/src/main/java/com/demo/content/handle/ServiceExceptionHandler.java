package com.demo.content.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.web.ResponseMessage;

/**
 * Service Exception handler
 * 
 * @author Larry_lee
 * @since 2020-07-05
 */
@ControllerAdvice
public class ServiceExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseMessage<String> exceptionHandler(Exception e) {
		return ResponseMessage.error(e.getMessage());
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseMessage<String> runtimeExceptionHandler(RuntimeException e) {
		return ResponseMessage.error(e.getMessage());
	}
	
}