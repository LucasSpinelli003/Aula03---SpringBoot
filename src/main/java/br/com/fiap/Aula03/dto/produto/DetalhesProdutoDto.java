package br.com.fiap.Aula03.dto.produto;

import br.com.fiap.Aula03.model.Produto;

public record DetalhesProdutoDto(Integer id, String name, Double price, Integer amount) {
    public DetalhesProdutoDto(Produto produto) {
        this(produto.getId(), produto.getName(), produto.getPrice(), produto.getAmount());
    }
}
