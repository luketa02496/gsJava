package com.gs.gsjava.service;

import com.gs.gsjava.model.Usuario;
import com.gs.gsjava.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id " + id));
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario existente = buscarPorId(id);
        existente.setNome(usuarioAtualizado.getNome());
        existente.setEmail(usuarioAtualizado.getEmail());
        existente.setTipo(usuarioAtualizado.getTipo());
        existente.setRegiao(usuarioAtualizado.getRegiao());
        return usuarioRepository.save(existente);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
