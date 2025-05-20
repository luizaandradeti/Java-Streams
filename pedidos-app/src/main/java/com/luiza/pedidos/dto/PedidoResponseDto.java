package com.luiza.pedidos.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoResponseDto {
    private Long id;
    private String nome;
    private String ultimoNome;
    private String tel;
    private String cpf;
    private Double salario;
    private Double prazoPagamento;
    private Double valor;
    private int prazoCobranca;
    private Boolean aprovada;
    private boolean incluida;
    private String detalhes;
}