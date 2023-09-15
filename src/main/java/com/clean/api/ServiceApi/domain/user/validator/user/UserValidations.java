package com.clean.api.ServiceApi.domain.user.validator.user;

import com.clean.api.ServiceApi.domain.user.UserRegisterDataDTO;

public interface UserValidations {
    void userValidation(UserRegisterDataDTO userRegisterDataDTO); //Need to change to the service class
}
