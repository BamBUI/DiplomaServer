package com.psuti.Server.service;

import com.psuti.Server.dto.UpdateDto;
import com.psuti.Server.dto.UserInfo;
import com.psuti.Server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserMeService{
    private final UserCrudService userCrudService;
    @Autowired
    public UserMeService(UserCrudService userCrudService) {
        this.userCrudService = userCrudService;
    }
    public UserInfo update(UpdateDto user) {
        User userEntity = fromUpdateDto(user);
        userEntity = userCrudService.update(userEntity, userEntity.getId());
        return toUserInfo(userEntity);
    }
    public void remove(){
        User user = getAuthenticatedUser();
        userCrudService.remove(user);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
    public UserInfo get(){
        User user =  getAuthenticatedUser();
        return toUserInfo(user);
    }
    private User getAuthenticatedUser(){
        return userCrudService.getByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
        );
    }
    private UserInfo toUserInfo(User user){
        return new UserInfo(user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }
    private User fromUpdateDto(UpdateDto updateDto){
        User userEntity = new User();
        userEntity.setEmail(updateDto.getEmail());
        userEntity.setLastname(updateDto.getLastname());
        userEntity.setFirstname(updateDto.getFirstname());
        userEntity.setPassword(updateDto.getPassword());
        userEntity.setId(getAuthenticatedUser().getId());
        userEntity.setRole(getAuthenticatedUser().getRole());
        userEntity.setEnabled(getAuthenticatedUser().isEnabled());
        return userEntity;
    }
}

