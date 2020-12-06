package com.shixin.framework.handler;

import com.shixin.commons.exception.BaseException;
import com.shixin.commons.exception.QueryException;
import com.shixin.framework.exception.AuthException;
import com.shixin.framework.exception.ParamNotValidException;
import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 处理RestController中的异常
 *
 * @author shixin
 * @date 2020/10/18 9:50 上午
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /**
     *
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResult handler(HttpRequestMethodNotSupportedException ex) {
        return JsonResult.warn("请求方式有误");
    }

    /**
     * 参数无效异常
     */
    @ExceptionHandler(ParamNotValidException.class)
    public BaseResult handler(ParamNotValidException ex) {
        return JsonResult.warn("参数有误：" + ex.getMessage());
    }

    /**
     * JSON反序列化失败异常处理
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResult handler(HttpMessageNotReadableException ex) {
        return JsonResult.warn("参数不匹配：" + ex.getMessage());
    }

    /**
     * 参数校验异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handler(MethodArgumentNotValidException ex) {
        var errorInformation = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        return JsonResult.warn("参数校验不通过：" + errorInformation.toString());
    }

    /**
     * 认证异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(AuthException.class)
    public BaseResult handler(AuthException ex) {
        return JsonResult.unauthorized(ex.getMessage());
    }

    /**
     * SpringSecurity认证失败异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    public BaseResult handler(RuntimeException ex) {
        return JsonResult.unauthorized(ex.getMessage());
    }

    /**
     * SpringSecurity鉴权失败异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(AccessDeniedException.class)
    public BaseResult handler(AccessDeniedException ex) {
        return JsonResult.forbidden();
    }

    /**
     * 查询参数异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(QueryException.class)
    public BaseResult handler(QueryException ex) {
        log.warn(ex.getMessage());
        return JsonResult.warn(ex.getMessage());
    }

    /**
     * 基础异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(BaseException.class)
    public BaseResult handler(BaseException ex) {
        log.warn(ex.getMessage());
        return JsonResult.warn(ex.getMessage());
    }

    /**
     * 最顶级异常
     *
     * @param t 异常对象
     */
    @ExceptionHandler(Throwable.class)
    public BaseResult handler(Throwable t) {
        log.error(t.getMessage(), t);
        return JsonResult.error("服务器异常");
    }
}
