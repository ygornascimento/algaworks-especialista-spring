package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.notificacao.NivelUrgencia;
import com.itlabs.algafood.di.notificacao.Notificador;
import com.itlabs.algafood.di.notificacao.TipoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {
    /*
    Desta vez utilizamos um notificador customizado, que também é um @Qualifier para informar ao Container qual seria o
    primeiro bean a ser injetado.
    * */

    @TipoNotificador(NivelUrgencia.NORMAL)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
