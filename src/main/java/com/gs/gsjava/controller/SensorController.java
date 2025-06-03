package com.gs.gsjava.controller;

import com.gs.gsjava.dto.SensorDTO;
import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.model.Sensor;
import com.gs.gsjava.service.RegiaoService;
import com.gs.gsjava.service.SensorService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private RegiaoService regiaoService;

    @GetMapping
    public List<SensorDTO> listarTodos() {
        return sensorService.listarTodos().stream()
                .map(SensorDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Sensor sensor = sensorService.buscarPorId(id);
            return ResponseEntity.ok(new SensorDTO(sensor));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<SensorDTO> salvar(@Valid @RequestBody SensorDTO dto) {
        Regiao regiao = regiaoService.buscarPorId(dto.getIdRegiao());
        Sensor sensor = dto.toEntity(regiao);
        Sensor salvo = sensorService.salvar(sensor);
        return ResponseEntity.ok(new SensorDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorDTO> atualizar(@PathVariable Long id, @Valid @RequestBody SensorDTO dto) {
        Regiao regiao = regiaoService.buscarPorId(dto.getIdRegiao());
        Sensor atualizado = sensorService.atualizar(id, dto.toEntity(regiao));
        return ResponseEntity.ok(new SensorDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sensorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/paginado")
    public Page<SensorDTO> listarPaginado(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "idSensor") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return sensorService.listarPaginado(pageable).map(SensorDTO::new);
    }
    
    @GetMapping("/filtro")
    public Page<SensorDTO> filtrarPorStatus(
            @RequestParam String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idSensor") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return sensorService.filtrarPorStatus(status, pageable).map(SensorDTO::new);
    }


}
