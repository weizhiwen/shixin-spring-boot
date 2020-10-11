package com.shixin.framework.controller;

import com.shixin.framework.vo.JsonResult;

/**
 * @author shixin
 * @date 2020/10/11 10:10 上午
 */
public class BaseRestController {
    protected final JsonResult<String> OK = JsonResult.ok();
}
