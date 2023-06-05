package com.ssan.api16san.exceptions;

import org.mapstruct.control.MappingControl;

public class UserBanException extends RuntimeException {
    public UserBanException(String message) {
        super(message);
    }

    public UserBanException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
