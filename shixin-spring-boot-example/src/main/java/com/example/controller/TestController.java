package com.example.controller;

import com.example.service.TestService;
import com.shixin.framework.controller.BaseRestController;
import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;

import lombok.AllArgsConstructor;
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
    final TestService testService;

    @GetMapping("/hello")
    public BaseResult hello(@RequestParam String name) {
        return JsonResult.ok(name);
    }

    @PostMapping
    public BaseResult set(@RequestParam String key, @RequestParam String value) {
        return JsonResult.ok(testService.set(key, value));
    }
}
