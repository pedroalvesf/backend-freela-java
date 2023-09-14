package com.clean.api.ServiceApi.controller;


import com.clean.api.ServiceApi.domain.user.User;
import com.clean.api.ServiceApi.domain.user.auth.DataAuth;
import com.clean.api.ServiceApi.infra.security.DataTokenJWT;
import com.clean.api.ServiceApi.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity LogIn(@RequestBody @Valid DataAuth data) {
        var token = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.createToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}
