package com.lege.cloud.service;

import com.lege.cloud.domain.CommonResult;
import com.lege.cloud.domain.User;
import com.lege.cloud.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lege
 * @Description
 * @create 2022-06-20 17:39
 */
@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserService {
    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable("id") Long id);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam("username") String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable("id") Long id);
}