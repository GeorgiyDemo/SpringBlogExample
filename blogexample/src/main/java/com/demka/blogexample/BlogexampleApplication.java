package com.demka.blogexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
