package com.mongo.mongo.repository;

import com.mongo.mongo.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
