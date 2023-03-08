package com.test.mongo_atlas.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
@Configuration
public class MongoConfig {

    @Bean
    @Primary
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/tasks"));
    }

}
