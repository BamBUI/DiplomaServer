package com.psuti.Server.controller;

import com.psuti.Server.dto.UpdateDto;
import com.psuti.Server.dto.UserInfo;
import com.psuti.Server.service.UserMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/me")
@CrossOrigin(origins = "*", allowCredentials = "false")
public class MeRestController {
    private final UserMeService userMeService;
    @Autowired
    public MeRestController(UserMeService userMeService) {
        this.userMeService = userMeService;
    }
    @GetMapping
    public UserInfo get(){
        return userMeService.get();
    }
    @PutMapping
    public UserInfo update(@RequestBody UpdateDto user){
        return userMeService.update(user);
    }
    @DeleteMapping
    public void remove(){
        userMeService.remove();
    }
}

