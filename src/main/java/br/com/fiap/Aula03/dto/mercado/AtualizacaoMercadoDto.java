package br.com.fiap.Aula03.dto.mercado;

import br.com.fiap.Aula03.model.CategoriaMercado;

public record AtualizacaoMercadoDto(String nome, CategoriaMercado categoria, Double faturamento ) {
}
