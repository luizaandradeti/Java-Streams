package com.luiza.pedidos.service;

import com.luiza.pedidos.tabelas.Pedido;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RabbitService {

    private RabbitTemplate rabbitTemplate;

    public void notificacao(Pedido pedido, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", pedido);
    }
}