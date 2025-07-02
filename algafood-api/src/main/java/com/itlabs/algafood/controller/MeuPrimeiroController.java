package com.itlabs.algafood.controller;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
        System.out.println("Meu primeiro controller: " + ativacaoClienteService);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente cliente = new Cliente("João", "joao@xyz.com", "349999999585");
        ativacaoClienteService.ativar(cliente);

        return "Hello!";
    }
}
