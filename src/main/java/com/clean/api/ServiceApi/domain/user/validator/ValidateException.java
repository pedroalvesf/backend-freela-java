package com.clean.api.ServiceApi.domain.user.validator;

public class ValidateException extends RuntimeException{
    public ValidateException(String message) {
        super(message);
    }
}
