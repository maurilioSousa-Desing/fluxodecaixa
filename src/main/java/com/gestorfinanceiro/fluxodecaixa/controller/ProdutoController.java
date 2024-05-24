package com.gestorfinanceiro.fluxodecaixa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestorfinanceiro.fluxodecaixa.modelo.Produto;
import com.gestorfinanceiro.fluxodecaixa.servico.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para buscar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> todosProdutos() {
        List<Produto> produtos = produtoService.todosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    
    // Endpoint para criar um novo produto
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.inserir(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    // Endpoint para atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterar(@PathVariable Long id, @RequestBody Produto produto) throws Exception {
        Produto produtoAtualizado = produtoService.alterar(id, produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    // Endpoint para deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) throws Exception {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
