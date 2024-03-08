package br.com.fiap.Aula03.model;

import br.com.fiap.Aula03.dto.CadastroProdutoDto;
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
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Double price;

    private Integer amount;

    public Produto(CadastroProdutoDto produtoDto) {
        name = produtoDto.name();
        price = produtoDto.price();
        amount = produtoDto.amount();
    }
}
