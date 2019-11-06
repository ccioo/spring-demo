package com.taike.gateway.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
public class AuthController {


    /**
     * 登录颁发token
     */
    @PostMapping(value = "uniLogin")
    public String login() {
        return UUID.randomUUID().toString();
    }


}
