package com.gs.gsjava.controller;

import com.gs.gsjava.dto.RegiaoDTO;
import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.service.RegiaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regioes")
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;

    @GetMapping
    public List<RegiaoDTO> listarTodas() {
        return regiaoService.listarTodas().stream()
                .map(RegiaoDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegiaoDTO> buscarPorId(@PathVariable Long id) {
        Regiao regiao = regiaoService.buscarPorId(id);
        return ResponseEntity.ok(new RegiaoDTO(regiao));
    }

    @PostMapping
    public ResponseEntity<RegiaoDTO> salvar(@Valid @RequestBody RegiaoDTO dto) {
        Regiao regiao = dto.toEntity();
        Regiao salvo = regiaoService.salvar(regiao);
        return ResponseEntity.ok(new RegiaoDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegiaoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody RegiaoDTO dto) {
        Regiao atualizado = regiaoService.atualizar(id, dto.toEntity());
        return ResponseEntity.ok(new RegiaoDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        regiaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
