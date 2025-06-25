package com.itlabs.algafood.di.notificacao;

import com.itlabs.algafood.di.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
