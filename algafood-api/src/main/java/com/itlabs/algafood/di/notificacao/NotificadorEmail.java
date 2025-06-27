package com.itlabs.algafood.di.notificacao;
import com.itlabs.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

/* @Component Ao retirar a instanciação dessa classe do Container (removendo o @Component), ele passa a não ser mais
obrigatório na classe AtivaçãoClienteService.*/
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
