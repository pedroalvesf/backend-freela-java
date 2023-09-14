package com.clean.api.ServiceApi.controller;

import com.clean.api.ServiceApi.domain.user.UserDetailDataDTO;
import com.clean.api.ServiceApi.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<Page<UserDetailDataDTO>> listAllUsers(@PageableDefault (size = 10, sort = {
            "id"}) Pageable pageable) {
        var page = repository.findAllByActiveTrue(pageable).map(UserDetailDataDTO::new);
        return ResponseEntity.ok(page);
    }

}
