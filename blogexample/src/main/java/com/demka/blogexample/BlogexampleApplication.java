package com.demka.blogexample;

import com.demka.blogexample.entities.TagEntity;
import com.demka.blogexample.repos.TagsRepo;
import com.demka.blogexample.services.TagsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogexampleApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner initDatabase(TagsService tagsService){
		return args -> {
			tagsService.create(new TagEntity("1","Slug1"));
			tagsService.create(new TagEntity("2","Slug2"));
			tagsService.create(new TagEntity("3","Slug3"));

		};
	};

	 */
}
