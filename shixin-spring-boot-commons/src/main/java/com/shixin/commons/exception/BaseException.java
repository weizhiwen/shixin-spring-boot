package com.shixin.commons.exception;

/**
 * 基础异常类，用作其余模块的异常类，其余异常类继承该异常类
 *
 * @author shixin
 * @date 2020/10/11 9:51 上午
 */
public abstract class BaseException extends RuntimeException {
    public BaseException() {
        super("基础异常");
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
