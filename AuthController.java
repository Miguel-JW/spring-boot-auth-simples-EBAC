package com.exemplo.auth.controller;

import com.exemplo.auth.dto.LoginRequest;
import com.exemplo.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String resultado = authService.autenticar(request);
        return ResponseEntity.ok(resultado);
    }
}
