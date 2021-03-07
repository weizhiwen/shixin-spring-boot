package com.example.controller;

import com.shixin.framework.controller.BaseRestController;
import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author shixin
 * @date 2020/10/18 5:05 下午
 */
@RequestMapping("test")
@RestController
@RequiredArgsConstructor
public class TestController extends BaseRestController {
    @GetMapping("/hello")
    public BaseResult hello(@RequestParam String name) {
        return JsonResult.ok(name);
    }
}
