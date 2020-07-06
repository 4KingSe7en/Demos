package com.demo.web;

import java.io.Serializable;

/**
 * Response bode 
 * @author Larry_lee
 * @since 2020-07-04
 *
 */
public class ResponseMessage<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected String message;

    protected T result;

    private Long timestamp;

    private int code;
    
    public static <T> ResponseMessage<T> error(String message) {
        return error(500, message);
    }

    public static <T> ResponseMessage<T> error(int code, String message) {
    	ResponseMessage<T> msg = new ResponseMessage<>();
        msg.message = message;
        msg.code = code;
        msg.timestamp = System.currentTimeMillis();
        return msg;
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }

    public static <T> ResponseMessage<T> ok(T result) {
    	
    	ResponseMessage<T> msg = new ResponseMessage<>();
        msg.code = 200;
        msg.timestamp = System.currentTimeMillis();
        msg.result = result;
        return msg;
    }

    public ResponseMessage<T> result(T result) {
        this.result = result;
        return this;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", result=" + result + ", timestamp=" + timestamp + ", code="
				+ code + "]";
	}
	
}
