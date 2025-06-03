package com.gs.gsjava.controller;

import com.gs.gsjava.dto.LoginDTO;
import com.gs.gsjava.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO dto) {
        String token = authService.autenticar(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(token);
    }
}
