package cn.h.beeclub.common.exception;

import lombok.Data;

/**
 * 业务错误
 */
@Data
public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7539675919207772611L;
	private int code = -1;
	private Object data;

	public BusinessException() {
		super();
	}

	public BusinessException(int code) {
		super();
		this.code = code;
	}

	public BusinessException(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	
	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(int code,String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(int code,Object data,String message) {
		super(message);
		this.code = code;
		this.data = data;
	}

}
