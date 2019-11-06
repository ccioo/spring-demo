package com.taike.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;


/**
 * todo 所有的请求都会经过这里
 * 在这里可以进行权限校验
 */
@Component
public class PreGlobleAuthFilter implements GlobalFilter {


    private static final String HEADER_AUTH = "Authorization";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        URI uri = gatewayUrl.getUri();
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders header = request.getHeaders();
        //从请求头获取到token
        String token = header.getFirst(HEADER_AUTH);

        ServerHttpRequest.Builder mutate = request.mutate();
        //传递到请求头
        mutate.header("x-user-id", "");
        mutate.header("x-user-name", "");
        mutate.header("x-user-serviceName", uri.getHost());
        ServerHttpRequest serverHttpRequest = mutate.build();
        return chain.filter(exchange.mutate().request(serverHttpRequest).build());
    }
}
