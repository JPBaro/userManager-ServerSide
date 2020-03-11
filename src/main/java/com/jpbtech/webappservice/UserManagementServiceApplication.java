package com.jpbtech.webappservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//@ComponentScan(basePackages = "com.jpbtech.webappservice")
@SpringBootApplication
public class UserManagementServiceApplication extends SpringBootServletInitializer{

	/*
	 * <Provisional> JP 06.03.2020
	 * 
	 * @Bean Solucion provisional para evitar conflicto CORS con solicitudes
	 * desde :4200 Puede eliminarse una vez testeado todo ok. Proxy configurado
	 * en App2 para evitar conflicto , aun pendiente de validar
	 * 
	 */
	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// return new WebMvcConfigurerAdapter() {
	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/**").allowedMethods("GET", "POST", "PUT",
	// "DELETE").allowedOrigins("*")
	// .allowedHeaders("*");
	// }
	// };
	// }


	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}
	

}
