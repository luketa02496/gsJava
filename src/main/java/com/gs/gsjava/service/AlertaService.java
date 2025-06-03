package com.gs.gsjava.service;

import com.gs.gsjava.model.Alerta;
import com.gs.gsjava.repository.AlertaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Alerta buscarPorId(Long id) {
        return alertaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado com id " + id));
    }

    public Alerta salvar(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public void deletar(Long id) {
        alertaRepository.deleteById(id);
    }
}
