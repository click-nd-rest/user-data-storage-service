package com.github.click.nd.rest.uds.exception.handler;

import com.github.click.nd.rest.uds.exception.UserDataServiceException;
import com.github.click.nd.rest.uds.to.response.common.ErrorCommonTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserDataServiceExceptionHandler {

    @ExceptionHandler(UserDataServiceException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorCommonTO handleCommonException(UserDataServiceException exception) {
        return new ErrorCommonTO()
                .setMessage(exception.getMessage());
    }
}
