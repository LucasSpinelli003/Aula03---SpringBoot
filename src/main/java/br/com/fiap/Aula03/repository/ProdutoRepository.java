package br.com.fiap.Aula03.repository;

import br.com.fiap.Aula03.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
