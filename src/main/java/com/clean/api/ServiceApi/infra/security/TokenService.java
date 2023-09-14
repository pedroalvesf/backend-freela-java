package com.clean.api.ServiceApi.infra.security;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.clean.api.ServiceApi.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value ("${api.security.token.secret}")
    private String secret;

    public String createToken(User user) {
        System.out.println(secret);
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Clean")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error creating token", exception);
        }
    }

    public String getSubject(String token) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API Clean")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Invalid or expired token", exception);
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusDays(15).toInstant(ZoneOffset.of("-03:00"));
    }
}
