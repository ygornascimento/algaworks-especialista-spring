package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {
    /*
    Desta vez utilizamos a notação @Primary para informar ao Container qual seria o primeiro bean a ser injetado.
    * */

    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
