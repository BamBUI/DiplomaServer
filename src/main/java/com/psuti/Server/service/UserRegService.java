package com.psuti.Server.service;

import com.psuti.Server.dao.RoleRepository;
import com.psuti.Server.dto.AuthDto;
import com.psuti.Server.dto.RegDto;
import com.psuti.Server.entity.Token;
import com.psuti.Server.entity.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class UserRegService {
    private final UserCrudService userCrudService;
    private final RoleRepository roleRepository;
    private final UserAuthService userAuthService;
    public UserRegService(UserCrudService userCrudService,
                          RoleRepository roleRepository,
                          UserAuthService userAuthService) {
        this.userCrudService = userCrudService;
        this.roleRepository = roleRepository;
        this.userAuthService = userAuthService;
    }
    public Token registration(RegDto regDto) throws Exception {
        if (userCrudService.existsByUsername(regDto.getEmail())) {
            throw new EntityExistsException("User with email: " + regDto.getEmail() + " already exists");
        }
        User user = fromRegDto(regDto);
        user.setRole(roleRepository.findById("USER").get());
        userCrudService.create(user);
        Token token = userAuthService.authorization(
                new AuthDto(user.getEmail(), regDto.getPassword())
        );
        return token;
    }
    private User fromRegDto(RegDto regDto){
        User user = new User();
        user.setEnabled(true);
        user.setEmail(regDto.getEmail());
        user.setFirstname(regDto.getFirstname());
        user.setLastname(regDto.getLastname());
        user.setPassword(regDto.getPassword());
        return user;
    }
}

