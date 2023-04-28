package com.psuti.Server.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AuthorizationListener {
    private final VerificationService verificationService;
    private final UserCrudService userCrudService;
    public AuthorizationListener(UserCrudService userCrudService,
                                 VerificationService verificationService) {
        this.userCrudService = userCrudService;
        this.verificationService = verificationService;
    }
    @EventListener
    @Transactional
    public void onApplicationEvent(OnAuthorizationEvent event) {
        checkConfirmed(event);
    }
    private void checkConfirmed(OnAuthorizationEvent event){
        if(verificationService.shouldRemove(event.getAuthDto().getEmail())){
            userCrudService.removeByUsername(event.getAuthDto().getEmail());
        }
    }
}

