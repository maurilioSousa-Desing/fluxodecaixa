package com.gestorfinanceiro.fluxodecaixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestorfinanceiro.fluxodecaixa.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
