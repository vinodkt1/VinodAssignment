/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.validation;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.topcoder.assignment.model.Incoming;
import com.topcoder.assignment.response.APIResponse;
import com.topcoder.assignment.response.ErrorAPIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

/**
 * @author Vinod
 * This ControllerAdvice is used to Exception handling and validation for incoming data.
 */

@RestControllerAdvice
public class ControllerAdvice {

    /**
     * This method will handle Exceptions of type InvalidFormatException
     * @param e Exception
     * @return Response to incoming request
     */
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorAPIResponse> invalidFormatException(final InvalidFormatException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method will handle Exceptions of type InvalidFormatException
     * @param e Exception
     * @return Response to incoming request
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorAPIResponse> illegalArgumentException(final IllegalArgumentException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method creates a customised ErrorAPIResponse
     * @param exception that is thrown
     * @param httpStatus status of the http response
     * @return Response to incoming request
     */
    private ResponseEntity <ErrorAPIResponse> error(final Exception exception, final HttpStatus httpStatus) {
        final String detailedErrorMessage = Optional.ofNullable(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        final int beginIndex = detailedErrorMessage.indexOf(Incoming.class.getSimpleName()) + Incoming.class.getSimpleName().length() + 2;
        final String errorField = detailedErrorMessage.substring(beginIndex, detailedErrorMessage.indexOf("\"", beginIndex));;
        final String customErrorMessage = errorField + " field has invalid data.";
        ErrorAPIResponse errorAPIResponse = new ErrorAPIResponse();
        errorAPIResponse.setStatus(httpStatus.value());
        errorAPIResponse.setMessage(httpStatus.getReasonPhrase());
        errorAPIResponse.setError(customErrorMessage);
        errorAPIResponse.setDetailedErrorMessage(detailedErrorMessage);
        return new ResponseEntity(errorAPIResponse, httpStatus);
    }
}

