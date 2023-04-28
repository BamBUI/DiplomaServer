package com.psuti.Server.controller;

import com.psuti.Server.dto.AuthDto;
import com.psuti.Server.dto.RegDto;
import com.psuti.Server.entity.Token;
import com.psuti.Server.service.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowCredentials = "false")
public class AuthRestController {
    private final UserAuthService userAuthService;
    private final UserRegService userRegService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final VerificationService verificationService;
    public AuthRestController(UserAuthService userAuthService,
                              UserRegService userRegService,
                              ApplicationEventPublisher applicationEventPublisher, VerificationService verificationService) {
        this.userAuthService = userAuthService;
        this.userRegService = userRegService;
        this.applicationEventPublisher = applicationEventPublisher;
        this.verificationService = verificationService;
    }
    @PostMapping(path = "/login")
    @RequestMapping(value = "/login")
    public Token authorization(@RequestBody @Valid AuthDto authDto) throws Exception {
        applicationEventPublisher
                .publishEvent(new OnAuthorizationEvent(authDto));
        return userAuthService.authorization(authDto);
    }
    @PostMapping
    @RequestMapping("/reg")
    public Token registration(@RequestBody @Valid RegDto user) throws Exception {
        Token token = userRegService.registration(user);
        user.setId(token.getUserId());
        applicationEventPublisher.publishEvent(new OnRegistrationEvent(user));
        return token;
    }
    @PostMapping("/confirm")
    public void confirm(@RequestParam("token") String token){
        verificationService.confirm(token);
    }
}


