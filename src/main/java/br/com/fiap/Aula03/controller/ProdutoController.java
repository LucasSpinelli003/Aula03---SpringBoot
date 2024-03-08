package br.com.fiap.Aula03.controller;

import br.com.fiap.Aula03.dto.CadastroMercadoDto;
import br.com.fiap.Aula03.dto.CadastroProdutoDto;
import br.com.fiap.Aula03.dto.DetalhesProdutoDto;
import br.com.fiap.Aula03.model.Produto;
import br.com.fiap.Aula03.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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


}
