package com.jpbtech.webappservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/").setViewName("home.html");
		registry.addViewController("/X9872").setViewName("login.html");
		
	}

}
