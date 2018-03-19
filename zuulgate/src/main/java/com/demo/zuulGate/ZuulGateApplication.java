package com.demo.zuulGate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ZuulGateApplication
 *
 * @author qindaorong
 * @create 2018-03-15 4:08 PM
 **/
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulGateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateApplication.class, args);
    }
}
