package com.inventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://localhost:8080").description("Local Dev"))
                .info(new Info()
                        .title("Inventory Search Management API")
                        .version("1.0")
                        .description("API for managing and searching real-time warehouse inventory.")
                        .contact(new Contact().name("Dev Support").email("ramakrishnancse1@gmail.com")));
    }
}
