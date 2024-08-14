package com.unipi.software.tech.ClipCritique.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidCredentialsException extends RuntimeException {

    private final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;


    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *                method.
     */
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
