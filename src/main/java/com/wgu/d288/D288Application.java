package com.wgu.d288;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.wgu.d288.entities")
@EnableJpaRepositories("com.wgu.d288.services")
@ComponentScan("com.wgu.d288.controller")
public class D288Application {

	public static void main(String[] args) {
		SpringApplication.run(D288Application.class, args);
	}

}
