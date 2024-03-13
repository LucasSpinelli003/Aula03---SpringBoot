package br.com.fiap.Aula03.dto;

import br.com.fiap.Aula03.model.CategoriaMercado;
import br.com.fiap.Aula03.model.Mercado;

public record ListagemMercadoDto(Integer id, String nome, CategoriaMercado categoria) {

    public ListagemMercadoDto(Mercado mercado) {
        this(mercado.getId(), mercado.getName(), mercado.getCategoria());
    }

}
