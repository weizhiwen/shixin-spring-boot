package com.shixin.framework.exception;

import com.shixin.commons.exception.BaseException;

/**
 * 认证异常
 *
 * @author shixin
 * @date 2020/12/06
 */
public class AuthException extends BaseException {
    public AuthException() {
        super("认证异常");
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthException(Throwable cause) {
        super(cause);
    }
}
