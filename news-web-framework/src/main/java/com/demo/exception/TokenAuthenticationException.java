package com.demo.exception;

/**
 * token Authentication exception
 * @author Larry_lee
 * @since 2020-07-04
 */
public class TokenAuthenticationException extends RuntimeException {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
		 * Constructs  with the specified message and root
		 * cause.
		 *
		 * @param msg the detail message
		 * @param t the root cause
		 */
		public TokenAuthenticationException(String msg, Throwable t) {
			super(msg, t);
		}

		/**
		 * Constructs with the specified message and no
		 * root cause.
		 *
		 * @param msg the detail message
		 */
		public TokenAuthenticationException(String msg) {
			super(msg);
		}
}
