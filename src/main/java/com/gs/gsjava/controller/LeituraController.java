package com.gs.gsjava.controller;

import com.gs.gsjava.dto.LeituraDTO;
import com.gs.gsjava.model.Leitura;
import com.gs.gsjava.model.Sensor;
import com.gs.gsjava.repository.LeituraRepository;
import com.gs.gsjava.service.LeituraService;
import com.gs.gsjava.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;



import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leituras")
public class LeituraController {

    @Autowired
    private LeituraService leituraService;
    
    @Autowired
    private LeituraRepository leiturarepository;

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<LeituraDTO> listarTodas() {
        return leituraService.listarTodas().stream()
                .map(leitura -> {
                    LeituraDTO dto = new LeituraDTO();
                    dto.setId(leitura.getIdLeitura());
                    dto.setIdSensor(leitura.getSensor().getIdSensor());
                    dto.setTemperatura(leitura.getTemperatura());
                    dto.setUmidade(leitura.getUmidade());
                    dto.setDataHora(leitura.getDataHora());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraDTO> buscarPorId(@PathVariable Long id) {
        Leitura leitura = leituraService.buscarPorId(id);
        LeituraDTO dto = new LeituraDTO();
        dto.setId(leitura.getIdLeitura());
        dto.setIdSensor(leitura.getSensor().getIdSensor());
        dto.setTemperatura(leitura.getTemperatura());
        dto.setUmidade(leitura.getUmidade());
        dto.setDataHora(leitura.getDataHora());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LeituraDTO> salvar(@Valid @RequestBody LeituraDTO dto) {
        Sensor sensor = sensorService.buscarPorId(dto.getIdSensor());

        Leitura leitura = new Leitura();
        leitura.setIdLeitura(dto.getId());
        leitura.setSensor(sensor);
        leitura.setTemperatura(dto.getTemperatura());
        leitura.setUmidade(dto.getUmidade());
        leitura.setDataHora(dto.getDataHora());

        Leitura salva = leituraService.salvar(leitura);

        LeituraDTO resposta = new LeituraDTO();
        resposta.setId(salva.getIdLeitura());
        resposta.setIdSensor(sensor.getIdSensor());
        resposta.setTemperatura(salva.getTemperatura());
        resposta.setUmidade(salva.getUmidade());
        resposta.setDataHora(salva.getDataHora());

        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        leituraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/temperatura-media-por-regiao")
    public Map<String, Double> temperaturaMediaPorRegiao() {
        List<Map<String, Object>> dados = leiturarepository.buscarMediaTemperaturaPorRegiao();
        Map<String, Double> resultado = new java.util.HashMap<>();

        for (Map<String, Object> linha : dados) {
            String regiao = (String) linha.get("regiao");
            Double media = ((Number) linha.get("media")).doubleValue();
            resultado.put(regiao, media);
        }
        return resultado;
    }

}
