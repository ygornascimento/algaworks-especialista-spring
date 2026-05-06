package com.itlabs.algafood.api.controller;

import com.itlabs.algafood.domain.model.Cozinha;
import com.itlabs.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
        return  cozinhaRepository.buscar(cozinhaId);
    }

    @PostMapping
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        Cozinha cozinhaSalva = cozinhaRepository.salvar(cozinha);

        return cozinhaSalva;
    }
}
