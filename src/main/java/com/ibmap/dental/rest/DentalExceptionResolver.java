package com.ibmap.dental.rest;

import com.ibmap.dental.application.exception.DentalException;
import com.ibmap.dental.application.exception.ErrorDetails;
import com.ibmap.dental.application.exception.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * Defines the exception handlers responsible for transforming an exception to a REST resource.
 *
 * @author ibalde
 * @version 1.0.0
 * @since  1.0.0
 */
@Slf4j
@ControllerAdvice
public class DentalExceptionResolver extends ResponseEntityExceptionHandler {

    /**
     * Handle {@link DentalException} and convert it to error resource.
     *
     * @param ex the exception.
     * @return the error resource response.
     */
    @ExceptionHandler(DentalException.class)
    public ResponseEntity<ErrorDetails> handle(DentalException ex, WebRequest request) {
        ErrorDetails errorDetails = getErrorDetails(ex, ex.getStatus(), (ServletWebRequest) request);
        return new ResponseEntity<>(errorDetails, ex.getStatus());
    }

    /**
     * Handle {@link Exception} and convert it to error resource.
     *
     * @param ex the exception.
     * @return the error resource response.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handle(Exception ex, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDetails errorDetails = getErrorDetails(ex, httpStatus, (ServletWebRequest) request);
        return new ResponseEntity<>(errorDetails, httpStatus);
    }

    /**
     * Handle {@link MethodArgumentNotValidException} and convert it to error resource.
     *
     * @param ex the exception.
     * @return the error resource response.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ErrorDetails errorDetails = getErrorDetails(ex, status, (ServletWebRequest) request);

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach((FieldError fe) -> {
            List<ValidationError> validationErrorsList = errorDetails.getValidationErrors().get(fe.getField());
            if (Objects.isNull(validationErrorsList)) {
                validationErrorsList = new ArrayList<>();
                errorDetails.getValidationErrors().put(fe.getField(), validationErrorsList);
            }
            ValidationError validationError =
                    ValidationError.builder().code(fe.getCode()).message(fe.getDefaultMessage()).build();
            validationErrorsList.add(validationError);
        });
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    private ErrorDetails getErrorDetails(Exception ex, HttpStatus status, ServletWebRequest request) {
        String requestPath = request.getRequest().getRequestURI().toString();
        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(status.value())
                .message(ex.getMessage())
                .path(requestPath)
                .build();
        return errorDetails;
    }
}
