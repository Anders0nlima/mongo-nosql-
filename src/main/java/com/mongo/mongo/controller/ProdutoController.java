package com.mongo.mongo.controller;

import com.mongo.mongo.model.Produto;
import com.mongo.mongo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarProduto(@PathVariable String id){
        return produtoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable String id, @RequestBody Produto produto){
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable String id){
        produtoRepository.deleteById(id);
    }

    @GetMapping("/buscar")
    public List<Produto> buscarPorNome(@RequestParam String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
