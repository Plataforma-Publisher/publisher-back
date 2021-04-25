package com.platformpublisher.handler;

import com.platformpublisher.exception.BadRequestException;
import com.platformpublisher.exception.BadRequestExceptionDetails;
import com.platformpublisher.exception.ValidationExceptionDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice @Log4j2
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(
            BadRequestException exception, HttpServletRequest servletRequest){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                    .title("Bad request exception")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .details(exception.getMessage())
                    .message(exception.getClass().getName())
                    .timestamp(LocalDateTime.now())
                    .path(servletRequest.getRequestURI())
                    .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception, HttpServletRequest servletRequest){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream()
                .map(FieldError::getField).collect(Collectors.joining(", "));

        String fieldsMessage = fieldErrors.stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
             ValidationExceptionDetails.builder()
                    .title("Bad request exception, invalid fields")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .details("Check the field(s) erro(s)")
                    .message(exception.getClass().getName())
                    .timestamp(LocalDateTime.now())
                    .path(servletRequest.getRequestURI())
                    .fields(fields)
                    .fieldsMessage(fieldsMessage)
                    .build(), HttpStatus.BAD_REQUEST);
    }
}
