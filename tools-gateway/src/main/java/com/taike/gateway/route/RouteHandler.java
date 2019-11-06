package com.taike.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由断言进行转发
 */
@Configuration
public class RouteHandler {

    /**
     * 当访问http://localhost:8080/jd  转发到http://jd.com
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/jd")
                        .uri("http://jd.com:80/").id("jd_route")
                ).build();
    }


    /**
     * header 路由工厂
     */
    @Bean
    public RouteLocator customRouteLocatorheader(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("header_route", r -> r.header("X-Request-Id", "xujin")
                        .uri("http://localhost:8071/test/head"))
                .build();
    }


    /**
     * host 路由断言
     */
    @Bean
    public RouteLocator customRouteLocatorHost(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("host_route", r -> r.host("**.baidu.com:8080")
                        .uri("http://jd.com"))
                .build();
    }


    /**
     * 方法断言
     */
    @Bean
    public RouteLocator customRouteLocatorMethod(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("method_route", r -> r.method("GET")
                        .uri("http://jd.com"))
                .build();
    }


    /**
     * query 断言
     */
    @Bean
    public RouteLocator customRouteLocatorQuery(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("query_route", r -> r.query("foo", "baz")
                        .uri("http://baidu.com"))
                .build();
    }



}
