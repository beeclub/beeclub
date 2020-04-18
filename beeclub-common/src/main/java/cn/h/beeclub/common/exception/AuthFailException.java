package cn.h.beeclub.common.exception;

public class AuthFailException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3184748451641397503L;

	public AuthFailException() {
		super();
	}
	
	public AuthFailException(String message) {
		super(message);
	}
}
