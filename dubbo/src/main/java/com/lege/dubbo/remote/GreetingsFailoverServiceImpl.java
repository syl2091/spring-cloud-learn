package com.lege.dubbo.remote;

/**
 * @author lege
 * @Description 快速失败
 * @create 2022-08-18 14:35
 */
public class GreetingsFailoverServiceImpl implements GreetingsService{

    @Override
    public String sayHi(String name) {
        System.out.println("failover implementation");
        return "hi, failover " + name;
    }
}
