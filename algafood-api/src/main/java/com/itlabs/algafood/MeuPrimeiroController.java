package com.itlabs.algafood;

import com.itlabs.algafood.di.modelo.Cliente;
import com.itlabs.algafood.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService atividacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService atividacaoClienteService) {
        this.atividacaoClienteService = atividacaoClienteService;
        System.out.println("Meu primeiro controller: " + atividacaoClienteService);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente cliente = new Cliente("João", "joao@xyz.com", "349999999585");
        atividacaoClienteService.ativar(cliente);

        return "Olá6!";
    }
}
