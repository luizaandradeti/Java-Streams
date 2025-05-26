package com.luiza.pedidos.mapper;

import com.luiza.pedidos.dto.PedidoRequestDto;
import com.luiza.pedidos.dto.PedidoResponseDto;
import com.luiza.pedidos.tabelas.Pedido;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "cliente.nome", source = "nome")
    @Mapping(target = "cliente.ultimoNome", source = "ultimoNome")
    @Mapping(target = "cliente.cpf", source = "cpf")
    @Mapping(target = "cliente.tel", source = "tel")
    @Mapping(target = "cliente.salario", source = "salario")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovada", ignore = true)
    @Mapping(target = "incluida", constant = "true")
    @Mapping(target = "detalhes", ignore = true)
    Pedido convertDtoToPedido(PedidoRequestDto pedidoRequestDto);

    @Mapping(target = "nome", source = "cliente.nome")
    @Mapping(target = "ultimoNome", source = "cliente.ultimoNome")
    @Mapping(target = "tel", source = "cliente.tel")
    @Mapping(target = "cpf", source = "cliente.cpf")
    @Mapping(target = "salario", source = "cliente.salario")
    @Mapping(target = "valorFormatado", expression = "java(setValorFormatado(pedido))")
    PedidoResponseDto convertEntityToDto(Pedido pedido);


    List<PedidoResponseDto> convertListEntityToListDto(Iterable<Pedido> pedidos);
    
    default String setValorSolicitadoFmt(Pedido pedido) {
        return NumberFormat.getCurrencyInstance().format(pedido.getValorFormatado());
    }
}

