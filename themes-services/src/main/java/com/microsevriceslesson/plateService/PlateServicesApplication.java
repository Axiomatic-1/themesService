package com.microsevriceslesson.plateService;

import com.microsevriceslesson.plateService.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties(AppProperties.class)
public class PlateServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlateServicesApplication.class, args);
	}

}
