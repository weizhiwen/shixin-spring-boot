package com.shixin.framework.controller;

import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 重写 404 处理
 *
 * @author shixin
 */
@RestController
@Slf4j
public class RequestErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public BaseResult errorPage() {
        return JsonResult.notFound("请求的地址没有对应的API方法");
    }
}
