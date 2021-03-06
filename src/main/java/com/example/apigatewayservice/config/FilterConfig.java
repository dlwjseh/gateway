package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration - yml에서 설정
public class FilterConfig {
//	@Bean - yml에서 설정
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/first-service/**")
						.filters(f -> f.addRequestHeader("first-request", "first-request-header")
								.addResponseHeader("first-response", "first-response-header"))
						.uri("http://localhost:8081/"))
				.route(r -> r.path("/second-service/**")
						.filters(f -> f.addRequestHeader("second-request", "second-request-header")
								.addResponseHeader("second-response", "second-response-header"))
						.uri("http://localhost:8082/"))
				.build();
	}
}
