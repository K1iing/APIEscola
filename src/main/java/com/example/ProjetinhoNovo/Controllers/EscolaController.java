package com.example.ProjetinhoNovo.Controllers;


import com.example.ProjetinhoNovo.Alunos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping()
public class EscolaController {

    @Autowired
    private PessoasRepository repository;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<PessoaDetalhamento> cadastrarNew(@RequestBody @Valid Alunos dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoas(dados);
        repository.save(pessoa);

        var uri = uriBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new PessoaDetalhamento(pessoa));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DadosPessoas>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosPessoas::new).toList();

        return ResponseEntity.ok(lista);


    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<PessoaDetalhamento> atualizar(@RequestBody @Valid AtualizarAlunos dados) {
        var alunos = repository.getReferenceById(dados.id());
        alunos.atualizarInformacao(dados);

        return ResponseEntity.ok(new PessoaDetalhamento(alunos));
    }


    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var alunos = repository.getReferenceById(id);
        alunos.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<Void> ativar(@PathVariable Long id) {
        var alunos = repository.getReferenceById(id);
        alunos.ativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<PessoaDetalhamento> detalhar(@PathVariable Long id) {
        var alunos = repository.getReferenceById(id);


        return ResponseEntity.ok(new PessoaDetalhamento(alunos));
    }

}
