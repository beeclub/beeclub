package cn.h.beeclub.core.exception;

public class UnauthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7685154170617999096L;

	public UnauthorizedException(String message) {
		super(message);
	}
	
	public UnauthorizedException() {
		super();
	}
		
}
