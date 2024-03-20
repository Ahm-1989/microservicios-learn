package com.msvc.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
	"com.msvc.ratingservice.services",
	"com.msvc.ratingservice.repository",
	"com.msvc.ratingservice.controller",
	"com.msvc.ratingservice.entity",
})
@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}
}
