package br.com.fiap.Aula03.dto.mercado;

import br.com.fiap.Aula03.model.CategoriaMercado;



public record CadastroMercadoDto(String nome, CategoriaMercado categoria, String cnpj, Double faturamento) {
}
