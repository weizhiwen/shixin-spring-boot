package com.shixin.framework.controller;

import com.shixin.framework.vo.JsonResult;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * RestController基础类，其他RestController类基础该类
 *
 * @author shixin
 * @date 2020/10/11 10:10 上午
 */
@Slf4j
public class BaseRestController {
    protected final JsonResult<String> OK = JsonResult.ok();
}
