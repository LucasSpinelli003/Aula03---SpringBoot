package br.com.fiap.Aula03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Mercado {

    private Integer id;

    private String name;

    private CategoriaMercado categoria;

}
