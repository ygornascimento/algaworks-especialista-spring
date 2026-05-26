package com.itlabs.algafood.api.controller;

import com.itlabs.algafood.domain.exceprion.EntidadeNaoEncontradaException;
import com.itlabs.algafood.domain.model.Restaurante;
import com.itlabs.algafood.domain.repository.RestauranteRepository;
import com.itlabs.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    final private RestauranteRepository restauranteRepository;
    final private CadastroRestauranteService cadastroRestauranteService;

    public RestauranteController(RestauranteRepository restauranteRepository,
                                 CadastroRestauranteService cadastroRestauranteService) {
        this.restauranteRepository = restauranteRepository;
        this.cadastroRestauranteService = cadastroRestauranteService;
    }

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @GetMapping("/{restauranteId}")
    public Restaurante buscar(@PathVariable Long restauranteId) {
        return restauranteRepository.buscar(restauranteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            restaurante = cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurante);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/restauranteId")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        Restaurante restauranteModificado = restauranteRepository.buscar(restauranteId);

        try {
            if  (restauranteModificado != null) {
                BeanUtils.copyProperties(restaurante, restauranteModificado, "id");

                restauranteModificado = cadastroRestauranteService.salvar(restauranteModificado);
                return ResponseEntity.ok(restauranteModificado);
            }
            return ResponseEntity.notFound().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
