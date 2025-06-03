package com.gs.gsjava.controller;

import com.gs.gsjava.dto.AlertaDTO;
import com.gs.gsjava.model.Alerta;
import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.service.AlertaService;
import com.gs.gsjava.service.RegiaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @Autowired
    private RegiaoService regiaoService;

    @GetMapping
    public List<AlertaDTO> listarTodos() {
        return alertaService.listarTodos().stream()
                .map(alerta -> {
                    AlertaDTO dto = new AlertaDTO();
                    dto.setId(alerta.getIdAlerta());
                    dto.setIdRegiao(alerta.getRegiao().getIdRegiao());
                    dto.setTipo(alerta.getTipo());
                    dto.setSeveridade(alerta.getSeveridade());
                    dto.setDataHora(alerta.getDataHora());
                    dto.setMensagem(alerta.getMensagem());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaDTO> buscarPorId(@PathVariable Long id) {
        Alerta alerta = alertaService.buscarPorId(id);
        AlertaDTO dto = new AlertaDTO();
        dto.setId(alerta.getIdAlerta());
        dto.setIdRegiao(alerta.getRegiao().getIdRegiao());
        dto.setTipo(alerta.getTipo());
        dto.setSeveridade(alerta.getSeveridade());
        dto.setDataHora(alerta.getDataHora());
        dto.setMensagem(alerta.getMensagem());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AlertaDTO> salvar(@Valid @RequestBody AlertaDTO dto) {
        Regiao regiao = regiaoService.buscarPorId(dto.getIdRegiao());

        Alerta alerta = new Alerta();
        alerta.setIdAlerta(dto.getId());
        alerta.setRegiao(regiao);
        alerta.setTipo(dto.getTipo());
        alerta.setSeveridade(dto.getSeveridade());
        alerta.setDataHora(dto.getDataHora());
        alerta.setMensagem(dto.getMensagem());

        Alerta salvo = alertaService.salvar(alerta);

        AlertaDTO resposta = new AlertaDTO();
        resposta.setId(salvo.getIdAlerta());
        resposta.setIdRegiao(salvo.getRegiao().getIdRegiao());
        resposta.setTipo(salvo.getTipo());
        resposta.setSeveridade(salvo.getSeveridade());
        resposta.setDataHora(salvo.getDataHora());
        resposta.setMensagem(salvo.getMensagem());

        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alertaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
