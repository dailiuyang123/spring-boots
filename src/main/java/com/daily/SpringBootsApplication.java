package com.daily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.daily.mybatis.dao")
public class SpringBootsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootsApplication.class, args);
	}
}
