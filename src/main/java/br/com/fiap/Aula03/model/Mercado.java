package br.com.fiap.Aula03.model;

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

}
