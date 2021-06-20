package com.kiran.microservices.apigateway;

import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;



import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter{

	private Logger logger = org.slf4j.LoggerFactory.getLogger(LoggingFilter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path of the request recieve is: {}", exchange.getRequest().getPath());
		// TODO Auto-generated method stub
		return chain.filter(exchange);
	}

}
