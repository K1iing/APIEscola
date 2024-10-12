package com.example.ProjetinhoNovo.Controllers;



import com.example.ProjetinhoNovo.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
}
