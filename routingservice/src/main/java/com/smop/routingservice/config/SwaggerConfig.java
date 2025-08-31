package com.smop.routingservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Routing Service API")
                        .version("1.0")
                        .description("API for the Routing Service")
                        .contact(new Contact()
                                .name("API Support")
                                .email("support@example.com")));
    }
}
