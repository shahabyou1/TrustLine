package com.ripple.trustline.domain;
import org.springframework.http.*;

public enum TrustLineStatusException {


    OK            (HttpStatus.OK,    ""),
    EMPTY_REQUEST       (HttpStatus.BAD_REQUEST, "The Request is empty"),
    INVALID_JSON_PAYLOAD(HttpStatus.BAD_REQUEST, "Invalid JSON body"),
    USER_EXIST        (HttpStatus.BAD_REQUEST, "user is already registered for this trustline."),
    TL_USER_NOT_EXIST        (HttpStatus.NOT_FOUND, "trust line user not registered."),
    NO_SEARCH_RESULT          (HttpStatus.NOT_FOUND, "No Search Result Found");

    private final HttpStatus httpStatus;
    private final String messageKey;

    TrustLineStatusException(HttpStatus httpStatus, String messageKey) {
        this.httpStatus = httpStatus;
        this.messageKey = messageKey;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getMessage() {
        return messageKey;
    }

}
