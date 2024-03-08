package br.com.fiap.Aula03.controller;

import br.com.fiap.Aula03.dto.CadastroMercadoDto;
import br.com.fiap.Aula03.dto.DetalhesMercadoDto;
import br.com.fiap.Aula03.model.CategoriaMercado;
import br.com.fiap.Aula03.model.Mercado;
import br.com.fiap.Aula03.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @Autowired
    private MercadoRepository mercadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesMercadoDto> cadastrar(@RequestBody CadastroMercadoDto mercadoDto, UriComponentsBuilder uri){
        var mercado = new Mercado(mercadoDto);
        mercadoRepository.save(mercado);
        var url = uri.path("/mercados/{id}").buildAndExpand(mercado.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesMercadoDto(mercado));
    }
    @GetMapping
    public Mercado get(){
        return new Mercado(1, "Assai", CategoriaMercado.HIPER);
    }

}
