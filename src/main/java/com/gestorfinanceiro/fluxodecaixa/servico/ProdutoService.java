package com.gestorfinanceiro.fluxodecaixa.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorfinanceiro.fluxodecaixa.modelo.Produto;
import com.gestorfinanceiro.fluxodecaixa.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> todosProdutos(){
        
        return produtoRepository.findAll();
    }


    public Produto inserir(Produto produto){

        return produtoRepository.saveAndFlush(produto);

    }

    public Produto alterar(Long id, Produto produto) throws Exception{

       if (produtoRepository.existsById(id)) {
        produto.setId(id);
        return produtoRepository.save(produto);
    
       } else {
        throw new Exception("Produto não encontrado com o ID: " + id);
       }
    }


    public void deleteProduto(Long id) throws Exception {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new Exception("Produto não encontrado com o ID: " + id);
        }
    }
}
