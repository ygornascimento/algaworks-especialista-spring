package com.itlabs.algafood.api.controller;

import com.itlabs.algafood.domain.exceprion.EntidadeEmUsoException;
import com.itlabs.algafood.domain.exceprion.EntidadeNaoEncontradaException;
import com.itlabs.algafood.domain.model.Cozinha;
import com.itlabs.algafood.domain.repository.CozinhaRepository;
import com.itlabs.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
* Por que construtor é preferido para DI?
1) Dependências obrigatórias ficam explícitas
Quando a Controller precisa de Service para existir, isso aparece no construtor.
Com injeção em campo, essa obrigação fica “escondida”.

2) Imutabilidade (final)
Com construtor, você consegue declarar dependências como final, evitando alteração acidental depois da criação do objeto.

3) Melhor testabilidade
Fica muito mais fácil criar a classe em teste passando mocks pelo construtor, sem precisar de reflection/hacks.

4) Falha mais cedo (fail fast)
Se faltar dependência, o erro aparece na criação do bean, de forma mais clara.

5) Aderência a princípios OO/SOLID
Combina melhor com:
Dependency Inversion
Design explícito de contratos
Baixo acoplamento acidental de framework
*
* */

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {

        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

        if (cozinhaId != null) {
            return ResponseEntity.ok(cozinha);
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cadastroCozinhaService.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
                                             @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);

        if (cozinhaAtual != null) {
            cozinhaAtual.setNome(cozinha.getNome());
            cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
        try {
            cadastroCozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
