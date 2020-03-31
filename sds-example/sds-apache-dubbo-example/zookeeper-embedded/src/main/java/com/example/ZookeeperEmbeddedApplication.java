package com.example;

import org.apache.curator.test.TestingServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZookeeperEmbeddedApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperEmbeddedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TestingServer zkServer = new TestingServer(2181, true);
        zkServer.start();
    }
}
