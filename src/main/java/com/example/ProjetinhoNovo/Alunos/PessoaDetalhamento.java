package com.example.ProjetinhoNovo.Alunos;

import com.example.ProjetinhoNovo.Controllers.AtualizarAlunos;

public record PessoaDetalhamento(
        Long id,
        String nome,
        int idade,
        Escola escola,
        String classe,
        Boolean ativo

) {
    public PessoaDetalhamento(Pessoas pessoas) {
        this(pessoas.getId(),
                pessoas.getNome(),
                pessoas.getIdade(),
                pessoas.getEscola(),
                pessoas.getClasse(),
                pessoas.getAtivo());
    }
}
