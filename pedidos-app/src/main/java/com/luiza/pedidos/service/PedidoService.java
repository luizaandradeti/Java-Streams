package com.luiza.pedidos.service;

import com.luiza.pedidos.dto.PedidoRequestDto;
import com.luiza.pedidos.dto.PedidoResponseDto;
import com.luiza.pedidos.mapper.PedidoMapper;
import com.luiza.pedidos.repository.PedidoRepository;
import com.luiza.pedidos.tabelas.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final NotificarRabbitService notificarRabbitService;

    @Autowired
    PedidoRepository pedidoRepository;
    private final String exchange;

    public PedidoService(NotificarRabbitService notificarRabbitService, String exchange) {
        this.notificarRabbitService = notificarRabbitService;
        this.exchange = exchange;
    }
    public PedidoResponseDto criar(PedidoRequestDto requestDto) {
        Pedido Pedido = PedidoMapper.INSTANCE.convertDtoToPedido(requestDto);
        pedidoRepository.save(Pedido);
        return PedidoMapper.INSTANCE.convertEntityToDto(Pedido);
    }
    private void notificarRabbitMQ(Pedido pedido) {
        try {
            notificarRabbitService.notificar(pedido, exchange);
        } catch (RuntimeException ex) {
            pedidoRepository.atualizarStatusIncluida(pedido.getId(), false);
        }
    }
}