package br.com.fiap.Aula03.dto.produto;

import br.com.fiap.Aula03.model.Produto;

import java.awt.print.Pageable;

public record ListagemProdutoDto(Integer id, String nome, Integer amount) {

    public ListagemProdutoDto(Produto produto){
        this(produto.getId(),produto.getName(),produto.getAmount());
    }
}
