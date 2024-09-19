package com.BSP.StudentApis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class StudentApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApisApplication.class, args);
	}

}
