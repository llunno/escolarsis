package com.infnet.edu.lucas.escolarsis.config;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;

@Component
@OpenAPIDefinition(
	info = @Info(
		title = "Escolarsis",
		version = "1.0",
		description = "Documentação da API do Sistema de Gerenciamento Escolar",
		summary = "Endpoints da API"
	),
    servers = {
        @Server(
            url = "https://escolarsis-production.up.railway.app",
            description = "Local server"
        )
    },
    security = @SecurityRequirement(name = "basic")
)
public class SwaggerConfig {

}
