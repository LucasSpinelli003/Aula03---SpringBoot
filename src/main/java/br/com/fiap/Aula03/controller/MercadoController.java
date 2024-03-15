package br.com.fiap.Aula03.controller;

import br.com.fiap.Aula03.dto.mercado.AtualizacaoMercadoDto;
import br.com.fiap.Aula03.dto.mercado.CadastroMercadoDto;
import br.com.fiap.Aula03.dto.mercado.DetalhesMercadoDto;
import br.com.fiap.Aula03.dto.mercado.ListagemMercadoDto;
import br.com.fiap.Aula03.model.Mercado;
import br.com.fiap.Aula03.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
    public ResponseEntity<List<ListagemMercadoDto>> listar(Pageable pageable){
        var lista = mercadoRepository.findAll(pageable).stream().map(ListagemMercadoDto::new).toList();
        return ResponseEntity.ok(lista);

    }
    @GetMapping("{id}")
    public ResponseEntity<ListagemMercadoDto> pesquisar(@PathVariable("id") Integer id){
        var mercado = mercadoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemMercadoDto(mercado));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesMercadoDto> atualiza(@PathVariable("id") Integer id, @RequestBody AtualizacaoMercadoDto atualizacaoMercadoDto){
        var mercado = mercadoRepository.getReferenceById(id);
        mercado.atualizaDados(atualizacaoMercadoDto);
        return ResponseEntity.ok(new DetalhesMercadoDto(mercado));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        mercadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
