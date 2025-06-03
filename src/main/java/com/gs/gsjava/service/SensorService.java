package com.gs.gsjava.service;

import com.gs.gsjava.model.Sensor;
import com.gs.gsjava.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public Page<Sensor> listarPaginado(Pageable pageable) {
        return sensorRepository.findAll(pageable);
    }

    public Page<Sensor> filtrarPorStatus(String status, Pageable pageable) {
        return sensorRepository.findByStatus(status, pageable);
    }

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Sensor buscarPorId(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor com ID " + id + " não encontrado"));
    }

    public Sensor salvar(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor atualizar(Long id, Sensor sensorAtualizado) {
        Sensor existente = buscarPorId(id);
        existente.setModelo(sensorAtualizado.getModelo());
        existente.setStatus(sensorAtualizado.getStatus());
        existente.setDataInstalacao(sensorAtualizado.getDataInstalacao());
        existente.setRegiao(sensorAtualizado.getRegiao());
        return sensorRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new EntityNotFoundException("Sensor com ID " + id + " não encontrado");
        }
        sensorRepository.deleteById(id);
    }
}

