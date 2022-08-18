package com.lege.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.lege.dubbo.remote.GreetingsService;
import com.lege.dubbo.remote.GreetingsServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lege
 * @Description API配置
 * @create 2022-08-18 10:59
 */
public class APIConfigurationLiveTest {

    @Before
    public void init(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("demo-provider");
        applicationConfig.setVersion("1.0");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.1.1.1:9090");


        ServiceConfig<GreetingsService> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig);
        service.setInterface(GreetingsService.class);
        service.setRef(new GreetingsServiceImpl());


        service.export();
    }


    @Test
    public void givenProviderConsumer_whenSayHi_thenGotResponse(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("demo-consumer");
        applicationConfig.setVersion("1.0");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("multicast://224.1.1.1:9090");

        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(GreetingsService.class);

        GreetingsService greetingsService = reference.get();
        String hiMessage = greetingsService.sayHi("lege");
        System.out.println(hiMessage);
    }
}
