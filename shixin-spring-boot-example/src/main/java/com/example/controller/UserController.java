package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.shixin.framework.controller.BaseRestController;
import com.shixin.framework.vo.BaseResult;
import com.shixin.framework.vo.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shixin
 * @date 2021/2/27
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseRestController {
    final UserService userService;
    final static int COUNT = 10000;
    final static List<User> USER_LIST = new ArrayList<>(COUNT);

    static {
        for (int i = 0; i < COUNT; i++) {
            String random = i + "";
            User user = new User().setName(random).setPassword(random);
            user.setId(i);
            USER_LIST.add(user);
        }
    }

    @PostMapping
    public BaseResult createUser(@RequestBody User user) {
        return JsonResult.ok(userService.createUser(user));
    }

    @PostMapping("/batch1")
    public BaseResult batch1CreateUser() {
        return JsonResult.ok(userService.batch1CreateUser(USER_LIST));
    }

    @PostMapping("/batch2")
    public BaseResult batch2CreateUser() {
        return JsonResult.ok(userService.batch2CreateUser(USER_LIST));
    }

    @GetMapping
    public BaseResult listUser() {
        return JsonResult.ok(userService.listUser());
    }

    @GetMapping(params = "page")
    public BaseResult pageUser(@PageableDefault Pageable pageable) {
        return JsonResult.ok(userService.pageUser(pageable));
    }

    @GetMapping("/{id}")
    public BaseResult userDetails(@PathVariable Integer id) {
        return JsonResult.ok(userService.userDetails(id));
    }

    @PutMapping("/{id}")
    public BaseResult updateUser(@PathVariable Integer id, @RequestBody User user) {
        return JsonResult.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public BaseResult deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return OK;
    }
}
