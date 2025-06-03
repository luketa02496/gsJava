package com.gs.gsjava.service;

import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.repository.RegiaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    public List<Regiao> listarTodas() {
        return regiaoRepository.findAll();
    }

    public Regiao buscarPorId(Long id) {
        return regiaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Região não encontrada com id " + id));
    }

    public Regiao salvar(Regiao regiao) {
        return regiaoRepository.save(regiao);
    }

    public Regiao atualizar(Long id, Regiao regiaoAtualizada) {
        Regiao existente = buscarPorId(id);
        existente.setNome(regiaoAtualizada.getNome());
        existente.setLatitude(regiaoAtualizada.getLatitude());
        existente.setLongitude(regiaoAtualizada.getLongitude());
        existente.setVulnerabilidade(regiaoAtualizada.getVulnerabilidade());
        return regiaoRepository.save(existente);
    }

    public void deletar(Long id) {
        regiaoRepository.deleteById(id);
    }
}
