package com.itlabs.algafood.config;

import com.itlabs.algafood.di.notificacao.Notificador;
import com.itlabs.algafood.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean()
    public AtivacaoClienteService atividacaoClienteService() {
        return new AtivacaoClienteService();
    }
}
