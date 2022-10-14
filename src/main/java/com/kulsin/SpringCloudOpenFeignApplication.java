package com.kulsin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan("com.kulsin.client")
public class SpringCloudOpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOpenFeignApplication.class, args);
	}

}
