package com.shixin.framework.vo;

import lombok.AllArgsConstructor;

/**
 * @author shixin
 * @date 2020/10/11 9:22 上午
 */
@AllArgsConstructor
public class JsonResult<T> extends BaseResult {
    enum Status {
        /**
         * 业务状态枚举值
         */
        OK(200, "操作成功"),
        WARN(400, "参数或业务警告"),
        UNAUTHORIZED(401, "没有认证"),
        FORBIDDEN(403, "没有权限"),
        NOT_FOUND(404, "没有找到"),
        ERROR(500, "系统异常");

        final int code;
        final String msg;

        Status(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    /**
     * 状态码
     */
    int code;
    /**
     * 消息
     */
    String msg;
    /**
     * 数据
     */
    T data;

    /**
     * 请求成功
     */
    public static JsonResult<String> ok() {
        return new JsonResult<String>(Status.OK.code, Status.OK.msg, null);
    }

    /**
     * 请求成功
     *
     * @param data 数据
     */
    public static <T> JsonResult<T> ok(T data) {
        return new JsonResult<T>(Status.OK.code, Status.OK.msg, data);
    }

    /**
     * 参数或业务警告
     */
    public static JsonResult<String> warn() {
        return new JsonResult<String>(Status.WARN.code, Status.WARN.msg, null);
    }

    /**
     * 参数或业务警告
     *
     * @param msg 警告消息
     */
    public static JsonResult<String> warn(String msg) {
        return new JsonResult<String>(Status.WARN.code, msg, null);
    }

    /**
     * 没有认证
     */
    public static JsonResult<String> unauthorized() {
        return new JsonResult<String>(Status.UNAUTHORIZED.code, Status.UNAUTHORIZED.msg, null);
    }

    /**
     * 没有认证
     *
     * @param msg 提示消息
     */
    public static JsonResult<String> unauthorized(String msg) {
        return new JsonResult<String>(Status.UNAUTHORIZED.code, Status.UNAUTHORIZED.msg, null);
    }

    /**
     * 没有权限
     */
    public static JsonResult<String> forbidden() {
        return new JsonResult<String>(Status.FORBIDDEN.code, Status.FORBIDDEN.msg, null);
    }

    /**
     * 没有权限
     *
     * @param msg 提示消息
     */
    public static JsonResult<String> forbidden(String msg) {
        return new JsonResult<String>(Status.FORBIDDEN.code, Status.FORBIDDEN.msg, null);
    }

    /**
     * 没有找到
     */
    public static JsonResult<String> notFound() {
        return new JsonResult<String>(Status.NOT_FOUND.code, Status.NOT_FOUND.msg, null);
    }

    /**
     * 没有找到
     *
     * @param msg 提示消息
     */
    public static JsonResult<String> notFound(String msg) {
        return new JsonResult<String>(Status.NOT_FOUND.code, msg, null);
    }

    /**
     * 系统异常
     */
    public static JsonResult<String> error() {
        return new JsonResult<String>(Status.ERROR.code, Status.ERROR.msg, null);
    }

    /**
     * 系统异常
     *
     * @param msg 异常消息
     */
    public static JsonResult<String> error(String msg) {
        return new JsonResult<String>(Status.ERROR.code, msg, null);
    }
}
