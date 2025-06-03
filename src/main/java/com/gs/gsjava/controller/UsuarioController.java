package com.gs.gsjava.controller;

import com.gs.gsjava.dto.UsuarioDTO;
import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.model.Usuario;
import com.gs.gsjava.service.RegiaoService;
import com.gs.gsjava.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RegiaoService regiaoService;

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos().stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioDTO dto) {
        Regiao regiao = dto.getIdRegiao() != null ? regiaoService.buscarPorId(dto.getIdRegiao()) : null;
        Usuario usuario = dto.toEntity(regiao);
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(new UsuarioDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
        Regiao regiao = dto.getIdRegiao() != null ? regiaoService.buscarPorId(dto.getIdRegiao()) : null;
        Usuario atualizado = usuarioService.atualizar(id, dto.toEntity(regiao));
        return ResponseEntity.ok(new UsuarioDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
