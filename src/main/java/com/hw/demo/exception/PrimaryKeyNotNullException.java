package com.hw.demo.exception;


import java.io.Serial;

public class PrimaryKeyNotNullException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -5375851972392843455L;

    public PrimaryKeyNotNullException(String message) {
        super(message);
    }

    public PrimaryKeyNotNullException(int code, String message) {
        super(code, message);
    }
}
