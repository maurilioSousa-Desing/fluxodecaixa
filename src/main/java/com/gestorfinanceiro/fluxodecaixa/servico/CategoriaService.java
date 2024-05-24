package com.gestorfinanceiro.fluxodecaixa.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorfinanceiro.fluxodecaixa.modelo.Categoria;
import com.gestorfinanceiro.fluxodecaixa.repository.CategoriaRepository;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Categoria> todasCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoria) throws Exception {
        if (categoriaRepository.existsById(id)) {
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        } else {
            throw new Exception("Categoria não encontrado com o ID: " + id);
        }
    }

    public void deleteCategoria(Long id) throws Exception {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new Exception("Categoria não encontrado com o ID: " + id);
        }
    }

}
