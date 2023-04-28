package com.psuti.Server.service;

import com.psuti.Server.dto.AuthDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnAuthorizationEvent {
    private AuthDto authDto;
    public OnAuthorizationEvent(AuthDto authDto){
        this.authDto = authDto;
    }
}

