package br.com.fiap.Aula03.controller;

import br.com.fiap.Aula03.dto.produto.AtualizacaoProdutoDto;
import br.com.fiap.Aula03.dto.produto.CadastroProdutoDto;
import br.com.fiap.Aula03.dto.produto.DetalhesProdutoDto;
import br.com.fiap.Aula03.dto.produto.ListagemProdutoDto;
import br.com.fiap.Aula03.model.Produto;
import br.com.fiap.Aula03.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> cadastrar(@RequestBody CadastroProdutoDto produtoDto, UriComponentsBuilder uri){
        var produto = new Produto(produtoDto);
        produtoRepository.save(produto);
        var url = uri.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesProdutoDto(produto));
    }
    @GetMapping
    public ResponseEntity<List<ListagemProdutoDto>> listar(Pageable pageable){
        var lista = produtoRepository.findAll(pageable).stream().map(ListagemProdutoDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemProdutoDto> pesquisar(@PathVariable("id") Integer id){
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemProdutoDto(produto));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> atualizar(@PathVariable("id") Integer id, @RequestBody AtualizacaoProdutoDto atualizacaoProdutoDto){
        var produto = produtoRepository.getReferenceById(id);
        produto.atualizaProduto(atualizacaoProdutoDto);
        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleta(@PathVariable("id") Integer id){
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
