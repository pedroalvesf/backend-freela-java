package com.clean.api.ServiceApi.controller;

import com.clean.api.ServiceApi.domain.user.UserDetailDataDTO;
import com.clean.api.ServiceApi.domain.user.UserRepository;
import com.clean.api.ServiceApi.domain.user.UserUpdateDataDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<Page<UserDetailDataDTO>> listAllUsers(
            @PageableDefault (size = 10,
            sort = {
            "id"}) Pageable pageable) {
        var page = repository.findAllByActiveTrue(pageable).map(UserDetailDataDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UserUpdateDataDTO data) {
        var user = repository.getReferenceById(data.id());
        user.updateUser(data);

        return ResponseEntity.ok(new UserDetailDataDTO(user));
    }

}
