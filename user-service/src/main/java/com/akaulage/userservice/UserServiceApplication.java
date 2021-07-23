package com.akaulage.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient  //enable as eureka client
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	//Creating RestTemplate object

	@Bean
	@LoadBalanced // if multiple service available in service registry connected each other then use loadbalanced the request for us
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}


