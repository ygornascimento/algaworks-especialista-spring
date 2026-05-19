package com.itlabs.algafood.domain.service;

import com.itlabs.algafood.domain.exceprion.EntidadeEmUsoException;
import com.itlabs.algafood.domain.exceprion.EntidadeNaoEncontradaException;
import com.itlabs.algafood.domain.model.Cozinha;
import com.itlabs.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.remover(cozinhaId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com o id: %s", cozinhaId));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("COzinha de código %d não pode ser removida, pois está em uso", cozinhaId));
        }
    }
}
