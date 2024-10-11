package com.example.ProjetinhoNovo.Alunos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;

public record Alunos(


        @NotBlank(message = "O nome não pode ser nulo")
        String nome,

        int idade,
        @Enumerated(EnumType.STRING)
        @NotNull
        Escola escola,
        @NotBlank
        String classe


) {
}
