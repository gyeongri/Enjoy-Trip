package com.ssafy.trip.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

//	Swagger-UI 3.x 확인
//	//http://localhost/trip/swagger-ui/index.html
	
	private final ServerProperties serverProperties;

    public SwaggerConfiguration(ServerProperties serverProperties) {
		super();
		this.serverProperties = serverProperties;
	}
	


}
