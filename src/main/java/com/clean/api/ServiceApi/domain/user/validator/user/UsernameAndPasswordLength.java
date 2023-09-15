package com.clean.api.ServiceApi.domain.user.validator.user;

import com.clean.api.ServiceApi.domain.user.UserRegisterDataDTO;
import com.clean.api.ServiceApi.domain.user.UserRepository;
import com.clean.api.ServiceApi.domain.user.validator.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsernameAndPasswordLength implements UserValidations{

    @Autowired
    private UserRepository repository;

    public void userValidation(UserRegisterDataDTO userRegisterDataDTO) {
        if (userRegisterDataDTO.username().length() < 4 || userRegisterDataDTO.password().length() <= 5) {
            throw new ValidateException("Username or password is too short");
        }
    }
}
