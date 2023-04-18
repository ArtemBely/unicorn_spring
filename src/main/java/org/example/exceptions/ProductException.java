package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not compatible type of filter")
public class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}
