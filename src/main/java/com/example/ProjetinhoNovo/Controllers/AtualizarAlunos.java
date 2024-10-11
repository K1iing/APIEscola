package com.example.ProjetinhoNovo.Controllers;

import com.example.ProjetinhoNovo.Alunos.Escola;
import jakarta.validation.constraints.NotNull;

public record AtualizarAlunos(
        @NotNull
        long id,
        String nome,
        int idade,
        Escola escola,
        String classe) {
}
