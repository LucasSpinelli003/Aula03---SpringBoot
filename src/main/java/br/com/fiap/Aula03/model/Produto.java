package br.com.fiap.Aula03.model;

import br.com.fiap.Aula03.dto.produto.AtualizacaoProdutoDto;
import br.com.fiap.Aula03.dto.produto.CadastroProdutoDto;
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

    public void atualizaProduto(AtualizacaoProdutoDto atualizacaoProdutoDto) {
        if(atualizacaoProdutoDto.name() != null){
            name = atualizacaoProdutoDto.name();
        }
        if(atualizacaoProdutoDto.price() != null){
            price = atualizacaoProdutoDto.price();
        }
        if(atualizacaoProdutoDto.amount() != null){
            amount = atualizacaoProdutoDto.amount();
        }
    }
}
