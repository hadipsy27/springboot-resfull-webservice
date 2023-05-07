package com.labs.springbootrestfullwebservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Springboot Restfull Webservices",
				version = "1.0",
				description = "Springboot Restfull Webservices",
				contact = @Contact(
						name = "Hadi",
						url = "https://github.com/hadipsy27/springboot-restfull-webservices",
						email = "hadipsy321@gmail.com"
		),
				license = @License(
						name = "Apache License Version 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				url = "https://github.com/hadipsy27/springboot-restfull-webservices",
				description = "Springboot Restfull Webservices"
		)
)
public class SpringbootRestfullWebservicesApplication {

	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
	}

}
