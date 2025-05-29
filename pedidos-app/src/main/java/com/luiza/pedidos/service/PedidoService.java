package com.luiza.pedidos.service;

import com.luiza.pedidos.dto.PedidoRequestDto;
import com.luiza.pedidos.dto.PedidoResponseDto;
import com.luiza.pedidos.mapper.PedidoMapper;
import com.luiza.pedidos.repository.PedidoRepository;
import com.luiza.pedidos.tabelas.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;


    public PedidoResponseDto criar(PedidoRequestDto requestDto) {
        Pedido Pedido = PedidoMapper.INSTANCE.convertDtoToPedido(requestDto);
        pedidoRepository.save(Pedido);
        return PedidoMapper.INSTANCE.convertEntityToDto(Pedido);
    }
    private void notificarRabbitMQ(Pedido pedido) {
        try {
            System.out.println("Enviando notificacao...");
        } catch (RuntimeException ex) {
            pedidoRepository.atualizarStatusIncluida(pedido.getId(), false);
        }
    }
    public List<PedidoResponseDto> obterPedido() {
        return PedidoMapper.INSTANCE.convertListEntityToListDto(pedidoRepository.findAll());
    }
}