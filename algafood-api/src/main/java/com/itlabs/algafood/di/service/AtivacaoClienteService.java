package com.itlabs.algafood.di.service;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.notificacao.NivelUrgencia;
import com.itlabs.algafood.di.notificacao.Notificador;
import com.itlabs.algafood.di.notificacao.TipoNotificador;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class AtivacaoClienteService implements InitializingBean, DisposableBean {
    /*
    Desta vez utilizamos um notificador customizado, que também é um @Qualifier para informar ao Container qual seria o
    primeiro bean a ser injetado.
    * */

    @TipoNotificador(NivelUrgencia.NORMAL)
    @Autowired
    private Notificador notificador;

//    @PostConstruct
//    public void init() {
//        System.out.println("Iniciando notificacao...");
//    }

//    @PreDestroy
    public void destroy() {
        System.out.println("Destruindo notificacao...");
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Iniciando notificacao...");
    }
}
