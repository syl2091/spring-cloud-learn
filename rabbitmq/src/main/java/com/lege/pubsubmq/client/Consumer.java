package com.lege.pubsubmq.client;

/**
 * @author lege
 * @Description
 * @create 2022-09-05 11:10
 */
public class Consumer {
    public void receiveOrder(String message) {
        System.out.printf("Order received: %s%n", message);
    }
}

