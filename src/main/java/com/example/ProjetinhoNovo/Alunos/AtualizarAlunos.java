package com.example.ProjetinhoNovo.Alunos;

import jakarta.validation.constraints.NotNull;

public record  AtualizarAlunos(
        @NotNull
        long id,
        String nome,
        int idade,
        Escola escola,
        String classe) {
}
