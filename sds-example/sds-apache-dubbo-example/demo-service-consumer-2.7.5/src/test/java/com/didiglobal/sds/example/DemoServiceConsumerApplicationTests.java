package com.didiglobal.sds.example;

import com.didiglobal.sds.example.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest
class DemoServiceConsumerApplicationTests {

    @Reference(timeout = 3000)
    HelloService helloService;


    @Test
    void testHello() {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    try {
                        System.out.println(helloService.hello("abc"));
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    @Test
    public void testHelloAsync() {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    try {
                        CompletableFuture<String> future = helloService.asyncHello("abc");
                        System.out.println(future.get());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

}
