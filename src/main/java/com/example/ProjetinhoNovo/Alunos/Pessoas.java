package com.example.ProjetinhoNovo.Alunos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoas {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    @Enumerated(EnumType.STRING)
    private Escola escola;
    private String classe;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    private Boolean ativo;

    public Pessoas(Alunos dados) {
        this.nome = dados.nome();
        this.classe = dados.classe();
        this.escola = dados.escola();
        this.idade = dados.idade();
        this.ativo = true;
    }

    public void atualizarInformacao(@Valid AtualizarAlunos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.classe() != null) {
            this.classe = dados.classe();
        }
        if (dados.escola() != null) {
            this.escola = dados.escola();

        }
        if (dados.idade() > 0) {
            this.idade = dados.idade();
        }


    }

    public void inativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
