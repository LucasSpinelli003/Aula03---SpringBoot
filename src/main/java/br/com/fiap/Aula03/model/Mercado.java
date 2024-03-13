package br.com.fiap.Aula03.model;

import br.com.fiap.Aula03.dto.CadastroMercadoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
public class Mercado {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private CategoriaMercado categoria;

    private String cnpj;
    private Double faturamento;

    public Mercado(CadastroMercadoDto mercadoDto) {
        name = mercadoDto.nome();
        categoria = mercadoDto.categoria();
        cnpj = mercadoDto.cnpj();
        faturamento = mercadoDto.faturamento();
    }
}
