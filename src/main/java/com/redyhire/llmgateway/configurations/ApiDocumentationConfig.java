package com.redyhire.llmgateway.configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {
    @Bean
    public OpenAPI apiDocConfig() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Internal API")
                .description("Internal API documentation")
                .version("0.0.1")
                .contact(new Contact().name("LLMInternal").email("llminternal@redyhire.com")));
    }
}
