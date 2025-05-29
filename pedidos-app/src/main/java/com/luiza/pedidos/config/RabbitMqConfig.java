package com.luiza.pedidos.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.pedidopendente.exchange}")
    private String exchangePedidoPendente;

    @Value("${rabbitmq.pedidoconcluido.exchange}")
    private String exchangePedidoConcluído;
}