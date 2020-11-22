package com.shixin.commons.exception;

/**
 * 查询参数异常
 *
 * @author shixin
 * @date 2020/10/11 9:51 上午
 */
public class QueryException extends BaseException {

    public QueryException() {
        super("查询参数异常");
    }

    public QueryException(String message) {
        super(message);
    }

    public QueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryException(Throwable cause) {
        super(cause);
    }

}
