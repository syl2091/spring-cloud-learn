package com.lege.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author lege
 * @Description
 * @create 2023-02-17 10:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    int NOT_LIMITED = 0;

    /**
     * qps
     */
    @AliasFor("qps") double value() default NOT_LIMITED;

    /**
     * qps
     */
    @AliasFor("value") double qps() default NOT_LIMITED;

    /**
     * 超时时长
     */
    int timeout() default 0;

    /**
     * 超时时间单位
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}

