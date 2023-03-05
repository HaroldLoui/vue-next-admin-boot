package com.hw.demo.exception;


import java.io.Serial;

public class PrimaryKeyNotNullException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -5375851972392843455L;

    public static final String DEFAULT_MESSAGE = "id不能为空";

    public PrimaryKeyNotNullException() {
        this(DEFAULT_MESSAGE);
    }

    public PrimaryKeyNotNullException(String message) {
        super(message);
    }

    public PrimaryKeyNotNullException(int code, String message) {
        super(code, message);
    }
}
