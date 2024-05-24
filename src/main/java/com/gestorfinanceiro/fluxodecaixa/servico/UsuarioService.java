package com.gestorfinanceiro.fluxodecaixa.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gestorfinanceiro.fluxodecaixa.modelo.Usuario;
import com.gestorfinanceiro.fluxodecaixa.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    
    public Usuario updateUsuario(Long id, Usuario usuario) throws Exception {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            throw new Exception("Usuario não encontrado com o ID: " + id);
        }
    }

    public void deleteUsuario(Long id) throws Exception {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new Exception("Usuario não encontrado com o ID: " + id);
        }
    }


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
