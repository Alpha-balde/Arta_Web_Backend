package com.ibmap.dental.application.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorDetails {
    private final LocalDateTime date = LocalDateTime.now();
    private int status;
    private String message;
    private String path;
    private Map<String, List<ValidationError>> validationErrors = new HashMap<>();

}
