package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {
    /*
    Como podemos fazer para sanar o problema: (Field notificador in com.itlabs.algafood.di.service.AtivacaoClienteService
    required a single bean, but 2 were found:)? Existem algumas opções, como a seguir, onde podemos fazer o notificador
    se tornar uma lista e recebermos os dois.
    * */

    @Autowired
    private List<Notificador> notificadores;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        for (Notificador notificador : notificadores) {
            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        }
    }
}
