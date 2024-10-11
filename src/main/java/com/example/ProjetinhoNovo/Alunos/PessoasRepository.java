package com.example.ProjetinhoNovo.Alunos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
    List<Pessoas> findAllByAtivoTrue();


}
