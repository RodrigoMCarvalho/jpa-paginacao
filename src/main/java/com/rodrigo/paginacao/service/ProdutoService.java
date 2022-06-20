package com.rodrigo.paginacao.service;

import com.rodrigo.paginacao.model.Produto;
import com.rodrigo.paginacao.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public void create(Produto produto) {
        repository.save(produto);
    }

    public Page<Produto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Produto> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Produto> findByTipo(String tipo, Pageable pageable) {
        return repository.findByTipo(tipo, pageable);
    }

    public Page<Produto> findByProdutoAcimaZero(String nome, Pageable pageable) {
        return repository.findByProdutoAcimaZero(nome, pageable);
    }
}
