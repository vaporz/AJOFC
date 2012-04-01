package org.jofc.exception;

public class TypeMismatchException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -3959543567581063570L;

    public TypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeMismatchException(String message) {
        super(message);
    }
}
