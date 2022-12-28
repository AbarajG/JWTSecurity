package com.andygomez.securityJWT.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {

    @GetMapping("/")
    public String mainMessage(){
        return "Main message";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userMessage(Authentication authentication){
        log.info("Username={}, roles={}", authentication.getPrincipal(), authentication.getAuthorities());
        return "User message";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminMessage(){
        return "Admin message";
    }

}
