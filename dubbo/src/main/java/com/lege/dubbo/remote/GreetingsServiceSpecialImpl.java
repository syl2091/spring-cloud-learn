package com.lege.dubbo.remote;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author aiet
 */
public class GreetingsServiceSpecialImpl implements GreetingsService {

    @Override
    public String sayHi(String name) {
        try {
            // 测试缓存
            System.out.println("specially called");
            SECONDS.sleep(5);
        } catch (Exception ignored) {
        }
        return "hi, " + name;
    }

}
