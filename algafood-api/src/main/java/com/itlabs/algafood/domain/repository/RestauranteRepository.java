package com.itlabs.algafood.domain.repository;
import com.itlabs.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> listar();
    Restaurante buscar(Long id);
}
