package br.com.fiap.Aula03.dto;

import br.com.fiap.Aula03.model.CategoriaMercado;
import br.com.fiap.Aula03.model.Mercado;

public record DetalhesMercadoDto(Integer id, String nome, CategoriaMercado categoria) {
    public DetalhesMercadoDto(Mercado mercado) {
    this(mercado.getId(), mercado.getName(), mercado.getCategoria());
    }
}