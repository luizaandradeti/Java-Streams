package com.luiza.pedidos.controller;

import com.luiza.pedidos.dto.PedidoResponseDto;
import com.luiza.pedidos.mapper.PedidoMapper;
import com.luiza.pedidos.tabelas.Pedido;
import org.springframework.data.repository.Repository;

import java.util.List;

interface PedidoRepository extends Repository<Pedido, Long> {


}
