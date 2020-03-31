package com.didiglobal.sds.example;

import com.didiglobal.sds.client.config.SdsDowngradeActionNotify;
import com.didiglobal.sds.client.enums.DowngradeActionType;
import com.didiglobal.sds.client.listener.DowngradeActionListener;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableDubbo
public class DemoServiceConsumerApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceConsumerApplication.class);

    static {
        SdsDowngradeActionNotify.addDowngradeActionListener((point, downgradeActionType, date) -> {
            logger.info("point:{} is downgraded at {} type:{}", point, date, downgradeActionType);
        });

    }

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceConsumerApplication.class, args);
    }


}
