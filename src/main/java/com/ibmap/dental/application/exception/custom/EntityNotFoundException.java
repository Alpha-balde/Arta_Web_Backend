package com.ibmap.dental.application.exception.custom;

import com.ibmap.dental.application.exception.DentalException;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends DentalException {
    public EntityNotFoundException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
