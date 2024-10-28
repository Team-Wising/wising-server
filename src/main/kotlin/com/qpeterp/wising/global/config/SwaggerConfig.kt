package com.qpeterp.wising.global.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI {
        val jwt = "JWT"
        val components = Components().addSecuritySchemes(
            jwt, SecurityScheme()
                .name(jwt)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
        )
        return OpenAPI()
            .components(Components())
            .info(
                Info()
                    .title("Wising API")
                    .description("위싱 API 입니다")
                    .version("1.0.0")
            )
            .addSecurityItem(SecurityRequirement().addList(jwt))
            .components(components)
    }
}