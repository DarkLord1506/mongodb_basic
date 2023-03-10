package com.test.mongo_atlas.exceptions;

public class MongoException extends RuntimeException {

    public MongoException() {
        super();
    }

    public MongoException(String message) {
        super(message);
    }

    public MongoException(String message, Throwable cause) {
        super(message, cause);
    }
}
