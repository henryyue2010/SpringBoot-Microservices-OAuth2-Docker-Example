package com.example.microservices.secondservice;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SecondServiceApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SecondServiceApplication.class);

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SecondServiceApplication.class, args);
	}

}
