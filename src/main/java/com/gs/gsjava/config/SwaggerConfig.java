package com.gs.gsjava.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API - SAFE.Guard")
                .version("1.0")
                .description("Documentação da API para o sistema de monitoramento de eventos extremos"));
    }
}
