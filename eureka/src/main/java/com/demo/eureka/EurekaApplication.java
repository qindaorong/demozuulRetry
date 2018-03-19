package com.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaApplication
 *
 * @author qindaorong
 * @date 2017/10/16
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
