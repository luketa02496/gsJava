package com.gs.gsjava.service;

import com.gs.gsjava.model.Leitura;
import com.gs.gsjava.repository.LeituraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeituraService {

    @Autowired
    private LeituraRepository leituraRepository;

    public List<Leitura> listarTodas() {
        return leituraRepository.findAll();
    }

    public Leitura buscarPorId(Long id) {
        return leituraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada com id " + id));
    }

    public Leitura salvar(Leitura leitura) {
        return leituraRepository.save(leitura);
    }

    public void deletar(Long id) {
        leituraRepository.deleteById(id);
    }
}
