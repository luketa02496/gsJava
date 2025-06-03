package com.gs.gsjava.controller;

import com.gs.gsjava.repository.LeituraRepository;
import com.gs.gsjava.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    @Autowired
    private SensorRepository sensorRepository;
    
    @Autowired
    private LeituraRepository leituraRepository;

    @GetMapping("/sensores-por-status")
    public Map<String, Long> sensoresPorStatus() {
        List<String> statusList = Arrays.asList("ATIVO", "INATIVO", "MANUTENCAO");
        Map<String, Long> resultado = new HashMap<>();

        statusList.forEach(status ->
            resultado.put(status, sensorRepository.countByStatus(status))
        );

        return resultado;
    }
    
    
}
