package com.mocheng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class MochengApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MochengApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		//修改 开发分支
		return builder.sources(MochengApplication.class);
	}
	
}
