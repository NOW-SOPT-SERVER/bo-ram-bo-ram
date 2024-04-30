package sopt.cloneCoding.carrot.domain.common;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
    HttpStatus statusCode;
    String responseMessage;

    public NotFoundException(HttpStatus statusCode, String responseMessage) {
        super(responseMessage);
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
    }
}
