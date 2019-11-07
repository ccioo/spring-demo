package com.taike.gateway.filter.global;

import com.taike.gateway.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
public class PreGlobleAuthFilter implements GlobalFilter, Ordered {


    private static final String HEADER_AUTH = "Authorization";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        System.out.println("进入GlobalFilter filter");
        Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        URI uri = gatewayUrl.getUri();
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders header = request.getHeaders();
        header.get("");
        //从请求头获取到token
        String token = header.getFirst(HEADER_AUTH);
        String userId = header.getFirst("userId");

//        if (StringUtils.isBlank(token)) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

        ServerHttpRequest.Builder mutate = request.mutate();
        //传递到请求头
        mutate.header("x-user-id", "");
        mutate.header("x-user-name", "");
        mutate.header("x-user-serviceName", uri.getHost());
        ServerHttpRequest serverHttpRequest = mutate.build();
        return chain.filter(exchange.mutate().request(serverHttpRequest).build());
    }


    @Override
    public int getOrder() {
        return -400;
    }

//    private User getUser(HttpServletRequest request) {
//        String userid = request.getHeader("x-user-id");
//        String username = request.getHeader("x-user-name");
//        User user = new User();
//        user.setUserId(userid);
//        user.setUserName(username);
//        return user;
//    }
}
