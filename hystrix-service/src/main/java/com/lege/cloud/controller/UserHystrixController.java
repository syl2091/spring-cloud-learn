package com.lege.cloud.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.lege.cloud.domain.CommonResult;
import com.lege.cloud.domain.User;
import com.lege.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author lege
 * @Description
 * @create 2022-06-17 16:50
 */
@RestController
@RequestMapping("/user")
public class UserHystrixController {

    @Autowired
    private UserService userService;

    @GetMapping("/testFallback/{id}")
    public CommonResult testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }

    /**
     * 设置命令、分组及线程池名称
     * @param id
     * @return
     */
    @GetMapping("/testCommand/{id}")
    public CommonResult testCommand(@PathVariable Long id) {
        return userService.getUserCommand(id);
    }

    /**
     * 使用ignoreExceptions忽略某些异常降级
     * @param id
     * @return
     */
    @GetMapping("/testException/{id}")
    public CommonResult testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    /**
     * 测试使用缓存
     * @param id
     * @return
     */
    @GetMapping("/testCache/{id}")
    public CommonResult testCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
        return new CommonResult("操作成功", 200);
    }

    /**
     * 测试移除缓存
     * @param id
     * @return
     */
    @GetMapping("/testRemoveCache/{id}")
    public CommonResult testRemoveCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.removeCache(id);
        userService.getUserCache(id);
        return new CommonResult("操作成功", 200);
    }

    @GetMapping("/testCollapser")
    public CommonResult testCollapser() throws ExecutionException, InterruptedException{
        Future<User> future1 = userService.getUserFuture(1L);
        Future<User> future2 = userService.getUserFuture(2L);
        Future<User> future3 = userService.getUserFuture(3L);
        future1.get();
        future2.get();
        ThreadUtil.safeSleep(300);
        future3.get();
        return new CommonResult("操作成功", 200);
    }
}
