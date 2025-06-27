package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

//    @Autowired
//    public AtivacaoClienteService(Notificador notificador) {
//        this.notificador = notificador;
//    }

    /* Quando temos mais de um construtor em uma classe que está marcada para ser um Bean (através do @Component por exemplo),
    o SpringContext (ou ApplicationContext ou Container) não sabe qual construtor usar, e como não encontrou o construtor
    padrão da classe, ele se perde e lança uma exception (org.springframework.beans.BeanInstantiationException: Failed to instantiate
    [com.itlabs.algafood.di.service.AtivacaoClienteService]: No default constructor found;). Como dizemos qual construtor
    usar? Usando a anotação @Autowired no construtor que queremos que o Container utilize.
    * */
//    public AtivacaoClienteService(String qualquerCoisa) {
//
//    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }

    /* Outra forma de fazer a injeção de dependência é via o setter da propriedade da classe, porém, sem avisar ao Container
     (através da anotação @Autowired) que vamos usar o setter também temos um erro, só que agora,  de runtime
     (java.lang.NullPointerException: Cannot invoke "com.itlabs.algafood.di.notificacao.Notificador.notificar
     (com.itlabs.algafood.di.modelo.Cliente, String)" because "this.notificador" is null)
    * */
    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }
}
