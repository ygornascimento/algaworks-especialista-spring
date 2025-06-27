package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.notificacao.Notificador;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;
    }

    /* Quando temos mais de um construtor em uma classe que está marcada para ser um Bean (através do @Component por exemplo),
    o SpringContext (ou ApplicationContext ou Container) não sabe qual construtor usar, e como não encontrou o construtor
    padrão da classe, ele se perde e lança uma exception (org.springframework.beans.BeanInstantiationException: Failed to instantiate
    [com.itlabs.algafood.di.service.AtivacaoClienteService]: No default constructor found;). Como dizemos qual construtor
    usar? Usando a anotação @Autowired no construtor que queremos que o Container utilize.
    * */
    public AtivacaoClienteService(String qualquerCoisa) {

    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
