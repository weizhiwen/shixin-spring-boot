//package com.example.controller;
//
//import com.example.service.RedisService;
//import com.shixin.framework.controller.BaseRestController;
//import com.shixin.framework.vo.BaseResult;
//import com.shixin.framework.vo.JsonResult;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author shixin
// * @date 2020/10/18 5:05 下午
// */
//@RequestMapping("redis")
//@RestController
//@RequiredArgsConstructor
//public class RedisController extends BaseRestController {
//    final RedisService redisService;
//
//    @PostMapping
//    public BaseResult set(@RequestParam String key, @RequestParam String value) {
//        return JsonResult.ok(redisService.set(key, value));
//    }
//}
