package cn.h.beeclub.core.exception;

/**
 *
 */
public class NoAuthException extends RuntimeException {
    private static final long serialVersionUID = -7114277916379742675L;

    public NoAuthException(){
        super();
    }
    public NoAuthException(String message){
        super(message);
    }
}
