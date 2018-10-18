package com.middleware.middleware.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.middleware.middleware.model.Connector;
import com.middleware.middleware.model.Middleware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MiddlewareConfig {

    @Bean
    public Middleware middleware() throws IOException {

        StringBuilder jsonStringBuilder = new StringBuilder();

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(classLoader.getResource("Middleware.json").getFile()))) {
            jsonStringBuilder.append(br.readLine());
        }

        String jsonString = jsonStringBuilder.toString();

        return new ObjectMapper().readValue(jsonString, Middleware.class);
    }

    @Bean
    public Map<String, Connector> connectorMap(){
        return new HashMap<>();
    }

}