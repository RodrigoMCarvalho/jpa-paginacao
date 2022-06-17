package com.rodrigo.paginacao.repository;

import com.rodrigo.paginacao.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.quantidadeEstoque > 0 AND p.nome LIKE %:nome%")
    Page<Produto> findByProdutoAcimaZero(@Param("nome") String nome, Pageable pageable);

    Page<Produto> findByTipo(String tipo, Pageable pageable);

}
