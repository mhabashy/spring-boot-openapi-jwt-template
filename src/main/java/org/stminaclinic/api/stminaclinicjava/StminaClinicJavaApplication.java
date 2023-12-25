package org.stminaclinic.api.stminaclinicjava;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class StminaClinicJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StminaClinicJavaApplication.class, args);
	}

}
