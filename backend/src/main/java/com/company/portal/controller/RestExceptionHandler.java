package com.company.portal.controller;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String,String>> badRequest(Exception ex) { return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage())); }
}
