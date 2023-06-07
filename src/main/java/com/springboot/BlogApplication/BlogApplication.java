package com.springboot.BlogApplication;

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
				title = "Blog Application REST APIs",
				description = "Spring Boot Blog Application Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Prudhvi",
						email = "prudv.raj06@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Link to GitHub Repository",
				url = "https://github.com/prudv13/BlogApplication"
		)
)
public class BlogApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
