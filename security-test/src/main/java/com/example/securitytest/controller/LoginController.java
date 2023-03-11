package com.example.securitytest.controller;

import com.example.securitytest.model.User;
import com.example.securitytest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;


    @GetMapping("/user")
    @ResponseBody
    public String user(Principal principal){
        Optional<User> user = userService.getUserByUsername(principal.getName());
        System.out.println(user);
        return user.get().toString();
    }
    // A different way to getting logged user username.
    @GetMapping("/auth")
    @ResponseBody
    public String auth(Authentication authentication){
        //authentication.getDetails() returns  WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=A1C95A657CDC14D586A3414FEE883C74]
        return authentication.getName();
    }
}
