package com.ibmap.dental;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Arta API", version = "1.0", description = "Electronic management of the activities of the association"))
public class DentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalApplication.class, args);
	}

}
