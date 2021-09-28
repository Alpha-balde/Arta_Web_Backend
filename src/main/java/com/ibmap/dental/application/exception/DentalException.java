package com.ibmap.dental.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DentalException extends ResponseStatusException {

    public DentalException(HttpStatus status) {
        super(status);
    }

    public DentalException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public DentalException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public DentalException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
