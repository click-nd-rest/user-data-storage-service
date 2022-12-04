package com.github.click.nd.rest.uds.exception;

public class UserDataServiceException extends Exception{
    public UserDataServiceException() {
        super();
    }

    public UserDataServiceException(String message) {
        super(message);
    }

    public UserDataServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDataServiceException(Throwable cause) {
        super(cause);
    }
}
