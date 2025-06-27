//package com.itlabs.algafood.config;
//
//import com.itlabs.algafood.di.notificacao.NotificadorEmail;
//import com.itlabs.algafood.di.service.AtivacaoClienteService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
//public class AlgaConfig {
//
//    @Bean
//    public NotificadorEmail notificadorEmail() {
//        NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.algamail.com.br");
//        notificadorEmail.setCaixaAlta(true);
//
//        return notificadorEmail;
//    }
//
//    @Bean
//    public AtivacaoClienteService atividacaoClienteService() {
//        return new AtivacaoClienteService(notificadorEmail());
//    }
//}
