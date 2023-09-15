package com.clean.api.ServiceApi.controller;


import com.clean.api.ServiceApi.domain.service.ServiceRegisterDTO;
import com.clean.api.ServiceApi.domain.service.ServiceRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
@SecurityRequirement(name = "bearer-key")
public class ServiceController {

}
