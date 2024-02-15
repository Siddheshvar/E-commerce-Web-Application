package com.example.Ecommerce.Web.Apk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Ecommerce.Web.Apk.*"})
public class ECommerceWebApkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceWebApkApplication.class, args);
		System.out.println("Application is running!");
	}

}
