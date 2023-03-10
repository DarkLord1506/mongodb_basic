package com.test.mongo_atlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MongoAtlasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoAtlasApplication.class, args);
    }

}
