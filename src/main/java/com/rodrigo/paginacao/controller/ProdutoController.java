package com.rodrigo.paginacao.controller;

import com.rodrigo.paginacao.model.Produto;
import com.rodrigo.paginacao.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Produto produto) {
        service.create(produto);
        return ResponseEntity.ok().body("Produto criado com sucesso");
    }

    //http://localhost:8080/v1/produtos?page=0&size=10&sort=quantidadeEstoque
    @GetMapping
    public ResponseEntity<Page<Produto>> findAllPage(Pageable pageable) {
        return Optional.ofNullable(service.findAllPage(pageable))
                .map(p -> ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.noContent().build());

    }

    //http://localhost:8080/v1/produtos/filtro?nome=produto&page=0&size=10
    @GetMapping("/filtro")
    public ResponseEntity<Page<Produto>> findByProdutoAcimaZero(@RequestParam("nome") String nome, Pageable pageable) {
        return Optional.ofNullable(service.findByProdutoAcimaZero(nome, pageable))
                .map(p -> ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.noContent().build());

    }

    //http://localhost:8080/v1/produtos/tipo/tipo1?page=1&size=5
    @GetMapping("/tipo/{nomeTipo}")
    public ResponseEntity<Page<Produto>> findByTipo(@PathVariable("nomeTipo") String tipo, Pageable pageable) {
        return Optional.ofNullable(service.findByTipo(tipo, pageable))
                .map(p -> ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.noContent().build());

    }

}
