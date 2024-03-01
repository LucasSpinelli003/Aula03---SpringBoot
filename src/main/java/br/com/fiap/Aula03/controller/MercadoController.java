package br.com.fiap.Aula03.controller;

import br.com.fiap.Aula03.dto.CadastroMercadoDto;
import br.com.fiap.Aula03.model.CategoriaMercado;
import br.com.fiap.Aula03.model.Mercado;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @PostMapping
    public ResponseEntity<Mercado> cadastrar(@RequestBody CadastroMercadoDto mercadoDto, UriComponentsBuilder   uri){
    var url = uri.path("/mercados/{id}").buildAndExpand(1).toUri();
    return ResponseEntity.created(url).body(new Mercado(1,"Sonda",CategoriaMercado.SUPER));
    }
    @GetMapping
    public Mercado get(){
        return new Mercado(1, "Assai", CategoriaMercado.HIPER);
    }

}
