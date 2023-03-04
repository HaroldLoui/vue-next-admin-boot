package com.hw.demo.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Getter
public final class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6886028689512845258L;

    private final int code;

    private final String msg;

    private final T data;

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> ok(String msg) {
        return new Result<>(HttpStatus.OK.value(), msg, null);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return new Result<>(HttpStatus.OK.value(), msg, data);
    }

    public static <T> Result<T> ok(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }


    public static <T> Result<T> fail(String msg) {
        return new Result<>(HttpStatus.BAD_REQUEST.value(), msg, null);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return new Result<>(HttpStatus.BAD_REQUEST.value(), msg, data);
    }

    public static <T> Result<T> fail(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }
}
