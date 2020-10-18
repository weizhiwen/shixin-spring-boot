package com.shixin.framework.handler;

import com.shixin.commons.exception.BaseException;
import com.shixin.commons.exception.QueryException;
import com.shixin.framework.exception.ParamNotValidException;
import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * 处理RestController中的异常
 *
 * @author shixin
 * @date 2020/10/18 9:50 上午
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    /**
     * 参数无效异常
     */
    @ExceptionHandler(ParamNotValidException.class)
    public BaseResult handler(ParamNotValidException ex) {
        log.warn(ex.getMessage());
        return JsonResult.warn(ex.getMessage());
    }

    /**
     * 参数校验异常
     *
     * @param ex 异常对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult validationErrorHandler(MethodArgumentNotValidException ex) {
        var errorInformation = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        return JsonResult.warn(errorInformation.toString());
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
