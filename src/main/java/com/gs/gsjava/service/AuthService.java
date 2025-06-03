package com.gs.gsjava.service;

import com.gs.gsjava.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    public String autenticar(String email, String senha) {
        if (email.equals("admin@email.com") && senha.equals("admin")) {
            return jwtUtil.gerarToken(email);
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}
