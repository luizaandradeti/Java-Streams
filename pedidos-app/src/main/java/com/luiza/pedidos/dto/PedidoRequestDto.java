package com.luiza.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequestDto {

    private String nome;
    private String utimoNome;
    private String cpf;
    private String tel;
    private Double salario;
    private String valorFormatado;
    private int prazoPagamento;
}