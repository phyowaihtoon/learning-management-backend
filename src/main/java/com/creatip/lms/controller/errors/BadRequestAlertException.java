package com.creatip.lms.controller.errors;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public class BadRequestAlertException extends ErrorResponseException {
    private static final long serialVersionUID = 1L;

    private final String entityName;

    private final String errorKey;

    public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
    }

    public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
        super(HttpStatus.BAD_REQUEST, asProblemDetail(type, defaultMessage, entityName, errorKey), null);
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    private static ProblemDetail asProblemDetail(URI type, String defaultMessage, String entityName, String errorKey) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, defaultMessage);
        problemDetail.setType(type);
        problemDetail.setTitle("Bad Request");
        problemDetail.setProperty("message", "error." + errorKey);
        problemDetail.setProperty("params", entityName);
        return problemDetail;
    }
}
