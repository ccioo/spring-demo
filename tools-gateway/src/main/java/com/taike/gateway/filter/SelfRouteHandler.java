package com.taike.gateway.filter;


import com.taike.gateway.filter.gateway.TimeGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 路由过滤器
 * 可以对 请求目标地址 在请求之前和之后做一些事情
 */
@Configuration
public class SelfRouteHandler {

    /**
     * 请求头添加参数
     */
    @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_header_route", r -> r.path("/test")
                        .filters(f -> {
                            f.addRequestHeader("X-Request-Acme", "ValueB");
                            f.addRequestHeader("X-Request-Acme1", "ValueB1");
                            return f;
                        })
                        .uri("http://localhost:8071/test/head"))
                .build();
    }

    /**
     *
     */
    @Bean
    public RouteLocator testRouteLocator2(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_parameter_route", r ->
                        r.path("/addRequestParameter").filters(f -> f.addRequestParameter("example", "ValueB"))
                                .uri("http://localhost:8071/test/addRequestParameter"))
                .build();
    }


    /**
     * /foo/** 的请求 转发到 http://www.baidu.com 并且去除了前缀 /foo
     */
    @Bean
    public RouteLocator testRouteLocator3(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rewritepath_route", r ->
                        r.path("/foo/**")
                                .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/$\\{segment}"))
                                .uri("http://www.baidu.com"))
                .build();
    }


    /**
     * 向响应添加头参数
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator testRouteLocator4(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_header_route", r ->
                        r.path("/test")
                                .filters(f -> f.addResponseHeader("X-Response-Foo", "Bar"))
                                .uri("http://www.baidu.com"))
                .build();
    }


    /**
     * 重试过滤器
     */
    @Bean
    public RouteLocator retryRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("retry_route", r -> r.path("/test/retry")
                        .filters(f -> f.retry(config -> config.setRetries(2).setStatuses(HttpStatus.INTERNAL_SERVER_ERROR)))
                        .uri("http://localhost:8071/retry?key=abc&count=2"))
                .build();
    }


    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test")
                        .filters(f -> f.filter(new TimeGatewayFilter()))
                        .uri("http://localhost:8001/customFilter?name=xujin")
                        .order(0)
                        .id("custom_filter")
                )
                .build();
    }




}
