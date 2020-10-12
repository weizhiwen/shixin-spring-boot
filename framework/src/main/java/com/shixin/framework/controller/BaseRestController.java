package com.shixin.framework.controller;

import com.shixin.framework.vo.JsonResult;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author shixin
 * @date 2020/10/11 10:10 上午
 */
public class BaseRestController {
    protected final JsonResult<String> OK = JsonResult.ok();

    public static void main(String[] args) {
        BeanUtil.beanToMap(null);
    }
}
