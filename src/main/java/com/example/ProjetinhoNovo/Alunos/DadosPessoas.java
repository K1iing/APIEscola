package com.example.ProjetinhoNovo.Alunos;

public record DadosPessoas(
        long id,
        String nome,
        int idade,
        Escola escola,
        String classe


) {
    public DadosPessoas(Pessoas pessoa) {
        this(pessoa.getId(),pessoa.getNome(), pessoa.getIdade(), pessoa.getEscola(), pessoa.getClasse());
    }
}
