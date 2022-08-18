package com.lege.dubbo;

import com.lege.dubbo.remote.GreetingsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * @author lege
 * @Description 负载均衡
 * @create 2022-08-18 13:59
 */
public class ClusterLoadBalanceLiveTest {
    private ExecutorService executorService;

    @Before
    public void init() {
        executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            ClassPathXmlApplicationContext remoteContext = new ClassPathXmlApplicationContext("cluster/provider-app-default.xml");
            remoteContext.start();
        });
        executorService.submit(() -> {
            ClassPathXmlApplicationContext remoteContext = new ClassPathXmlApplicationContext("cluster/provider-app-special.xml");
            remoteContext.start();
        });
    }


    @Test
    public void givenProviderCluster_whenConsumerSaysHi_thenResponseBalanced() {
        ClassPathXmlApplicationContext localContext =
                new ClassPathXmlApplicationContext("cluster/consumer-app-lb.xml");
        localContext.start();
        GreetingsService greetingsService
                = (GreetingsService) localContext.getBean("greetingsService");
        List<Long> elapseList = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            long current = System.currentTimeMillis();
            String hiMessage = greetingsService.sayHi("baeldung");
            assertNotNull(hiMessage);
            elapseList.add(System.currentTimeMillis() - current);
        }

        OptionalDouble avgElapse = elapseList
                .stream()
                .mapToLong(e -> e)
                .average();
        assertTrue(avgElapse.isPresent());
        assertTrue(avgElapse.getAsDouble() > 2500.0);

    }

    @After
    public void destroy(){
        executorService.shutdown();
    }
}
