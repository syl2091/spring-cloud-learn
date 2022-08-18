package com.lege.dubbo.remote;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author lege
 * @Description
 * @create 2022-08-18 9:28
 */
public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        System.out.println("default implementation");
        return "hi, " + name;
    }
}
