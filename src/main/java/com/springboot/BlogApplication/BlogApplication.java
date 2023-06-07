package com.springboot.BlogApplication;

import com.springboot.BlogApplication.Entity.Role;
import com.springboot.BlogApplication.Repository.RoleRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
public class BlogApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);
	}
}
