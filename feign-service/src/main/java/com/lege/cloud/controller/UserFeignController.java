package com.lege.cloud.controller;

import com.lege.cloud.domain.CommonResult;
import com.lege.cloud.domain.User;
import com.lege.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lege
 * @Description
 * @create 2022-06-20 17:40
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam("username") String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}