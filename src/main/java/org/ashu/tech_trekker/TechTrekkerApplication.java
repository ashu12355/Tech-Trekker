package org.ashu.tech_trekker;

import org.ashu.tech_trekker.service.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechTrekkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechTrekkerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FileService fileService) {
		return args-> {
			fileService.createProfileDirectory();
			fileService.createBlogDirectory();
		};
	}
}
