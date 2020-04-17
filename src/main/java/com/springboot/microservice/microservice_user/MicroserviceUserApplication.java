package com.springboot.microservice.microservice_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@EntityScan({"com.springboot.microservice.servicec_commons.model.entities"})
@SpringBootApplication
public class MicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserApplication.class, args);
	}
	
	@Bean
	DispatcherServlet dispatcherServlet () {
	    DispatcherServlet ds = new DispatcherServlet();
	    ds.setThrowExceptionIfNoHandlerFound(true);
	    return ds;
	}

}
