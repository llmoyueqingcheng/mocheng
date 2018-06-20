package com.mocheng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages ="com.mocheng.demo")
@SpringBootApplication
@EnableScheduling
public class MochengApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MochengApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MochengApplication.class);
	}
	
}
