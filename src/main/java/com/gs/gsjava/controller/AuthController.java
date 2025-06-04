package com.gs.gsjava.controller;

import com.gs.gsjava.dto.LoginDTO;
import com.gs.gsjava.model.Usuario;
import com.gs.gsjava.service.TokenService;
import com.gs.gsjava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Usuario usuario = usuarioService.autenticar(loginDTO.getEmail(), loginDTO.getSenha());
        if (usuario != null) {
            String token = tokenService.gerarToken(usuario);
            return ResponseEntity.ok().body(token);
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }
}
