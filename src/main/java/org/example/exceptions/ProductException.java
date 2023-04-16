package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Product Not Found")
public class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}
