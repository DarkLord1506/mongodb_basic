package com.test.mongo_atlas.exception_handler;

import com.test.mongo_atlas.exceptions.MongoException;
import com.test.mongo_atlas.model.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MongoException.class)
    public ResponseEntity<ExceptionResponse> handleMongoException(MongoException mongoException) {
        log.info("[handleMongoException] Handling mongo exception ");
        ExceptionResponse response = new ExceptionResponse(mongoException.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, response.getStatus());
    }

}
