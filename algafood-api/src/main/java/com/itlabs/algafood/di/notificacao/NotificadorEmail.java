package com.itlabs.algafood.di.notificacao;
import com.itlabs.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

@TipoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
