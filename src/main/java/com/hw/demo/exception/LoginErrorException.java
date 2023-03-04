package com.hw.demo.exception;

import java.io.Serial;

public class LoginErrorException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -7920880860210685851L;

    public LoginErrorException(String message) {
        super(message);
    }

    public LoginErrorException(int code, String message) {
        super(code, message);
    }
}
