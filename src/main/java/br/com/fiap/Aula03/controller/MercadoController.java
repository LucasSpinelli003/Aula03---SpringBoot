package br.com.fiap.Aula03.controller;

import br.com.fiap.Aula03.model.CategoriaMercado;
import br.com.fiap.Aula03.model.Mercado;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mercado")
public class MercadoController {

    @GetMapping
    public Mercado get(){
        return new Mercado(1, "Assai", CategoriaMercado.HIPER);
    }

}
