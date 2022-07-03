package com.example.geektrust.exception;

/**
 * @author Vishal Malviya
 */
public class CustomExceptionHandler extends RuntimeException {
    private static final long serialVersionUID = -195666378282613819L;

    /**
     * No Args Constructor
     */
    public CustomExceptionHandler() {
        super();
    }

    /**
     * @param message
     */
    public CustomExceptionHandler(String message) {
        super(message);
    }

}
