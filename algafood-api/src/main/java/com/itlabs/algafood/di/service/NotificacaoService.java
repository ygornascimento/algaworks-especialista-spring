package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.notificacao.NivelUrgencia;
import com.itlabs.algafood.di.notificacao.Notificador;
import com.itlabs.algafood.di.notificacao.TipoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoNotificador(NivelUrgencia.NORMAL)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }
}
