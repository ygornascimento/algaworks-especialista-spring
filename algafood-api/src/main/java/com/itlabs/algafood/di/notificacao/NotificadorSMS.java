package com.itlabs.algafood.di.notificacao;

import com.itlabs.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("sms")
@Component
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
