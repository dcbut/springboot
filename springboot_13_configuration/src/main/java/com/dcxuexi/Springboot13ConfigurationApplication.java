package com.dcxuexi;

import com.dcxuexi.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot13ConfigurationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot13ConfigurationApplication.class, args);

		ServiceConfig bean = applicationContext.getBean(ServiceConfig.class);
		System.out.println(bean);

	}

}
