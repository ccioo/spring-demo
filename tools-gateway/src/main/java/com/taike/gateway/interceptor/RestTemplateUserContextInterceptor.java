package com.taike.gateway.interceptor;

import com.taike.gateway.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        User user = UserContextHolder.currentUser();
        request.getHeaders().add("x-user-id", user.getUserId());
        request.getHeaders().add("x-user-name", user.getUserName());
        request.getHeaders().add("x-user-serviceName", request.getURI().getHost());
        return execution.execute(request, body);
    }
}
