package com.gestorfinanceiro.fluxodecaixa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestorfinanceiro.fluxodecaixa.modelo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
