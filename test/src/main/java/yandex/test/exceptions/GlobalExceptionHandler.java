package yandex.test.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PostDelResponse> catchRunTimeException(IllegalStateException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PostDelResponse> cacthHttpMessageNotReadableException (HttpMessageNotReadableException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PostDelResponse> cacthMethodArgumentNotValidException (MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PostDelResponse> cacthHttpMediaTypeNotSupportedException (HttpMediaTypeNotSupportedException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PostDelResponse> catchNoSuchElementException (NoSuchElementException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.NOT_FOUND.value(), "Item not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PostDelResponse> catchPSQLException (PSQLException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed"), HttpStatus.BAD_REQUEST);
    }

}
