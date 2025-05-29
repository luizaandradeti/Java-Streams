package com.luiza.pedidos.service;

import com.luiza.pedidos.tabelas.Pedido;
import lombok.AllArgsConstructor;
//import org.springframework.amqp.rabbit.core.RabbitTemplateimport org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificarRabbitService {

//    private RabbitTemplate rabbitTemplate;
//
//    public void notificar(Pedido pedido, String exchange) {
//        rabbitTemplate.convertAndSend(exchange, "", pedido);
//    }
}