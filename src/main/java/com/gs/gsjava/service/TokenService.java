package com.gs.gsjava.service;

import com.gs.gsjava.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.JwtParser;
import java.security.Key;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String gerarToken(Usuario usuario) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes()); 

        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("nome", usuario.getNome())
                .claim("tipo", usuario.getTipo())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
    public User validarToken(String token) {
        try {
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build();

            Claims claims = parser
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            String tipo = claims.get("tipo", String.class);

            return new User(email, "", java.util.List.of(() -> "ROLE_" + tipo.toUpperCase()));
        } catch (Exception e) {
            return null;
        }
    }
}
