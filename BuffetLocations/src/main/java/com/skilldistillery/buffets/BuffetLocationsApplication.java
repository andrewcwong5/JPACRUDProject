package com.skilldistillery.buffets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.skilldistillery.buffets")
public class BuffetLocationsApplication  extends SpringBootServletInitializer {

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(BuffetLocationsApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BuffetLocationsApplication.class, args);
	}

}
