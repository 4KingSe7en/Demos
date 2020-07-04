package com.demo.exception;

/**
 * customer exception
 * @author Larry_lee
 * @since 2020-07-04
 */
public class NewsException extends RuntimeException{
	

	public NewsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NewsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NewsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NewsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
