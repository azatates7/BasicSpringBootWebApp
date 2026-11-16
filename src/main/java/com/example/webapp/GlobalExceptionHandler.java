package com.example.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle 404 Not Found
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> notFound(NoResourceFoundException e) {
        log.warn("Not found: {}", e.getResourcePath());
        return ResponseEntity.status(404).body("Not found");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
        log.error("Unhandled exception", e);
        return ResponseEntity.status(500).body("Internal error");
    }
}